package br.com.javaplatform.actions;

// Common
import br.com.javaplatform.utils.StringUtils;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


// InfoCEP
import br.com.javaplatform.models.InfoCEP;

// Weather
import br.com.javaplatform.weather.Root;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.*;

// Trash
import java.io.DataOutputStream;

//Classe responsavel por realizar as ações solicitadas pelo usuario (/cep ou /clima)
public class JPUtilityActions {

    public JPUtilityActions() { }

    //Método responsavel por detectar qual o comando a ser executado com base na mensagem
    public String callAction(String command) {
        //Quebrando a mensagem em partes para detectar o comando e seus parametros
        String[] commandParts = command.split(" ");
        String actionName = commandParts[0];

        switch (actionName) {
            case "/start":
                StringBuilder welcomeMessage = new StringBuilder();

                return welcomeMessage
                            .append("Olá, aqui estão algumas coisas que consigo fazer: \n")
                            .append("/cep {cep} (Ex: /cep 0333300) \n")
                            .append("/clima {clima} (Ex: /clima saopaulo_sp) \n")
                            .toString();

            case "/cep":

                try {
                    if(commandParts.length <= 1) {
                        return "Você precisa me informar o CEP pra que eu possa consutá-lo. Ex.: \"/cep 03333000\"";
                    }

                    String cep = commandParts[1];
                    return this.searchCEP(cep);
                } catch (IOException e) {
                    e.printStackTrace();
                    return "Desculpe, não consigo consultar o CEP no momento";
                }

            case "/clima":

                try {
                    if(commandParts.length <= 1) {
                        return "Você precisa me informar a cidade em um formato específico para que eu possa consultá-la. Ex.: \"/clima saopaulo,sp\" ou em alguns casos separado por underline Ex.: \"campo_grande,ms\"";
                    }

                    String city = StringUtils.unaccented(commandParts[1]).toLowerCase();
                    return this.searchWeather(city);
                } catch (IOException e) {
                    e.printStackTrace();
                    return "Desculpe, não consigo consultar o clima no momento";
                }

            default:
                return "Desculpe, ainda não sei fazer isso que me pediu";

        }

    }

    //Método responsavel por fazer a consulta do CEP informado
    public String searchCEP(String numberCEP) throws IOException {

        //Criando uma nova chamada para API de CEP
        URL url = new URL("https://viacep.com.br/ws/" + numberCEP + "/json/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        //Informandos os tempos de timeout da requisição
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        Integer status = con.getResponseCode();

        //Pegando o retorno da chamada
        if(status == 200) {
            //Lendo a resposta da API
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            //Utilizando a biblioteca GSON para converter o resultado da API em um Objeto do tipo InfoCEP
            Gson gson = new Gson();
            InfoCEP infoCep = gson.fromJson(content.toString(), InfoCEP.class);

            //Utilizando o método toString do objeto para retornar uma mensagem formatada ao usuário
            return infoCep.toString();
        } else {
            //Mensagem de erro caso o status da requisição seja diferente de 200 (OK)
            return "Não consigo consultar este CEP, um CEP válido seria: \"/cep 03333300\"";
        }

    }

    public String searchWeather(String locationCity) throws IOException {
        final String appId = "Dig7SAH1";
        final String consumerKey = "dj0yJmk9SkJNcFJhaWZwQWNqJnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PTQy";
        final String consumerSecret = "7c51afaca95c4823dbd1202402fff0c17a423f1a";
        final String urlConnection = "https://weather-ydn-yql.media.yahoo.com/forecastrss";

        long timestamp = new Date().getTime() / 1000;
        byte[] nonce = new byte[32];
        Random rand = new Random();
        rand.nextBytes(nonce);
        String oauthNonce = new String(nonce).replaceAll("\\W", "");

        List<String> parameters = new ArrayList<>();
        parameters.add("oauth_consumer_key=" + consumerKey);
        parameters.add("oauth_nonce=" + oauthNonce);
        parameters.add("oauth_signature_method=HMAC-SHA1");
        parameters.add("oauth_timestamp=" + timestamp);
        parameters.add("oauth_version=1.0");
        // Make sure value is encoded
        parameters.add("location=" + URLEncoder.encode(locationCity, "UTF-8"));
        parameters.add("u=c");
        parameters.add("format=json");
        Collections.sort(parameters);

        StringBuffer parametersList = new StringBuffer();
        for (int i = 0; i < parameters.size(); i++) {
            parametersList.append(((i > 0) ? "&" : "") + parameters.get(i));
        }

        String signatureString = "GET&" +
                URLEncoder.encode(urlConnection, "UTF-8") + "&" +
                URLEncoder.encode(parametersList.toString(), "UTF-8");

        String signature = null;
        try {
            SecretKeySpec signingKey = new SecretKeySpec((consumerSecret + "&").getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHMAC = mac.doFinal(signatureString.getBytes());
            Base64.Encoder encoder = Base64.getEncoder();
            signature = encoder.encodeToString(rawHMAC);
        } catch (Exception e) {
            System.err.println("Unable to append signature");
            System.exit(0);
        }

        String authorizationLine = "OAuth " +
                "oauth_consumer_key=\"" + consumerKey + "\", " +
                "oauth_nonce=\"" + oauthNonce + "\", " +
                "oauth_timestamp=\"" + timestamp + "\", " +
                "oauth_signature_method=\"HMAC-SHA1\", " +
                "oauth_signature=\"" + signature + "\", " +
                "oauth_version=\"1.0\"";

        URL url = new URL(urlConnection + "?location=" + locationCity + "&u=c&format=json");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Authorization", authorizationLine);
        con.setRequestProperty("X-Yahoo-App-Id", appId);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestMethod("GET");

        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        Integer status = con.getResponseCode();
        System.out.println(locationCity);
        if (status == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            Gson gson = new Gson();
            Root root = gson.fromJson(content.toString(), Root.class);
            try {
                return root.toString();
            } catch (Exception e) {
                return "Houston we have a problem!";
            }

        } else {

            return "Você precisa informar a cidade em um formato específico para que eu possa consultá-la. Ex.: \"/clima saopaulo,sp\" ou em alguns casos separado por underline Ex.: \"campo_grande,ms\"";

        }
    }

}
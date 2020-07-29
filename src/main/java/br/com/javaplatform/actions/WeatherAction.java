package br.com.javaplatform.actions;

import br.com.javaplatform.weather.Root;
import com.google.gson.Gson;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

public class WeatherAction {

    //Método responsavel por fazer a consulta do do clima da cidade informada
    public String searchWeather(String locationCity) throws IOException {

        final String appId = "Dig7SAH1";
        final String consumerKey = "dj0yJmk9SkJNcFJhaWZwQWNqJnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PTQy";
        final String consumerSecret = "7c51afaca95c4823dbd1202402fff0c17a423f1a";
        final String urlConnection = "https://weather-ydn-yql.media.yahoo.com/forecastrss";

        // Responsável por gerar o oauthNonce aleatório
        long timestamp = new Date().getTime() / 1000;
        byte[] nonce = new byte[32];
        Random rand = new Random();
        rand.nextBytes(nonce);
        String oauthNonce = new String(nonce).replaceAll("\\W", "");

        //Criação dos parâmetros de request da mensagem http
        List<String> parameters = new ArrayList<>();
        parameters.add("oauth_consumer_key=" + consumerKey);
        parameters.add("oauth_nonce=" + oauthNonce);
        parameters.add("oauth_signature_method=HMAC-SHA1");
        parameters.add("oauth_timestamp=" + timestamp);
        parameters.add("oauth_version=1.0");
        // Garantir que este parâmetro está em UTF-8
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
            return "Não consegui contato com o meu informante. Ele deve ter saído para tomar um café";
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

        //Pegando o retorno da chamada
        if (status == 200) {
            //Lendo a resposta da API
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            //Utilizando a biblioteca GSON para converter o resultado da API em um Objeto do tipo Root
            Gson gson = new Gson();
            Root root = gson.fromJson(content.toString(), Root.class);
            try {
                //Utilizando o método toString do objeto para retornar uma mensagem formatada ao usuário
                return root.toString();
            } catch (Exception e) {
                //Tratamento de erro caso a resposta esteja vazia
                return "Não foi possível consultar a cidade informada";
            }
            //Mensagem de erro caso o status da requisição seja diferente de 200 (OK)
        } else {

            return "Você precisa informar a cidade em um formato específico para que eu possa consultá-la. Ex.: \"/clima saopaulo,sp\" ou em alguns casos separado por underline Ex.: \"campo_grande,ms\"";

        }
    }

}

package br.com.javaplatform.actions;

import br.com.javaplatform.models.InfoCEP;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class JPUtilityActions {

    public JPUtilityActions() { }

    public String callAction(String command) {
        String[] commandParts = command.split(" ");
        String actionName = commandParts[0];

        switch (actionName) {
            case "/start":
                StringBuilder welcomeMessage = new StringBuilder();

                return welcomeMessage
                            .append("Olá, me chamo Utility Boot, aqui estão algumas coisas que consigo fazer: \n")
                            .append("/cep {cep} (Ex: /cep 0333300) \n")
                            .toString();

            case "/cep":

                try {
                    if(commandParts.length <= 1) {
                        return "Você precisa me informar o CEP pra que possa consuta-lo. Ex: /cep 03333000";
                    }

                    String cep = commandParts[1];
                    return this.searchCEP(cep);
                } catch (IOException e) {
                    e.printStackTrace();
                    return "Desculpe, não consigo consultar o CEP no momento";
                }

            default:
                return "Desculpe, ainda não sei fazer isso que me pediu";
        }

    }

    public String searchCEP(String numberCEP) throws IOException {

        URL url = new URL("https://viacep.com.br/ws/" + numberCEP + "/json/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        Integer status = con.getResponseCode();

        if(status == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            Gson gson = new Gson();
            InfoCEP infoCep = gson.fromJson(content.toString(), InfoCEP.class);

            return infoCep.toString();
        } else {
            return "Não consigo consultar este CEP, um CEP válido seria: 03333300";
        }

    }

}

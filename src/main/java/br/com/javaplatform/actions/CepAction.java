package br.com.javaplatform.actions;

import br.com.javaplatform.models.InfoCEP;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CepAction {

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

}

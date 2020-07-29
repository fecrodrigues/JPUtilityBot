package br.com.javaplatform.actions;

import br.com.javaplatform.utils.StringUtils;
import java.io.IOException;

//Classe responsavel por realizar as ações solicitadas pelo usuario (/cep ou /clima)
public class JPUtilityActions {

    public JPUtilityActions() { }

    //Método responsavel por detectar qual o comando a ser executado com base na mensagem
    public String callAction(String command) {
        //Quebrando a mensagem em partes para detectar o comando e seus parametros
        String[] commandParts = command.split(" ");
        String actionName = commandParts[0];

        // Switch responsável pela seleção do comando.
        switch (actionName) {
            case "/start":
                StringBuilder welcomeMessage = new StringBuilder();

                return welcomeMessage
                            .append("Olá, aqui estão algumas coisas que consigo fazer: \n")
                            .append("/cep {cep} (Ex: /cep 0333300) \n")
                            .append("/clima {clima} (Ex: /clima saopaulo_sp) \n")
                            .append("Ou se quiser podemos bater um papo. \n")
                            .toString();

            case "/cep":

                try {
                    if(commandParts.length <= 1) {
                        return "Você precisa me informar o CEP pra que eu possa consutá-lo. Ex.: \"/cep 03333000\"";
                    }

                    String cep = commandParts[1];
                    CepAction cepAction = new CepAction();
                    return cepAction.searchCEP(cep);
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
                    WeatherAction weatherAction = new WeatherAction();
                    return weatherAction.searchWeather(city);
                } catch (IOException e) {
                    e.printStackTrace();
                    return "Desculpe, não consigo consultar o clima no momento";
                }

            default:
                return "Desculpe, ainda não sei fazer isso que me pediu";

        }

    }

}
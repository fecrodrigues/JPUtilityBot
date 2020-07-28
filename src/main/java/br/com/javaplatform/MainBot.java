package br.com.javaplatform;

public class MainBot {

    public static void main(String[] args) {
        //Criando uma nova instância do Boot
        JPUtilityBot bot = new JPUtilityBot("1321074754:AAEbKc-ZtZGggfQ3lXLBPnWE1tFVZCphG_g");
        //Chamando o método para iniciar e escutar as novas mensagens
        bot.start();
    }

}

package br.com.javaplatform;

public class MainBot {

    public static void main(String[] args) {
        //Criando uma nova instância do Boot
        JPUtilityBot bot = new JPUtilityBot("1214558417:AAFsTiOtg1tFrN9XgcZoV4i5EiEvmVXLqpU");
        //Chamando o método para iniciar e escutar as novas mensagens
        bot.start();
    }

}

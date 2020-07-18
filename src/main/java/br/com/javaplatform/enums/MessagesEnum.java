package br.com.javaplatform.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MessagesEnum {

    OLA("\\b(?:ola|oi|eae)\\b") {

        /*@Override
        public MessagesEnum nextState() {
            return ESTABEM;
        }*/

        @Override
        public String message() {
            return "Olá, eu sou o Utility bot, prazer em conhecer você";
        }
    },

    ESTABEM("\\b(?:como você|você está|como voce|voce esta|tudo bem|como vai)\\b") {

        /*@Override
        public MessagesEnum nextState() {
            return DIA;
        }*/

        @Override
        public String message() {
            return "Eu estou bem :)";
        }
    },

    QUANTOSANOS("\\b(?:anos|idade)\\b") {

        /*@Override
        public MessagesEnum nextState() {
            return VAIFAZER;
        }*/

        @Override
        public String message() {
            return "Acabei de nascer, nem um mês sequer.";
        }
    },

    VAIFAZER("\\b(?:fazendo)\\b") {

        /*@Override
        public MessagesEnum nextState() {
            return AJUDA;
        }*/

        @Override
        public String message() {
            return "Por enquanto nada, não tenho nada a fazer!";
        }
    },

    AJUDA("\\b(?:ajuda|ajudar|fazer)\\b") {

        /*@Override
        public MessagesEnum nextState() {
            return OLA;
        }*/

        @Override
        public String message() {
            return "Ainda não sei fazer muita coisa, mais consigo consultar a previsão do tempo!";
        }
    },

    NAOENTENDI("") {

        @Override
        public String message() {
            return "Desculpa, não te entendi.";
        }
    };

    private String regex;

    MessagesEnum(String regex) {
        this.regex = regex;
    }

    public static MessagesEnum detectNextState(String message) {

        //CHAMAR METODO REMOVER ACENTOS

        for(MessagesEnum messagesEnum: MessagesEnum.values()) {
            Pattern pattern = Pattern.compile(messagesEnum.regex);
            Matcher matcher = pattern.matcher(message.toLowerCase());

            if(!messagesEnum.regex.isEmpty() && matcher.find()) {
                return messagesEnum;
            }
        }

        return NAOENTENDI;
    }

    public MessagesEnum nextState(String message) {
        return this.detectNextState(message);
    }

    public abstract String message();

}

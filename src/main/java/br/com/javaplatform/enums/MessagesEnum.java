package br.com.javaplatform.enums;

public enum MessagesEnum {

    BOAS_VINDAS("\\b(?:ola|oi|eae)\\b"),

    DIALOGO1("\\b(?:como você|você está|como voce|voce esta|tudo bem|como vai)\\b"),

    DIALOGO2("\\b(?:anos|idade)\\b"),

    DIALOGO3("\\b(?:fazendo)\\b"),

    DESPEDIDA("\\b(?:Obrigado|Até|Adeus|Tchau)\\b"),
    
    NAO_ENTENDI("");

    private String regex;

    MessagesEnum(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
    	return regex;
    }

}

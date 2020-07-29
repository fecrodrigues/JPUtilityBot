package br.com.javaplatform.enums;


/**
 * Enum responsável por gardar regex para analisar padróes de mensagem
 */
public enum MessagesEnum {

    BOAS_VINDAS("(o|O)(i|I|L|l)(a|A)?|(e|E)(a|A)(e|E)"),

    DIALOGO1("((C|c)omo\\s(voc(e|ê))?\\s?(est(a|á))?|((t|T)udo)\\sbem)|((C|c)omo)\\svai"),

    DIALOGO2("(((Q|q)uantos)|((Q|q)ual))\\s?\\w*?\\s(anos)?(idade)?"),

    DIALOGO3("((O|o)\\s?(que|q))\\s\\w*?\\s?\\w*?\\s(faz|fazendo|feito)"),

    DESPEDIDA("(O|o)brigado|(A|a)deus|(A|a)t?t(e|é)?|(T|t)chau"),
    
    NAO_ENTENDI("");

    private String regex;

    MessagesEnum(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
    	return regex;
    }

}

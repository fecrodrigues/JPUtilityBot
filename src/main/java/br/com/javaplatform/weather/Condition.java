package br.com.javaplatform.weather;

public class Condition {
    private String text;

    private int code;

    private int temperature;

    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
    public void setTemperature(int temperature){
        this.temperature = temperature;
    }
    public int getTemperature(){
        return this.temperature;
    }

}

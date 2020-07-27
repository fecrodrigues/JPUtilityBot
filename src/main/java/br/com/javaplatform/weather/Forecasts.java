package br.com.javaplatform.weather;

public class Forecasts {
    private String day;

    private int date;

    private int low;

    private int high;

    private String text;

    private int code;

    public void setDay(String day){
        this.day = day;
    }
    public String getDay(){
        return this.day;
    }
    public void setDate(int date){
        this.date = date;
    }
    public int getDate(){
        return this.date;
    }
    public void setLow(int low){
        this.low = low;
    }
    public int getLow(){
        return this.low;
    }
    public void setHigh(int high){
        this.high = high;
    }
    public int getHigh(){
        return this.high;
    }
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

}

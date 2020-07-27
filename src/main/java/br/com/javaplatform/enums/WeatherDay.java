package br.com.javaplatform.enums;

public enum WeatherDay {
    Mon("Segunda");
    private String mon;
    WeatherDay(String mon) {this.mon = mon;}
    public String getMon () {return this.mon;}
}

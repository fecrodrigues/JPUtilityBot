package br.com.javaplatform.weather;

public class Atmosphere {
    private int humidity;

    private double visibility;

    private int pressure;

    private int rising;

    public void setHumidity(int humidity){
        this.humidity = humidity;
    }
    public int getHumidity(){
        return this.humidity;
    }
    public void setVisibility(double visibility){
        this.visibility = visibility;
    }
    public double getVisibility(){
        return this.visibility;
    }
    public void setPressure(int pressure){
        this.pressure = pressure;
    }
    public int getPressure(){
        return this.pressure;
    }
    public void setRising(int rising){
        this.rising = rising;
    }
    public int getRising(){
        return this.rising;
    }

}

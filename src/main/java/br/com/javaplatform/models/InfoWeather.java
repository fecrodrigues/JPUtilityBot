package br.com.javaplatform.models;

public class InfoWeather {
    private String city;
    private String region;
    private String country;
    private String timezone_id;
    private String chill;
    private String direction;
    private String speed;
    private String humidity;
    private String visibility;
    private String pressure;
    private String rising;
    private String sunrise;
    private String sunset;
    private String text;
    private String temperature;

    public InfoWeather() {}

    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    public String getRegion() {return region;}
    public void setRegion(String region) {this.region = region;}

    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}

    public String getTimezone_id() {return timezone_id;}
    public void setTimezone_id(String timezone_id) {this.timezone_id = timezone_id;}

    public String getChill() {return chill;}
    public void setChill(String chill) {this.chill = chill;}

    public String getDirection() {return direction;}
    public void setDirection(String direction) {this.direction = direction;}

    public String getSpeed() {return speed;}
    public void setSpeed(String speed) {this.speed = speed;}

    public String getHumidity() {return humidity;}
    public void setHumidity(String humidity) {this.humidity = humidity;}

    public String getVisibility() {return visibility;}
    public void setVisibility(String visibility) {this.visibility = visibility;}

    public String getPressure() {return pressure;}
    public void setPressure(String pressure) {this.pressure = pressure;}

    public String getRising() {return rising;}
    public void setRising(String rising) {this.rising = rising;}

    public String getSunrise() {return sunrise;}
    public void setSunrise(String sunrise) {this.sunrise = sunrise;}

    public String getSunset() {return sunset;}
    public void setSunset(String sunset) {this.sunset = sunset;}

    public String getText() {return text;}
    public void setText(String text) {this.text = text;}

    public String getTemperature() {return temperature;}
    public void setTemperature(String temperature) {this.temperature = temperature;}

    @Override

    public String toString() {
        return  "Cidade: " + city + "\n" +
                "Estado: " + region + "\n" +
                "País: " + country + "\n" +
                "Fuso Horário: " + timezone_id + "\n" +
                "Sensação Térmica: " + chill + "\n" +
                "Direção do vento: " + direction + "\n" +
                "Velocidade do Vento: " + speed + "\n" +
                "Humidade: " + humidity + "\n" +
                "Visibilidade: " + visibility + "\n" +
                "Pressão Atmosférica: " + pressure + "\n" +
                "Aumento de Temperatura: " + rising + "\n" +
                "Nascer do Sol: " + sunrise + "\n" +
                "Pôr do Sol: " + sunset + "\n" +
                "Condição do Tempo: " + text + "\n" +
                "Temperatura: " + temperature + "\n";
    }
}
package br.com.javaplatform.weather;

import br.com.javaplatform.enums.WeatherDay;
import br.com.javaplatform.utils.StringUtils;

import java.util.List;

public class Root {
    private Location location;

    private Current_observation current_observation;

    private List<Forecasts> forecasts;

    public void setLocation(Location location){
        this.location = location;
    }
    public Location getLocation(){
        return this.location;
    }
    public void setCurrent_observation(Current_observation current_observation){
        this.current_observation = current_observation;
    }
    public Current_observation getCurrent_observation(){
        return this.current_observation;
    }
    public void setForecasts(List<Forecasts> forecasts){
        this.forecasts = forecasts;
    }
    public List<Forecasts> getForecasts(){
        return this.forecasts;
    }

    @Override

    public String toString() {
        return  "Cidade: " + location.getCity() + "\n" +
                "Estado: " + location.getRegion() + "\n" +
                "País: " + location.getCountry() + "\n" +
                "Fuso Horário: " + location.getTimezone_id() + "\n" +
                "Sensação Térmica: " + current_observation.getWind().getChill() + "°C" + "\n" +
                "Direção do Vento: " + current_observation.getWind().getDirection() + "°" + "\n" +
                "Velocidade do Vento: " + current_observation.getWind().getSpeed() + "Km/h" + "\n" +
                "Humidade: " + current_observation.getAtmosphere().getHumidity() + "%" + "\n" +
                "Visibilidade: " + current_observation.getAtmosphere().getVisibility() + "Km" + "\n" +
                "Pressão Atmosférica: " + current_observation.getAtmosphere().getPressure() + "mb" + "\n" +
                "Aumento de Temperatura: " + current_observation.getAtmosphere().getRising() + "\n" +
                "Nascer do Sol: " + current_observation.getAstronomy().getSunrise() + "\n" +
                "Pôr do Sol: " + current_observation.getAstronomy().getSunset() + "\n" +
                "Condição do Tempo: " + current_observation.getCondition().getText() + "\n" +
                "Temperatura: " + current_observation.getCondition().getTemperature() + "°C" + "\n" + "\n" +
                "Previsão Para os Próximos Dias :" + "\n" + "\n" +
                //"Dia da semana: " + StringUtils.dayOfWeek(forecasts.get(1).getDay()) + "\n" +
                "Dia da semana: " + forecasts.get(1).getDay() + "\n" +
                "Data: " + forecasts.get(1).getDate() + "\n" +
                "Temperatura Mínima: " + forecasts.get(1).getLow() + "°C" + "\n" +
                "Temperatura Máxima: " + forecasts.get(1).getHigh() + "°C" + "\n" +
                "Condição do Tempo: " + forecasts.get(1).getText() + "\n"
                ;
    }
}
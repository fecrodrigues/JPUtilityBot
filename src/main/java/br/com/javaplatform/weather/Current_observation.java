package br.com.javaplatform.weather;

public class Current_observation
{
    private Wind wind;

    private Atmosphere atmosphere;

    private Astronomy astronomy;

    private Condition condition;

    private int pubDate;

    public void setWind(Wind wind){
        this.wind = wind;
    }
    public Wind getWind(){
        return this.wind;
    }
    public void setAtmosphere(Atmosphere atmosphere){
        this.atmosphere = atmosphere;
    }
    public Atmosphere getAtmosphere(){
        return this.atmosphere;
    }
    public void setAstronomy(Astronomy astronomy){
        this.astronomy = astronomy;
    }
    public Astronomy getAstronomy(){
        return this.astronomy;
    }
    public void setCondition(Condition condition){
        this.condition = condition;
    }
    public Condition getCondition(){
        return this.condition;
    }
    public void setPubDate(int pubDate){
        this.pubDate = pubDate;
    }
    public int getPubDate(){
        return this.pubDate;
    }
}

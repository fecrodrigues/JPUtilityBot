package br.com.javaplatform.weather;

public class Location {
    private String city;

    private String region;

    private int woeid;

    private String country;

    private double lat;

//    private double long;

    private String timezone_id;

    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }
    public void setRegion(String region){
        this.region = region;
    }
    public String getRegion(){
        return this.region;
    }
    public void setWoeid(int woeid){
        this.woeid = woeid;
    }
    public int getWoeid(){
        return this.woeid;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    public void setLat(double lat){
        this.lat = lat;
    }
    public double getLat(){
        return this.lat;
    }
 //   public void setLong(double long){
 //       this.long = long;
 //   }

    public void setTimezone_id(String timezone_id){
        this.timezone_id = timezone_id;
    }
    public String getTimezone_id(){
        return this.timezone_id;
    }

}

package webservice.po;

public class WeatherPo {

    private String region;
    private String wind;
    private String sun;
    private String rain;
    private String snow;
    private String other;

    public WeatherPo() {
    }

    public WeatherPo(String region, String wind, String sun, String rain, String snow, String other) {
        this.region = region;
        this.wind = wind;
        this.sun = sun;
        this.rain = rain;
        this.snow = snow;
        this.other = other;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getSnow() {
        return snow;
    }

    public void setSnow(String snow) {
        this.snow = snow;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}

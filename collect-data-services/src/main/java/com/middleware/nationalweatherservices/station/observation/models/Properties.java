
package com.middleware.nationalweatherservices.station.observation.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Properties {

    @SerializedName("elevation")
    @Expose
    private Elevation elevation;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("textDescription")
    @Expose
    private String textDescription;
    @SerializedName("temperature")
    @Expose
    private Temperature temperature;
    @SerializedName("dewpoint")
    @Expose
    private Dewpoint dewpoint;
    @SerializedName("windDirection")
    @Expose
    private WindDirection windDirection;
    @SerializedName("windSpeed")
    @Expose
    private WindSpeed windSpeed;
    @SerializedName("windGust")
    @Expose
    private WindGust windGust;
    @SerializedName("barometricPressure")
    @Expose
    private BarometricPressure barometricPressure;
    @SerializedName("seaLevelPressure")
    @Expose
    private SeaLevelPressure seaLevelPressure;
    @SerializedName("visibility")
    @Expose
    private Visibility visibility;
    @SerializedName("maxTemperatureLast24Hours")
    @Expose
    private MaxTemperatureLast24Hours maxTemperatureLast24Hours;
    @SerializedName("minTemperatureLast24Hours")
    @Expose
    private MinTemperatureLast24Hours minTemperatureLast24Hours;
    @SerializedName("precipitationLastHour")
    @Expose
    private PrecipitationLastHour precipitationLastHour;
    @SerializedName("precipitationLast3Hours")
    @Expose
    private PrecipitationLast3Hours precipitationLast3Hours;
    @SerializedName("precipitationLast6Hours")
    @Expose
    private PrecipitationLast6Hours precipitationLast6Hours;
    @SerializedName("relativeHumidity")
    @Expose
    private RelativeHumidity relativeHumidity;
    @SerializedName("windChill")
    @Expose
    private WindChill windChill;
    @SerializedName("heatIndex")
    @Expose
    private HeatIndex heatIndex;
    @SerializedName("cloudLayers")
    @Expose
    private List<CloudLayer> cloudLayers = null;

    public Elevation getElevation() {
        return elevation;
    }

    public void setElevation(Elevation elevation) {
        this.elevation = elevation;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Dewpoint getDewpoint() {
        return dewpoint;
    }

    public void setDewpoint(Dewpoint dewpoint) {
        this.dewpoint = dewpoint;
    }

    public WindDirection getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(WindDirection windDirection) {
        this.windDirection = windDirection;
    }

    public WindSpeed getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(WindSpeed windSpeed) {
        this.windSpeed = windSpeed;
    }

    public WindGust getWindGust() {
        return windGust;
    }

    public void setWindGust(WindGust windGust) {
        this.windGust = windGust;
    }

    public BarometricPressure getBarometricPressure() {
        return barometricPressure;
    }

    public void setBarometricPressure(BarometricPressure barometricPressure) {
        this.barometricPressure = barometricPressure;
    }

    public SeaLevelPressure getSeaLevelPressure() {
        return seaLevelPressure;
    }

    public void setSeaLevelPressure(SeaLevelPressure seaLevelPressure) {
        this.seaLevelPressure = seaLevelPressure;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public MaxTemperatureLast24Hours getMaxTemperatureLast24Hours() {
        return maxTemperatureLast24Hours;
    }

    public void setMaxTemperatureLast24Hours(MaxTemperatureLast24Hours maxTemperatureLast24Hours) {
        this.maxTemperatureLast24Hours = maxTemperatureLast24Hours;
    }

    public MinTemperatureLast24Hours getMinTemperatureLast24Hours() {
        return minTemperatureLast24Hours;
    }

    public void setMinTemperatureLast24Hours(MinTemperatureLast24Hours minTemperatureLast24Hours) {
        this.minTemperatureLast24Hours = minTemperatureLast24Hours;
    }

    public PrecipitationLastHour getPrecipitationLastHour() {
        return precipitationLastHour;
    }

    public void setPrecipitationLastHour(PrecipitationLastHour precipitationLastHour) {
        this.precipitationLastHour = precipitationLastHour;
    }

    public PrecipitationLast3Hours getPrecipitationLast3Hours() {
        return precipitationLast3Hours;
    }

    public void setPrecipitationLast3Hours(PrecipitationLast3Hours precipitationLast3Hours) {
        this.precipitationLast3Hours = precipitationLast3Hours;
    }

    public PrecipitationLast6Hours getPrecipitationLast6Hours() {
        return precipitationLast6Hours;
    }

    public void setPrecipitationLast6Hours(PrecipitationLast6Hours precipitationLast6Hours) {
        this.precipitationLast6Hours = precipitationLast6Hours;
    }

    public RelativeHumidity getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(RelativeHumidity relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public WindChill getWindChill() {
        return windChill;
    }

    public void setWindChill(WindChill windChill) {
        this.windChill = windChill;
    }

    public HeatIndex getHeatIndex() {
        return heatIndex;
    }

    public void setHeatIndex(HeatIndex heatIndex) {
        this.heatIndex = heatIndex;
    }

    public List<CloudLayer> getCloudLayers() {
        return cloudLayers;
    }

    public void setCloudLayers(List<CloudLayer> cloudLayers) {
        this.cloudLayers = cloudLayers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Properties.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("elevation");
        sb.append('=');
        sb.append(((this.elevation == null)?"<null>":this.elevation));
        sb.append(',');
        sb.append("timestamp");
        sb.append('=');
        sb.append(((this.timestamp == null)?"<null>":this.timestamp));
        sb.append(',');
        sb.append("textDescription");
        sb.append('=');
        sb.append(((this.textDescription == null)?"<null>":this.textDescription));
        sb.append(',');
        sb.append("temperature");
        sb.append('=');
        sb.append(((this.temperature == null)?"<null>":this.temperature));
        sb.append(',');
        sb.append("dewpoint");
        sb.append('=');
        sb.append(((this.dewpoint == null)?"<null>":this.dewpoint));
        sb.append(',');
        sb.append("windDirection");
        sb.append('=');
        sb.append(((this.windDirection == null)?"<null>":this.windDirection));
        sb.append(',');
        sb.append("windSpeed");
        sb.append('=');
        sb.append(((this.windSpeed == null)?"<null>":this.windSpeed));
        sb.append(',');
        sb.append("windGust");
        sb.append('=');
        sb.append(((this.windGust == null)?"<null>":this.windGust));
        sb.append(',');
        sb.append("barometricPressure");
        sb.append('=');
        sb.append(((this.barometricPressure == null)?"<null>":this.barometricPressure));
        sb.append(',');
        sb.append("seaLevelPressure");
        sb.append('=');
        sb.append(((this.seaLevelPressure == null)?"<null>":this.seaLevelPressure));
        sb.append(',');
        sb.append("visibility");
        sb.append('=');
        sb.append(((this.visibility == null)?"<null>":this.visibility));
        sb.append(',');
        sb.append("maxTemperatureLast24Hours");
        sb.append('=');
        sb.append(((this.maxTemperatureLast24Hours == null)?"<null>":this.maxTemperatureLast24Hours));
        sb.append(',');
        sb.append("minTemperatureLast24Hours");
        sb.append('=');
        sb.append(((this.minTemperatureLast24Hours == null)?"<null>":this.minTemperatureLast24Hours));
        sb.append(',');
        sb.append("precipitationLastHour");
        sb.append('=');
        sb.append(((this.precipitationLastHour == null)?"<null>":this.precipitationLastHour));
        sb.append(',');
        sb.append("precipitationLast3Hours");
        sb.append('=');
        sb.append(((this.precipitationLast3Hours == null)?"<null>":this.precipitationLast3Hours));
        sb.append(',');
        sb.append("precipitationLast6Hours");
        sb.append('=');
        sb.append(((this.precipitationLast6Hours == null)?"<null>":this.precipitationLast6Hours));
        sb.append(',');
        sb.append("relativeHumidity");
        sb.append('=');
        sb.append(((this.relativeHumidity == null)?"<null>":this.relativeHumidity));
        sb.append(',');
        sb.append("windChill");
        sb.append('=');
        sb.append(((this.windChill == null)?"<null>":this.windChill));
        sb.append(',');
        sb.append("heatIndex");
        sb.append('=');
        sb.append(((this.heatIndex == null)?"<null>":this.heatIndex));
        sb.append(',');
        sb.append("cloudLayers");
        sb.append('=');
        sb.append(((this.cloudLayers == null)?"<null>":this.cloudLayers));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}

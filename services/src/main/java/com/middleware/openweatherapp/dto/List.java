package com.middleware.openweatherapp.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class List {

	@SerializedName("id")
	@Expose
	private long id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("coord")
	@Expose
	private Coord coord;
	@SerializedName("main")
	@Expose
	private Main main;
	@SerializedName("dt")
	@Expose
	private long dt;
	@SerializedName("wind")
	@Expose
	private Wind wind;
	@SerializedName("sys")
	@Expose
	private Sys sys;
	@SerializedName("rain")
	@Expose
	private Object rain;
	@SerializedName("snow")
	@Expose
	private Object snow;
	@SerializedName("clouds")
	@Expose
	private Clouds clouds;
	@SerializedName("weather")
	@Expose
	private java.util.List<Weather> weather = null;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public List withId(long id) {
		this.id = id;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List withName(String name) {
		this.name = name;
	return this;
	}
	
	public Coord getCoord() {
		return coord;
	}
	
	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	
	public List withCoord(Coord coord) {
		this.coord = coord;
		return this;
	}
	
	public Main getMain() {
		return main;
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	public List withMain(Main main) {
		this.main = main;
	return this;
	}
	
	public long getDt() {
		return dt;
	}
	
	public void setDt(long dt) {
		this.dt = dt;
	}
	
	public List withDt(long dt) {
		this.dt = dt;
	return this;
	}
	
	public Wind getWind() {
		return wind;
	}
	
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	
	public List withWind(Wind wind) {
		this.wind = wind;
	return this;
	}
	
	public Sys getSys() {
		return sys;
	}
	
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	
	public List withSys(Sys sys) {
		this.sys = sys;
		return this;
	}
	
	public Object getRain() {
		return rain;
	}
	
	public void setRain(Object rain) {
		this.rain = rain;
	}
	
	public List withRain(Object rain) {
		this.rain = rain;
		return this;
	}
	
	public Object getSnow() {
		return snow;
	}
	
	public void setSnow(Object snow) {
		this.snow = snow;
	}
	
	public List withSnow(Object snow) {
		this.snow = snow;
		return this;
	}
	
	public Clouds getClouds() {
		return clouds;
	}
	
	public void setClouds(Clouds clouds) {
	this.clouds = clouds;
	}
	
	public List withClouds(Clouds clouds) {
	this.clouds = clouds;
	return this;
	}
	
	public java.util.List<Weather> getWeather() {
	return weather;
	}
	
	public void setWeather(java.util.List<Weather> weather) {
	this.weather = weather;
	}
	
	public List withWeather(java.util.List<Weather> weather) {
	this.weather = weather;
	return this;
	}
	
	@Override
	public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append(List.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
	sb.append("id");
	sb.append('=');
	sb.append(this.id);
	sb.append(',');
	sb.append("name");
	sb.append('=');
	sb.append(((this.name == null)?"<null>":this.name));
	sb.append(',');
	sb.append("coord");
	sb.append('=');
	sb.append(((this.coord == null)?"<null>":this.coord));
	sb.append(',');
	sb.append("main");
	sb.append('=');
	sb.append(((this.main == null)?"<null>":this.main));
	sb.append(',');
	sb.append("dt");
	sb.append('=');
	sb.append(this.dt);
	sb.append(',');
	sb.append("wind");
	sb.append('=');
	sb.append(((this.wind == null)?"<null>":this.wind));
	sb.append(',');
	sb.append("sys");
	sb.append('=');
	sb.append(((this.sys == null)?"<null>":this.sys));
	sb.append(',');
	sb.append("rain");
	sb.append('=');
	sb.append(((this.rain == null)?"<null>":this.rain));
	sb.append(',');
	sb.append("snow");
	sb.append('=');
	sb.append(((this.snow == null)?"<null>":this.snow));
	sb.append(',');
	sb.append("clouds");
	sb.append('=');
	sb.append(((this.clouds == null)?"<null>":this.clouds));
	sb.append(',');
	sb.append("weather");
	sb.append('=');
	sb.append(((this.weather == null)?"<null>":this.weather));
	sb.append(',');
	if (sb.charAt((sb.length()- 1)) == ',') {
	sb.setCharAt((sb.length()- 1), ']');
	} else {
	sb.append(']');
	}
	return sb.toString();
	}

}
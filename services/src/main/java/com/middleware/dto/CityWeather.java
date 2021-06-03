package com.middleware.dto;

import java.io.Serializable;
import java.util.Date;

public class CityWeather implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private Coordinates coord;
	private MainParameters main;
	private Date dt;
	private Wind wind;
	private String rain;
	private String snow;
	private WeatherSummary weather;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Coordinates getCoord() {
		return coord;
	}
	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}
	public MainParameters getMain() {
		return main;
	}
	public void setMain(MainParameters main) {
		this.main = main;
	}
	public Date getDt() {
		return dt;
	}
	public void setDt(Date dt) {
		this.dt = dt;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
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
	public WeatherSummary getWeather() {
		return weather;
	}
	public void setWeather(WeatherSummary weather) {
		this.weather = weather;
	}
	
	
	/**
	 * Implement the toString method
	 * @return 
	 * */
	
	@Override
	public String toString() {
		return null;
	}
	
	
}

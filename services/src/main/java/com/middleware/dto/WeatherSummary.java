package com.middleware.dto;

import java.io.Serializable;

public class WeatherSummary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String main;
	private String description;
	
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

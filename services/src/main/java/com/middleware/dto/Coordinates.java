package com.middleware.dto;

import java.io.Serializable;

public class Coordinates implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double lat;
	private Double lon;
	
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	
	
}

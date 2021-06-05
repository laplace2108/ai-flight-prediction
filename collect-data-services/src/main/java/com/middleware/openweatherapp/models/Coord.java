package com.middleware.openweatherapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coord {

	@SerializedName("lat")
	@Expose
	private double lat;
	@SerializedName("lon")
	@Expose
	private double lon;
	
	public double getLat() {
		return lat;
	}
	
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	public Coord withLat(double lat) {
		this.lat = lat;
	return this;
	}
	
	public double getLon() {
		return lon;
	}
	
	public void setLon(double lon) {
		this.lon = lon;
	}
	
	public Coord withLon(double lon) {
		this.lon = lon;
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Coord.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("lat");
		sb.append('=');
		sb.append(this.lat);
		sb.append(',');
		sb.append("lon");
		sb.append('=');
		sb.append(this.lon);
		sb.append(',');
	
	if (sb.charAt((sb.length()- 1)) == ',') {
		sb.setCharAt((sb.length()- 1), ']');
	} else {
		sb.append(']');
	}
		return sb.toString();
	}

}

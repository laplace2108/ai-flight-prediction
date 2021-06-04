package com.middleware.openweatherapp.dto;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sys implements Serializable {

	@SerializedName("country")
	@Expose
	private String country;
	private final static long serialVersionUID = -4247137587882759367L;
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Sys.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("country");
		sb.append('=');
		sb.append(((this.country == null)?"<null>":this.country));
		sb.append(',');
		
		if (sb.charAt((sb.length()- 1)) == ',') {
			sb.setCharAt((sb.length()- 1), ']');
		} else {
			sb.append(']');
		}
		
		return sb.toString();
	}

}

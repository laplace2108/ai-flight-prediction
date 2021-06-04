package com.middleware.openweatherapp.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clouds {

	@SerializedName("all")
	@Expose
	private long all;
	
	public long getAll() {
		return all;
	}
	
	public void setAll(long all) {
		this.all = all;
	}
	
	public Clouds withAll(long all) {
		this.all = all;
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Clouds.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("all");
		sb.append('=');
		sb.append(this.all);
		sb.append(',');
		
		if (sb.charAt((sb.length()- 1)) == ',') {
			sb.setCharAt((sb.length()- 1), ']');
		} else {
			sb.append(']');
		}
		
		return sb.toString();
	}

}

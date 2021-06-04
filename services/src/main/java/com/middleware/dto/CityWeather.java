package com.middleware.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityWeather {

	@SerializedName("message")
	@Expose
	private String message;
	@SerializedName("cod")
	@Expose
	private String cod;
	@SerializedName("count")
	@Expose
	private long count;
	@SerializedName("list")
	@Expose
	private java.util.List<com.middleware.dto.List> list = null;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public CityWeather withMessage(String message) {
		this.message = message;
	return this;
	}
	
	public String getCod() {
		return cod;
	}
	
	public void setCod(String cod) {
		this.cod = cod;
	}
	
	public CityWeather withCod(String cod) {
		this.cod = cod;
		return this;
	}
	
	public long getCount() {
		return count;
	}
	
	public void setCount(long count) {
		this.count = count;
	}
	
	public CityWeather withCount(long count) {
		this.count = count;
	return this;
	}
	
	public java.util.List<com.middleware.dto.List> getList() {
		return list;
	}
	
	public void setList(java.util.List<com.middleware.dto.List> list) {
		this.list = list;
	}
	
	public CityWeather withList(java.util.List<com.middleware.dto.List> list) {
		this.list = list;
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(CityWeather.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("message");
		sb.append('=');
		sb.append(((this.message == null)?"<null>":this.message));
		sb.append(',');
		sb.append("cod");
		sb.append('=');
		sb.append(((this.cod == null)?"<null>":this.cod));
		sb.append(',');
		sb.append("count");
		sb.append('=');
		sb.append(this.count);
		sb.append(',');
		sb.append("list");
		sb.append('=');
		sb.append(((this.list == null)?"<null>":this.list));
		sb.append(',');
		
		if (sb.charAt((sb.length()- 1)) == ',') {
			sb.setCharAt((sb.length()- 1), ']');
		} else {
			sb.append(']');
		}
			return sb.toString();
		}

}

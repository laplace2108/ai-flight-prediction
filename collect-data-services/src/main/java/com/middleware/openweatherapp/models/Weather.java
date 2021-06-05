package com.middleware.openweatherapp.models;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather implements Serializable {

	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("main")
	@Expose
	private String main;
	@SerializedName("description")
	@Expose
	private String description;
	@SerializedName("icon")
	@Expose
	private String icon;
	private final static long serialVersionUID = 7821827645768665046L;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
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
	
	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Weather.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null)?"<null>":this.id));
		sb.append(',');
		sb.append("main");
		sb.append('=');
		sb.append(((this.main == null)?"<null>":this.main));
		sb.append(',');
		sb.append("description");
		sb.append('=');
		sb.append(((this.description == null)?"<null>":this.description));
		sb.append(',');
		sb.append("icon");
		sb.append('=');
		sb.append(((this.icon == null)?"<null>":this.icon));
		sb.append(',');
		
		if (sb.charAt((sb.length()- 1)) == ',') {
			sb.setCharAt((sb.length()- 1), ']');
		} else {
			sb.append(']');
		}
		
		return sb.toString();
	}

}
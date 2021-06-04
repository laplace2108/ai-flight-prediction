package com.middleware.dto;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind implements Serializable {

	@SerializedName("speed")
	@Expose
	private Double speed;
	@SerializedName("deg")
	@Expose
	private Long deg;
	private final static long serialVersionUID = 1475532348199022213L;
	
	public Double getSpeed() {
		return speed;
	}
	
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	
	public Long getDeg() {
		return deg;
	}
	
	public void setDeg(Long deg) {
		this.deg = deg;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Wind.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("speed");
		sb.append('=');
		sb.append(((this.speed == null)?"<null>":this.speed));
		sb.append(',');
		sb.append("deg");
		sb.append('=');
		sb.append(((this.deg == null)?"<null>":this.deg));
		sb.append(',');
		
		if (sb.charAt((sb.length()- 1)) == ',') {
			sb.setCharAt((sb.length()- 1), ']');
		} else {
			sb.append(']');
		}
		
		return sb.toString();
	}

}

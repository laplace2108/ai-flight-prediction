package com.middleware.dto;

import java.io.Serializable;

public class Wind implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double speed;
	private Double deg;
	
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	public Double getDeg() {
		return deg;
	}
	public void setDeg(Double deg) {
		this.deg = deg;
	}
	
	

}

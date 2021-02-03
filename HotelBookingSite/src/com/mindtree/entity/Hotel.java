package com.mindtree.entity;

import java.util.List;

public class Hotel {
	private int hotelId;
	private String hotelName;
	private String hotelCity;
	public Hotel(int hotelId, String hotelName, String hotelCity) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelCity = hotelCity;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelCity() {
		return hotelCity;
	}
	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}
}

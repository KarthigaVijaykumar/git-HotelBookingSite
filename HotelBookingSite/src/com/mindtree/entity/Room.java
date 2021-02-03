package com.mindtree.entity;

public class Room {
	private Hotel hotel;
	private int roomNO;
	private String roomType;
	private float roomCost;
	
	public Room() {
		super();
	}

	public Room(Hotel hotel, int roomNO, String roomType, float roomCost) {
		super();
		this.hotel = hotel;
		this.roomNO = roomNO;
		this.roomType = roomType;
		this.roomCost = roomCost;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public int getRoomNO() {
		return roomNO;
	}

	public void setRoomNO(int roomNO) {
		this.roomNO = roomNO;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public float getRoomCost() {
		return roomCost;
	}

	public void setRoomCost(float roomCost) {
		this.roomCost = roomCost;
	}
}

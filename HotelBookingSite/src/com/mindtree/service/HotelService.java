package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Hotel;
import com.mindtree.entity.Room;
import com.mindtree.exception.ServiceException.HotelServiceException;

public interface HotelService {
	boolean insertHotelToDB(Hotel hotel) throws HotelServiceException;

	boolean insertRoomToDB(Room room) throws HotelServiceException;

	List<Hotel> getHotelsFromDB(String city) throws HotelServiceException;
}

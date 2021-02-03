package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Hotel;
import com.mindtree.entity.Room;
import com.mindtree.exception.DaoException.HotelDaoException;

public interface HotelDao  {
	boolean insertHotelToDB(Hotel hotel) throws HotelDaoException;

	boolean insertRoomToDB(Room room) throws HotelDaoException;

	List<Hotel> getHotelsFromDB(String city) throws HotelDaoException;
}

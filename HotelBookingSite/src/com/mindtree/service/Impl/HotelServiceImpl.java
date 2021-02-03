package com.mindtree.service.Impl;

import java.util.List;

import com.mindtree.dao.HotelDao;
import com.mindtree.dao.impl.HotelDaoImpl;
import com.mindtree.entity.Hotel;
import com.mindtree.entity.Room;
import com.mindtree.exception.DaoException.HotelDaoException;
import com.mindtree.exception.ServiceException.HotelServiceException;
import com.mindtree.service.HotelService;

public class HotelServiceImpl implements HotelService {
	private static HotelDao hoteldao = new HotelDaoImpl();

	@Override
	public boolean insertHotelToDB(Hotel hotel) throws HotelServiceException {
		try {
			return hoteldao.insertHotelToDB(hotel);
		} catch (HotelDaoException e) {
			throw new HotelServiceException("Something is wrong in DB", e);
		}
		
	}

	@Override
	public boolean insertRoomToDB(Room room) throws HotelServiceException {
		try {
			return hoteldao.insertRoomToDB(room);
		} catch (HotelDaoException e) {
			throw new HotelServiceException("something is wrong in DB", e);
		}
	}

	@Override
	public List<Hotel> getHotelsFromDB(String city) throws HotelServiceException {
		try {
			return hoteldao.getHotelsFromDB(city);
		} catch (HotelDaoException e) {
			throw new HotelServiceException("something is wrong in DB", e);
		}
	}	
}

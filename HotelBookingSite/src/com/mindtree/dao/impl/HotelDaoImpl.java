package com.mindtree.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.dao.HotelDao;
import com.mindtree.entity.Hotel;
import com.mindtree.entity.Room;
import com.mindtree.exception.DaoException.HotelDaoException;
import com.mindtree.utility.DBUtil;

public class HotelDaoImpl implements HotelDao{
	private DBUtil dbutil = new DBUtil();

	public boolean insertHotelToDB(Hotel hotel) throws HotelDaoException {
		boolean inserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbutil.connect();
			String query = "Insert into hotel values (?,?,?)";
			ps = con.prepareStatement(query);
			ps.setInt(1, hotel.getHotelId());
			ps.setString(2, hotel.getHotelName());
			ps.setString(3, hotel.getHotelCity());
			ps.executeUpdate();
			inserted = true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HotelDaoException ("DB not connected",e);
		} finally {
			dbutil.close(ps);
			dbutil.close(con);
		}
		return inserted;
	}

	@Override
	public boolean insertRoomToDB(Room room) throws HotelDaoException {
		boolean inserted = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dbutil.connect();
			String query = "Insert into room values (?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setInt(1, room.getHotel().getHotelId());
			ps.setInt(2, room.getRoomNO());
			ps.setString(3, room.getRoomType());
			ps.setFloat(4, room.getRoomCost());
			ps.executeUpdate();
			inserted = true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HotelDaoException ("DB not connected",e);
		} finally {
			dbutil.close(ps);
			dbutil.close(con);
		}
		return inserted;
	}

	@Override
	public List<Hotel> getHotelsFromDB(String city) throws HotelDaoException {
		List<Hotel> hotels = new ArrayList<Hotel>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dbutil.connect();
			String query = "Select * from hotel where hotelCity = ?";
			ps= con.prepareStatement(query);
			ps.setString(1,city);
			rs = ps.executeQuery();
			while(rs.next()) {
				Hotel hotel = new Hotel(rs.getInt(1),rs.getString(2),rs.getString(3));
				hotels.add(hotel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HotelDaoException ("DB not connected",e);
		} finally {
			dbutil.close(ps);
			dbutil.close(con);
		}
		return hotels;
	}
}

package com.mindtree.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.exception.DaoException.DBConnectionFailedException;

public class DBUtil {
	private final String URL = "jdbc:mysql://localhost:3306/hotelbookingsite";
	private final String USERNAME = "root123";
	private final String PASSWORD = "root123";
	
	public Connection connect() throws DBConnectionFailedException{
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			throw new DBConnectionFailedException("Database could not be connected",e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close (Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close (Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close (PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close (ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}

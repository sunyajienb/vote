package com.yajie.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yajie.bean.User;
import com.yajie.dao.UserDao;
import com.yajie.util.DBConnection;

public class UserDaoImpl implements UserDao{

	@Override
	public void addUser(User user) {
		Connection conn = DBConnection.getConnection();
		String addSQl = "insert into user_info(user_username,user_password) values(?,?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(addSQl);
			ps.setString(1, user.getUsername());
			ps.setString(2,user.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{			
			DBConnection.close(ps);
			DBConnection.close(conn);
		}		
	
	}

	@Override
	public int findByUser(User user) {
		Connection conn = DBConnection.getConnection();
		String findSQL = "select user_id from user_info where user_username =? and user_password =?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int userID = 0;
		
		try {
			ps = conn.prepareStatement(findSQL);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			rs = ps.executeQuery();
			if(rs.next()){
				userID = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userID;
	}

}

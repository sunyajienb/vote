package com.yajie.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yajie.bean.Voter;
import com.yajie.dao.VoteDao;
import com.yajie.util.DBConnection;

public class VoteDaoImpl implements VoteDao{

	@Override
	public void addVote(Voter vote) {
		Connection conn = DBConnection.getConnection();
		String addSQl = "insert into vote_info(user_name) values(?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(addSQl);
			ps.setString(1, vote.getUserName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{			
			DBConnection.close(ps);
			DBConnection.close(conn);
		}		
	}

	@Override
	public boolean findIsVoted(String userName) {
		Connection conn = DBConnection.getConnection();
		String findSQL = "select * from vote_info where user_name = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = true;//默认已投
		
		try {
			ps = conn.prepareStatement(findSQL);
			ps.setString(1,userName);
			rs = ps.executeQuery();
			if(rs.next()){
				flag = true;//已投
			}else{
				flag = false;//未投
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);                      
            DBConnection.close(ps);                
            DBConnection.close(conn);
		}
		return flag;
	}

}

package com.yajie.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yajie.bean.Competitor;
import com.yajie.dao.CompetitorDao;
import com.yajie.util.DBConnection;
import com.yajie.util.Page;

public class CompetitorDaoImpl implements CompetitorDao {

	@Override
	public void add(Competitor competitor) {
		Connection conn = DBConnection.getConnection();
		String addSQl = "insert into competitor_info(competitor_name,competitor_age,"
				+ "competitor_sex,photo_path,ticket_num) values(?,?,?,?,?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(addSQl);
			ps.setString(1, competitor.getName());
			ps.setInt(2,competitor.getAge());
			ps.setString(3, competitor.getSex());
			ps.setString(4, competitor.getPhotoPath());
			ps.setInt(5,competitor.getTicketNum());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{			
			DBConnection.close(ps);
			DBConnection.close(conn);
		}		
	}
	
	@Override
	public void updateTicketNum(Competitor competitor){
		Connection conn = DBConnection.getConnection();
		String updateSQL = "update competitor_info set ticket_num = ? where competitor_id = ?";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(updateSQL);
			ps.setInt(1, competitor.getTicketNum());
			ps.setInt(2,competitor.getID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{			
			DBConnection.close(ps);
			DBConnection.close(conn);
		}		
	}
	
	@Override
	public int findAllCount() {
		Connection conn = DBConnection.getConnection();
		String findSQL = "select count(*) from competitor_info";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			ps = conn.prepareStatement(findSQL);
			rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);                      
            DBConnection.close(ps);                
            DBConnection.close(conn);
		}
		return count;
	}

	@Override
	public Competitor findByID(int ID) {
		Connection conn = DBConnection.getConnection();
		String findSQL = "select * from competitor_info where competitor_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Competitor competitor = null;
		
		try {
			ps = conn.prepareStatement(findSQL);
			ps.setInt(1, ID);
			rs = ps.executeQuery();
			if(rs.next()){
				competitor = new Competitor();
				competitor.setID(rs.getInt(1)); 
				competitor.setName(rs.getString(2));
				competitor.setAge(rs.getInt(3));
				competitor.setSex(rs.getString(4));
				competitor.setPhotoPath(rs.getString(5));
				competitor.setTicketNum(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);                      
            DBConnection.close(ps);                
            DBConnection.close(conn);
		}
		return competitor;
	}

	@Override
	public List<Competitor> findByName(String name) {
		Connection conn = DBConnection.getConnection();
		String findSQL = "select * from competitor_info where "
				+ "competitor_name like \'%?%\'" ;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		try {
			ps = conn.prepareStatement(findSQL);
			ps.setString(1, name);
			rs = ps.executeQuery();
			/*if(rs.next()){
				do{
					Competitor competitor = new Competitor();
					competitor.setID(rs.getInt(1)); 
					competitor.setName(rs.getString(2));
					competitor.setAge(rs.getInt(3));
					competitor.setSex(rs.getString(4));
					competitor.setPhotoPath(rs.getString(5));
					competitor.setTicketNum(rs.getInt(6));
					competitors.add(competitor);//加入队列
				}while(rs.next());				
			}*/
			while(rs.next()){
				Competitor competitor = new Competitor();
				competitor.setID(rs.getInt(1)); 
				competitor.setName(rs.getString(2));
				competitor.setAge(rs.getInt(3));
				competitor.setSex(rs.getString(4));
				competitor.setPhotoPath(rs.getString(5));
				competitor.setTicketNum(rs.getInt(6));
				competitors.add(competitor);//加入队列
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);                      
            DBConnection.close(ps);                
            DBConnection.close(conn);
		}
		return competitors;
	}

	@Override
	public List<Competitor> findAllCompetitor(Page page) {
		Connection conn = DBConnection.getConnection();
		String findSQL = "select * from competitor_info limit ?,?";				
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Competitor> competitors = new ArrayList<Competitor>();
		
		try {
			ps = conn.prepareStatement(findSQL);
			ps.setInt(1, page.getBeginIndex());
			ps.setInt(2, page.getEveryPage());
			rs = ps.executeQuery();
			
			while(rs.next()){
				Competitor competitor = new Competitor();
				competitor.setID(rs.getInt(1)); 
				competitor.setName(rs.getString(2));
				competitor.setAge(rs.getInt(3));
				competitor.setSex(rs.getString(4));
				competitor.setPhotoPath(rs.getString(5));
				competitor.setTicketNum(rs.getInt(6));
				competitors.add(competitor);//加入队列
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.close(rs);                      
            DBConnection.close(ps);                
            DBConnection.close(conn);
		}
		return competitors;
	}

}

package com.yajie.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yajie.util.DBConnection;

public class ClearAction extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		Connection conn = DBConnection.getConnection();
		String clearSQl = "truncate table vote_info";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(clearSQl);
			ps.executeUpdate();
			getServletContext().getRequestDispatcher("/admin/success.jsp").forward(req, res);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{			
			DBConnection.close(ps);
			DBConnection.close(conn);
		}		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		doGet(req,res);
	}
}

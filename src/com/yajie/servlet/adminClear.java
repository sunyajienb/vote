package com.yajie.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class adminClear extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{

		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(username.equals("admin") && password.equals("123456") ){
			res.sendRedirect("/wxVote/admin/clear.jsp");
			/*servletContext.getRequestDispatcher("/wxVote/ShowResult?currentPage=1");
			dispatcher.forward(req, res);*/
		}else{
			req.setAttribute("error", "用户名或密码错误!!!");
			dispatcher = servletContext.getRequestDispatcher("/admin/login.jsp");
			dispatcher.forward(req, res);
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		doGet(req,res);
	}
}

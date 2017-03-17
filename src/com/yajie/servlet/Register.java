package com.yajie.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yajie.bean.User;
import com.yajie.dao.UserDao;
import com.yajie.daoFactory.UserDaoFactory;

public class Register extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)
		throws ServletException, IOException{
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println(username);System.out.println(password);//测试是否调用
		
		if(username.equals("") || username == null){
			req.setAttribute("error", "请输入用户名");
			dispatcher = servletContext.getRequestDispatcher("/User/register.jsp");
		}else if(password.equals("") || password == null){
			req.setAttribute("error", "请输入密码");
			dispatcher = servletContext.getRequestDispatcher("/User/register.jsp");
		}else{
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			UserDao userDao = UserDaoFactory.getUserDaoInstance();
			userDao.addUser(user);
			
			dispatcher = servletContext.getRequestDispatcher("/User/login.jsp");
		}
		dispatcher.forward(req, res);
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)
		throws ServletException, IOException{
		doGet(req,res);
	}
}

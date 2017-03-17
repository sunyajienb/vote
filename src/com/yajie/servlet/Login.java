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

public class Login extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		int userID;

		if (username.equals("") || username == null) {
			req.setAttribute("error", "请输入用户名");
			dispatcher = servletContext.getRequestDispatcher("/User/login.jsp");
		} else if (password.equals("") || password == null) {
			req.setAttribute("error", "请输入密码");
			dispatcher = servletContext.getRequestDispatcher("/User/login.jsp");
		} else {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			UserDao userDao = UserDaoFactory.getUserDaoInstance();
			userID = userDao.findByUser(user);
			if (userID == 0) {
				req.setAttribute("error", "用户名或密码错误!!!");
				dispatcher = servletContext.getRequestDispatcher("/User/login.jsp");
			} else {
				req.getSession().setAttribute("username", username);// 用户名放在session中
				res.sendRedirect("/wxVote/ShowResult?currentPage=1");
				return;
			}
		}
		dispatcher.forward(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}

package com.yajie.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yajie.bean.Competitor;
import com.yajie.dao.CompetitorDao;
import com.yajie.daoFactory.CompetitorDaoImplFactory;
import com.yajie.util.Page;
import com.yajie.util.PageUtil;

public class ShowResult extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		 CompetitorDao  competitorDao = CompetitorDaoImplFactory.getCompetitorDaoInstance();
		 int total = competitorDao.findAllCount();
		 int currentPage = Integer.valueOf(req.getParameter("currentPage"));
		 Page page = PageUtil.createPage(2, total, currentPage);		 
		 List<Competitor> competitors = competitorDao.findAllCompetitor(page);
		 
		 req.setAttribute("competitors", competitors);
		 req.setAttribute("page", page);
		 
		 getServletContext().getRequestDispatcher("/show.jsp").forward(req, res);
		 
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		doGet(req,res);
	}
}

package com.yajie.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yajie.bean.Competitor;
import com.yajie.bean.Voter;
import com.yajie.dao.CompetitorDao;
import com.yajie.dao.VoteDao;
import com.yajie.daoFactory.CompetitorDaoImplFactory;
import com.yajie.daoFactory.VoteDaoImplFactory;

public class Vote extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException, IOException{
		ServletContext  servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		//String username = req.getParameter("username");
		String username = (String) req.getSession().getAttribute("username");
		//System.out.println("111"+username+"22222");//////////
		int ID = Integer.valueOf(req.getParameter("ID"));
		int ticketNum = Integer.valueOf(req.getParameter("ticketNum"));
		
		if(username == null){//�û�û��½
			dispatcher = servletContext.getRequestDispatcher("/User/login.jsp");
			//System.out.println("333"+username+"22222");

		}else{//�û��ѵ�½
			VoteDao voteDao = VoteDaoImplFactory.getVoteDaoInstance();
			if(voteDao.findIsVoted(username)){//�û���½������ͶƱ
				req.setAttribute("warning", "�������ͶƱ,������Ͷ�ð�???");
				dispatcher = servletContext.getRequestDispatcher("/show.jsp");
				//res.sendRedirect("ShowResult?currentPage="+req.getParameter("current"));
				//return;
			}else{//�û�����ûͶƱ����ͶƱ
				Competitor competitor = new Competitor();
				competitor.setID(ID);
				competitor.setTicketNum(ticketNum+1);
				CompetitorDao  competitorDao = CompetitorDaoImplFactory.getCompetitorDaoInstance();
				competitorDao.updateTicketNum(competitor);
				
				Voter voter = new Voter();
				voter.setUserName(username);
				voteDao.addVote(voter);
				
				req.setAttribute("warning", "ͶƱ�ɹ�!!!");
				dispatcher = servletContext.getRequestDispatcher("/show.jsp");
			}
		}
		dispatcher.forward(req, res);
	}

    public void doPost(HttpServletRequest req,HttpServletResponse res)
    		throws ServletException, IOException{
		doGet(req,res);
	}
}

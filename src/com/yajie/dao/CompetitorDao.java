package com.yajie.dao;

import java.util.List;

import com.yajie.bean.Competitor;
import com.yajie.util.Page;

public interface CompetitorDao {
	public void add(Competitor competitor);
	public void updateTicketNum(Competitor competitor);
	public int findAllCount(); 
	public Competitor findByID(int ID);
	public List<Competitor> findByName(String name);
	public List<Competitor> findAllCompetitor(Page page);
}

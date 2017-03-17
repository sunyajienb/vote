package com.yajie.daoFactory;

import com.yajie.dao.CompetitorDao;
import com.yajie.daoImpl.CompetitorDaoImpl;

public class CompetitorDaoImplFactory {
	public static CompetitorDao getCompetitorDaoInstance(){
		return new CompetitorDaoImpl();
	}
}

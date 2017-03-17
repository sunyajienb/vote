package com.yajie.daoFactory;

import com.yajie.dao.VoteDao;
import com.yajie.daoImpl.VoteDaoImpl;

public class VoteDaoImplFactory {
	public static VoteDao getVoteDaoInstance(){
		return new VoteDaoImpl();
	}
}

package com.yajie.daoFactory;

import com.yajie.dao.UserDao;
import com.yajie.daoImpl.UserDaoImpl;

public class UserDaoFactory {
	public static UserDao getUserDaoInstance(){
		return new UserDaoImpl();
	}
}

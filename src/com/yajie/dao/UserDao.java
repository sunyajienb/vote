package com.yajie.dao;

import com.yajie.bean.User;

public interface UserDao {
	public void addUser(User user);
	public int findByUser(User user);
}

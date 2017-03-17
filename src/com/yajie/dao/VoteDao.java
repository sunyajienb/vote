package com.yajie.dao;

import com.yajie.bean.Voter;

public interface VoteDao {
	public void addVote(Voter vote);
	public boolean findIsVoted(String userName);
}

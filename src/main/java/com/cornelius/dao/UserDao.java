package com.cornelius.dao;

import org.springframework.stereotype.Repository;

import com.cornelius.bean.User;
import com.cornelius.dao.base.BaseDao;

/**
 * user
 * @author wxk
 *
 */
@Repository
public class UserDao extends BaseDao{


	public User selectById(int id){
		return selectOne("com.cornelius.mapper.User.selectById",id);
	}
	
	public User getUser(User u){
		return selectOne("com.cornelius.mapper.User.getUser",u);
	}
	public int saveUser(User u){
		return insert("com.cornelius.mapper.User.saveUser",u);
	}
}

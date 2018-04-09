package com.cornelius.dao;

import com.cornelius.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private UserMapper userMapper;


	public User selectById(int id){
//		return selectOne("com.cornelius.mapper.User.selectById",id);
		return userMapper.selectById(id);
	}
	
	public User getUser(User u){
	    return null;
//		return selectOne("com.cornelius.mapper.User.getUser",u);
	}
	public int saveUser(User u){
        return 0;
//		return insert("com.cornelius.mapper.User.saveUser",u);
	}
}

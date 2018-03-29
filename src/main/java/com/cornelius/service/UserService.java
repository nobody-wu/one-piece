package com.cornelius.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cornelius.bean.User;
import com.cornelius.dao.UserDao;

@Service
public class UserService {

	@Resource
	private UserDao userDao;
	
	public User getUser(int id){
		return userDao.selectById(id);
	}
	public User login(String userName, String password){
		
		User u = userDao.getUser(new User(userName, password));
		if(u == null){
			if(userDao.saveUser(new User(userName, password)) > 0){
				u = new User(password, password);
			}
		}
		return u;
	}
}

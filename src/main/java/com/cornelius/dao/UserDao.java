package com.cornelius.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.cornelius.bean.User;

/**
 * user
 * @author wxk
 *
 */
public class UserDao {

	public User selectById(int id) throws IOException{
		String resource = "mybatis.xml";
		InputStream inStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inStream);
		SqlSession session = factory.openSession();
		User u = session.selectOne("com.cornelius.mapper.User.selectByName",id);
		System.out.println(u);
		return u;
	}
}

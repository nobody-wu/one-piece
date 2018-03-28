package dao;

import java.io.IOException;

import org.junit.Test;

import com.cornelius.bean.User;
import com.cornelius.dao.UserDao;

public class TestMybatis {
	private UserDao dao = new UserDao();
	
	@Test
	public void test() {
		
		try {
			User u = dao.selectById(1);
			System.out.println(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

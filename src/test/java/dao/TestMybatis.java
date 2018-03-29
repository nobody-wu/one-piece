package dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.cornelius.bean.User;
import com.cornelius.service.UserService;
@ContextConfiguration({"/application*.xml"})
public class TestMybatis {

	@Autowired
	private UserService service;
	
	@Test
	public void test() {
		User u = service.getUser(1);
		System.out.println(u);
		
	}

}

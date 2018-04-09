package dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cornelius.bean.User;
import com.cornelius.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/application*.xml"})
public class TestMybatis {

	@Autowired
	private UserService service;
	
	@Test
	public void test() {
		User u = service.getUser(1);
		System.out.println(u);
		
	}
	@Test
	public void testStr(){
		List<String> strs = new ArrayList<String>();
		strs.add("sadasdd");
		strs.add("sdasd");
		System.out.println(strs.toString());
	}

}

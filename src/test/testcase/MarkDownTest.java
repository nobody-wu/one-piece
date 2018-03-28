package testcase;

import com.youbenzi.mdtool.tool.MDTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext*.xml"})
public class MarkDownTest {

	@Test
	public void test() {
		String result = MDTool.markdown2Html(new File(MarkDownTest.class.getResource("/file.md").getFile()));
		System.out.println(result);
	}
}

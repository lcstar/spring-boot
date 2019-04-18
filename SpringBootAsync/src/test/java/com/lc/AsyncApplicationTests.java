package com.lc;

import com.lc.async.DemoTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncApplicationTests {

	@Autowired
	DemoTest demoTest;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testDemoTest() throws Exception{
		System.out.println(System.currentTimeMillis());
		demoTest.testOne();
		Thread.sleep(1000);
		System.out.println(System.currentTimeMillis());
	}

}

package com.lc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
public class DevApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testAsync() throws InterruptedException {
		testAsync1();
		Thread.sleep(100);
		System.out.println("testAsync method has done");
	}

	@Async
	private void testAsync1() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("do the testAsync1 method");
		testAsync2();
	}

	private void testAsync2(){
		System.out.println("do the testAsync2 method");
	}
}

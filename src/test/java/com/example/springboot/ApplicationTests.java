package com.example.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTests {

	@Test
    public void contextLoads() {
		Assert.assertEquals(10,20);
	}

}

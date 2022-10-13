package com.hooks;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends BaseClass {
	@Before
	public static void initialize() {
		try {
			browsers();
		} catch (Exception e) {
			setUp();
		}
	}

	@After
	public static void tearDown() {
		driver.quit();
	}
	
	
}

package com.selenium.challenges;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class ClickOnRadioButton extends BaseClass {
	
	@Test
	public void radioButton() {
		//browsers("chrome");
		driver.findElement(By.name("q")).sendKeys("hellogoogle");
		
	}

}

package com.stepdef;

import org.openqa.selenium.By;

import com.base.BaseClass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef extends BaseClass {
	
	@When("I enter the username and password")
	public void i_enter_the_username_and_password() {
	   driver.findElement(By.id("email")).sendKeys("hello@world.com");
	    
	}

	@Then("I validate")
	public void i_validate() {
	    
	    
	}
	
}

package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	private static String configPath = "Configuration/configsetting.properties";
	
	public static void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		browserProperties();	
	}
		
	public static void setAllProperties() {	
		try {
		prop = new Properties();
		InputStream instm = new FileInputStream(configPath);		
		prop.load(instm);
		} catch (FileNotFoundException e) {				
			e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
	}
		
	}
	
	public static void browsers() {
		if(prop.getProperty("BrowserType").equalsIgnoreCase("chrome")) {
			setUp();
		} else if (prop.getProperty("BrowserType").equalsIgnoreCase("firefox")) {		
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();		
		} else if (prop.getProperty("BrowserType").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		browserProperties();
	}
	
	public static void browserProperties() {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	
	
}

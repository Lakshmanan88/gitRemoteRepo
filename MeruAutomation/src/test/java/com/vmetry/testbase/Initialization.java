package com.vmetry.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Initialization {
	
	public static WebDriver wd=null;
	public static Properties p=null;
	
	public static void Start() throws IOException {
		File f=new File("C:\\Users\\Owner\\workspace\\MeruAutomation\\src\\test\\resources\\configuration\\config.properties");
		FileInputStream fis=new FileInputStream(f);
		p=new Properties();	
		p.load(fis);
		if(p.getProperty("browser").equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.gecko.driver","C:\\Users\\Owner\\Desktop\\Seleniumwebdriver JAR File\\geckodriver.exe");
			wd=new ChromeDriver();
		}else if(p.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Owner\\Desktop\\Seleniumwebdriver JAR File\\geckodriver.exe");
			 wd=new FirefoxDriver();
		}else {
			
			//
		}
		
		wd.get(p.getProperty("testUrl"));
		wd.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
	}

}

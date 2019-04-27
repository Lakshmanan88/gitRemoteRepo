package com.vmetry.pagetest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vmetry.pageobjects.HomePagePO;
import com.vmetry.pageobjects.LoginPO;
import com.vmetry.testbase.Initialization;

import testutils.Utility;

public class LoginTest extends Initialization {
	
	
	@BeforeClass
	public void beforeLogin() throws IOException {
		Start();
	}
	
	@Test(dataProvider="data")
	public void testLogin(String tcid,String mob, String pass, String exp, String type) {
		wd.get(p.getProperty("testUrl"));
		LoginPO lp=PageFactory.initElements(wd, LoginPO.class);
		HomePagePO hp=PageFactory.initElements(wd, HomePagePO.class);
		lp.enter_Mobile_No(mob);
		lp.enter_Password(pass);
		lp.click_SiginIn();
		
		if(type.equalsIgnoreCase("valid")) {
		String userName=hp.getDispName();
		
		Assert.assertEquals(exp,userName );
		}else {
			String errmsg=lp.getError();
			Assert.assertEquals(exp, errmsg);
		}
		
	}
	
	@AfterClass
	public void afrClass() {
		
		wd.quit();
	}
	
	@DataProvider
	public static String[][] data() throws IOException{
		String[][] data=Utility.getExcelData("Login");
		
		return data;
	}
			
			
	
	

}

package com.vmetry.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPO {
	
	
	@FindBy(how=How.CSS,using="input.email")
	public WebElement mobileno;
	
	public void enter_Mobile_No(String mno) {
		mobileno.sendKeys(mno);
	}

	
	@FindBy(how=How.CLASS_NAME,using="password")
	public WebElement password;
	
	public void enter_Password(String pass) {
		password.sendKeys(pass);
	}

	
	@FindBy(how=How.CSS,using="button.signin-button")
	public WebElement signin;
	
	public void click_SiginIn() {
		signin.click();
	}
	
	@FindBy(how=How.ID,using="error")
	public WebElement error;
	
	public String getError() {

		return error.getText();
	
}
}
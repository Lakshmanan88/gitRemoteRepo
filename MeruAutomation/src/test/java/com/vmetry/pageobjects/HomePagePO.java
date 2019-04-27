package com.vmetry.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePagePO {
	
	
	@FindBy(how=How.CSS,using="a.dropdown-toggle")
	public WebElement dispName;
	
	public void clickdispName() {
		dispName.click();
	}
	
	public void Dummy() {
		dispName.click();
	}
	
	
	public String getDispName() {
		return dispName.getText();
	}

}

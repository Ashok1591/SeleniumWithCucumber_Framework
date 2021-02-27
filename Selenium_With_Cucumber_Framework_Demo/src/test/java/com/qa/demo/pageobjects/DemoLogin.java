package com.qa.demo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import stepdefinitions.MyBase;

public class DemoLogin extends MyBase {
	
    public DemoLogin() {	
		PageFactory.initElements(driver, this);
	}
    
    private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.cssSelector("input[value='Login']");
	
	//Action Methods
	
	public void insertEmail(String text)
	{
		doInsert(emailId, text);
	}
	
	public void insertPassword(String text)
	{
		doInsert(password, text);
	}
	
	public void clickOnLogin()
	{
		doClick(loginButton);
	}
	

}

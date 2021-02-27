package com.qa.demo.pageobjects;

import stepdefinitions.MyBase;

public class InitPage extends MyBase {
	
	public DemoLogin demoLogin;
	
	public InitPage() {
		demoLogin = new DemoLogin();
	}

}

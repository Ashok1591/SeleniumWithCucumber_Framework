package com.qa.demo.environment;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.qa.utilities.DriverManager;
import com.qa.utilities.PropertyManager;


public class Environment {
	
	protected WebDriver driver;
	
	public Environment() {
		driver = new DriverManager().getDriver();
		Properties props;
		try {
			props = new PropertyManager().getProps();
			driver.get(props.getProperty("environment"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

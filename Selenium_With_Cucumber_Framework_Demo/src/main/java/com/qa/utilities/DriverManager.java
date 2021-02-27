package com.qa.utilities;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}

	public void setDriver(WebDriver driver2) {
		driver.set(driver2);
	}

	public void initializeDriver() throws IOException {
		WebDriver driver = null;
		Properties props = new PropertyManager().getProps();

		if(driver == null) {
			try {
				System.setProperty(props.getProperty("driverName"), props.getProperty("driverPath"));
				driver = new ChromeDriver();
				driver.manage().window().maximize();

				this.driver.set(driver);

			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

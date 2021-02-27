package stepdefinitions;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.qa.utilities.DriverManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class MyHook {
	
	private static int failureCount = 0;
	private static int executionCount = 0;
	
	@Before
	public void opneBrowser() throws IOException {
		
		new DriverManager().initializeDriver();
	}
	
	@After
	public void closeBrowser(Scenario scenario) throws Exception {
		
		 System.out.println(executionCount + ": " + Arrays.asList(scenario.getSourceTagNames()).toString() + " ---- " + scenario.getStatus());
	        if (scenario.isFailed()) {
	            failureCount++;
	            System.out.println("No. of failures: \t" + failureCount);
	            try {
	                scenario.write("Current Page URL is " + new URL(new DriverManager().getDriver().getCurrentUrl()));
	                byte[] screenshot = ((TakesScreenshot) new DriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
	                scenario.embed(screenshot, "image/png");
	            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
	                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
	            }
	        }
	        
	        DriverManager driverManager = new DriverManager();
	        if(driverManager.getDriver() != null){
	            driverManager.getDriver().quit();
	            driverManager.setDriver(null);
	        }
	}

}

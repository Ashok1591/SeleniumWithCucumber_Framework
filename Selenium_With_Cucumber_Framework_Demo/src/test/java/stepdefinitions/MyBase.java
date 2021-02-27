package stepdefinitions;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;
import com.qa.demo.environment.Environment;
import com.qa.utilities.DriverManager;

public class MyBase {
	
	protected WebDriver driver = new DriverManager().getDriver();
	Environment environment;
	Faker randomValue = new Faker();


	public void navigateToLoginPage() throws IOException {

		environment = new Environment();
	}

	//Reusable methods
	public String getPageTitle() {

		return	driver.getTitle();
	}

	public void doClick(By locator) {

		driver.findElement(locator).click();
	}

	public void doInsert(By locator, String text) {

		driver.findElement(locator).sendKeys(text);
	}

	//pause execution of code
	public void pause(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException interruptedException) {
			System.out.println("Fail to pause script");
		}
	}

	public void waitForElement(int time, By locator) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
	}

	public String generateRandomEmail()
	{
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();

		Random rnd = new Random();
		while (salt.length() < 10) 
		{ 
			// length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	//Generating random name,username and lastname
	public String random(String text)
	{		
		if(text.equals("name"))
		{
			String firstName =  randomValue.name().firstName();
			return firstName ; 
		}

		if(text.equals("username"))
		{
			String userName = randomValue.name().username();
			return userName ;
		}

		if(text.equals("lastname"))
		{
			String lastName = randomValue.name().lastName();
			return lastName;
		}

		return text;
	}

	public String randomValue()
	{
		final String AB = "abcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();
		int len = 5;

		StringBuilder sb = new StringBuilder(len);
		for( int i = 0; i < len; i++ ) 
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}

}

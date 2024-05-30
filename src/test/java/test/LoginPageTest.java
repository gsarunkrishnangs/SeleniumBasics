package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import dataprovider.DataProviders;
import listener.ReTryAnalyzer;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {

	@Test (priority = 2)
	public void verifyLoginPageTitle() {

		driver.get("https://demowebshop.tricentis.com/login");
		String actualtitle = driver.getTitle();
		System.out.println("Actual title is" + " " + actualtitle);
		String expectedtitle = ExcelUtility.getStringData(0, 0, "LoginPage");
		Assert.assertEquals(actualtitle, expectedtitle, "Login page is not displayed");
	}

	@Test(priority = 4,retryAnalyzer=ReTryAnalyzer.class)
	public void verifyUserLogin() {  //ReTryAnalyzer (If test fails, will repeat the test as per the count already set in the ReTryAnalyzer class)

		driver.get("https://demowebshop.tricentis.com/login");
		WebElement username = driver.findElement(By.xpath("//input[@id='Email']"));
		username.sendKeys("gsarunkrishnangs12345678@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		password.sendKeys("arun@123");
		WebElement loginbutton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		loginbutton.click();
		WebElement loginmailid = driver.findElement(By.xpath("//a[text()='gsarunkrishnangs12345678@gmail.com']"));
		String actualmailid = loginmailid.getText();
		System.out.println("Login mail id is" + " " + actualmailid);
		String expectedmailid = ExcelUtility.getStringData(0, 1, "LoginPage");
		Assert.assertEquals(actualmailid, expectedmailid, "Login attempt is failed");
	}

	@Test(priority = 7)
	public void verifyUserLoginWithInvalidCredentials() {

		driver.get("https://demowebshop.tricentis.com/login");
		WebElement username = driver.findElement(By.xpath("//input[@id='Email']"));
		username.sendKeys("qaz@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		password.sendKeys("arun@123");
		WebElement loginbutton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		loginbutton.click();
		WebElement errormessage = driver.findElement(
				By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));
		String actualmessage = errormessage.getText();
		System.out.println("Warning message is" + " " + actualmessage);
		String expectedmessage = ExcelUtility.getStringData(0, 2, "LoginPage");
		Assert.assertEquals(actualmessage, expectedmessage, "Login is successful");
	}

	@Test(priority = 5,dataProvider = "InvalidUserCredentials", dataProviderClass = DataProviders.class) // variable (dataprovider
																							// name),class
	public void verifyUserLoginInvalidCredentials(String username, String password) {

		driver.get("https://demowebshop.tricentis.com/login");
		WebElement username1 = driver.findElement(By.xpath("//input[@id='Email']"));
		username1.sendKeys(username);
		WebElement password1 = driver.findElement(By.xpath("//input[@id='Password']"));
		password1.sendKeys(password);
		WebElement loginbutton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		loginbutton.click();
		WebElement errormessage = driver.findElement(
				By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));
		String actualmessage = errormessage.getText();
		System.out.println("Warning message is" + " " + actualmessage);
		String expectedmessage = ExcelUtility.getStringData(0, 2, "LoginPage");
		Assert.assertEquals(actualmessage, expectedmessage, "Login is successful");

	}

}

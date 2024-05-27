package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {

	@Test
	public void verifyLoginPageTitle() throws IOException {

		driver.get("https://demowebshop.tricentis.com/login");
		String actualtitle = driver.getTitle();
		System.out.println("Actual title is" + " " + actualtitle);
		String expectedtitle = ExcelUtility.getStringData(0, 0, "LoginPage");
		Assert.assertEquals(actualtitle, expectedtitle, "Login page is not displayed");
	}

	@Test
	public void verifyUserLogin() throws IOException {

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

	@Test
	public void verifyUserLoginWithInvalidCredentials() throws IOException {

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

}

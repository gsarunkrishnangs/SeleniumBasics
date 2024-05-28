package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import utilities.ExcelUtility;

public class RegistrationPageTest extends Base {

	@Test
	public void verifyRegisterPageTitle() {

		driver.get("https://demowebshop.tricentis.com/");
		WebElement registrationlink = driver.findElement(By.linkText("Register"));
		registrationlink.click();
		String actualtitle = driver.getTitle();
		System.out.println("Actual title is" + " " + actualtitle);
		String expectedtitle = ExcelUtility.getStringData(0, 0, "RegistrationPage");
		Assert.assertEquals(actualtitle, expectedtitle, "Registration page is not displayed");
	}

	@Test
	public void verifyUserRegistration() {

		driver.get("https://demowebshop.tricentis.com/");
		WebElement registrationlink = driver.findElement(By.linkText("Register"));
		registrationlink.click();
		WebElement firstname = driver.findElement(By.xpath("//input[@id='FirstName']"));
		firstname.sendKeys("Arun");
		WebElement lastname = driver.findElement(By.xpath("//input[@id='LastName']"));
		lastname.sendKeys("Krishnan");
		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		email.sendKeys("gsarunkrishnangs12345678@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		password.sendKeys("arun@123");
		WebElement confirmpassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
		confirmpassword.sendKeys("arun@123");
		WebElement registerbutton = driver.findElement(By.xpath("//input[@id='register-button']"));
		registerbutton.click();
		String registrationhomewindow = driver.getTitle();
		System.out.println("Home page title is" + " " + registrationhomewindow);
		WebElement actualmessage = driver.findElement(By.xpath("//div[@class='result']"));
		String actualresult = actualmessage.getText();
		String expectedresult = ExcelUtility.getStringData(0, 1, "RegistrationPage");
		Assert.assertEquals(actualresult, expectedresult, "Registration failed");

	}
}

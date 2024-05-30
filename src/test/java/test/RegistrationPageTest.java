package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class RegistrationPageTest extends Base {

	@Test(priority = 8)
	public void verifyRegisterPageTitle() {

		driver.get("https://demowebshop.tricentis.com/");
		WebElement registrationlink = driver.findElement(By.linkText("Register"));
		registrationlink.click();
		String actualtitle = driver.getTitle();
		System.out.println("Actual title is" + " " + actualtitle);
		String expectedtitle = ExcelUtility.getStringData(0, 0, "RegistrationPage");
		Assert.assertEquals(actualtitle, expectedtitle, "Registration page is not displayed");
	}

	@Test(priority = 6)
	public void verifyUserRegistration() { // RandomDataUtility(Faker class), Add Java Faker dependency in POM xml
		String firstname_new = RandomDataUtility.getFirstName();
		String lastname_new = RandomDataUtility.getLastName();
		String mailid = firstname_new + "." + lastname_new + "@gmail.com";
		String password_new = firstname_new + "." + lastname_new;
		driver.get("https://demowebshop.tricentis.com/");
		WebElement registrationlink = driver.findElement(By.linkText("Register"));
		registrationlink.click();
		WebElement firstname = driver.findElement(By.xpath("//input[@id='FirstName']"));
		firstname.sendKeys(firstname_new);
		WebElement lastname = driver.findElement(By.xpath("//input[@id='LastName']"));
		lastname.sendKeys(lastname_new);
		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		email.sendKeys(mailid);
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		password.sendKeys(password_new);
		WebElement confirmpassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
		confirmpassword.sendKeys(password_new);
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

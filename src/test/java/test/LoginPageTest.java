package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;

public class LoginPageTest extends Base {

	@Test
	public void verifyLoginPageTitle() {

		driver.get("https://demowebshop.tricentis.com/login");
		String actualtitle = driver.getTitle();
		System.out.println("Actual title is" + " " + actualtitle);
		String expectedtitle = "Demo Web Shop. Login";
		Assert.assertEquals(actualtitle, expectedtitle, "Login page is not displayed");
	}

	@Test
	public void verifyUserLogin() {

	}

	@Test
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
		String expectedmessage = "Login was unsuccessful. Please correct the errors and try again.";
		Assert.assertEquals(actualmessage, expectedmessage, "Login is successful");
	}

}

package org.selenium.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsCommands {

	public void validateSauceDemoLogin() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		WebElement userName = driver.findElement(By.id("user-name"));
		userName.sendKeys("standard_user");
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		driver.quit();

	}

	public void validateDemoWebShopLogin() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		WebElement userName = driver.findElement(By.id("Email"));
		userName.sendKeys("gsarunkrishnangs@gmail.com");
		WebElement passWord = driver.findElement(By.id("Password"));
		passWord.sendKeys("Tester12@");
		WebElement loginButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
		loginButton.click();
        driver.quit();
	}
	
	public void validateDemoWebShopLoginUsingName() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		WebElement userName = driver.findElement(By.name("Email"));
		userName.sendKeys("gsarunkrishnangs@gmail.com");
		WebElement passWord = driver.findElement(By.name("Password"));
		passWord.sendKeys("Tester12@");
		WebElement loginButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
		loginButton.click();
        driver.quit();
	}
	
	public void validateDemoWebShopLoginUsingXpath() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		WebElement userName = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		userName.sendKeys("gsarunkrishnangs@gmail.com");
		WebElement passWord = driver.findElement(By.xpath("//*[@id=\"Password\"]"));
		passWord.sendKeys("Tester12@");
		WebElement loginButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
		loginButton.click();
        driver.quit();
	}
	
	public void validateDemoWebShopLoginUsingCSSSelector() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		WebElement userName = driver.findElement(By.cssSelector("#Email"));
		userName.sendKeys("gsarunkrishnangs@gmail.com");
		WebElement passWord = driver.findElement(By.cssSelector("#Password"));
		passWord.sendKeys("Tester12@");
		WebElement loginButton = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
		loginButton.click();
        driver.quit();
	}
	
	public void validateTotalNumberOfTagsInTheApplication() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com");
		driver.manage().window().maximize();
		List<WebElement> divtags = driver.findElements(By.tagName("div"));
		int totaldivtags = divtags.size();
		System.out.println("Total div tags count is"+" "+totaldivtags);
		driver.quit();
		
	}
	
	public void validateLinkText() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/link.html");
		driver.manage().window().maximize();
		WebElement link = driver.findElement(By.linkText("click here"));
		link.click();
        driver.quit();
	}
	
	public void validatePartialLinkText() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/accessing-link.html");
		driver.manage().window().maximize();
		WebElement partiallink = driver.findElement(By.partialLinkText("here"));
		partiallink.click();
        driver.quit();
	}


	public static void main(String[] args) {

		WebElementsCommands obj = new WebElementsCommands();
		obj.validateSauceDemoLogin();
        obj.validateDemoWebShopLogin();
		obj.validateTotalNumberOfTagsInTheApplication();
		obj.validateDemoWebShopLoginUsingName();
		obj.validateDemoWebShopLoginUsingXpath();
		obj.validateDemoWebShopLoginUsingCSSSelector();
		obj.validateLinkText();
		obj.validatePartialLinkText();

	}

}

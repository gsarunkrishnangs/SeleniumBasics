package org.selenium.commands;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SampleCommands {

	public static void verifyCommunityPoll() {
		// Radio Button
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		List<WebElement> communitypollelements = driver.findElements(
				By.xpath("//li[@class='answer']//input[@name='pollanswers-1']//following-sibling::label"));
		for (int i = 0; i < communitypollelements.size(); i++) {
			System.out.println(communitypollelements.get(i).getText());
			String pollelementstext = communitypollelements.get(i).getText();
			if (pollelementstext.equals("Poor")) {
				communitypollelements.get(i).click();
			}
			if (pollelementstext.equals("Very bad")) {
				communitypollelements.get(i).click();
			}
		}
		driver.quit();
	}

	public static void verifyValuesFromDropDown() {
		// Dropdownbox
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
		WebElement countrydropdown = driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(countrydropdown);
		select.selectByVisibleText("INDIA");
		select.selectByIndex(7);
		select.selectByValue("HUNGARY");
		WebElement getcountryname = select.getFirstSelectedOption();
		System.out.println(getcountryname.getText());
		List<WebElement> listdropdownoptions = select.getOptions();
		for (int i = 0; i < listdropdownoptions.size(); i++) {
			System.out.println(listdropdownoptions.get(i).getText());
			String dropdowntext = listdropdownoptions.get(i).getText();
			if (dropdowntext.equals("ICELAND")) {
				listdropdownoptions.get(i).click();
			}
		}

		driver.quit();

	}

	public static void assignmentDropDown() {
		// Assignment Dropdownbox
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/select-input.php");
		driver.manage().window().maximize();
		WebElement colordropdown = driver.findElement(By.xpath("//select[@id='single-input-field']"));
		Select select = new Select(colordropdown);
		select.selectByIndex(2);
		select.selectByValue("Green");
		select.selectByVisibleText("Red");
		WebElement countryname = select.getFirstSelectedOption();
		System.out.println(countryname.getText());
		List<WebElement> dropdownlist = select.getOptions();
		for (int i = 0; i < dropdownlist.size(); i++) {
			System.out.println(dropdownlist.get(i).getText());
			String dropdownlisttext = dropdownlist.get(i).getText();
			if (dropdownlisttext.equals("Yellow")) {
				dropdownlist.get(i).click();
			}
		}
		WebElement multidropdown = driver.findElement(By.xpath("//select[@id='multi-select-field']"));
		Select multiobject = new Select(multidropdown);
		for (int i = 0; i < 3; i++) {
			multiobject.selectByIndex(i);
		}

		List<WebElement> multidropdowntext = multiobject.getAllSelectedOptions();
		for (int j = 0; j < multidropdowntext.size(); j++) {
			System.out.println(multidropdowntext.get(j).getText());
			multiobject.deselectAll();
		}

		driver.quit();
	}

	public static void verifyMultiSelectDropDown() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform(); // Page Down
		System.out.println("Scroll down perfomed");
		Thread.sleep(3000);
		WebElement multidropdown = driver.findElement(By.xpath("//select[@id='state']"));
		Select select = new Select(multidropdown);
		boolean selectedvalue = select.isMultiple();
		System.out.println(selectedvalue);
		select.selectByVisibleText("Haryana");
		select.selectByVisibleText("Rajasthan");
		List<WebElement> selectedvalues = select.getAllSelectedOptions();
		for (WebElement e : selectedvalues) {
			System.out.println(e.getText());
		}

		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {

		SampleCommands.verifyCommunityPoll();
		SampleCommands.verifyValuesFromDropDown();
		SampleCommands.assignmentDropDown();
		SampleCommands.verifyMultiSelectDropDown();

	}

}

package org.selenium.commands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
		//Assignment Dropdownbox
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
		driver.quit();
	}

	public static void main(String[] args) {
		
		SampleCommands.verifyCommunityPoll();
		SampleCommands.verifyValuesFromDropDown();
		SampleCommands.assignmentDropDown();


	}

}

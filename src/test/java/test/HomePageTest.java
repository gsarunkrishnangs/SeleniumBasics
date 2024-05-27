package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import automationcore.Base;
import utilities.ExcelUtility;

public class HomePageTest extends Base {

	@Test
	public void verifyHomePageTitle() throws IOException {

		driver.get("https://demowebshop.tricentis.com/");
		String actualtitle = driver.getTitle();
		System.out.println("Actual title is" + " " + actualtitle);
		String expectedtitle = ExcelUtility.getStringData(0, 0, "HomePage");
		Assert.assertEquals(actualtitle, expectedtitle, "Invalid title");

	}

	@Test
	public void verifyCommunityPollSelection() throws IOException {

		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		List<WebElement> communitypollelements = driver.findElements(
				By.xpath("//li[@class='answer']//input[@name='pollanswers-1']//following-sibling::label"));
		String exceldata = ExcelUtility.getStringData(0, 1, "HomePage");
		for (int i = 0; i < communitypollelements.size(); i++) {
			System.out.println(communitypollelements.get(i).getText());
			String pollelementstext = communitypollelements.get(i).getText();
			if (pollelementstext.equals(exceldata)) {
				communitypollelements.get(i).click();
				WebElement selectedradiobutton = driver.findElement(By.xpath("//input[@id='pollanswers-3']"));
				boolean test = selectedradiobutton.isSelected();
				System.out.println("Poor radio button is selected" + " " + test);
				Assert.assertTrue(test, "Poor radio button is not selected");
			}

		}
	}

}

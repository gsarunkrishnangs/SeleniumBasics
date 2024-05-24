package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import automationcore.Base;

public class HomePageTest extends Base {

	@Test
	public void verifyHomePageTitle() {

		driver.get("https://demowebshop.tricentis.com/");
		String actualtitle = driver.getTitle();
		System.out.println("Actual title is" + " " + actualtitle);
		String expectedtitle = "Demo Web Shop";
		Assert.assertEquals(actualtitle, expectedtitle, "Invalid title");

	}

	@Test
	public void verifyCommunityPollSelection() {

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
				WebElement selectedradiobutton = driver.findElement(By.xpath("//input[@id='pollanswers-3']"));
				boolean test = selectedradiobutton.isSelected();
				System.out.println("Poor radio button is selected" + " " + test);
				Assert.assertTrue(test, "Poor radio button is not selected");
			}

		}
	}

}

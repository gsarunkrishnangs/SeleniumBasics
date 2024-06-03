package automationcore;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {

	
	protected WebDriver driver;

	public void initializeBrowser(String browser) {

		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("Invalid browser request recieved");
		}
		driver.manage().window().maximize();
	}

	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser_name) {

		initializeBrowser(browser_name);
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			takeScreenShot(result);
		}

		driver.quit();
	}

	public void takeScreenShot(ITestResult result) throws IOException { // ITestResult = TestNG listener

		TakesScreenshot takescreenshot = (TakesScreenshot) driver; // TakesScreenshot = Interface

		File screenshot = takescreenshot.getScreenshotAs(OutputType.FILE); // getScreenshotAs = Method used for taking
																			// screenshot
		FileUtils.copyFile(screenshot, new File("./ScreenShot/" + result.getName() + ".png"));

	}

}

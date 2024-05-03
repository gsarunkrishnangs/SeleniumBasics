package seleniumbasiccommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BrowserLaunch {

	WebDriver driver;

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
	public void setup() {

		initializeBrowser("Chrome");
	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}
}

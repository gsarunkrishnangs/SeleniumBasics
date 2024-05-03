package seleniumbasiccommands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SeleniumCommands extends BrowserLaunch {

	@Test
	public void assignmentDropDown() {
		// Assignment Dropdownbox

		driver.get("https://selenium.qabible.in/select-input.php");

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

	}

	@Test
	public void verifyrRegistrationMercuryTours() throws InterruptedException {

		driver.get("https://demo.guru99.com/test/newtours/register.php");
		Thread.sleep(3000);
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstName']"));
		firstname.sendKeys("Arun");
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastName']"));
		lastname.sendKeys("Krishnan");
		WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
		lastname.sendKeys("8714382959");
		WebElement email = driver.findElement(By.xpath("//input[@name='userName']"));
		email.sendKeys("arunkrishnanuck@gmail.com");
		WebElement address = driver.findElement(By.xpath("//input[@name='address1']"));
		address.sendKeys("Sreekrishna");
		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys("Trivandrum");
		WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
		state.sendKeys("Kerala");
		WebElement postalcode = driver.findElement(By.xpath("//input[@name='postalCode']"));
		postalcode.sendKeys("695521");
		WebElement countrydropdown = driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(countrydropdown);
		select.selectByVisibleText("INDIA");
		WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
		username.sendKeys("Arunkrishnan");
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("arun@123");
		WebElement confirmpassword = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
		confirmpassword.sendKeys("arun@123");
		WebElement submitbutton = driver.findElement(By.xpath("//input[@name='submit']"));
		submitbutton.click();
		String registrationhomewindow = driver.getTitle();
		System.out.println("Home page title is" + " " + registrationhomewindow);

	}

	@Test

	public void verifyDemowebshopRegistration() {

		driver.get("https://demowebshop.tricentis.com/");
		WebElement registrationlink = driver.findElement(By.linkText("Register"));
		registrationlink.click();
		WebElement firstname = driver.findElement(By.xpath("//input[@id='FirstName']"));
		firstname.sendKeys("Arun");
		WebElement lastname = driver.findElement(By.xpath("//input[@id='LastName']"));
		lastname.sendKeys("Krishnan");
		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		email.sendKeys("gsarunkrishnangs123@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		password.sendKeys("arun@123");
		WebElement confirmpassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
		confirmpassword.sendKeys("arun@123");
		WebElement registerbutton = driver.findElement(By.xpath("//input[@id='register-button']"));
		registerbutton.click();
		String registrationhomewindow = driver.getTitle();
		System.out.println("Home page title is" + " " + registrationhomewindow);

	}

}

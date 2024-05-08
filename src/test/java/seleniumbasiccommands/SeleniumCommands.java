package seleniumbasiccommands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
		WebElement actualmessage = driver.findElement(By.xpath("//a[text()=' sign-in ']"));
		String actualresult = actualmessage.getText();
		String expectedresult = "sign-in";
		Assert.assertEquals(actualresult, expectedresult, "Mercury Tours Registration failed");
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
		email.sendKeys("gsarunkrishnangs123456@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		password.sendKeys("arun@123");
		WebElement confirmpassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
		confirmpassword.sendKeys("arun@123");
		WebElement registerbutton = driver.findElement(By.xpath("//input[@id='register-button']"));
		registerbutton.click();
		String registrationhomewindow = driver.getTitle();
		System.out.println("Home page title is" + " " + registrationhomewindow);
		WebElement actualmessage = driver.findElement(By.xpath("//div[@class='result']"));
		String actualresult = actualmessage.getText();
		String expectedresult = "Your registration completed";
		Assert.assertEquals(actualresult, expectedresult, "Registration failed");
	}
	
	@Test
	public void validateDemoWebShopLogin() {
        driver.get("https://demowebshop.tricentis.com/login");
		WebElement userName = driver.findElement(By.id("Email"));
		userName.sendKeys("gsarunkrishnangs@gmail.com");
		WebElement passWord = driver.findElement(By.id("Password"));
		passWord.sendKeys("Tester12@");
		WebElement loginButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
		loginButton.click();
        WebElement actualemailfield = driver.findElement(By.xpath("//a[text() = 'gsarunkrishnangs@gmail.com']"));
        String actualresult = actualemailfield.getText();
        String expectedresult = "gsarunkrishnangs@gmail.com";
        Assert.assertEquals(actualresult, expectedresult, "Login not success");
	}
	
	@Test
	public void validateRadiobuttonIsSelected() {
		boolean ismaleselected;
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement maleradiobutton = driver.findElement(By.xpath("//input[@id='gender-male']"));
		ismaleselected = maleradiobutton.isSelected();
		Assert.assertFalse(ismaleselected, "Radio button is selected");
		System.out.println("Male element before selected"+" "+ismaleselected);
		maleradiobutton.click();
		ismaleselected = maleradiobutton.isSelected();
		Assert.assertTrue(ismaleselected, "Radio button is not selected");
		System.out.println("Male element after selected"+" "+ismaleselected);
	}
	
	@Test
	public void validateButtonIsEnabled() {
		boolean issubscribebuttonenabled;
		driver.get("https://demowebshop.tricentis.com/");
		WebElement subscribebutton = driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
		issubscribebuttonenabled = subscribebutton.isEnabled();
		Assert.assertTrue(issubscribebuttonenabled, "Subscribe button is not enabled");
		System.out.println("Subscribe button is enabled"+" "+issubscribebuttonenabled);
		}
	
	@Test
	public void validateButtonIsDisplayed() {
		boolean isvotebuttondisplayed;
		driver.get("https://demowebshop.tricentis.com/");
		WebElement votebutton = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
		isvotebuttondisplayed = votebutton.isDisplayed();
		Assert.assertTrue(isvotebuttondisplayed, "Vote button is not displayed");
		System.out.println("Vote button is displayed"+" "+isvotebuttondisplayed);
		}
	
	}

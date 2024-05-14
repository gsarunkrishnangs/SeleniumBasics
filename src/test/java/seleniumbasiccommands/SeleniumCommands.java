package seleniumbasiccommands;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		WebElement loginButton = driver.findElement(
				By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
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
		System.out.println("Male element before selected" + " " + ismaleselected);
		maleradiobutton.click();
		ismaleselected = maleradiobutton.isSelected();
		Assert.assertTrue(ismaleselected, "Radio button is not selected");
		System.out.println("Male element after selected" + " " + ismaleselected);
	}

	@Test
	public void validateButtonIsEnabled() {
		boolean issubscribebuttonenabled;
		driver.get("https://demowebshop.tricentis.com/");
		WebElement subscribebutton = driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
		issubscribebuttonenabled = subscribebutton.isEnabled();
		Assert.assertTrue(issubscribebuttonenabled, "Subscribe button is not enabled");
		System.out.println("Subscribe button is enabled" + " " + issubscribebuttonenabled);
	}

	@Test
	public void validateButtonIsDisplayed() {
		boolean isvotebuttondisplayed;
		driver.get("https://demowebshop.tricentis.com/");
		WebElement votebutton = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
		isvotebuttondisplayed = votebutton.isDisplayed();
		Assert.assertTrue(isvotebuttondisplayed, "Vote button is not displayed");
		System.out.println("Vote button is displayed" + " " + isvotebuttondisplayed);
	}

	@Test
	public void verifyRightClick() {

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightclickbutton = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action = new Actions(driver);
		action.contextClick(rightclickbutton).build().perform();

	}

	@Test
	public void verifyDoubleClick() {

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement doubleclickbutton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions action = new Actions(driver);
		action.doubleClick(doubleclickbutton).build().perform();
	}

	@Test
	public void verifyDragAndDrop() {

		driver.get("https://demoqa.com/droppable");
		WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement droppable = driver.findElement(
				By.xpath("//div[@class='simple-drop-container']//div[@id='draggable']//following-sibling::div"));
		Actions action = new Actions(driver);
		action.dragAndDrop(draggable, droppable).build().perform();

	}

	@Test
	public void verifyDragAndDropAxis() {

		driver.get("https://demoqa.com/dragabble");
		WebElement dragelement = driver.findElement(By.xpath("//div[text()='Drag me']"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(dragelement, 100, 100).build().perform();
	}

	@Test
	public void verifyMouseHover() {

		driver.get("https://demoqa.com/menu/");
		WebElement mainitem2 = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
		Actions action = new Actions(driver);
		action.moveToElement(mainitem2).build().perform();
		WebElement sublist = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
		action.moveToElement(sublist).build().perform();
		WebElement secondsublist1 = driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"));
		boolean subitemdisplay = secondsublist1.isDisplayed();
		System.out.println("Sub is Visible" + " " + subitemdisplay);
		Assert.assertTrue(subitemdisplay, "Sub Item 1 is not displayed");
		WebElement secondsublist2 = driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"));
		String actualresult = secondsublist2.getText();
		System.out.println("Actual result is" + " " + actualresult);
		String expectedresult = "Sub Sub Item 2";
		Assert.assertEquals(actualresult, expectedresult, "Sub menu item name is different");

	}

	@Test
	public void assignmentDragAndDrop() {

		driver.get("https://demo.guru99.com/test/drag_drop.html");
		WebElement drag = driver.findElement(By.xpath("//li[@id='credit1']"));
		WebElement drop = driver
				.findElement(By.xpath("//div[@class='ui-widget-content']//ol[@id='loan']//following-sibling::li"));
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();

	}

	@Test
	public void assignmentRightClick() {

		driver.get("https://demo.guru99.com/test/drag_drop.html");
		WebElement clickright = driver.findElement(By.xpath("//a[text()='Agile Project']"));
		Actions action = new Actions(driver);
		action.contextClick(clickright).build().perform();

	}

	@Test
	public void assignmentDoubleClick() throws InterruptedException {

		driver.get("https://demo.guru99.com/test/drag_drop.html");
		WebElement clickdouble = driver.findElement(By.xpath("//a[text()='Testing']"));
		Actions action = new Actions(driver);
		action.doubleClick(clickdouble).build().perform();
		Thread.sleep(3000);
		WebElement verification = driver.findElement(By.xpath("//h2[text()='Software Testing Training Summary']"));
		boolean test = verification.isDisplayed();
		System.out.println("Result is" + " " + test);
		Assert.assertTrue(test, "Testing Training Summary page is not displayed");

	}

	@Test
	public void verifySimpleAlert() {

		driver.get("https://demoqa.com/alerts");
		WebElement clickmebutton = driver.findElement(By.xpath("//button[@id='alertButton']"));
		clickmebutton.click();
		Alert simplealert = driver.switchTo().alert();
		simplealert.accept();
	}

	@Test
	public void verifyConfirmationAlert() {

		driver.get("https://demoqa.com/alerts");
		WebElement confirmbutton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		confirmbutton.click();
		Alert confirmalert = driver.switchTo().alert();
		String alerttext = confirmalert.getText();
		System.out.println("Alert text is" + " " + alerttext);
		confirmalert.dismiss();
		WebElement confirmmessage = driver.findElement(By.xpath("//span[text()='Cancel']"));
		String actualresult = confirmmessage.getText();
		String expectedresult = "You selected Cancel";
		Assert.assertEquals(actualresult, expectedresult, "Alert is accepted");
	}

	@Test

	public void verifyPromptAlert() {

		driver.get("https://demoqa.com/alerts");
		WebElement promptbutton = driver.findElement(By.xpath("//button[@id='promtButton']"));
		promptbutton.click();
		Alert promptalert = driver.switchTo().alert();
		String promptalerttext = promptalert.getText();
		System.out.println("Alert text is" + " " + promptalerttext);
		promptalert.sendKeys("My name is Arun");
		promptalert.accept();
		WebElement confirmmessage = driver.findElement(By.xpath("//span[text()='My name is Arun']"));
		String actualresult = confirmmessage.getText();
		String expectedresult = "You entered My name is Arun";
		Assert.assertEquals(actualresult, expectedresult, "Text not entered / Wrong text entered");
	}

	@Test
	public void verifyMultipleWindowHandles() {
		driver.get("https://demo.guru99.com/popup.php");
		String parentwindowid = driver.getWindowHandle();
		System.out.println("Parent Window handle is" + " " + parentwindowid);
		WebElement clicklink = driver.findElement(By.xpath("//a[text()='Click Here']"));
		clicklink.click();
		Set<String> windowshandleid = driver.getWindowHandles();
		System.out.println("All Window handles are" + " " + windowshandleid);
		Iterator<String> values = windowshandleid.iterator();
		while (values.hasNext()) {
			String childwindowid = values.next();
			if (!parentwindowid.equals(childwindowid)) {
				driver.switchTo().window(childwindowid);
				WebElement email = driver.findElement(By.cssSelector("input[name='emailid']"));
				email.sendKeys("arun@gmail.com");
				WebElement submitbutton = driver.findElement(By.xpath("//input[@name='btnLogin']"));
				submitbutton.click();
				driver.close();
			}
		}
		driver.switchTo().window(parentwindowid);
	}

	@Test
	public void assignmentVerifyMultipleWindows() throws InterruptedException {

		driver.get("https://demoqa.com/browser-windows");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform(); // Page Down
		System.out.println("Scroll down perfomed");
		Thread.sleep(3000);
		String parentwindow = driver.getWindowHandle();
		System.out.println("Parent window handle is" + " " + parentwindow);
		WebElement windowbutton = driver.findElement(By.xpath("//button[@id='windowButton']"));
		windowbutton.click();
		Set<String> allhandles = driver.getWindowHandles();
		System.out.println("All window handles are" + " " + allhandles);
		Iterator<String> values = allhandles.iterator();
		while (values.hasNext()) {
			String childwindow = values.next();
			if (!parentwindow.equals(childwindow)) {
				driver.switchTo().window(childwindow);
				WebElement pageheading = driver.findElement(By.xpath("//h1[text()='This is a sample page']"));
				String childwindowheading = pageheading.getText();
				System.out.println("Child window heading is" + " " + childwindowheading);
				driver.close();
			}
		}

		driver.switchTo().window(parentwindow);

	}
}

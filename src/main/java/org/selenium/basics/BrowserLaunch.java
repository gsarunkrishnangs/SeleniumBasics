package org.selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Page title is"+" "+title);
		String url = driver.getCurrentUrl();
		System.out.println("Current url is"+" "+url);
		String windowhandle = driver.getWindowHandle();
		System.out.println("Windowhandle is"+" "+windowhandle);
		String pagesource = driver.getPageSource();
		System.out.println("PageSource is"+" "+pagesource);
		driver.close();
		
	}

}

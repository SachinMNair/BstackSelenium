package com.selenium.basictestcases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToNewWindow {

	public static void main(String[] args) {
		
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
			WebDriver driver = new ChromeDriver();

			SwitchToNewWindow  stnw = new SwitchToNewWindow();
			stnw.switchToNewWindow(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void switchToNewWindow(WebDriver driver)
	{
		try {
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("https://www.amazon.in");
			String str = driver.getWindowHandle();
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.open('https://www.google.com', '')", "");
			
			Thread.sleep(3000);
			
			driver.switchTo().window(str);
			
			Set<String> s = driver.getWindowHandles();
			
			for(String win: s)
			{
				driver.switchTo().window(win);
				System.out.println(driver.getTitle());
				Thread.sleep(3000);				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

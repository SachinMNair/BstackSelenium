package com.selenium.basictestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SwitchToiFrame {

	public static void main(String[] args) {
		
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			SwitchToiFrame stif = new SwitchToiFrame();
			stif.switchToiFrame(driver);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void switchToiFrame(WebDriver driver) {
		
		try {
			driver.get("https://allwebco-templates.com/support/S_script_IFrame.htm");
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;

			driver.switchTo().frame(0);
			
			js1.executeScript("window.scrollBy(0,500)", "");
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

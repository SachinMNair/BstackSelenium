package com.selenium.basictestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollUpAndDown {

	public static void main(String[] args) {
		
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			ScrollUpAndDown suad = new ScrollUpAndDown();
			suad.scrollUpAndDown(driver);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void scrollUpAndDown(WebDriver driver) {
		
		try {
			driver.get("https://www.amazon.in");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("window.scrollBy(0,1000)", "");
			
			Thread.sleep(5000);
			
			js.executeScript("window.scrollBy(0,-500)", "");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

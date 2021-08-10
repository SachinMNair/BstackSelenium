package com.selenium.simple;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class sPHandleiFrame {
	
	public static void main(String[] args) {
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			sPHandleiFrame sp = new sPHandleiFrame();
			sp.performTasks(driver);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void performTasks(WebDriver driver) {
		
		try {
			driver.get("https://allwebco-templates.com/support/S_script_IFrame.htm");
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,500)", "");
			
			Thread.sleep(3000);
			
			driver.switchTo().frame(0);
			
			js1.executeScript("window.scrollBy(0,500)", "");
		
			Thread.sleep(1000);
			
			driver.switchTo().parentFrame();
			driver.switchTo().defaultContent();
			
			Thread.sleep(3000);
			
			js1.executeScript("window.scrollBy(0,-500)", "");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

package com.selenium.simple;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class sPHandleWindow {
	
	public static void main(String[] args) {
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			sPHandleWindow sp = new sPHandleWindow();
			sp.performTasks(driver);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void performTasks(WebDriver driver) {
		
		try {
			driver.get("https://www.amazon.in");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.open('https://www.google.com')", "");
			
			Thread.sleep(1000);
			
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

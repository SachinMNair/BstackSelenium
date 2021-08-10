package com.selenium.basictestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickButton {

	public static void main(String[] args) {
		
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
			WebDriver driver = new ChromeDriver();

			ClickButton cb = new ClickButton();
			cb.clickbutton(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickbutton(WebDriver driver)
	{
		try {
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("https://the-internet.herokuapp.com/login");
			
			driver.findElement(By.cssSelector("button[class='radius']")).click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

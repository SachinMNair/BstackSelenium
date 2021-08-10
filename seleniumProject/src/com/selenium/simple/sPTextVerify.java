package com.selenium.simple;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sPTextVerify {
	
	public static void main(String[] args) {
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			sPTextVerify sp = new sPTextVerify();
			sp.performTasks(driver);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void performTasks(WebDriver driver) {
		
		try {
			driver.get("https://www.amazon.in");
			
			WebElement e1 = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
			e1.sendKeys("Wireless Earphones");
			
			WebElement e2 = driver.findElement(By.cssSelector("input[id='nav-search-submit-button']"));
			e2.click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

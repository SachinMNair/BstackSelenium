package com.selenium.simple;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class sPButtonFirefox {
	
	public static void main(String[] args) {
		try {
			System.setProperty("webdriver.gecko.driver", "/Users/sachin/Desktop/Sachin/Softwares/geckodriver");
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			sPButtonFirefox sp = new sPButtonFirefox();
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
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[contains(text(),'Get It by Tomorrow')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/span[1]/div[1]/div[1]/div[4]/ul[1]/li[1]/span[1]/a[1]/span[1]")).click();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

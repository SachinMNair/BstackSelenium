package com.selenium.simple;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumProjectLogin {
	
	public static void main(String[] args) {
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			seleniumProjectLogin sp = new seleniumProjectLogin();
			sp.performTasks(driver);
			//driver.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void performTasks(WebDriver driver) {
		
		try {
			driver.get("https://the-internet.herokuapp.com/login");
			Thread.sleep(3000);
			WebElement e1 = driver.findElement(By.cssSelector("input[id='username']"));
			e1.sendKeys("tomsmith");
			Thread.sleep(3000);
			WebElement e2 = driver.findElement(By.xpath("//input[@id='password']"));
			e2.sendKeys("SuperSecretPassword!");
			Thread.sleep(3000);
			WebElement e3 = driver.findElement(By.cssSelector("button[class='radius']"));
			e3.click();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}

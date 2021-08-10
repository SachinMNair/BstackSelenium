package com.selenium.basictestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioCheckbox {

	public static void main(String[] args) {
	
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
			WebDriver driver = new ChromeDriver();

			RadioCheckbox rc = new RadioCheckbox();
			rc.selectRadioCheckbox(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectRadioCheckbox(WebDriver driver)
	{
		try {
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("https://www.amazon.in");
			
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Wireless Earphones");
			driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
			
			driver.findElement(By.xpath("//span[contains(text(),'Get It Today')]")).click();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			
			driver.findElement(By.xpath("//span[contains(text(),\"Today's Deals\")]")).click();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//span[contains(text(),'Include Out of Stock')]")).click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

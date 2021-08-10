package com.selenium.basictestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterTextinField {

	public static void main(String[] args) {
		

		try {
			System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
			WebDriver driver = new ChromeDriver();

			EnterTextinField etif = new EnterTextinField();
			etif.enterTextinField(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterTextinField(WebDriver driver)
	{
		try {
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("https://www.amazon.in");
			
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Wireless Earphones");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

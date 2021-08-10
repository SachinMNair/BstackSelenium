package com.selenium.basictestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GetTitle {

	public static void main(String[] args) {
		

		try {
			System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
			WebDriver driver = new ChromeDriver();

			GetTitle gt = new GetTitle();
			gt.getTitle(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getTitle(WebDriver driver)
	{
		try {
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("https://www.amazon.in");
			
			System.out.println(driver.getTitle());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

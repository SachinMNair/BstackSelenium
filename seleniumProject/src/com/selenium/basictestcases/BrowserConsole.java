package com.selenium.basictestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class BrowserConsole {

	public static void main(String[] args) {
		
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			BrowserConsole bc = new BrowserConsole();
			bc.browserConsole(driver);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void browserConsole(WebDriver driver) {
		
		try {
			driver.get("https://www.amazon.in");
			
			LogEntries lg = driver.manage().logs().get(LogType.BROWSER);
			for(LogEntry l : lg)
			{
				System.out.println(l.getMessage()+" "+ l.getTimestamp()+ " " + l.getLevel());
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

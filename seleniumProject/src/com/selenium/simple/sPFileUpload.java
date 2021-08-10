package com.selenium.simple;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

public class sPFileUpload {
	
	public static void main(String[] args) {
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			sPFileUpload sp = new sPFileUpload();
			sp.performTasks(driver);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void performTasks(WebDriver driver) {
		
		try {
			driver.get("https://tinypng.com/");
			
			WebElement addFile = driver.findElement(By.xpath("//header/section[1]/section[1]"));
			
			((RemoteWebElement) addFile).setFileDetector(new LocalFileDetector());
			
			addFile.click();
			
			addFile.sendKeys("/Users/sachin/Desktop/Sachin/CodeFiles/demo.html");
						
		} catch (Exception e) {
			e.printStackTrace();
		}

}
	
}

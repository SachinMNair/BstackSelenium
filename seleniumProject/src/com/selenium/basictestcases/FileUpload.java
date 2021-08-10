package com.selenium.basictestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
		
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			FileUpload fu = new FileUpload();
			fu.fileUpload(driver);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileUpload(WebDriver driver) {
		
		try {
			driver.get("https://the-internet.herokuapp.com/upload");
			
			driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("/Users/sachin/Desktop/Sachin/CodeFiles/HTMLWebpages/demo.html");
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//input[@id='file-submit']")).click();
			
			//driver.get("https://tinypng.com/");
			
			//driver.findElement(By.xpath("//header/section[1]/section[1]/input[1]")).sendKeys("/Users/sachin/Desktop/Sachin/Pictures/Personal/Caricature.jpg");
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

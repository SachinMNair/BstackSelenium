package com.selenium.Bstack;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class sPButtonChromeBstack {
	
	public static final String URL = "https://sachinm_mSzRqL:9zR8dSpRnp2pNxzSQ3sW@hub-cloud.browserstack.com/wd/hub";
	public static void main(String[] args) {
		try {
			
			DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("os_version", "10");
		    caps.setCapability("resolution", "1920x1080");
		    caps.setCapability("browser", "Chrome");
		    caps.setCapability("browser_version", "latest");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("name", "AmazonTest");
		    caps.setCapability("build", "AZ3"); 
		
		    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);  
			
			System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			sPButtonChromeBstack sp = new sPButtonChromeBstack();
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
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//span[contains(text(),'Get It by Tomorrow')]")).click();
			
			sPButtonChromeBstack.markTestStatus("passed","Yaay!",driver);
			
		} catch (Exception e) {
			e.printStackTrace();
			sPButtonChromeBstack.markTestStatus("failed","Naay!",driver);
		}
		 driver.quit(); 
	}
	
	public static void markTestStatus(String status, String reason, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
		
	  }
		
	
}

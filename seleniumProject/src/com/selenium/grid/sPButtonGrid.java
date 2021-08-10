package com.selenium.grid;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class sPButtonGrid {
	
	public static final String URL = "http://localhost:4444/wd/hub";
	public static void main(String[] args) {
		try {
		     
			sPButtonGrid sp = new sPButtonGrid();
			sp.performTaskinFirefox();
			sp.performTaskinChrome();
			sp.performTaskinSafari();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void performTaskinFirefox() {
		
		try {
			
			System.setProperty("webdriver.gecko.driver", "/Users/sachin/Desktop/Sachin/Softwares/geckodriver");
			
			DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setBrowserName("firefox");
		    caps.setPlatform(Platform.MAC);
		    
			WebDriver driver = new RemoteWebDriver(new URL(URL), caps); 
		 				
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				
			driver.get("https://www.amazon.in");
				
			System.out.println(driver.getTitle());
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
public void performTaskinChrome() {
		
		try {
			
			System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
			DesiredCapabilities caps1 = new DesiredCapabilities();
		    caps1.setBrowserName("chrome");
		    caps1.setPlatform(Platform.MAC);
			
			WebDriver driver1 = new RemoteWebDriver(new URL(URL), caps1); 
			
			driver1.manage().window().maximize();
			driver1.manage().deleteAllCookies();
			driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver1.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver1.get("https://www.amazon.in");
			
			System.out.println(driver1.getTitle());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	
public void performTaskinSafari() {
	
	try {
		
		System.setProperty("webdriver.safari.driver", "/Users/sachin/Desktop/Sachin/Softwares/safaridriver");
		DesiredCapabilities caps2 = new DesiredCapabilities();
	    caps2.setBrowserName("safari");
	    caps2.setPlatform(Platform.MAC);
		
		WebDriver driver2 = new RemoteWebDriver(new URL(URL), caps2); 
		
		driver2.manage().window().maximize();
		driver2.manage().deleteAllCookies();
		driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver2.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver2.get("https://www.amazon.in");
		
		System.out.println(driver2.getTitle());
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	 
}
	
}

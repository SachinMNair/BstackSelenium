package com.selenium.local;


import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class LocalTesting {
	
	  public static final String URL = "https://sachinm_mSzRqL:9zR8dSpRnp2pNxzSQ3sW@hub-cloud.browserstack.com/wd/hub";
	  public static void main(String[] args){
	    try {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("os_version", "7");
			caps.setCapability("resolution", "1920x1080");
			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "latest");
			caps.setCapability("os", "Windows");
			caps.setCapability("name", "LocalTesting");
			caps.setCapability("build", "LT1");
			caps.setCapability("browserstack.local", "true");
			
			WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
			driver.get("http://localhost:3000");
			Thread.sleep(3000);
			
			driver.get("http://localhost:3000/about.html");
			Thread.sleep(3000);
			
			driver.get("http://localhost:3000/contact.html");
			Thread.sleep(3000);
			
			driver.close();	
			
			driver.quit();
			
				
		} catch (Exception e) {
			e.printStackTrace();
			
	}
	    
	  }
	 
	 
}



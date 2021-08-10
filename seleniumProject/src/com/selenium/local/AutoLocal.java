package com.selenium.local;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.browserstack.local.Local;

public class AutoLocal {

	public static final String URL = "https://sachinm_mSzRqL:9zR8dSpRnp2pNxzSQ3sW@hub-cloud.browserstack.com/wd/hub";
	public static void main(String[] args) {
		
		try {
			
			 // Creates an instance of Local
			  Local bsLocal = new Local();

			  // You can also set an environment variable - "BROWSERSTACK_ACCESS_KEY".
			  HashMap<String, String> bsLocalArgs = new HashMap<String, String>();
			  bsLocalArgs.put("key", "9zR8dSpRnp2pNxzSQ3sW");

			  // Starts the Local instance with the required arguments
			  bsLocal.start(bsLocalArgs);

			  // Check if BrowserStack local instance is running
			  System.out.println(bsLocal.isRunning());

			  
			
			  DesiredCapabilities caps = new DesiredCapabilities();
			  caps.setCapability("os_version", "10");
			  caps.setCapability("resolution", "1920x1080");
			  caps.setCapability("browser", "Chrome");
			  caps.setCapability("browser_version", "latest-1");
			  caps.setCapability("os", "Windows");
			  caps.setCapability("name", "ForceLocalTesting");
			  caps.setCapability("build", "FLT2");
			  caps.setCapability("browserstack.local", "true");
			
			  WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
			  driver.get("http://localhost:3000");
			  Thread.sleep(3000);
			
			  driver.get("https://www.google.com");
			  Thread.sleep(3000);
			
			  driver.get("https://www.amazon.in");
			  Thread.sleep(3000);
			
			  driver.get("http://localhost:3000");
			  Thread.sleep(3000);
			
			  driver.close();	
			
			  driver.quit();
			
			  // Stop the Local instance
			  bsLocal.stop();
				
		} catch (Exception e) {
			e.printStackTrace();
			
	}

	}

}

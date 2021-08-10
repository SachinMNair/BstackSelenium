//Sample test in Java to run Automate session.
package com.sachin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.net.URL;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalTestDemo {
  //public static final String AUTOMATE_USERNAME = "sachinmadhavan1";
  //public static final String AUTOMATE_ACCESS_KEY = "AvHfeXy7Jw5Pnyyrbsx6";
  public static final String URL = "https://sachinm_mSzRqL:9zR8dSpRnp2pNxzSQ3sW@hub-cloud.browserstack.com/wd/hub";
  public static void main(String[] args) throws Exception {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("os_version", "7");
    caps.setCapability("resolution", "1920x1080");
    caps.setCapability("browser", "Chrome");
    caps.setCapability("browser_version", "latest");
    caps.setCapability("os", "Windows");
    caps.setCapability("name", "FlipkartTest"); // test name
    caps.setCapability("build", "FP1"); // CI/CD job or build name
    caps.setCapability("browserstack.local", "true");
    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get("http://localhost");
    WebDriverWait wait = new WebDriverWait(driver, 5);
    try {
    	wait.until(ExpectedConditions.titleContains("IIS Windows"));
    	markTestStatus("passed","Yaay title contains 'IIS Windows'!",driver);
    }
    catch(Exception e) {
    	markTestStatus("failed","Naay title does not contain 'IIS Windows'!",driver);
    }
    System.out.println(driver.getTitle());
    driver.quit();
  }
  // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
  public static void markTestStatus(String status, String reason, WebDriver driver) {
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
	//session ID: e991f6ad27e0752b180c9aa41ab382ca65acf8e6
  }
} 

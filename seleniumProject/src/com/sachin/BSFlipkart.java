package com.sachin;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class BSFlipkart {
		  //public static final String AUTOMATE_USERNAME = "sachinmadhavan1";
		  //public static final String AUTOMATE_ACCESS_KEY = "AvHfeXy7Jw5Pnyyrbsx6";
		  public static final String URL = "https://sachinm_mSzRqL:9zR8dSpRnp2pNxzSQ3sW@hub-cloud.browserstack.com/wd/hub";
		  public static void main(String[] args) throws Exception {
		    DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("os_version", "10");
		    caps.setCapability("resolution", "1920x1080");
		    caps.setCapability("browser", "Chrome");
		    caps.setCapability("browser_version", "latest");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("name", "FlipkartTest3");
		    caps.setCapability("build", "FK3"); 
		
		    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);    

			driver.manage().window().maximize(); //1st question
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //2nd question
			
			driver.get("https://www.flipkart.com");//3rd question
			
			driver.findElement(By.className("_2doB4z")).click();
			
			driver.findElement(By.className("_3704LK")).sendKeys("iPhone 11"); //4th
			driver.findElement(By.className("L0Z3Pu")).click();
			Thread.sleep(2000);
			
			WebElement element1 = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[2]/div[4]/div[1]/select"));
			Select sel1 = new Select(element1);
			sel1.selectByValue("30000"); //5.1
			
			WebElement element2 = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[2]/div[4]/div[3]/select"));
			Select sel2 = new Select(element2);
			sel2.selectByValue("Max"); //5.1
				
			driver.findElement(By.xpath("//*[@id='container']/div/div[3]/div[1]/div[1]/div/div[1]/div/section[3]/label/div[1]")).click();//5.2
			
			driver.findElement(By.xpath("//*[@id='container']/div/div[3]/div[1]/div[1]/div/div[1]/div/section[5]/div[2]/div/div/div/label/div[1]")).click();//5.3
				
			String xpathnoofrows = "//*[@id='container']/div/div[3]/div[1]/div[2]/div";
			
			List <WebElement> noOfRows = driver.findElements(By.xpath(xpathnoofrows));//6th and 7th
			
			for(int i=2; i<noOfRows.size()-1; i++)
			{
				String xpathprice = xpathnoofrows+"["+i+"]/div/div/div/a/div[2]/div[2]/div[1]/div/div[1]";
				String xpathname = xpathnoofrows+"["+i+"]/div/div/div/a/div[2]/div[1]/div[1]";
				String xpathlink = xpathnoofrows+"["+i+"]/div/div/div/a";			
				
				WebElement link = driver.findElement(By.xpath(xpathlink));		
				WebElement name = driver.findElement(By.xpath(xpathname)); 
				WebElement price = driver.findElement(By.xpath(xpathprice));
				
				System.out.println("Name: "+name.getText().toString());
				System.out.println("Price: "+price.getText().toString());
				System.out.println("Link: "+link.getAttribute("href").toString());
			
				System.out.println("==============================");
			}
			
		    try {
		    	
		    	markTestStatus("passed","Yaay!",driver);
		    }
		    catch(Exception e) {
		    	markTestStatus("failed","Naay!",driver);
		    }		    
		    driver.quit();
		  }
		
		  public static void markTestStatus(String status, String reason, WebDriver driver) {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
			
		  }
		  
		  //Session ID: 1e0e673764e917a658bfc2b62a09bc57659a8293
		  //6f20090f79b6617fcbfd1cc6cd29ae3e61d38b70
}
	




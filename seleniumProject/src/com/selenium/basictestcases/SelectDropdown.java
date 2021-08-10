package com.selenium.basictestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {

	public static void main(String[] args) {
		

		try {
			System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
			WebDriver driver = new ChromeDriver();

			SelectDropdown sd = new SelectDropdown();
			sd.selectDropdown(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectDropdown(WebDriver driver)
	{
		try {
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("https://www.amazon.in");
			
			WebElement dd = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
			
			Select select = new Select(dd);
			
			select.selectByVisibleText("Electronics");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

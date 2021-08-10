package com.sachin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoFlipkart {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sachin/Desktop/Sachin/Softwares/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //1st question
				
		Robot robot= new Robot();
		robot.mouseMove(500, 7);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //2nd question
		
		driver.get("https://www.flipkart.com"); //3rd question
		
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

		//String xpathnoofpages = "//*[@id='container']/div/div[3]/div/div[2]/div[26]/div/div/nav/a";
	
		/*List<WebElement> noOfPages = driver.findElements(By.xpath(xpathnoofpages));
		for(int j=2; j<noOfPages.size()-1; j++)
		{*/
		
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
		
		//driver.findElement(By.xpath(xpathnoofpages+"["+j+"]")).click();
		
	}

}

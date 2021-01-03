package com.autotrader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class carSearchTest {

	@Test
	public void SearchTest() throws InterruptedException {

		// Steps to test car searching functionality
		System.out.println("Starting searchFlightTest");

		// Step 1: Create Driver (What is a driver)
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); // Full screen

		// Step 2: Open Page (Test Page)
		String url = "https://www.autotrader.ca/";
		driver.get(url);
		System.out.println("Page is opened succefully");

		// Select the make from drop down menu
		WebElement makeMenu = driver.findElement(By.xpath("//select[@id='rfMakes']"));
		Select make = new Select(makeMenu);
		make.selectByValue("Toyota");
		Thread.sleep(3000);

		// Select the model from drop down menu
		WebElement modelMenu = driver.findElement(By.xpath("//select[@id='rfModel']"));
		Select model = new Select(modelMenu);
		model.selectByValue("Camry");
		Thread.sleep(3000);

		// Select the price from drop down menu
		WebElement priceMenu = driver.findElement(By.xpath("//select[@id='rfPriceHigh']"));
		Select maxPrice = new Select(priceMenu);
		maxPrice.selectByValue("10000");
		Thread.sleep(3000);
		
		//Enter Postal Code
		driver.findElement(By.xpath("//input[@id='locationAddress']")).sendKeys("K2B 7S8");
		Thread.sleep(2000);
		
		//Search
		driver.findElement(By.xpath("/html//a[@id='SearchButton']")).click();
		Thread.sleep(5000);


		

		driver.quit();

	}
}

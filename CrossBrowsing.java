package com.cross;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowsing {
	WebDriver driver;
	
	@Parameters("browser")
	@Test
	public void crossBrowser(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			//driver.manage().window().maximize();
		
		} else if (browser.equals("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("harikrishnan");
		driver.findElement(By.id("pass")).sendKeys("asdfghjk");
		driver.findElement(By.name("login")).click();
	}
	

}

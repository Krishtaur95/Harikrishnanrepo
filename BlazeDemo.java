package com.booking;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlazeDemo {
	WebDriver driver;
	
	@BeforeMethod
	public static void startTime() {
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println(currentTimeMillis);
	}
	@BeforeClass
	public  void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://blazedemo.com/");
		
	}
	
		@Test(priority=1)
		public void searchFlight() {
			
			WebElement ddnDepartureCity= driver.findElement(By.name("fromPort"));
			Select s=new Select(ddnDepartureCity);
			s.selectByVisibleText("Boston");
			
			WebElement ddnDestinationCity = driver.findElement(By.name("toPort"));
			Select s1=new Select(ddnDestinationCity);
			s1.selectByVisibleText("Dublin");
			
			WebElement btnFlight = driver.findElement(By.xpath("//input[@type='submit']"));
			btnFlight.click();
			
//			WebElement expSuccessMsg = driver.findElement(By.xpath("//h3[contains(text(),'Flights')]"));
//			String actSuccessMsg = expSuccessMsg.getText();
//			Assert.assertEquals(actSuccessMsg, expSuccessMsg,"verify flight search success message");
//			
		}
		@Test(priority=2)
		public void selectFlight() {
			WebElement btnChooseFlight = driver.findElement(By.xpath("(//input[@type='submit'])[4]"));
			btnChooseFlight.click();
		}
		@Test(priority=3)
		public void bookingFlight() {
			WebElement txtName = driver.findElement(By.id("inputName"));
			txtName.sendKeys("HariKrishnan");
			WebElement txtAddress = driver.findElement(By.id("address"));
			txtAddress.sendKeys("Nanjikottai Road");
			WebElement txtCity = driver.findElement(By.id("city"));
			txtCity.sendKeys("Thanjavur");
			WebElement txtState = driver.findElement(By.id("state"));
			txtState.sendKeys("TamilNadu");
			WebElement txtZipCode = driver.findElement(By.id("zipCode"));
			txtZipCode.sendKeys("613006");
			WebElement ddnCardType = driver.findElement(By.id("cardType"));
			Select s=new Select(ddnCardType);
			s.selectByVisibleText("Diner's Club");
			WebElement txtCcNumber = driver.findElement(By.id("creditCardNumber"));
			txtCcNumber.sendKeys("1234567899876543");
			WebElement txtCcMonth = driver.findElement(By.id("creditCardMonth"));
			txtCcMonth.clear();
			txtCcMonth.sendKeys("2");
			WebElement txtCcYear = driver.findElement(By.id("creditCardYear"));
			txtCcYear.clear();
			txtCcYear.sendKeys("December");
			WebElement txtNameCard = driver.findElement(By.id("nameOnCard"));
			txtNameCard.sendKeys("harikrishnan nethiram");
			WebElement btnPurchase = driver.findElement(By.xpath("//input[(contains(@value,'Purchase Flight'))]"));
			btnPurchase.click();
			
			

			
		}
		
		@Test(priority=4)
		public void alert() throws AWTException {
			WebElement idNum = driver.findElement(By.xpath("//td[contains(text(),'1675')]"));
			String text2 = idNum.getText();
			System.out.println(" Id number is " + "" + text2);

			Robot r =new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			
		}
		@AfterClass
		public  void quit() throws InterruptedException {
			Thread.sleep(12000);
			driver.close();
		}
		@AfterMethod
		public static void afterMethod() {
			long end = System.currentTimeMillis();
			System.out.println(end);
		}
}

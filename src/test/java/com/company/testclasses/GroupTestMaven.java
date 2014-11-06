package com.company.testclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.company.util.Excel;

public class GroupTestMaven {
	
	
	private WebDriver driver;
	
	@BeforeMethod
	public void beforMeth()
	{
		System.out.println("1111");
		driver = new FirefoxDriver();
		System.out.println("2222");
		driver.manage().window().maximize();
		System.out.println("33333");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
		}
	
	
	@Test
	  public void google() throws Exception
	  {
		
		driver.get("https://www.google.co.in/?gfe_rd=cr&ei=ZSJbVJnYN4rC8gfct4CwCw&gws_rd=ssl");
		Excel ex = new Excel();
		ex.setExcel("src/test/resources/Data/A11.xls", "Sheet1");
		
		String search = ex.getCellValue(0,1);
		System.out.println("The word is"+search);
		
		driver.findElement(By.id("gbqfq")).sendKeys(ex.getCellValue(0, 1));
		  driver.findElement(By.id("gbqfb")).click();
		  Assert.assertTrue(driver.findElement(By.xpath("//ol[@id='rso']/div[@class='srg']/li[1]//h3/a")).getText().toUpperCase().contains( (ex.getCellValue(0, 1)).toUpperCase() ));
		
	  }
	@AfterMethod
	public void afterMeth()
	{
		driver.quit();
	}

}

  package DEWA;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class InsertPreventiveWorkOrders {
	boolean test = false;
	String[] preventive = {"Preventive1","Preventive2","Preventive3","Preventive4","Preventive5","Preventive6","Preventive7","Preventive8",
 			"Preventive9","Preventive10","Preventive11","Preventive12","Preventive13","Preventive14","Preventive15","Preventive16","Preventive17",
 			"Preventive18","Preventive19","Preventive20","Preventive21"};

	
  @Test
  public void insertpreventiveworkorders() throws FileNotFoundException {
	 		  Properties prop = new Properties();
	 		 FileInputStream file = new FileInputStream("C:\\Users\\Aila\\workspace\\dewa\\src\\DEWA\\datadriven.properties");
	      try {
			prop.load(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	      //Create Firefox drive
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url1"));
			try{
				Thread.sleep(1500);

			//Login into the software filling username & password
			driver.findElement(By.name("username")).sendKeys(prop.getProperty("username1"));
			driver.findElement(By.name("password")).sendKeys(prop.getProperty("password1"));
			driver.findElement(By.xpath("//input[@value='Log In']")).click();
			}catch(Exception e)
			{
				System.out.println(e);
				}
			//Choose organisation TEST
			try{
			Thread.sleep(1500);
			WebElement orgdropdown = driver.findElement(By.name("organisation"));
			Select org = new Select(orgdropdown);
			org.selectByVisibleText("TEST");
			}catch(Exception e)
			{
			System.out.println(e);
			}
		//Go to OPERATIONS Tab
			driver.findElement(By.id("operations")).click();
		driver.findElement(By.linkText("Maintenance")).isDisplayed();
		driver.findElement(By.linkText("Work Orders")).isDisplayed();
		//Go to Work orders
		try{
			Thread.sleep(1500);
		driver.findElement(By.linkText("Work Orders")).click();
		}catch(Exception e)
		{
			System.out.println(e);
			}
		int i,j;
		for(i=0;i<5;i++)
			for(j=0;j<5;j++)
			{
				{
			//Raise new work order
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("actionsMenu")).click();
			driver.findElement(By.id("btnPreventative")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}
			//Choose device
			try{
			Thread.sleep(1500);
			driver.findElement(By.name("deviceSelectContainer:deviceSelect")).sendKeys("NewDeviceIsInTown");
			WebElement devicedrop = driver.findElement(By.name("div.col-md-9 > input[name='deviceSelect']"));
			Select device = new Select(devicedrop);
			device.selectByVisibleText("NewDeviceIsInTown");
			}catch(Exception e)
			{
			System.out.println(e);
			}

		//Fill an work order title
		driver.findElement(By.name("workOrder.workOrderTitle")).sendKeys(preventive[i]);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		

		//Choose organisation
		WebElement userdrop = driver.findElement(By.name("user"));
		Select user = new Select(userdrop);
		user.selectByVisibleText("test.admin");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//Press Save
		driver.findElement(By.xpath("//button[@value='Save']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				}
			}
		//Logout
		try{
			Thread.sleep(1500);
		driver.findElement(By.className("icon-eject")).click();
		}catch(Exception e)
		{
			System.out.println(e);
			}
		test=true;

	  }
  }
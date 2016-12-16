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
	String[] preventive = new String[]{"Preventive1","Preventive2","Preventive3","Preventive4","Preventive5","Preventive6","Preventive7","Preventive8",
 			"Preventive9","Preventive10","Preventive11","Preventive12","Preventive13","Preventive14","Preventive15","Preventive16","Preventive17",
 			"Preventive18","Preventive19","Preventive20","Preventive21"};

	String[] devices = new String[] {"deviceSeleniumOrganisation11111","SeleniumDeviceE","SeleniumDeviceFFFFF5",
			"SeleniumDevice009","SeleniumDevice43","SeleniumDeviceAAAAA5","SeleniumDevice00","DEVICE000",
			"SeleniumDeviceEEEEE","deviceSeleniumOrganisationAA","deviceA","deviceSeleniumOrganisation11",
			"SeleniumDevice000000001","SeleniumDevice123","SeleniumDevice03","SeleniumDeviceAAAAA3",
			"deviceASD","DEVICE00000","SeleniumDevice02","SeleniumDeviceAAAAA","deviceSeleniumOrganisation1111",
			"SeleniumDeviceAA","SeleniumDevice00000001","SeleniumDeviceEEEEE5",
			"SeleniumDevice33","deviceSeleniumOrganisation1",
			"DEVICE00002","SeleniumDevice0","SeleniumDeviceAAAAA1"};
  @Test
  public void f() throws FileNotFoundException {
	 		  Properties prop = new Properties();
	 		 FileInputStream file = new FileInputStream("D:\\workspace\\DEWA\\src\\DEWA\\datadriven.properties");
	      try {
			prop.load(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	      //Create Firefox drive
			WebDriver driver = new FirefoxDriver();
			//WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			//Access http://66.hubeleon.appspot.com
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
			//Choose organisation DEWA
			try{
			Thread.sleep(1500);
			WebElement orgdropdown = driver.findElement(By.name("organisation"));
			Select org = new Select(orgdropdown);
			org.selectByVisibleText("DEWA");
			}catch(Exception e)
			{
			System.out.println(e);
			}
		//Go to OPERATIONS Tab
		driver.findElement(By.id("orders")).click();
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
		for(i=0;i<21;i++)
			for(j=0;j<21;j++)
			{
				{
			//Raise new work order
			try{
			Thread.sleep(1500);
			driver.findElement(By.id("actionsMenu")).click();
			driver.findElement(By.linkText("Raise new work order")).click();
			}catch(Exception e)
			{
			System.out.println(e);
			}

		//Fill an work order title
		driver.findElement(By.name("workOrder.workOrderTitle")).sendKeys(preventive[i]);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//Choose type of work
		WebElement worktype = driver.findElement(By.name("workOrder.workOrderType"));
		Select type = new Select(worktype);
		type.selectByVisibleText("preventitive");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		 //Choose event priority
		WebElement eventtype = driver.findElement(By.name("workOrder.eventPriority"));
		Select event = new Select(eventtype);
		event.selectByVisibleText("Parked fault");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//Choose device
		try{
		Thread.sleep(1500);
		driver.findElement(By.name("deviceSelect")).sendKeys(devices[j]);
		}catch(Exception e)
		{
		System.out.println(e);
		}

		//Choose organisation
		WebElement orgdrop = driver.findElement(By.id("organisationId"));
		Select org = new Select(orgdrop);
		org.selectByVisibleText("DEWA");
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
/* Add a new device with Unknown status and check the status of the device*/

package DEWA;
import org.testng.annotations.Test;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.sql.Date;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Calendar;
	import java.util.Properties;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

	public class CreateAndCheckDeviceStatusUnknown { 
		boolean test = false;
		GenerateData genData = null;
		String device = GenerateData.generateRandomString(20);
		@Test
		 public void addcheckunknown() throws FileNotFoundException {
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
				
				//Go to List
				try{
				Thread.sleep(1500);
				driver.findElement(By.id("devices")).click();
				driver.findElement(By.linkText("List")).click();
				}catch(Exception e)
				{
				System.out.println(e);
				}
				driver.findElement(By.cssSelector("span.icon-plus")).click();
				 //Modal window is displayed & add new device
				try{
				Thread.sleep(1500);
				//Check for modal window is displayed
				driver.findElement(By.className("modal-dialog")).isDisplayed();
				}catch(Exception e)
				{
				System.out.println(e);
				}
				//Fill a device name
				try{
				Thread.sleep(1500);
				driver.findElement(By.name("deviceName")).sendKeys(device);
				}catch(Exception e)
				{
				System.out.println(e);
				}
				
				//Choose Make and Model
				try{
				Thread.sleep(1500);
				WebElement makedropdown = driver.findElement(By.id("organisationId"));
				Select make = new Select(makedropdown);
				make.selectByVisibleText("make123");
				}catch(Exception e)
				{
					System.out.println(e);
				}
				try{
				Thread.sleep(1500);
				WebElement modeldropdown = driver.findElement(By.id("equipmentType"));
				Select model = new Select(modeldropdown);
				model.selectByVisibleText("model123");
				}catch(Exception e)
				{
				System.out.println(e);
				}
				
				
			//Choose Owner
			try{
			Thread.sleep(1500);
			WebElement orgdropdown = driver.findElement(By.cssSelector("div.col-md-6 > select[name='organisation']"));
			Select organisation = new Select(orgdropdown);
			organisation.selectByVisibleText("TEST");
			}catch(Exception e)
			{
			System.out.println(e);
			}

			//Add status
			try{
			WebElement statusdropdown = driver.findElement(By.name("userAppliedStatusType"));
			Select status = new Select(statusdropdown);
			status.selectByVisibleText("Unknown");
			}catch(Exception e)
			{
				System.out.println(e);
				}

			//Fill Latitude
			try{
				Thread.sleep(1500);
		    driver.findElement(By.id("latitude")).sendKeys("44.440391");
			}catch(Exception e)
			{
				System.out.println(e);
				}

			//Fill longitude
			try{
				Thread.sleep(1500);
		    driver.findElement(By.id("longditude")).sendKeys("26.101965");
			}catch(Exception e)
			{
				System.out.println(e);
				}
			//Fill Network address
			try{
				Thread.sleep(1500);
		    driver.findElement(By.name("networkAddress")).sendKeys("192.168.100.3");
			}catch(Exception e)
			{
				System.out.println(e);
				}

			//Fill Offline & Maintenance interval
			try{
				Thread.sleep(1500);
			driver.findElement(By.name("offlineThresholdMins")).sendKeys("15");
			}catch(Exception e)
			{
				System.out.println(e);
				}

			//Fill instalattion date
			DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
			Date date = new Date(0);
			try{
				Thread.sleep(1500);
			driver.findElement(By.name("installationDate")).sendKeys(dateFormat.format(date));
			}catch(Exception e)
			{
				System.out.println(e);
				}

			//Fill Expiry date
			Calendar c = Calendar.getInstance();
			c.setTime(new Date(0));
			c.add(Calendar.DAY_OF_MONTH, 21);
			try{
				Thread.sleep(1500);
			driver.findElement(By.name("warrantyExpiry")).sendKeys((dateFormat.format(c.getTime())));
			}catch(Exception e)
			{
				System.out.println(e);
				}
			//Fill Ewe App Id
			try{
				Thread.sleep(1500);
			driver.findElement(By.id("eweAppId")).sendKeys("12390");
			}catch(Exception e)
			{
				System.out.println(e);
				}
			//Fill Sms Charge Id
			try{
				Thread.sleep(1500);
			driver.findElement(By.name("smsChargeId")).sendKeys("8901");
			}catch(Exception e)
			{
				System.out.println(e);
				}

			//Press Save
			try{
				Thread.sleep(1500);
			driver.findElement(By.xpath("//button[@class='btn btn-success btn-clean']")).click();
			}catch(Exception e)
			{
				System.out.println(e);
				}

			//Go to DEVICES Tab
			try{
				Thread.sleep(1500);
			driver.findElement(By.id("devices")).click();
			driver.findElement(By.linkText("List")).isDisplayed();
			driver.findElement(By.linkText("Map")).isDisplayed();
			driver.findElement(By.linkText("Events")).isDisplayed();
			driver.findElement(By.linkText("Overview")).isDisplayed();
			}catch(Exception e)
			{
				System.out.println(e);
				}
			//Search for device already created
			try{
				Thread.sleep(1500);
			driver.findElement(By.id("search2")).sendKeys(device);
			}catch(Exception e)
			{
				System.out.println(e);
				}

			//Press Search Button
			try{
				Thread.sleep(1500);
			driver.findElement(By.id("btnSearch")).click();
			}catch(Exception e)
			{
				System.out.println(e);
			}
				//Check the device's status
				//Find organisation already created in the table of organisations
				 WebElement table = driver.findElement(By.id("table_wrapper"));

				// Now get all the TR elements from the table
				java.util.List<WebElement> allRows = table.findElements(By.tagName("tr"));
				// And iterate over them, getting the cells
				for (WebElement row : allRows) {
				java.util.List<WebElement> cells = row.findElements(By.tagName("td"));
				for (WebElement cell : cells)
				if(cell.getText()== device);
				{
				}
				
				}
		        try{
				Thread.sleep(1500);
				if(driver.getPageSource().contains("Unknown"))
						{
					test = true;
					System.out.println("Device's status is in Unknown status");
				}
				else
				{
					System.out.println("Device has wrong status");
				 }
				}catch(Exception e)
				{
				System.out.println(e);
				     }
				
				//Logout
				try{
				Thread.sleep(1500);
				driver.findElement(By.className("icon-eject")).click();
				}catch(Exception e)
				{
				System.out.println(e);
				}
		
		}
		  
  }

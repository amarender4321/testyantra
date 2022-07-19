package org.vtiger.documents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.FileUtility;
import org.tyss.genericUtility.IConstants;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebDriverUtility;

public class CreateDocumentsTest {

	public static void main(String[] args) {
		//create objects for Generic Utility
				FileUtility fileUtility=new FileUtility();
				JavaUtility javaUtility=new JavaUtility();
				ExcelUtility excelUtility= new ExcelUtility();
				WebDriverUtility webdriverUtility= new WebDriverUtility();
				
				//intiallize data from property file
				fileUtility.intiallizePropertyFile(IConstants.VITIGERPROPERTYFILEPATH);
				
				//Generate the random Number
				int randomNumber=javaUtility.getRandomNmber();
				
				//get the control for particular sheet in excel
			//	excelUtility.intiallizeExcelFile(IConstants.VITIGEREXCELFILEPATH);
				
				
				//Fetch the data from property file
				String browser = fileUtility.getDtaFromProperty("browser");
				String userName = fileUtility.getDtaFromProperty("username");
				String password = fileUtility.getDtaFromProperty("password");
				String url = fileUtility.getDtaFromProperty("url");
				String timeouts = fileUtility.getDtaFromProperty("timeout");
				long time = javaUtility.convertStringToLong(timeouts);
				//launching the browser
				WebDriver driver = webdriverUtility.setupDriver(browser);
				
				//Fetch the data from Excel File
			//	String expectedCampaignName = excelUtility.getDataFromExcel(4,2,"Campaign")+randomNumber;
					
				//pre-setting the browser
				webdriverUtility.maximizeBrowser();
				webdriverUtility.implicitWait(time);
				
				
				//intililize the Explicit wait,Actions
				webdriverUtility.intiallizeActions();
				
				//navigating the application
				webdriverUtility.openApplicion(url);
				//login to the app
				driver.findElement(null);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
				
			
/*WebDriver driver=new ChromeDriver();
Actions a= new Actions(driver);

driver.get("http://localhost:8888/");*/

driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
driver.findElement(By.xpath("//input[@id='submitButton']")).click();
driver.findElement(By.xpath("//a[@href='index.php?module=Documents&action=index']")).click();
driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	}

}

package org.vtiger.organizations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.FileUtility;
import org.tyss.genericUtility.IConstants;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException {
		
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

			//pre-setting the browser
			webdriverUtility.maximizeBrowser();
			webdriverUtility.implicitWait(time);

			//intililize the Explicit wait,Actions
			webdriverUtility.intiallizeActions();

			//navigating the application
			webdriverUtility.openApplicion(url);

			//Login application
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(userName);
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	    
	    
	    String actualorganizationName = "QSPR_";
	    driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	    driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(actualorganizationName+randomNumber);
	    driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	    String actualorganization = actualorganizationName+randomNumber;
	    WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='dvHeaderText']"))));
	   String expected = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
	   if(expected.equals(actualorganizationName)) {
		   	System.out.println("pass");
	   }
	   else {
		   System.out.println("fail");
	   }
	   WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 //  a.moveToElement(wb).perform();
	   driver.findElement(By.linkText("Sign Out")).click();
	    	driver.close();	
	}

}

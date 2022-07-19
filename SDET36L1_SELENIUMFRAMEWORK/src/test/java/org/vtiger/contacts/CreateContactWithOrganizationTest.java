package org.vtiger.contacts;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.FileUtility;
import org.tyss.genericUtility.IConstants;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebDriverUtility;

public class CreateContactWithOrganizationTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		//create objects for Generic Utility
		FileUtility fileUtility=new FileUtility();
		JavaUtility javaUtility=new JavaUtility();
		ExcelUtility excelUtility= new ExcelUtility();
		WebDriverUtility webdriverUtility= new WebDriverUtility();


		//intiallize data from property file
		fileUtility.intiallizePropertyFile(IConstants.VITIGERPROPERTYFILEPATH);

		//Generate the random Number
		int randomNumber=javaUtility.getRandomNmber();


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
		
		
		    //Business code
		    driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		    driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		                                            //  driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(stcel+randomNumber);
	                                            	//    String expectedOrganizationName = stcel+randomNumber;
		    driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		    driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		   // driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(pars);
		    
		    Set<String> winids = driver.getWindowHandles();
		    for(String id:winids) {
		    driver.switchTo().window(id);
		    if(driver.getCurrentUrl().contains("contacts"));
	                                               //   driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(expectedOrganizationName);
		    driver.findElement(By.xpath("//input[@name='search']")).click();
		    
		    
	  
	          
		} 

	}

}

package org.vtiger.contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.FileUtility;
import org.tyss.genericUtility.IConstants;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CretaeContactsTest_2 {

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
			

/*

driver.findElement(By.linkText("Contacts")).click();
expected = data;
driver.findElement(By.xpath("//img[@tittle='Create Contact... ']")).sendKeys(data);
driver.findElement(By.xpath("//input[@name='button'][1][1]")).click();
driver.findElement(By.id("dtlview_Last Name")).getText();
System.out.println(actual);


/*
  System.out.println(expected);
if(actual.equals(expected)) {
	System.out.println("pass");
}
 else
	System.out.println("Fail");
Actions a=new Actions(driver);
WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
a.moveToElement(wb).perform();
driver.findElement(By.linkText("Sign Out")).click();
driver.close();
}
*/

	}


}
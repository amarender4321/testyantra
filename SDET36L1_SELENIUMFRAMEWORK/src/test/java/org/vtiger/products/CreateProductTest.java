package org.vtiger.products;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.FileUtility;
import org.tyss.genericUtility.IConstants;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest {

	public static void main(String[] args) {
		
		/*
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
Actions a=new Actions(driver);
driver.get("http://localhost:8888/");
Random ran=new Random();
int randomNumber = ran.nextInt();




driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
driver.findElement(By.xpath("//input[@id='submitButton']")).click();*/
		
		
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

String productName = "paperbags_";


driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productName+randomNumber);
driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
String actualproduct = productName+randomNumber;
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='lvtHeaderText']"))));
 String text = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

if(text.equals(actualproduct)) {
	System.out.println("pass");
}
else {
	System.out.println("fail");
}

WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

webdriverUtility.mouseHoverOnElement(wb);

//a.moveToElement(wb).perform();
driver.findElement(By.linkText("Sign Out")).click();
driver.quit();
}
	}


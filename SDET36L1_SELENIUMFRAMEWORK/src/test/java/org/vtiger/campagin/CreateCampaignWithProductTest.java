package org.vtiger.campagin;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

public class CreateCampaignWithProductTest {

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
	    

	FileInputStream fisexcel=new FileInputStream("./src/test/resources/testdata.xlsx");
	    Workbook workbook = WorkbookFactory.create(fisexcel);
        String stcel = workbook.getSheet("Products").getRow(2).getCell(1).getStringCellValue();
	    
	    //Thread.sleep(3000);
	    driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	  driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(stcel+randomNumber);
	 
		String expectedName = stcel+randomNumber;
		
	    driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	    System.out.println("product created succesfully");
	    
	    
		   WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='lvtHeaderText']"))));
	     WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
	     webdriverUtility.mouseHoverOnElement(wb);
	 //   a.moveToElement(wb).perform();
	    
	   driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
	   driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	   
	   
	   String campaignName = "Deleep_";
	                      String expectedCampaign = campaignName+randomNumber;
	   
	   driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(expectedCampaign);
	   
	     
	   
	   driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	   WebDriverWait wait1 =new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[@class='moduleName']"))));
	  Set<String> winIds = driver.getWindowHandles();
	  for( String id:winIds) {
		  driver.switchTo().window(id);
		  if(driver.getCurrentUrl().contains("Products")) {
			  break;
		  }
		  
	  }
  driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(stcel);
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
// driver.findElement(By.xpath("//a[.='')).click();
	   driver.findElement(By.xpath("//a[.='"+stcel+"'")).click();
	 driver.switchTo().defaultContent();
	  driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

	}

}

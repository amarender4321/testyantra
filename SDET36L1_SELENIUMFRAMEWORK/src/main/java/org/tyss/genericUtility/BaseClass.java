package org.tyss.genericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.FileUtility;
import org.tyss.genericUtility.IConstants;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebDriverUtility;
import org.vtiger.objectRepository.CommonPage;
import org.vtiger.objectRepository.LoginPage;

public class BaseClass extends InstanceClass{
	@BeforeSuite
	public  void suiteSetup() {
		//create objects for Generic Utility
		 fileUtility=new FileUtility();
		 javaUtility=new JavaUtility();
		 excelUtility= new ExcelUtility();
		 webDriverUtility= new WebDriverUtility();
		
		
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
		
	}
	@BeforeClass
	public void ClassSetup() {

		//launching the browser
		WebDriver driver = webDriverUtility.setupDriver(browser);
		
		//pre-setting the browser
				webDriverUtility.maximizeBrowser();
				webDriverUtility.implicitWait(longTimeout);
				
				
				//intililize the Explicit wait,Actions
				webDriverUtility.intiallizeActions();
				loginPage=new LoginPage(driver);
				commonPage=new CommonPage(driver);
				

				//navigating the application
				webDriverUtility.openApplicion(url);
				
	}
	
			
		
@BeforeMethod
public void  methodSetup() {
	randomNumber=javaUtility.getRandomNmber();
	loginPage.loginAction(userName, password);
	
}

@AfterMethod
public void methodTearDown() {
	
	commonPage.logoutAction(webDriverUtility);
}
@AfterClass
public void classTearDown() {
	//close Browser
	webDriverUtility.closeBrowser();
}

}

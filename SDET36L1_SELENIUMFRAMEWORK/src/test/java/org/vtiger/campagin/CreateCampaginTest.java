package org.vtiger.campagin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.tyss.genericUtility.BaseClass;
import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.FileUtility;
import org.tyss.genericUtility.IConstants;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebDriverUtility;
import org.vtiger.objectRepository.CampaignInformationPage;
import org.vtiger.objectRepository.CommonPage;
import org.vtiger.objectRepository.CreateNewCampaignPage;
import org.vtiger.objectRepository.LoginPage;

public class CreateCampaginTest {

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
		
		
		//Fetch the data from Excel File
	String expectedCampaignName = excelUtility.getDataFromExcel(2,2,"Contacts")+randomNumber;
		
		
		//create object for POM repo classes
		LoginPage loginpage=new LoginPage(driver);
		CommonPage commonpage=new CommonPage(driver);
		CreateNewCampaignPage createNewCampaignpage=new CreateNewCampaignPage(driver);
		CampaignInformationPage campaignInformationPage=new CampaignInformationPage(driver);
	
	//Login 
		loginpage.loginAction(userName, password);
		commonpage.clickCampign(webdriverUtility);
		//createNewCampaignpage.createCampaign(expectedCampaignName);
		String actualCampaignName = campaignInformationPage.getActualCampaignName();
	if(actualCampaignName.equals(expectedCampaignName))
		{
		javaUtility.printStatement("Campaign is created succesfully---->TC is Pass");
	}
		else {
			javaUtility.printStatement("Campaign is not created ---->TC is Fail");

		}
		commonpage.logoutAction(webdriverUtility);
		webdriverUtility.closeBrowser();
	
}

}

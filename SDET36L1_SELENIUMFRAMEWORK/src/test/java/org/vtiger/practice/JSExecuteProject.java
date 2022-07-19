package org.vtiger.practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.tyss.genericUtility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSExecuteProject {

	public static void main(String[] args) {
		/*
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
JavaUtility javaUtility=new JavaUtility();
JSExecuteProject currentclass=new JSExecuteProject();
JavascriptExecutor js=(JavascriptExecutor) driver;
js.executeScript("window.location='http://localhost:8888'");
WebElement userNameTxtFIeld = driver.findElement(By.xpath("//input[@name='user_name']"));
WebElement passwordTxtField = driver.findElement(By.xpath("input[@name='user_namepassword']"));
WebElement loginBtn = driver.findElement(By.xpath("//input[@id='submitButton']"));
js.executeScript("arguments[0]. value=arguments[1]",userNameTxtFIeld,"admin");
js.executeScript("arguments[0]. value=arguments[1]",passwordTxtField,"admin");
js.executeScript("arguments[0]. click()",loginBtn);
//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//js.executeScript("window.scrollBy(0,300");
driver.findElement(By.xpath("//b[contains(.,'Top Quotes')]"));
js.executeScript("arguments[0].scrollIntView()",scrollTillElement);
TakesScreenshot ts=(TakesScreenshot)driver;
File src=ts.getScreenshotAs(OutputType.FILE);
File dst = new File("./errorsshot/"+currentclass.getClass().getSimpleName()+javaUtility.getCurrentData("dd_mm_yyyy_HH_mm_sss"));
try {
	FileUtils.copyFile(src,dst);
}
catch(IOException e) {
	e.printStackTrace();
}*/

		
	}

}

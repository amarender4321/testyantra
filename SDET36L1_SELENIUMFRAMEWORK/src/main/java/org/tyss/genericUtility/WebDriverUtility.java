package org.tyss.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains all the webdriver actions
 * @author AMARENDER
 * @param <SwitchWindow>
 *
 */

public final class WebDriverUtility{
	private  WebDriver driver;
	private Actions act;
	private WebDriverWait wait;
	/**
	 * This method is used to setup the driver instance
	 * @param browser
	 * @return
	 */
	public WebDriver setupDriver(String browser)
	{
		switch (browser) {
		
		
		case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;		
		case "ie":
		WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
		break;
		
		
	default :
		System.out.println("You entered wrong key in the property file");
		break;
		}
		return driver;
		
	}
	
	
	/**
	 * This method is used to maximaize the browser
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	/**
	 * This method  is used to  wait the page by using implicit wait
	 * @param longTimeout
	 */
	public void implicitWait(long longTimeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}
	
	/**
	 * This browser is used to navigate the application
	 */
	
	public void openApplicion(String url) {
		driver.get(url);
	}
	
	/**
	 * This method is used to initialize the application
	 * @param url
	 */
	public void intiallizeActions() {
		act= new Actions(driver);
	}
	/**
	 * this method is used to Mouse hover on Element
	 * @param element
	 */
	public void mouseHoverOnElement(WebElement element) {
		act.moveToElement(element).perform();
	}
	/**
	 * This method is used to perform right click action on current mouse location
	 */
	public void rightClickAction() {
		act.contextClick().perform();
	}
	/**
	 *  This method is used to perform right click action on particular webelement
	 *  @param element
	 */
	public void rightClickAction(WebElement element) {
		act.contextClick(element).perform();
	}
	
	
	/**
	 * This method is used to switch frame by index
	 * @param index
	 */
	public void switchframe(int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * Thia method is used to switch frame by web element
	 * @param element
	 */
	public void switchframe(WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch by name or id 
	 */
	public void switchframe(String nameorid) {
		driver.switchTo().frame(nameorid);
	}
	/**
	 * This method is used to close particular Browser
	 */
	
	public void closeBrowser() {
		driver.quit();
	}
	/**
	 * This method is used to close particular Tab
	 */
	public void closeTab() {
		driver.close();
	}
	/**
	 * This method is used to handle <select>tagDropdown by using visible text
	 * @param dropdownElement
	 * @param visibleText
	 */
	public void handleSelectDropdown(WebElement dropDownElement,String visibleText) {
		Select select =new Select(dropDownElement);
		select.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method is used to switch the window
	 * @param partilText
	 * @param  strategy
	 */
	public void switchwindow(String partialText,String strategy) {
		Set<String> winds = driver.getWindowHandles();
		for(String id:winds) {
			driver.switchTo().window(id);
			if(strategy().toString().equalsIgnoreCase("URL")) {
				if(driver.getCurrentUrl().contains(partialText)) {
					break;
				}
			
				else if(strategy.toString().equalsIgnoreCase("Tittle")) {
					if(driver.getTitle().contains(partialText)) {
						break;
					}
				}
					}
		}
		
	}
	private Object strategy() {
		return null;
	}


	/**This method is used to handle <select>tagDropdown by using  value attribute of the <option> tag
	 * @param value 
	 * @param dropDownElement
	 * 
	 * 
	 */

	public void handleSelectDropdown( String value,WebElement dropDownElement) {
		Select select =new Select(dropDownElement);
		select.selectByValue(value);
	}
	/**
	 * This method will wait till the element is clickable(custom wait)
	 * @param totalDuration
	 * @param pollingTime
	 * @param element
	 */
	public void waitTillElementClickable(int totalDuration,long pollingTime,WebElement element) {
		int currentTime=0;
		while(currentTime<=totalDuration) {
			try {
				element.click();
				break;
			}catch(Exception e){
				try {
					Thread.sleep(pollingTime);
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				currentTime++;
				
			}
		}
	}
	/**
	 * This method is used to iniallize the Explict wait or webdriverWait
	 * @param timeOuts
	 */
	public void intiallizeExplicitWait(long timeOuts, long pollingTime) {
		 wait = new WebDriverWait(driver,Duration.ofSeconds(pollingTime));
		wait.pollingEvery(Duration.ofMillis(pollingTime));
		wait.ignoring(Exception.class);
	}
	/**
	 * This method is used to take the particular element screen Shot
	 * @param element
	 * @paream currentClass
	 * @param javaUtility
	 */
	public void takeScreenShotElement(WebElement element,Object currentClass,JavaUtility javaUtility) {
	File src	=element.getScreenshotAs(OutputType.FILE);
	File dst = new File("./elementScreenShot/"+currentClass.getClass().getSimpleName()+javaUtility.getCurrentData("dd_MM_yyyy_mm_ssss"));
	try {
		FileUtils.copyFile(src, dst);
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	}
	/**
	 * This method is used to take  the current page screen shot
	 * @param current
	 * @param javaUtility
	 */
	public void takeScreenShotPage(Object currentClass,JavaUtility javaUtility) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src	=ts.getScreenshotAs(OutputType.FILE);
	File dst = new File("./errorshots/"+currentClass.getClass().getSimpleName()+" "+javaUtility.getCurrentData("dd_MM_yyyy_HH_mm_sss")+".png");
		try {
			FileUtils.copyFile(src, dst);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to  untill element is visible
	 */
	public void waitTillElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to  untill element is invisible
	 * @param
	 */
	public void waitTillElementInvisible(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public void jsPopupaccept() {
		driver.switchTo().alert().accept();
	}
	public void jsPopupdecline() {
		driver.switchTo().alert().dismiss();
	}
	public void jsPopupSendData(String data) {
		driver.switchTo().alert().sendKeys(data);
	}
	public void jsPopupText() {
		driver.switchTo().alert().getText();
	}
	/**
	 * This method is used to handle <select>tag Dropdown by using index
	 * @param dropDownElement
	 * @param indexNumber
	 */

	public void handleSelectDropdown(WebElement dropDownElement,int indexNumber) {
		Select select =new Select(dropDownElement);
		select.selectByIndex(indexNumber);
	}
	  void switchWindow(String partialText,String strategy) {
		 Set<String> winds = driver.getWindowHandles(); 
		 for(String id:winds) {
			 driver.switchTo().window(id);
			 if(strategy.equalsIgnoreCase("url")) {
				 if(driver.getCurrentUrl().contains(partialText)) {
					 break;
				 }
			 }
			 else if(strategy.equalsIgnoreCase("tittle")) {
				 if(driver.getTitle().contains(partialText)) {
					 break;
				 }
			 }
		 }
		  
	  }
	
	}
	


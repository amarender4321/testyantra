package org.tyss.genericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains all the JS resuble Method/actions
 * @author AMARENDER
 *
 */
public final class JSExeutorUtility {
	private JavascriptExecutor js;
	/**
	 * Intiallize the JavaScript Excuutor
	 * @param
	 */
	public void intialliazeJSExecutor(WebDriver driver) {
		js=(JavascriptExecutor)driver;
	}
/**
 * NavigateApp by using JsExcutor
 * @param=url
 */
	public void navigateApp(String url) {
		js.executeScript("window.location=arguments[0]",url);
	}
	/**
	 * This method is used to  send ths data textfield usingJSExecutor
	 * @param element
	 * 
	 */
	public void enterData(WebElement element,String data) {
		js.executeScript("arguments[0].value=arguments[1]", element ,data);
	}
	/**
	 * This method is used to click on the element using JSExcutor
	 * @param element
	 */
	public void clickOnElement(WebElement element) {
		js.executeScript("argumments[0].click()",element);
	}
	/**
	 * This method is used to scroll till the end of page
	 */
	public void scrollTillEnd(String strategy) {
		String sign=strategy.equalsIgnoreCase("up") ?" ":"+";
		js.executeScript("window.scrollBy(0,"+sign+"document.body.scrollheight)");
		
	}
	/**
	 * This method is used to scrolltill some position
	 * @param y_position
	 */
	public void scrollTillSomePosition(int y_position,String strategy) {
		String sign = strategy.equalsIgnoreCase("up") ? " ":"+";
		js.executeScript("window.scrollBy(0,"+sign+"arguments[0])", y_position);
	}
	/**
	 * This methos is used to scroll till the element is visible
	 * @param element
	 */
	public void scrollTillElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
	/**
	 * This method is used to highlight the element
	 * @param element
	 */
	public void highlightElement(WebElement element) {
		js.executeScript("aruguments[0].setAttribute('style','border:5px solid red;')",element);
		
	}
	

}

package org.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.WebDriverUtility;

public class CommonPage  {
	
	public CommonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[.='More']")
	private WebElement moreTab;
	@FindBy(xpath="//a[.='Campaigns']")
	private WebElement CampaignsTab;
	@FindBy(xpath="//img[@src=;themes/softed/images/user.PNG']")
	private WebElement admitratorIcon;
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement  signOutLink;
	
	//business library
	
	/**
	 * This method is used to click on campaign tab in common page
	 * @param webdriverUtility
	 */
public void clickCampign(WebDriverUtility webdriverUtility) {
	webdriverUtility.mouseHoverOnElement(moreTab);
	CampaignsTab.click();
}
/**
 * This method is used to signout from the application
 * @param webdriverUtility
 */
public void logoutAction(WebDriverUtility webdriverUtility) {
	webdriverUtility.mouseHoverOnElement(admitratorIcon);
	signOutLink.click();
}





}

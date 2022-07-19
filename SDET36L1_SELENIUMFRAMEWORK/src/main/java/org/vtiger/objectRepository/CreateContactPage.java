package org.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

public CreateContactPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


@FindBy(xpath = "//a[.='Contacts']")
private WebElement ClickOnContactModule;


@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement ClickOnContactsNewBtn;

//kjvb

@FindBy(xpath = "//input[@name='lastname']")
private WebElement EnterLastNameTextField;



@FindBy(xpath = "//input[@class='crmButton small save']")
private WebElement LastNameSaveBtn;



public void clickContactModule() {
	ClickOnContactModule.click();
}
public void clickContactNewBtn() {
	ClickOnContactsNewBtn.click();
}
public void enterLastName() {
	EnterLastNameTextField.sendKeys();
}
public void saveLastName() {
	LastNameSaveBtn.click();
	
}
	
}

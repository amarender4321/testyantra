package org.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	
@FindAll({@FindBy(xpath="//form[@id='login']/div[1]/input[@name='email']"),@FindBy(name="user_name")})
private WebElement emailTextField;


@FindBy(xpath="//form[@id='login']/div[2]/input[@name='password']")
private WebElement passwordTextField;

@FindBy(xpath="//button[text()='Login']")
private WebElement loginBtn;


public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void loginAction(String userName,String password) {	
	emailTextField.sendKeys( userName);
	passwordTextField.sendKeys(password);
	loginBtn.click();
}

}

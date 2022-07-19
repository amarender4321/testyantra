package org.tyss.genericUtility;

import org.tyss.genericUtility.ExcelUtility;
import org.tyss.genericUtility.FileUtility;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.WebDriverUtility;
import org.vtiger.objectRepository.CommonPage;
import org.vtiger.objectRepository.LoginPage;

public class InstanceClass {

	public WebDriverUtility webDriverUtility;
public 	FileUtility fileUtility;
public 	ExcelUtility excelUtility;
protected String browser;
protected String userName;
protected String password;
protected String url;
protected long longTimeout;
protected LoginPage loginPage;
protected CommonPage commonPage;
public int randomNumber;
public	JavaUtility javaUtility;

}

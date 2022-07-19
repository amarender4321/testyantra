package org.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateDatabaseWrtoDui_rmgyantraTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    System.out.println("Brower launched");
   driver.get("http://localhost:8084/");
   Random ran=new Random();
  int randomNumber = ran.nextInt(1000);
  
  String projectName="srth"+randomNumber;
     driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
    driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[.='Sign in']")).click();
	System.out.println("Successfully Login");
	
	driver.findElement(By.xpath("//a[.='Projects']")).click();
	driver.findElement(By.xpath("//span[.='Create Project']")).click();
	driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectName);
	driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("raju");
    WebElement projectStatusDropDown = driver.findElement(By.xpath(" //label[.='Project Status ']/following-sibling::select"));
	Select s=new Select(projectStatusDropDown);
	s.selectByValue("On Going");
	driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
	System.out.println("Successfully created project");
	
	try {
	Driver dbDriver =new Driver();
	DriverManager.registerDriver(dbDriver);
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	Statement statement = connection.createStatement();
	statement.executeQuery("select project_name from project;");
	connection.close();
	}
	catch(Exception d) {
		d.printStackTrace();
	}
	driver.quit();
	}
}


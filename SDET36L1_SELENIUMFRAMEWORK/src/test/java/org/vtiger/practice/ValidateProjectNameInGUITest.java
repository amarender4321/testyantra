package org.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateProjectNameInGUITest {

	public static void main(String[] args) {
	int randomNumber = new Random().nextInt(100);
	String expectedProjectName = "TYSS67_"+ randomNumber;
try {
	Driver dbDriver=new Driver();

	DriverManager.registerDriver(dbDriver);
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	Statement statement = connection.createStatement();
	statement.executeUpdate("insert into project values ('TY_PROJ_"+ randomNumber +"','basker','20-04-2022','"+expectedProjectName+"','completed',20);");
connection.close();
}
catch(SQLException s ) {
	s.printStackTrace();
}

WebDriverManager.chromedriver().setup();
WebDriver driver =new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("http://localhost:8084/");
driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
driver.findElement(By.xpath("//button[.='Sign in']")).click();
System.out.println("Successfully Login");
driver.findElement(By.xpath("//a[.='Projects']")).click();
List<WebElement> projectsName = driver.findElements(By.xpath("//td[2]"));
	for(WebElement project:projectsName) {
		String name = project.getText();
		if(expectedProjectName.equals(name)) {
	System.out.println("New projected is created");
	break;
	}
	}
	driver.quit();
		
		}
	
	
	}



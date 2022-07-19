package org.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabasePactice {

	public static void main(String[] args) throws SQLException  {
	Driver driver = null;
	try {
		driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
		 Statement statement = connection.createStatement();
		int result =statement.executeUpdate("insert into sdet35 values(1002,'pandu',7032641616,'pandu@gmail.com','cheenai');");
		//int result =statement.executeQuery("select* from tyss;");
		//while 

		
		if(result==1) {
			System.out.println("data is entered into data basr");
			
		}
		else
			System.out.println("fail");
		
		connection.close();	
	}
	catch(Exception e) {}
	//ResultSet result = statement.executeQuery("select * from sdet35;");
	/*int count=0;
	while(result1.next()) {
		System.out.println(result1.getString(3)+" "+result1.getString("empName"));
	if(result1.getString("empName").equals("pandu")) {
		System.out.println("data is present in the database");
		
		count++;
	}
	
	}
	if(count==0) {
		System.out.println("data is not present the database");
	}*/
	
	
	}

}

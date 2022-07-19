package org.tyss.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.sun.tools.javac.util.List;

public class DatabaseUtility {
	 Connection connection;
	  Statement   statement;
	  ResultSet resultfetch;
	  
	  /**
	   * This method is to resister and get connection with database
	   * @param url
	   * @param userName
	   * @param password
	   */
	  public void resisterDriver(String url,String userName, String password) {
		  Driver driver;
		  try {
			  driver=new Driver();
			  DriverManager.registerDriver(driver);
		  }
		  catch(SQLException e) {
			  e.printStackTrace();
		  }  
	  }
/**
 * This method is used modify the data
 * @param sql query
 * @return
 * 
 */
	  public int modifyDataInDB(String sqlQuery) {
		  try {
			  statement=connection.createStatement();
		  }

		  catch(SQLException e) {
			  e.printStackTrace();
		  }  
		  int result=0;
		  try {
			  result=statement.executeUpdate(sqlQuery);
		  }

		  catch(SQLException e) {
			  e.printStackTrace();
		  } 
		  
			  return result;
		  }  
		  /**
		   * this method is used to fetch the data from database
		   * @param table
		   */
		   
		public void  fetchTheDataFromDatabase(String table) {
			 try {
				  resultfetch=statement.executeQuery(table);
			  }
			 catch(SQLException e) {
				  e.printStackTrace();	  
		  }
	  }
		public boolean verifyDataInDB1(String query,String coloumnNumberorColoumnIndex, String expectedData )
		{
			List<String>list = getDataFromDB1(query,coloumnNumberorColoumnIndex);
			System.out.println(list);
			boolean flag=false;
			for(String data:list)
			{
				if(data.equalsIgnoreCase(expectedData))
				{
					flag=true;
					break;
				}
			}
			return flag;
		}
		private List<String> getDataFromDB1(String query, String coloumnNumberorColoumnIndex) {
			return null;
		}
		/**
		 * This method is used to close connection of database
		 */
		public void closeConnection1()
		{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
/*
		public boolean verifyDataInDB(String query,String coloumnNumberorColoumnIndex, String expectedData )
		
		{
			List<String>list = getDataFromDB1(query,coloumnNumberorColoumnIndex);
			System.out.println(list);
			boolean flag=false;
			for(String data:list)
			{
		

				if(data.equalsIgnoreCase(expectedData))
				{
					flag=true;
					break;
				}
			}
			return flag;
		}
		private List<String> getDataFromDB(String query, String coloumnNumberorColoumnIndex) {
			return null;
		}/**
		 * This method is used to close connection of database
		 */
	/*	public void closeConnection()
		{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
			}
		
		
	  
	  
	  
	  
	  


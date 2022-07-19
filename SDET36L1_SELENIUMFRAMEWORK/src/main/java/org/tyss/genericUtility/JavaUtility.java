package org.tyss.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This ClassContains java reusable methods
 * @author AMARENDER
 *
 */
public final class JavaUtility {
	/**
	 * This method is used  to generate the Random Number with  in limit
	 * @param int
	 */
	
	public int getRandomNumber(int limit) {
		return new Random().nextInt(limit);
	}
	
	
	
	
	
/**
 * This method is used to generate the Random Number with in 1000
 * @param int
 */
	public int getRandomNmber() {
		return new Random().nextInt(1000);
	}
	/**
	 * This method is used to convert the String to long data type
	 * @param stringData
	 * return
	 */
	public long convertStringToLong(String stringData) {
		return Long.parseLong(stringData);
	
	}
	/**
	 * This method is used to print the values in console 
	 * @param
	 */
	public void printStatement(String value) {
		System.out.println(value);
	}
	/**
	 * This method is used to split the string based on strategy
	 * @param value
	 * @param value
	 * @return
	 */
	public String[] splitString(String value,String strategy) {
		return value.split(strategy);
	}
	/**
	 * This method is used to get current data in specified strategy
	 * @param strategy 
	 * @return
	 */
	public String getCurrentData(String strategy) {
		return new SimpleDateFormat(strategy).format(new Date());
		
	}
}

package org.tyss.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains reusabel method for excel
 * 
 * @author AMARENDER
 *
 */

public class ExcelUtility {
	private Workbook workbook;
	/**
	 * this method is used to intiallize the excel file 
	 * @param excelpath
	 * @param sheetName
	 */
	
	public void intiallizeExcelFile(String excelPath) {
		FileInputStream fisExcel = null;
		
		try {
			fisExcel=new FileInputStream(excelPath)	;
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook=WorkbookFactory.create(fisExcel);
		}
		catch(EncryptedDocumentException  | IOException e){
			e.printStackTrace();
		}	
	}
	/**
	 * This method is used to Fetch the data from the Excel
	 * @param rowNumber
	 * @param cellNumber
	 * @param sheetName
	 * @return
	 * 
	 */
	public String getDataFromExcel(int rowNumber,int cellNumber,String sheetName) {
		Sheet sheet = workbook.getSheet(sheetName);
		return new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
	}
	/**
	 * This method is used to write the data to the excel
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber 
	 * @param value
	 */
	public void setDataIntoExcel(String sheetName,int rowNumber,int cellNumber,String value) {
		Sheet sheet=workbook.getSheet(sheetName);
		sheet.getRow(rowNumber).createCell(cellNumber).setCellValue(value);
		System.out.println("Data Entered");		
	}
	/**
	 * This method is used save the data into excel
	 * @param excelSavePath
	 */
	public void saveDataIntoExcel(String excelSavePath) {
		FileOutputStream fosExcel=null;
		try {
			fosExcel=new FileOutputStream(excelSavePath);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fosExcel);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to close the excel workbook
	 * 
	 */
	public void closeworkbook() {
		try {
			workbook.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}

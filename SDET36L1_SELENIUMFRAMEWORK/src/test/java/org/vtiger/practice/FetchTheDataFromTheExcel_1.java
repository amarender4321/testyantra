package org.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchTheDataFromTheExcel_1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		DataFormatter dataFormat= new DataFormatter();

		FileInputStream fisEccel=new FileInputStream("src/test/resources/testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fisEccel);
		Sheet sheet = workbook.getSheet("Contacts");
		
		for(int i=0; i<=sheet.getLastRowNum();i++) {
			  String data=dataFormat.formatCellValue(sheet.getRow(i).getCell(1));
			  if(data.equalsIgnoreCase("ContactLastName")) {
				  System.out.println(sheet.getRow(i+1).getCell(i));
				  break;
			  }

		}
		workbook.close();
	}

}

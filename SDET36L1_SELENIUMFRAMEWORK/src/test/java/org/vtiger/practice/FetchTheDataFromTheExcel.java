package org.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchTheDataFromTheExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		DataFormatter dataFormat= new DataFormatter();

FileInputStream fisEccel=new FileInputStream("src/test/resources/testdata.xlsx");
Workbook workbook = WorkbookFactory.create(fisEccel);
  String data=dataFormat.formatCellValue(workbook.getSheet("contacts").getRow(5).getCell(1));
System.out.println(data);
workbook.close();
	}

}

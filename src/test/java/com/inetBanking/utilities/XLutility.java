package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class XLutility {

	

	
	public static FileInputStream fis ;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	//File file = new File(System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/practiceCreds.xlsx");
	@Test
	
	
	public  static int getRowCount(String path , String sheetName ) throws Exception {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		int rowSize = sheet.getPhysicalNumberOfRows();
		workbook.close();
		fis.close();
		return rowSize;
	}
	public static int getcolCount(String path , String sheetName, int rowNo) throws Exception {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		int colSize = sheet.getRow(rowNo).getPhysicalNumberOfCells();
		workbook.close();
		fis.close();
		return colSize;
	}
	public static String getCellData(String path , String sheetName, int rowNo, int colNo) throws IOException  {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowNo);
		XSSFCell cell = row.getCell(colNo);
		String data;
		try {
			DataFormatter df = new DataFormatter();
			String cellValue  = df.formatCellValue(cell);
			return cellValue;
		} catch (Exception e) {
			data = " ";
		}
		workbook.close();
		fis.close();
		return data;
//		DataFormatter df = new DataFormatter();
//		String cellValue  = df.formatCellValue(cell);
//		return cellValue;
	}
}

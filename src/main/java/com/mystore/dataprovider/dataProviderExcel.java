package com.mystore.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class dataProviderExcel {

	public static String excelPath = System.getProperty("user.dir") + "\\TestData.xlsx";

	//dataprovider without hashmap to create account
	@DataProvider(name = "testDataInput")
	// public Object[][] getTestData(String sheetName) throws IOException {
	public Object[][] getTestData() throws IOException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook book = new XSSFWorkbook(file);

		// XSSFSheet sheet = book.getSheet(sheetName);
		XSSFSheet sheet = book.getSheet("sheet2");
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k] + "   ");
			}
			System.out.println();
		}
		return data;

	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>dataprovider with hashmap to create account
	@DataProvider(name = "HM")
	// public Object[][] getTestData(String sheetName) throws IOException {
	public Object[][] getTestDataHM() throws IOException {
		HashMap<String, String> hashMap = new HashMap<String,String>();
		FileInputStream file = null;
		try {
			file = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook book = new XSSFWorkbook(file);

		// XSSFSheet sheet = book.getSheet(sheetName);
		XSSFSheet sheet = book.getSheet("sheet2");
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				hashMap.put(sheet.getRow(i).getCell(k).toString(), 
							sheet.getRow(i + 1).getCell(k).toString());
				//data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				//System.out.println(data[i][k] + "   ");
			}
			for(String i1 :hashMap.keySet())
			{
				System.out.println(hashMap.get(i1));
			}
			//System.out.println();
		}
		return new Object[][]{ 
			{hashMap}
			};
		}

}


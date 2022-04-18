package com.apachePOI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Utility {
	@DataProvider
	public static String[][] getExcelData(String fileName, String sheetName) {
		String [][] arrayActualData = null;
		try { 
				FileInputStream fis = new FileInputStream(fileName);
			    XSSFWorkbook workbook = new XSSFWorkbook(fis);
			    XSSFSheet spreadsheet = workbook.getSheet(sheetName);
			   
			    int rowCount = spreadsheet.getLastRowNum()+1;
			    int colCount = spreadsheet.getRow(1).getLastCellNum();
			    
			    
			    arrayActualData = new String[rowCount][colCount];
			    
			    
			    for(int i = 0; i<rowCount; i++){
			       	for(int j=0; j<colCount;j++){
			    		arrayActualData[i][j]=spreadsheet.getRow(i).getCell(j).getStringCellValue();
			    	}
			    }
			    workbook.close();
			    fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		
		return arrayActualData;
	}

}

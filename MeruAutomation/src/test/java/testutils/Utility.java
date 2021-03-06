package testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;



public class Utility {
	
	
	public static String[][] getExcelData(String Sheetname) throws IOException {

		// Xls File Initialization for Input
		FileInputStream xlfis = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Input.xls");

		String[][] arrayExcelData = null;
		System.out.println("Getting input data from getexceldata");
		HSSFWorkbook wb = new HSSFWorkbook(xlfis);
		Sheet sh = wb.getSheet(Sheetname);

		int totalNoOfRows = sh.getLastRowNum() + 1;
		int totalNoOfCols = sh.getRow(1).getLastCellNum();

		System.out.println(totalNoOfRows);
		System.out.println(totalNoOfCols);

		arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

		for (int i = 1; i < totalNoOfRows; i++) {

		for (int j = 0; j < (totalNoOfCols); j++) {
		arrayExcelData[i - 1][j] = sh.getRow(i).getCell(j).getStringCellValue();

		}

		}
		wb.close();
		return arrayExcelData;
		}
}  



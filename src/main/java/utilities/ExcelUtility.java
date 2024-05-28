package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	static FileInputStream file;
	static XSSFWorkbook excelworkbook;
	static XSSFSheet excelsheet;

	public static String getStringData(int a, int b, String sheet) {
		try {
			file = new FileInputStream("D:\\Java\\SeleniumBasics\\src\\main\\resources\\TestData.xlsx");
			excelworkbook = new XSSFWorkbook(file);
			excelsheet = excelworkbook.getSheet(sheet);
			Row r = excelsheet.getRow(a);
			Cell c = r.getCell(b);
			return c.getStringCellValue();
		} catch (Exception e) {
			throw new RuntimeException("TestData excel sheet not found");
		}

	}

	public static int getIntegerData(int a, int b, String sheet) {
		try {
			file = new FileInputStream("D:\\Java\\SeleniumBasics\\src\\main\\resources\\TestData.xlsx");
			excelworkbook = new XSSFWorkbook(file);
			excelsheet = excelworkbook.getSheet(sheet);
			Row r = excelsheet.getRow(a);
			Cell c = r.getCell(b);
			return (int) c.getNumericCellValue(); // converting double to integer

		} catch (Exception e) {
			throw new RuntimeException("TestData excel sheet not found");
		}
	}

}
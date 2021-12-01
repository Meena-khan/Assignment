package com.ether.genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author meena
 *
 */
public class ExcelLib {

	String filePath=Constants.excelFilePath;

	public String getCellData(String sheetName, int rowNum, int colNum) throws InvalidFormatException, IOException{
		FileInputStream excelInput=new FileInputStream(filePath);
		Workbook excelBook = WorkbookFactory.create(excelInput);
		Sheet sh = excelBook.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(colNum, Row.CREATE_NULL_AS_BLANK);
		if(cell.equals(null)){
			return cell.getStringCellValue().replaceAll(null, "");
		} 
		return cell.getStringCellValue();
	}

	public void setCellData(String sheetName, int rowNum, int colNum, String data) throws InvalidFormatException, IOException{
		FileInputStream excelInput=new FileInputStream(filePath);
		FileOutputStream excelOutput=new FileOutputStream(filePath);
		Workbook excelBook = WorkbookFactory.create(excelInput);
		Sheet sh = excelBook.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.createCell(colNum);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(data);
		excelBook.write(excelOutput);
		//excelOutput.close();
	}



	public int getRowCount(String sheetName) throws FileNotFoundException{
		int rowCount=0;

		FileInputStream excelInput = new FileInputStream(filePath);

		try {
			Workbook wb = WorkbookFactory.create(excelInput);
			Sheet sh = wb.getSheet(sheetName);

			rowCount = sh.getLastRowNum();
			return rowCount;
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	public int getTestCaseRowNumber(String sheetName, String expectedTestCaseName) throws InvalidFormatException, IOException{
		int rowNum=0;
		int lastRowNum=getRowCount(sheetName);

		for(int i=0;i<=lastRowNum;i++){
			String actualTestCaseName=getCellData(sheetName, i, 0);
			if(expectedTestCaseName.equals(actualTestCaseName)){
				rowNum=i;
				break;
			}
		}
		return rowNum;
	}

	public int getcolumnCountForRow(String sheetName,int rowNum) throws InvalidFormatException, IOException{
		int lastColumn = 0;
		FileInputStream excelInput=new FileInputStream(filePath);
		Workbook excelBook = WorkbookFactory.create(excelInput);
		Sheet sh = excelBook.getSheet(sheetName);
		lastColumn = sh.getRow(rowNum).getPhysicalNumberOfCells();

		return lastColumn;
	}


}

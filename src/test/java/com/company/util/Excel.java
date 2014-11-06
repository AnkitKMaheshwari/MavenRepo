package com.company.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.WebConsole.Formatter;


public class Excel {

		
		
		private FileInputStream file;
		private HSSFWorkbook workbook;
		private HSSFSheet sheet;
		private HSSFCell cell;
		private DataFormatter formatter;
		
		public void setExcel(String path, String sheetName) throws Exception
		{
			
			file = new FileInputStream(path);
			
			workbook = new HSSFWorkbook(file);
			// if you  have sheet name then do it
			sheet = workbook.getSheet(sheetName);
			
			
		
			// if you wan to give sheet no
			
			
		}
		
		
		public String getCellValue(int row, int column)
		{
			//System.out.println(row+"sdsds"+column);
			cell = sheet.getRow(row).getCell(column);
			formatter = new DataFormatter();
			return formatter.formatCellValue(cell);
		// This method have disadvantages
			//return cell.getStringCellValue();
			
			
		}
		public int gettotalRows() {
			// TODO Auto-generated method stub
			return sheet.getLastRowNum();
		}
		
		public int getTotalColumns(int row){
			return sheet.getRow(row).getLastCellNum();
		}
		
		
		
		
		
		
		
	}

	
	

package org.myhr.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.common.function.type4.Parser;
import org.apache.pdfbox.util.PDFTextStripper;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.myhr.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;





public class TestUtil extends TestBase {
	

	public static long Implicity_waitTime=40;
	public static long Page_Load_Timeout=40;
	public static String id;

	public static FileInputStream files;
	public static PDFParser parser;
	public static COSDocument cosdoc;
	public static PDDocument pddoc;
	public static PDFTextStripper striper;
	public static Workbook book;
	public static Sheet sheet;
	public static FileOutputStream fos;
	//public static XSSFWorkbook workbook;
	//public static XSSFSheet osheet;
	public static Row row ;
    public static Cell cell ;
    //public static FileInputStream fis;

	public static  List<String> list;
	

	public static  void clickByXpath(WebDriver ldriver,WebElement lxpath){
		Actions action=new Actions(ldriver);
		try {
			action.moveToElement(lxpath).click().build().perform();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public static String verifyPdfFile() {
		String data = "";
			try {
				files=new FileInputStream(new File(pro.getProperty("PdffileName")));
				parser=new PDFParser(files);
				parser.parse();			
				cosdoc=parser.getDocument();
				pddoc=new PDDocument(cosdoc);
				striper=new PDFTextStripper();
				data = striper.getText(pddoc);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return data;
			
	}
	
public static void deleteFileOperation(){
		   
		try {
			File file=new File(pro.getProperty("PdfFile"));
			File[] files=file.listFiles();
			 for(File f:files){
				   if(f.getName().endsWith(".pdf")){
					   f.delete();
					   System.out.println(f.getName() + "is Deleted!..."+ "");
					   break;
				   }
			 }
		} catch (Exception e) {
			
			e.printStackTrace();
		}	 
	
}

	
//public static Object[][] getTestdata(String sheetName){
//		
//		FileInputStream ofile=null;
//		try {
//			 ofile=new FileInputStream(DataFilePath); 
//		} 
//		catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		try {
//			book=WorkbookFactory.create(ofile);
//		} 
//		catch (InvalidFormatException e) {	
//			e.printStackTrace();
//		} 
//		catch (IOException e) {	
//			e.printStackTrace();
//		}
//		
//		sheet=book. getSheet(sheetName);
//		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//		System.out.println(sheet.getLastRowNum());
//    	System.out.println(sheet.getRow(0).getLastCellNum());
//		for(int i=0;i<sheet.getLastRowNum();i++){
//			
//			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
//				
////				DataFormatter formatter = new DataFormatter(); 
////				
////				 data[i][j]=formatter.formatCellValue(sheet.getRow(i+1).getCell(j));
//				 //Cell cell1 =sheet.getRow(i+1).getCell(j);
//				 sheet.getRow(i+1).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
//				 
//				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
//				
//				
//				System.out.println(data[i][j]);
//			
//			}
//		}
//		return data;
//	
//}
	
	
public static  String takeScreenshotAtEndOfTest(WebDriver driver,String screenshotName){
			String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts=(TakesScreenshot)driver;
			File srcfile=ts.getScreenshotAs(OutputType.FILE);
			String destfile=System.getProperty("user.dir")+"/failedTestsScreenshots/"+ screenshotName+dateName+System.currentTimeMillis() + ".png";
			try {
				
				FileUtils.copyFile(srcfile,new File(destfile));
		   } catch (IOException e) {
				
				e.printStackTrace();
			}
			return destfile;
	
}

public static void getScreenshotAtEndOfTest() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		String currentdir=System.getProperty("user.dir");
				try {
						FileUtils.copyFile(srcfile,new File(currentdir + "/screenshots/"+ System.currentTimeMillis() + ".png")); 
			    } catch (IOException e) {
				       e.printStackTrace();	 
	            }

}

	public static void explicity_WaitTime(WebElement element, int timeToWaitInSec) { 
		 	WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec); 
		 	wait.until(ExpectedConditions.visibilityOf(element)); 
	} 
	
	public static void clickonSpinnerButton(WebElement element){
		
		while (true) {
		     if (element.getAttribute("disabled")==null ) {
		    	 element.click();    	
		    }    
		    else {
		        break;
		    }
		}
}
	
//	public static  void zoomIn(){
//		WebElement html =driver.findElement(By.tagName("html"));
//		html.sendKeys(Keys.chord(Keys.CONTROL,Keys.ADD));
//	}
	
	 
	
	public static boolean setCellData(String sheetName, int colNumber, int rowNum, String value){
		
		 try {
			files = new FileInputStream(DataFilePath);
			 book = new XSSFWorkbook(files);
			 files.close();
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		
		try {
			sheet= book.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			if(row==null)
				row=sheet.createRow(rowNum);
			cell = row.getCell(colNumber);
			 if(cell == null)
			        cell = row.createCell(colNumber);
 
			  cell.setCellValue(value);
 
			  fos = new FileOutputStream(DataFilePath);
			  book.write(fos);
			  fos.close();
		}  catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
		
		
		
}
	
	
	public static void waitForPageToload(long timeOutInSeconds){
		
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>(){

			public Boolean apply(WebDriver driver) {
				
						return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				
				
			}
			
		};
		
		try{
			      System.out.println("Waiting for page to load..."); 
			      WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds); 
			      wait.until(expectation);
		} catch (Throwable error){
			       System.out.println("Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds"); 
			       Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete."); 
		}
	}

	
	

	
	
	
	
	
	
	
}
	
	
	
	
	
	


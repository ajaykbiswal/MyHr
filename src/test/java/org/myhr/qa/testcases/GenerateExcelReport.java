package org.myhr.qa.testcases;

import org.myhr.qa.utility.Xl;
import org.testng.annotations.Test;



public class GenerateExcelReport {

	@Test
	public void Report() throws Exception{
		
		Xl.generateReport("excel-report.xlsx");
	}
}

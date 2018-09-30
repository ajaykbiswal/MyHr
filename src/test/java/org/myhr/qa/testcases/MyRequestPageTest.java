package org.myhr.qa.testcases;

import org.myhr.qa.base.TestBase;
import org.myhr.qa.pages.HomePage;
import org.myhr.qa.pages.LoginPage;
import org.myhr.qa.pages.MyHrPage;
import org.myhr.qa.pages.MyRequestsPage;
import org.myhr.qa.utility.TestUtil;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;

public class MyRequestPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	MyHrPage myhrpage;
	MyRequestsPage myrequestpage;
	static String sheetName = "NewReqTab"; 
	
	public MyRequestPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUP(){
		
		initialization();
		loginpage=new LoginPage();
		myhrpage=new MyHrPage();
		myrequestpage=new MyRequestsPage();
		homepage=loginpage.login(pro.getProperty("userName"), pro.getProperty("password"));
		homepage.clickOnServices();
		homepage.clickOnMyFavouritesTab();
		homepage.clickOnMyhr();
		
		
	}
	
	public void verifyRequestHistoryTab(){
		logger=extent.createTest("verifyRequestHistoryTabTest");
		logger.log(Status.INFO, " verifyRequestHistoryTab-Testcase  Started !");
		myrequestpage.clickonMyRequestsTab();
		logger.log(Status.INFO, " myRequestTab clicked   Successfully !");
		logger.log(Status.INFO, " verifyRequestHistoryTab-Testcase  Ended !");
	
		
	}
	
	public void verifyOpenAllTab(){
		
		logger=extent.createTest("verifyOpenAllTabTest");
		logger.log(Status.INFO, " verifyOpenAllTab-Testcase  Started !");
		boolean allflag=myrequestpage.verifyAllTab();
		Assert.assertTrue(allflag);
		log.info("all Tab selected by default  and  the value is :-"+ allflag);
		logger.log(Status.INFO, " all Tab selected by default  and  the value is :-"+ allflag );
		boolean openflag=myrequestpage.verifyOpenTab();
		logger.log(Status.INFO, " openTab unselected by default  and  the value is :-"+ openflag );
		log.info("openTab unselected by default  and  the value is :-"+openflag);
		logger.log(Status.INFO, " verifyOpenAllTab-Testcase  Ended !");
		
	}
	
	public void verifyRequestNo(){
		
		
	
	logger=extent.createTest("verifyRequestNoTest");
	logger.log(Status.INFO, " verifyRequestNo Testcase  Started !");
	String requestNo=myrequestpage.verifyRequestNo();
	

	System.out.println(requestno);
	log.info("requestNo is :-"+id);
	System.out.println(requestNo);
	//Assert.assertEquals(id[1], requestNo, "Verification failed: Expected result : "+ id[1] +"and Actual result:"+requestNo+" does not matched: ");
   // logger.log(Status.INFO, "requestID validated successfully  "+ "Expected value: "+ id[1]+"Actual value: "+requestNo);
	logger.log(Status.INFO, " verifyRequestNo Testcase  Ended !");
	}

}

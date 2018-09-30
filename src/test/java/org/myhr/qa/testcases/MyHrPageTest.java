package org.myhr.qa.testcases;

import java.util.Arrays;
import java.util.List;

import org.myhr.qa.base.TestBase;

import org.myhr.qa.pages.HomePage;
import org.myhr.qa.pages.LoginPage;
import org.myhr.qa.pages.MyHrPage;
import org.myhr.qa.utility.TestUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import junit.framework.Assert;




public class MyHrPageTest extends TestBase {
	
	
	LoginPage loginpage;
	HomePage homepage;
	static MyHrPage myhrpage;
	static String sheetName = "NewReqTab"; 

	
	
	public MyHrPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUP(){
		
		initialization();
		loginpage=new LoginPage();
		myhrpage=new MyHrPage();
		homepage=loginpage.login(pro.getProperty("userName"), pro.getProperty("password"));
		homepage.clickOnServices();
		homepage.clickOnMyFavouritesTab();
		homepage.clickOnMyhr();
		
		
	}
	
	
	
	
	@DataProvider
	public Object[][] getMyHRTestData(){
		Object data[][]=TestUtil.getTestdata(sheetName);
		return data;
	}
  
	@Test(dataProvider="getMyHRTestData")
	public static void createNewRequestTest(String category,String subCategory,String subject,String reqdescription) throws Exception  {
		logger=extent.createTest("createNewRequestTest");
	    logger.log(Status.INFO, " createNewRequest-Testcase  Started !");
	  
	    myhrpage.clickOnCategory(category);
	   
	    
	    logger.log(Status.INFO, " category selected successfully !");
	    myhrpage.clickOnSubcategory(subCategory);
	    logger.log(Status.INFO, " subCategory selected successfully !");
	    myhrpage.enterSubjectAndDescription(subject, reqdescription);
	   logger.log(Status.INFO, " subject entered successfully  !");
	   logger.log(Status.INFO, " requestDescription entered successfully  !");
    
	    myhrpage.clickOnAttachOption();
	    logger.log(Status.INFO, " document attached successfully  !");
	    myhrpage.clickOnSave();
	    logger.log(Status.INFO, " saveButton clicked successfully  !");
	    
	    
		myhrpage.verifyPopupLabel();
		 logger.log(Status.INFO, " popupLabel verified successfully");
		
		myhrpage.verifySuccessMsgText();
		logger.log(Status.INFO, " successMsg verified successfully");
        
		
       
		String[] id=myhrpage.getRequestID().split(":");
		System.out.println(id[1]);
		 requestno=id[1];
		//TestUtil.setCellData(sheetName, 4, 1, id[1]);
		 logger.log(Status.INFO, " requestID created successfully & requestID is :  "+ requestno);
		 myhrpage.clickOnClose();
		 logger.log(Status.INFO, " closebutton clicked successfully");   
	    logger.log(Status.INFO, " createNewRequest-Testcase  Completed !");
	    
	    
	}
	
	

//@Test(priority=2)
//public void verifyRequestHistoryTest(){
//		logger=extent.createTest("verifyRequestHistoryTest");
//		logger.log(Status.INFO, " verifyRequestHistory-Testcase  Started !");
//		myhrpage.clickonMyRequestsTab();
//		logger.log(Status.INFO, " myRequestTab clicked   Successfully !");
//		logger.log(Status.INFO, " verifyRequestHistory-Testcase  Ended !");
//		
//	}
//@Test(priority=3)	
//	public void verifyOpenAllTabTest(){
//		logger=extent.createTest("verifyOpenAllTabTest");
//		logger.log(Status.INFO, " verifyOpenAllTab-Testcase  Started !");
//		boolean allflag=myhrpage.verifyAllTab();
//		Assert.assertTrue(allflag);
//		log.info("all Tab selected by default  and  the value is :-"+ allflag);
//		logger.log(Status.INFO, " all Tab selected by default  and  the value is :-"+ allflag );
//		boolean openflag=myhrpage.verifyOpenTab();
//		logger.log(Status.INFO, " openTab unselected by default  and  the value is :-"+ openflag );
//		log.info("openTab unselected by default  and  the value is :-"+openflag);
//		logger.log(Status.INFO, " verifyOpenAllTab-Testcase  Ended !");
//		
//	}
//@Test(priority=4)	
//	public void verifyRequestNoTest(){
//		logger=extent.createTest("verifyRequestNoTest");
//		logger.log(Status.INFO, " verifyRequestNo Testcase  Started !");
//		String requestNo=myhrpage.verifyRequestNo();
//		String id=requestno;
//		System.out.println(id);
//		log.info("requestNo is :-"+id);
//		//Assert.assertEquals(id[1], requestNo, "Verification failed: Expected result : "+ id[1] +"and Actual result:"+requestNo+" does not matched: ");
//	   // logger.log(Status.INFO, "requestID validated successfully  "+ "Expected value: "+ id[1]+"Actual value: "+requestNo);
//		logger.log(Status.INFO, " verifyRequestNo Testcase  Ended !");
//	}
//	
	
	
	
	
	

}

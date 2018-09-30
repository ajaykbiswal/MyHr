package org.myhr.qa.testcases;

import org.apache.log4j.Logger;
import org.myhr.qa.base.TestBase;
import org.myhr.qa.pages.HomePage;
import org.myhr.qa.pages.LoginPage;
import org.myhr.qa.utility.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

//import com.form16.qa.utility.TestUtil;


public class LoginPageTest extends TestBase {
	
	public static Logger log=Logger.getLogger(LoginPageTest.class.getName());
	LoginPage loginpage;
	HomePage homepage;
	//String sheetName = "Credentials"; 
	

	
	public LoginPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUP(){
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test 
	public void loginPageTitleTest(){
		log.info(" Starting loginPageTitleTest ");
		logger=extent.createTest("loginPageTitleTest");
		logger.log(Status.INFO, " loginPageTitle Testcase Started !");
		
		String title=loginpage.verifyLoginPageTitle();
		
		Assert.assertEquals(title, "HR Services");
		logger.log(Status.INFO, "title verified successfully and the value  is :  "+ title);
		
		log.info(" Ending loginPageTitleTest ");
		logger.log(Status.INFO, " loginPageTitle Testcase Completed !");
		
	}
	@Test
	public void hrServicelogoTest(){
		log.info(" Starting hrServicelogoTest ");
		logger=extent.createTest("hrServicelogoTest");
		logger.log(Status.INFO, " hrServicelogo Testcase Started !");
		boolean flag=loginpage.verifyHRservicelogo();
		Assert.assertTrue(flag);
		log.info("Logo validated successfully and  the value is :-"+ flag);
		logger.log(Status.INFO, "logo validated successfully and  the value is :-"+ flag);
		log.info(" Ending hrServicelogoTest ");
		logger.log(Status.INFO, "hrServicelogo Testcase Completed !");
		
	}
	
	
	
//    @Test 
//	public void loginTest() {
//    	log.info(" Starting loginTest ");
//    	logger=extent.createTest(" loginTest");
//    	logger.log(Status.INFO, "LoginTestcase Started !");
//     	log.info("Entered UserName :"+pro.getProperty("userName"));
//     	logger.log(Status.INFO, "Entered UserName :"+ pro.getProperty("userName"));
//    	log.info("Entered Password :"+pro.getProperty("password"));
//    	logger.log(Status.INFO, "Entered Password :"+ pro.getProperty("password"));
//		homepage=loginpage.login(pro.getProperty("userName"), pro.getProperty("password"));
//		log.info("Clicked on submit button successfully");
//		logger.log(Status.INFO, "Sumbit button clicked succesfully !");
//		logger.log(Status.INFO, "User logged in succesfully !");
//		logger.log(Status.INFO, "LoginTestcase Completed !");
//		log.info(" Ending loginTest ");
		
		
	//}
    
    @Test(dataProvider="getMyHRTestData")
    public void loginIntoApplication(String userName,String password){
    	homepage=loginpage.login(userName, password);
    }
    
    
}

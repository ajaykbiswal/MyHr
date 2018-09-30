package org.myhr.qa.testcases;



import org.apache.log4j.Logger;
import org.myhr.qa.base.TestBase;
import org.myhr.qa.pages.HomePage;
import org.myhr.qa.pages.LoginPage;
import org.myhr.qa.pages.MyHrPage;
import org.myhr.qa.utility.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;




public class HomePageTest extends TestBase {
	public static Logger log=Logger.getLogger(HomePageTest.class.getName());
	LoginPage loginpage;
	HomePage homepage;
	MyHrPage myhrpage;
	String sheetName = "Credentials"; 
	
	public HomePageTest(){
				super();
	}
	
	
	
	@BeforeClass
	public void setUP( ) throws Exception{
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		
		//homepage=loginpage.login(pro.getProperty("userName"), pro.getProperty("password"));
		
	}
	
	
	@DataProvider
	public  Object[][] getMyHRTestData(){
		Object data[][]=TestUtil.getTestdata(sheetName);
		return data;
		
	}

	 
	    
	
	  
	  
	  
	  
	  
	@Test(priority=1)
	public void homePageTest(){
				log.info(" Starting homeLabelTest ");
				logger=extent.createTest("homePageTest");
				logger.log(Status.INFO, "homePage Testcase Started !");
				
				boolean flag=homepage.verifyHomelabel();
				Assert.assertTrue(flag);
				logger.log(Status.INFO, "Navigated to Home page successfully & the value is : "+ flag);
				log.info("Navigated to Home page successfully & the value is : "+ flag);
				boolean flags=homepage.verifyServiceslabel();
				Assert.assertTrue(flags);
				
				log.info(" Services page label validated successfully & the value is : "+ flag);
				logger.log(Status.INFO, "Services page label validated successfully & the value is : "+ flag);
				
				logger.log(Status.INFO, "HomeLabel Testcase Completed !");
				log.info(" Ending homePageTest ");
	}
	
	@Test(priority=2)
	public void servicePageTest(){
		logger=extent.createTest("servicePageTest");
		logger.log(Status.INFO, "servicePageTestcase Started !");
		boolean flag=homepage.verifyServiceslabel();
		Assert.assertTrue(flag);
		logger.log(Status.INFO, "services page label validated successfully & the value is : "+ flag);
		
		homepage.clickOnServices();
		logger.log(Status.INFO, " service label clicked successfully !");
		logger.log(Status.INFO, "servicepage testcase Completed !");
		
		
	}
	

	@Test(priority=3)
	public void  clickOnServicesTest()  {
					log.info(" Starting clickOnServiceTest ");
					logger=extent.createTest("clickOnServicesTest");
					logger.log(Status.INFO, " cickOnServiceTestcase  Started !");
					
					homepage.clickOnServices();
					log.info("clicked on Service successfully");
					logger.log(Status.INFO, " service link clicked successfully !");
					homepage.clickOnMyFavouritesTab();
					logger.log(Status.INFO, " myFavouriteTab clicked successfully !");
					
					logger.log(Status.INFO, "ClickOnServiceTestcase Completed !");
					
					
					log.info(" Ending clickOnServiceTest ");
		
	}
	
	
	
	@Test(priority=4)
	public void  myHrTitleTest(){
					   log.info(" Starting myHrTitleTest ");
					   logger=extent.createTest("myHrTitleTest");
					   logger.log(Status.INFO, " myHrTitle-Testcase  Started !");
					   boolean flag=homepage.verifyMyhrTitle();
					   Assert.assertTrue(flag,"Verification failed:  The myHRTitle is not displayed correctly on the webpage");
					   logger.log(Status.INFO, "myHR title verified successfully & the value is : "+ flag);
					   log.info("myHR title verified successfully & the value is : "+ flag);
					   logger.log(Status.INFO, " myHRTitle-Testcase Completed !");
					   log.info(" Ending myHRTitleTest ");
	}
//	@Test
//	public void clickOnMyhrTest(){
//					log.info(" Starting clickOnForm16Test ");
//					logger=extent.createTest("clickOnForm16Test");
//					logger.log(Status.INFO, " Form16linkTitle Testcase  Started !");
//				
//					myhrpage = homepage.clickOnMyhr();
//					log.info("Clicked on Form16 successfully");
//					log.info("Form16 service Icon clicked succesfully");
//				    logger.log(Status.INFO, " Form16linkTitle-Testcase  Completed !");
//					log.info(" Ending clickOnForm16Test ");
//	}
	
	
	 @Test(dataProvider="getMyHRTestData")
	    public  void loginIntoApplication(String userName,String password){
		 		logger=extent.createTest("loginIntoApplication");
		 		logger.log(Status.INFO, " loginIntoApplication-Testcase  Started !");
		 		homepage=loginpage.login(userName, password);
		 		logger.log(Status.INFO, " loginIntoApplication Done Successfully");
		 		logger.log(Status.INFO, "loginIntoApplication -Testcase  Completed !");
	     	
	   }
	
}

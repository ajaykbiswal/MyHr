package org.myhr.qa.pages;

import org.apache.log4j.Logger;
import org.myhr.qa.base.TestBase;
import org.myhr.qa.utility.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;





public class HomePage extends TestBase {
	
	public static final Logger log=Logger.getLogger(HomePage.class.getName());
	
	@FindBy(how=How.XPATH,using="//i[@class='ico_home']")
	WebElement userHome_label;
	
	@FindBy(how=How.XPATH,using="//i[@class='ico_services']")
	WebElement services_label;
	
	@FindBy(how=How.XPATH,using="//a[@class='myhr' and @title='My HR']")
	WebElement myhr;
	
	@FindBy(how=How.ID,using="favourites")
	WebElement myfavourites;
	
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	//Actions
	
	
	
	public boolean verifyHomelabel() {
			//log("Home Screen displayed and object is :"+ userHome_label.toString());
		
			return userHome_label.isDisplayed();
			
	}
	
	public boolean verifyServiceslabel(){
		       
				//log("Service Label displayed and object is :"+ services_label.toString());
				return services_label.isDisplayed();
				
		
	}
	
	public void clickOnServices(){
		
		TestUtil.clickByXpath(driver, services_label);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public void clickOnMyFavouritesTab(){
		
		myfavourites.click();
	}
	public boolean verifyMyhrTitle(){
		
		return myhr.isDisplayed();
		
		
	}
	
	public MyHrPage  clickOnMyhr(){
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",myhr);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		TestUtil.clickByXpath(driver, myhr);
		//TestUtil.waitForPageToload(120L);
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return new MyHrPage();
	
}
	
	
}

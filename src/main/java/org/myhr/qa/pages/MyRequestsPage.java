package org.myhr.qa.pages;

import org.myhr.qa.base.TestBase;
import org.myhr.qa.utility.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyRequestsPage extends TestBase {
	
	@FindBy(how=How.XPATH,using="//div/span[text()='My Requests']")
	WebElement myreqTab;
	
	@FindBy(how=How.XPATH,using="//a[@id='tab-all']")
	WebElement allTab;
	
	@FindBy(how=How.XPATH,using="//a[@id='tab-open']")
	WebElement openTab;
	
	@FindBy(how=How.XPATH,using="//*[@id='tab-open-panel']/div[1]/app-hr-request-item/div/div/div[2]/div[2]/ul[1]/li[2]")
	WebElement requestNo;
	
	
	
	
	public MyRequestsPage(){
		PageFactory.initElements(driver, this);
	}
	
 //Actions
	
	public void clickonMyRequestsTab(){
		
		if (myreqTab.isDisplayed()){
			
			TestUtil.clickByXpath(driver, myreqTab);
			
		}
		
}

	public boolean verifyAllTab() {
		return allTab.isEnabled();
		
	}
	
	public  boolean verifyOpenTab() {
		return openTab.isEnabled();
		
	}
	
	public String  verifyRequestNo(){
		
		String reqNo=requestNo.getText();
		return reqNo;
		 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

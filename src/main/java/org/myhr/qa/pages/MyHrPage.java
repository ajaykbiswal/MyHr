package org.myhr.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.myhr.qa.base.TestBase;
import org.myhr.qa.utility.TestUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyHrPage extends TestBase{
	
	
	@FindBy(how=How.XPATH,using="//button[@id='dd-category']")
	WebElement category;
	
	@FindBy(how=How.XPATH,using="//div[@aria-labelledby='dd-category']//button")
	List<WebElement> categoryListItems;
	
	@FindBy(how=How.XPATH,using="//button[@id='dd-sub-category']")
	WebElement subCategory;
	
	@FindBy(how=How.XPATH,using="//div[text()='New Request']")
	WebElement newReqTab;
	
	
	@FindBy(how=How.XPATH,using="//div[@aria-labelledby='dd-sub-category']//button")
	List<WebElement> subCategoryListItems;
	
	@FindBy(how=How.NAME,using="subject")
	WebElement subject;
	
	@FindBy(how=How.NAME,using="description")
	WebElement description;
	
	@FindBy(how=How.XPATH,using="//span[text()='ATTACH']")
	WebElement attachbtn;
	
	@FindBy(how=How.XPATH,using="//button[text()='SAVE']")
	WebElement savebtn;
	
	@FindBy(how=How.XPATH,using="//button[text()='RESET']")
	WebElement resetbtn;
	
	@FindBy(how=How.XPATH,using="//button[contains(@class,'faq')]")
	WebElement faqbtn;
	
	@FindBy(how=How.XPATH,using="//h4[text()='Request Submitted']")
	WebElement popupLabel;
	
	@FindBy(how=How.XPATH,using="//span[text()='A new request has been generated with']")
	WebElement successMsgLabel;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'ID')]")
	WebElement IDLabel;
	
	@FindBy(how=How.XPATH,using="//button[text()='Close']")
	WebElement closebtn;
	
	@FindBy(how=How.XPATH,using="//div/span[text()='My Requests']")
	WebElement myreqTab;
	
	@FindBy(how=How.XPATH,using="//a[@id='tab-all']")
	WebElement allTab;
	
	@FindBy(how=How.XPATH,using="//a[@id='tab-open']")
	WebElement openTab;
	
	@FindBy(how=How.XPATH,using="//*[@id='tab-open-panel']/div[1]/app-hr-request-item/div/div/div[2]/div[2]/ul[1]/li[2]")
	                                                                           
	WebElement requestNo;
	
	
	public MyHrPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	

	
	public void clickOnCategory(String categoryName){
		
		   try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
			TestUtil.clickByXpath(driver, category);
			
			for(WebElement allcategoryItems: categoryListItems){ 	   
				if  ( allcategoryItems.getText().contentEquals(categoryName)==true){
						TestUtil.clickByXpath(driver, allcategoryItems);
						break;
				
				}	
				else{
					
				Assert.assertFalse(false,  " Select category : "+categoryName+" is not found  in the list box");
				break;
				
					
					
					
				}
		 }
	}
	
	public void clickOnSubcategory(String subCategoryName){
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			TestUtil.clickByXpath(driver, subCategory);
			for(WebElement allsubCategoryItems:subCategoryListItems){ 	   
				   System.out.println( allsubCategoryItems.getText());
			
					 if  ( allsubCategoryItems.getText().contentEquals(subCategoryName)==true){
						 	 TestUtil.clickByXpath(driver, allsubCategoryItems);
						 break;
					 }
					   
		  } 
	
}
	public void enterSubjectAndDescription(String subName,String subDescription) throws Exception{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(subject.isDisplayed() && subject.isEnabled()){
			 subject.sendKeys(subName);
		 }
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 if(description.isDisplayed() && description.isEnabled()){
			 description.sendKeys(subDescription);
		 }
		 
		 Thread.sleep(2000);
		 
	}
	
	public void clickOnAttachOption() throws Exception{
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",attachbtn);
		 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if(attachbtn.isDisplayed() && attachbtn.isEnabled()){
			TestUtil.clickByXpath(driver, attachbtn);
			
		 }
		 try {
			Runtime.getRuntime().exec("C:\\Attach\\Fileupload.exe");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void clickOnSave(){
		
		
		if(savebtn.isDisplayed() && savebtn.isEnabled()){
			savebtn.click();
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
	}
	
public void clickOnClose() throws Exception {
	
	
	 if(closebtn.isDisplayed() && closebtn.isEnabled()){
		 closebtn.click();
	 
	 try {
		Thread.sleep(45000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
}
 //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",newReqTab);
//	 
  ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
	// ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
	 ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	 
}
	
public void clickOnReset(){
		
		if(resetbtn.isDisplayed() && resetbtn.isEnabled()){
			resetbtn.click();
		 }
		
	}

public void clickOnFAQ(){
	
	if(faqbtn.isDisplayed() && resetbtn.isEnabled()){
		faqbtn.click();
	 }
	
}
	public boolean verifyPopupLabel(){
		return popupLabel.isDisplayed();
	}
	
	public boolean verifySuccessMsgText(){
		return successMsgLabel.isDisplayed();
	}
	
	public boolean verifyRequestID(){
		return IDLabel.isDisplayed();
	}
	
//	public List<String>  getRequestID(){
//		 list=new ArrayList<String>();
//		 list.add(IDLabel.getText());
//		return list;
//		
//	}
	
	public String getRequestID(){
		return IDLabel.getText();
	}
		
public void clickonMyRequestsTab(){
		
		if (myreqTab.isDisplayed()){
			
			myreqTab.click();
			//TestUtil.clickByXpath(driver, myreqTab);
			
		}
		
}

	public boolean verifyAllTab() {
		return allTab.isEnabled();
		
	}
	
	public  boolean verifyOpenTab() {
		return openTab.isEnabled();
		
	}
	
	
	public String  verifyRequestNo(){
		
		return requestNo.getText();
		
		 
		
	}
	
	

}

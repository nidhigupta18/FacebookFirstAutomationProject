package Com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	
	

	@FindBy(xpath="//span[@class='_1qv9']/child::span")
	@CacheLookup
	WebElement UserNameLabel;
	
	
	@FindBy(xpath="//a[@id='findFriendsNav']")
	WebElement FriendLink;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement HomeLink;
	
	@FindBy(xpath="//a[@id='creation_hub_entrypoint']")
	WebElement CreateBtn;
	
	@FindBy(xpath="//span[text()='Bring people together with a public or private event']")
	WebElement CreateEvent;
	
	@FindBy(xpath="//input[@aria-labelledby='eventCreateTitle']")
	WebElement EventTitle;
	
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String verifyHomepageTitle(){
		
		return driver.getTitle();
	}
	
	public boolean UserNameVerify(){
		
	return	UserNameLabel.isDisplayed();
		
	}
	public FriendsPage ClickOnFriendLink() throws IOException{
		FriendLink.click();
		return new FriendsPage();
		
	}
	
	public HomePage HomeClick() throws IOException{
		
		HomeLink.click();
		return new HomePage();
	}
	
	
	public void CreateBtnclick(){
		
		CreateBtn.click();
		
	}
	
	
	public void CreateNewEvent(String EventName){
		
		
		CreateEvent.click();
		
		EventTitle.sendKeys(EventName);
		
	}
}

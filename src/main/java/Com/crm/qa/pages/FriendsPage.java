package Com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Com.crm.qa.base.TestBase;

public class FriendsPage extends TestBase{

	@FindBy(xpath="//h2[text()='People you may know']")
	WebElement Label;
	
	
	public FriendsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyLabel(){
		
		return Label.isDisplayed();
	}
	
	public void SelectFriendContact(String name){
		
		driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
		
	}
}

package Com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.crm.qa.base.TestBase;

public class LoginPage  extends TestBase {
	
	
@FindBy(xpath="//input[@id='email']")
WebElement Email;

@FindBy(xpath="//input[@id='pass']")
WebElement Password;


@FindBy(xpath="//input[@type='submit']")
WebElement LoginBtn;

@FindBy(xpath="//i[@class='fb_logo img sp_iweMvYcNOXG sx_c594d5']")
WebElement logo;



//initalize page object 

public LoginPage() throws IOException {
	
PageFactory.initElements(driver, this);
	}


//action 
public String validateloginpagetitile(){
	
	return driver.getTitle();
}
 

public boolean validategoogleimage(){
return	logo.isDisplayed();
	
}


public void SetUsername(String username){
	Email.sendKeys(username);
}
public void SetPassword(String pass){
	Password.sendKeys(pass);
}
public void LoginBtnClick(){
	
	LoginBtn.click();
}


public HomePage login(String username,String pass) throws IOException{
	
this.SetUsername(username);
this.SetPassword(pass);
this.LoginBtnClick();
	return new HomePage();
}
}

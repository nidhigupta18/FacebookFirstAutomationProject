package Com.crm.qa.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.crm.qa.base.TestBase;
import Com.crm.qa.pages.FriendsPage;
import Com.crm.qa.pages.HomePage;
import Com.crm.qa.pages.LoginPage;

public class FriendsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	FriendsPage friendsPage;
	

	public FriendsPageTest() throws IOException {
		super();
		
	}
	@BeforeMethod
	public void setup() throws IOException{
		initialization();
		 loginPage= new LoginPage();
		 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// friendsPage= homePage.ClickOnFriendLink();
		}
	
	@Test(priority=9)
	public void verifyLabelTest() throws IOException{
		 
		 friendsPage= homePage.ClickOnFriendLink();
		boolean flag1=friendsPage.verifyLabel();
		
		Assert.assertTrue(flag1);
		
	}
	
	
	@Test(priority=10)
	
	public void ImageLinkClick() throws IOException {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		friendsPage= homePage.ClickOnFriendLink();
		friendsPage.SelectFriendContact("Adity Bhushan");
		
	}
	
	
	@AfterMethod 
	
	public void quit (){
		
		driver.quit();
	}
	
}

package Com.crm.qa.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.crm.qa.base.TestBase;
import Com.crm.qa.pages.FriendsPage;
import Com.crm.qa.pages.HomePage;
import Com.crm.qa.pages.LoginPage;
import Com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	FriendsPage friendsPage;
	
	String Sheetname="Event";
	
	

	public HomePageTest() throws IOException {
		super();
		
}
@BeforeMethod
public void setup() throws IOException{
	initialization();
	 loginPage= new LoginPage();
	 homePage=	 loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
@Test(priority=4)
public void VerifyHomePageTitle(){
	
String TitleHomePageTitle=homePage.verifyHomepageTitle();

Assert.assertEquals(TitleHomePageTitle,"Facebook");
	
}

@Test(priority=5)
public void UserNameVerifyTest(){
	
boolean flag=homePage.UserNameVerify();

Assert.assertTrue(flag);	
}

@Test(priority=6)

public void ClickOnFriendLinkTest() throws IOException{
	
	friendsPage=homePage.ClickOnFriendLink();
	
}
@Test(priority=7)

public void HomeClickTest() throws IOException{
	
	homePage=homePage.HomeClick();
	
}

@DataProvider

public Object[][] Facebooktestdata() throws IOException
{
	
	Object data [][]= TestUtil.getcelldata(Sheetname);
return data;
}

@Test(dataProvider="Facebooktestdata",priority=8)
public void CreateEventTest(String EventName) throws IOException{
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
homePage.CreateBtnclick();
homePage.CreateNewEvent(EventName);

}

@AfterMethod 

public void quit (){
	
	driver.quit();
}

}

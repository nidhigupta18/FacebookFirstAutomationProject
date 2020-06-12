package Com.crm.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.crm.qa.base.TestBase;
import Com.crm.qa.pages.HomePage;
import Com.crm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	
	HomePage homePage;
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
@BeforeMethod
public void setup() throws IOException{
	
	initialization();
	 loginPage= new LoginPage();
}


@Test(priority=1)
public void loginpageTitleTest(){
	
	String title =loginPage.validateloginpagetitile();
	
	Assert.assertEquals(title, "Facebook – log in or sign up");
}

@Test(priority=2)

public void logotest(){
	
	boolean pageImage=loginPage.validategoogleimage();
	
	Assert.assertTrue(pageImage);
}


@Test(priority=3)

public void lOGIN() throws IOException{
	
	homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
}

@AfterMethod()

public void teardown(){
	
	driver.quit();
	
	
}


}

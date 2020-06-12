package Com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Com.crm.qa.util.TestUtil;
import Com.crm.qa.util.WebEvnetListener;

public class TestBase {
	
public static WebDriver driver;
public static Properties prop;

public TestBase() throws IOException{
prop= new Properties();

	try {
		FileInputStream ip= new FileInputStream("C:\\Users\\nidhi\\Desktop\\FinalTest\\FinalTest\\FreeCRMTest\\src\\main\\java\\Com\\crm\\qa\\config\\Config.properties");
		
		prop.load(ip);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public static void initialization() throws IOException{
	
	
	String browsername=prop.getProperty("browser");
	
	if (browsername.equals("Firefox")){
		 System.setProperty("webdriver.gecko.driver","C:\\Users\\nidhi\\Desktop\\All\\jar\\geckodriver-v0.26.0-win64//geckodriver.exe");
		 driver = new FirefoxDriver();
	        
	        
	      
	        
	}
	
	
	else if (browsername.equals("chrome")){
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\nidhi\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
		
		driver= new ChromeDriver();
	}
	
	
	EventFiringWebDriver eventFiringwebdriver= new EventFiringWebDriver(driver);
	
	WebEvnetListener webEvnetListener= new WebEvnetListener();
	
	eventFiringwebdriver.register(webEvnetListener);
	
	driver=eventFiringwebdriver;
	
	//driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
	
	driver.manage().timeouts().implicitlyWait(TestUtil.impicit_wait, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
}
}

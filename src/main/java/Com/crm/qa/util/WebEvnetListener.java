package Com.crm.qa.util;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import Com.crm.qa.base.TestBase;

public class WebEvnetListener  extends TestBase implements WebDriverEventListener,IRetryAnalyzer,IAnnotationTransformer  {
int counter=0;
int retrylimit=2;
	public WebEvnetListener() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before Navigate to :-  "  +url);
		
	}
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After Navigate to :-  "  +url);
		
	}
	
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:"+element.toString()+"Before any change mode" );
		
	}
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:"+element.toString()+"After any change mode" );
		
	}
	
	
	
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println(" before trying to click on"+element.toString() );
		
	}


	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println(" After trying to click on"+element.toString() );
		
	}
	
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println(" Before navigate back to previous page" );
		
	}
	
	public void afterNavigateBack(WebDriver driver) {
		System.out.println(" After navigate back to previous page" );
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println(" after find by "+ by.toString());
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println(" before find by "+ by.toString());
		
	}
	
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println(" before navigate  to forword page" );
		
	}


	public void afterNavigateForward(WebDriver driver) {
		System.out.println(" after navigate  to forword page" );
		
	}

	

	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable error, WebDriver driver) {
System.out.println("Exception occur"+error);

try{
	
	TestUtil.TakeScreenShotAtEndOfTC();
}
catch(IOException e){
	
	e.printStackTrace();
}
	}

	@Override
	public boolean retry(ITestResult Result) {
		if (counter<retrylimit){
			
			counter++;
			return true;
		}
		return false;
	}

	@Override
	public void transform(ITestAnnotation Annotaion, Class testclass, Constructor TestConsurtutor,
			Method TestMehod) {
		// TODO Auto-generated method stub
		Annotaion.setRetryAnalyzer(Com.crm.qa.util.WebEvnetListener.class);
	}

}

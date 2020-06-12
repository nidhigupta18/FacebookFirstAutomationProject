package Com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	
	static Sheet guru99Sheet=null;
	
	public static  String TESTDATA_SHEET_PATH="C:\\Users\\nidhi\\Desktop\\FinalTest\\FinalTest\\FreeCRMTest\\src\\main\\java\\Com\\crm\\qa\\Testdata\\Facebooktestdata.xlsx";
	
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	public static long page_load_timeout=40;
	
	public static long impicit_wait=40;
	
	
	public void SwitchToFrame(){
		
		
		driver.switchTo().frame("");
		
		
	}
	
	
	public static Object[][] getcelldata(String Sheetname) throws IOException{
		File file = new File(TESTDATA_SHEET_PATH);
	   FileInputStream inputStream = new FileInputStream(file);
	   Workbook guru99Workbook = new XSSFWorkbook(inputStream);
	guru99Sheet = guru99Workbook.getSheet(Sheetname);
		int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
	int columncount=guru99Sheet.getRow(1).getLastCellNum();
	    
	    Object data [][]  =new Object[rowCount][columncount];
	   
	    
	    
	    
	    for( int rown=1;rown<=rowCount;rown++){
	    
	Row row = guru99Sheet.getRow(rown);
		
		for(int column=0;column<row.getLastCellNum();column++){
			
			  data [rown-1][column] =row.getCell(column).getStringCellValue();
		 System.out.println( data [rown-1][column]);
		 
		   }
		
	    }
		return data;
		
		
		
		 
	    
		}
	
	
	public static void TakeScreenShotAtEndOfTC() throws IOException{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
String currentdir=System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentdir+"/screenshots/"+System.currentTimeMillis()+".png"));

}
}
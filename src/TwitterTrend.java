
/**
 * simple selenium automation
 * The script launches the Firefox browser
 * Open the Twitter website
 * Identifies top 10 trends
 * takes screen capture and saves it
 */


import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.*;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.io.FileHandler.Filter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;


public class TwitterTrend {
	
	public static WebDriver driver = null;
	public static WebElement element = null;
	
	public static Calendar c = new GregorianCalendar();
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		driver = new FirefoxDriver();
		driver.get("https://twitter.com/search-home");
		
		
		getTrends();
		getScreenshot();

	}

   @SuppressWarnings("deprecation")
   
public static void getTrends(){
	   
	   //Calendar c = new GregorianCalendar();
	   
	   
	   for(int i = 1; i<10; i++){
		  String s= driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div[1]/div/div/div/div[2]/ul/li["+i+"]/a")).getText();
		   //System.out.println("Number "+i+" is  = "+s+"  date is ("+d.getDate()+"/ "+d.getMonth()+"/ "+d.getYear()+")");
		   System.out.println("Number "+i+" is  = "+s+"  date is => "+c.getTime());

		   
		   
	   }
	   
   }
   
   // takes screen capture and saves it in Temp folder
   public static void getScreenshot() throws IOException{
	   
	   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(scrFile, new File("C:\\"+"Temp\\screenshot-"+c.hashCode()+".jpg"));
   }
 	
}

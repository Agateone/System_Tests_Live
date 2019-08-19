package Elements;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Authorise_charge_notice_popbitch {

	
WebDriver driver_Authorise_charge_notice_popbitch;

	
	
	By Authorise_charge_notice_popbitch_on= By.className("switch__1WB6F false");
	
	By Authorise_charge_notice_popbitch_on_continue_reading=By.id("agate_payNow");
	
	
	public Authorise_charge_notice_popbitch(WebDriver driver_Authorise_charge_notice_popbitch2) 
	{
	this.driver_Authorise_charge_notice_popbitch= driver_Authorise_charge_notice_popbitch2;
	}
	

	
	
public void authorise_charge_on()
{driver_Authorise_charge_notice_popbitch.switchTo().frame("iframe__inpage_notices");
	driver_Authorise_charge_notice_popbitch.findElement(Authorise_charge_notice_popbitch_on).click();
	driver_Authorise_charge_notice_popbitch.switchTo().defaultContent();
}



public void authorise_charge_notice_click_continue() throws IOException, InterruptedException
{

	Thread.sleep(4000);	
	WebElement frame =driver_Authorise_charge_notice_popbitch.findElement((By.id("iframe__inpage_notices")));
	Thread.sleep(6000);
	driver_Authorise_charge_notice_popbitch.switchTo().frame(frame);			
	driver_Authorise_charge_notice_popbitch.findElement(Authorise_charge_notice_popbitch_on_continue_reading).click();
	driver_Authorise_charge_notice_popbitch.switchTo().defaultContent();
	Thread.sleep(8000);
	//String screenshot_name= "Popbitch_authorise_charge_notice";
	String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
	File scrFile = ((TakesScreenshot)driver_Authorise_charge_notice_popbitch).getScreenshotAs(OutputType.FILE);		
	FileUtils.copyFile(scrFile, new File("/Users/jay/Desktop/popbitch/"+"_"+timestamp+"_"+"jpg" ));
	
}
}
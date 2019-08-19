package Elements;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Cornwall_Reports_First_Use_Notice {

	//Instantiate web driver
	WebDriver driver_Cornwall_Reports_First_Use_Notice;
	//Cornwall First use Notice elements
	By green_tab= By.className("triangle__3TvaE");																	//green tab		
	By Cornwall_First_use_Login=By.xpath("//*[@id=\"first_use__btn_login\"]");												//login to agate
	By Cornwall_First_Use_CreateWallet= By.xpath("//*[@id=\"first_use__btn_pay\"]");
	By Cornwall_First_Use_I_Got_Digital_Subs = By.xpath("//*[@id=\"first_use__btn_subscribe\"]");
	By Cornwall_First_Use_Learn_More = By.xpath("/html/body/div/div/div/div/div/section/button[2]");	
	
	public Cornwall_Reports_First_Use_Notice(WebDriver driver_Cornwall_Reports_First_Use_Notice1) {							//constructor
		this.driver_Cornwall_Reports_First_Use_Notice= driver_Cornwall_Reports_First_Use_Notice1;
		}
		
	public void click_on_green_tab() throws InterruptedException {
		Thread.sleep(2000);
		WebElement svgobject = driver_Cornwall_Reports_First_Use_Notice.findElement(green_tab);
		Actions builder = new Actions(driver_Cornwall_Reports_First_Use_Notice);
		builder.click(svgobject).build().perform();						
	}
	
	public void Click_On_Cornwall_First_use_Login_button() throws InterruptedException {					
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver_Cornwall_Reports_First_Use_Notice;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		WebElement frame = 	driver_Cornwall_Reports_First_Use_Notice.findElement(By.xpath("//*[@id=\"iframe__inpage_notices\"]"));
		driver_Cornwall_Reports_First_Use_Notice.switchTo().frame(frame);
		WebElement yourelement= driver_Cornwall_Reports_First_Use_Notice.findElement(By.id("btn_login"));
		JavascriptExecutor executor = (JavascriptExecutor)driver_Cornwall_Reports_First_Use_Notice;
		executor.executeScript("arguments[0].click();", yourelement);		
		}
	
	public void Click_On_Cornwall_First_Use_CreateWallet() throws InterruptedException, IOException {						
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver_Cornwall_Reports_First_Use_Notice;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);	
		
		//String screenshot_name= "Popbitch_Finish_notice_click_on_button";
				String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				File scrFile = ((TakesScreenshot)driver_Cornwall_Reports_First_Use_Notice).getScreenshotAs(OutputType.FILE);		
				FileUtils.copyFile(scrFile, new File("/Users/jay/Desktop/cornwall/"+"_"+timestamp+"_"+"jpg" ));	
		WebElement frame = 	driver_Cornwall_Reports_First_Use_Notice.findElement(By.xpath("//*[@id=\"iframe__inpage_notices\"]"));
		driver_Cornwall_Reports_First_Use_Notice.switchTo().frame(frame);	
		Boolean finding = driver_Cornwall_Reports_First_Use_Notice.findElement(By.id("btn_cta")).isDisplayed();
		System.out.println(finding);
		WebElement yourelement= driver_Cornwall_Reports_First_Use_Notice.findElement(By.id("btn_cta"));
		JavascriptExecutor executor = (JavascriptExecutor)driver_Cornwall_Reports_First_Use_Notice;
		executor.executeScript("arguments[0].click();", yourelement);
		Thread.sleep(4000);
		driver_Cornwall_Reports_First_Use_Notice.switchTo().defaultContent();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

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


public class Reaction_first_use_notice {

WebDriver driver_Reaction_first_use_notice;														//driver_PopbitchFirstUseNoticeElements
	
	//Reaction First use Notice elements finding
	By green_tab= By.className("triangle__3TvaE");																	//green tab
								//stories
	
	By Reaction_First_use_Login=By.xpath("//*[@id=\"btn_login\"]");									//login to agate
	By Reaction_First_Use_CreateWallet= By.id("reaction__firstuse__create-wallet");
	
	By Reaction_First_Use_what_is_agate = By.id("reaction__firstuse__more-info");
	By Reaction_First_use_Pop_Up_Price_Per_Article = By.id("__currency__amount");
	By Reaction_First_use_Pop_Up_Free_point = By.xpath("//*[@id=\"__currency__amount\"]");
	
	public Reaction_first_use_notice(WebDriver driver_Reaction_first_use_notice2) {							//constructor
		this.driver_Reaction_first_use_notice= driver_Reaction_first_use_notice2;
		}
	
	
	public void Click_On_Reaction_First_use_Login_button() throws InterruptedException {					
		Thread.sleep(3000);
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver_Reaction_first_use_notice;
		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(5000);
		Boolean enab =driver_Reaction_first_use_notice.findElement(By.id("CybotCookiebotDialogBodyButtonAccept")).isDisplayed();
		if(enab== true )
		{
			
		driver_Reaction_first_use_notice.findElement(By.id("CybotCookiebotDialogBodyButtonAccept")).click();	
			
			
		}
	
		Thread.sleep(4000);
		JavascriptExecutor js1 = (JavascriptExecutor)driver_Reaction_first_use_notice;
		js1.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		WebElement frame = 	driver_Reaction_first_use_notice.findElement(By.xpath("//*[@id=\"iframe__inpage_notices\"]"));
		driver_Reaction_first_use_notice.switchTo().frame(frame);
		WebElement yourelement= driver_Reaction_first_use_notice.findElement(By.id("btn_login"));
		JavascriptExecutor executor = (JavascriptExecutor)driver_Reaction_first_use_notice;
		executor.executeScript("arguments[0].click();", yourelement);	
		
		}
	
	public void Click_On_Reaction_First_Use_CreateWallet() throws InterruptedException, IOException {					
			
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver_Reaction_first_use_notice;
		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(4000);
		
		//Screen shot of browser navigated to article
				File scrFile = ((TakesScreenshot)driver_Reaction_first_use_notice).getScreenshotAs(OutputType.FILE);
				String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				FileUtils.copyFile(scrFile, new File("/Users/jay/Desktop/reaction/"+"_"+timestamp+"_"+"jpg" ));	
				
				
		Thread.sleep(15000);
		Boolean enab =driver_Reaction_first_use_notice.findElement(By.id("CybotCookiebotDialogBodyButtonAccept")).isDisplayed();
		if(enab== true )
		{
			
			driver_Reaction_first_use_notice.findElement(By.id("CybotCookiebotDialogBodyButtonAccept")).click();	
			
			
		}
		WebElement frame = 	driver_Reaction_first_use_notice.findElement(By.xpath("//*[@id=\"iframe__inpage_notices\"]"));
		driver_Reaction_first_use_notice.switchTo().frame(frame);	
		Boolean finding = driver_Reaction_first_use_notice.findElement(By.xpath("//*[@id=\"btn_cta\"]")).isDisplayed();
		System.out.println(finding);
		WebElement yourelement= driver_Reaction_first_use_notice.findElement(By.xpath("//*[@id=\"btn_cta\"]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver_Reaction_first_use_notice;
		executor.executeScript("arguments[0].click();", yourelement);
		Thread.sleep(4000);
		driver_Reaction_first_use_notice.switchTo().defaultContent();
		}
			
	
	
	
	
	
	
	
	
	
	
	
}

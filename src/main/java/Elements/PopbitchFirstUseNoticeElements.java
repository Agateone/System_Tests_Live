package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PopbitchFirstUseNoticeElements {

	WebDriver driver_PopbitchFirstUseNoticeElements;														//driver_PopbitchFirstUseNoticeElements
	
	//Popbitch First use Notice elements finding
	By green_tab= By.className("triangle__3TvaE");																	//green tab
	By Nav_To_First_Use_Stories= By.xpath("//*[@id=\"menu-item-35878\"]/a");								//stories
	By Nav_To_First_Use_PremiumStory= By.xpath("//*[@id=\"post-37523\"]/div/div[2]/header/h2/a");	//first premium story
	By First_use_Login=By.id("btn_login");							//login to agate
	By First_Use_CreateWallet= By.xpath("/html/body/div/div/div/div/div/div/div[1]/button/span[3]");									//create wallet
	By First_Use_WhatIsAgate= By.linkText("What is Agate?");												//what is Agate
	
	


	public PopbitchFirstUseNoticeElements(WebDriver driver_PopbitchFirstUseNoticeElements2) {							//constructor
		this.driver_PopbitchFirstUseNoticeElements= driver_PopbitchFirstUseNoticeElements2;
		}
	
	public void click_on_green_tab() throws InterruptedException {
		Thread.sleep(2000);
		WebElement svgobject = driver_PopbitchFirstUseNoticeElements.findElement(green_tab);
		Actions builder = new Actions(driver_PopbitchFirstUseNoticeElements);
		builder.click(svgobject).build().perform();
						
	}
	
	public void Popbitch_premium_Story_create_wallet__Displayed()													//Check if all elements displayed on First use notice
	{
		Boolean Pop_First_Use_Notice_Create_Wallet_Displayed = driver_PopbitchFirstUseNoticeElements.findElement(First_Use_CreateWallet).isDisplayed();
		if(Pop_First_Use_Notice_Create_Wallet_Displayed==true)
		{
			System.out.println("create wallet button present");
		}
		else
		{
			
			System.out.println("create wallet button not present, please check ");
			
		}
		}
	
	
	
	
	
	public void Click_On_Popbitch_First_Use_Notice_Login() throws InterruptedException {					//Login from popbitch First use Notice	
		Thread.sleep(5000);
		//Scoll to the second half of Reg page
		JavascriptExecutor js = (JavascriptExecutor)driver_PopbitchFirstUseNoticeElements;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);	
		WebElement frame = driver_PopbitchFirstUseNoticeElements.findElement(By.id("iframe__inpage_notices"));
		
		driver_PopbitchFirstUseNoticeElements.switchTo().frame(frame);
		Thread.sleep(4000);
		Thread.sleep(4000);
		WebElement Login = (new WebDriverWait(driver_PopbitchFirstUseNoticeElements, 20))
				.until(ExpectedConditions.elementToBeClickable(By.id("btn_login")));
		
//WebElement Login=driver_PopbitchFirstUseNoticeElements.findElement(First_use_Login);
		Login.click();
		
		driver_PopbitchFirstUseNoticeElements.switchTo().defaultContent();
		}
	
	public void Click_On_Popbitch_First_Use_Notice_Create_Wallet() throws InterruptedException {										//Register from popbitch First use Notice
		Thread.sleep(2000);
		//Scoll to the second half of Reg page
				JavascriptExecutor js = (JavascriptExecutor)driver_PopbitchFirstUseNoticeElements;
				js.executeScript("window.scrollBy(0,500)");
				Thread.sleep(3000);	
		
		WebElement frame = driver_PopbitchFirstUseNoticeElements.findElement(By.id("iframe__inpage_notices"));
				
		driver_PopbitchFirstUseNoticeElements.switchTo().frame(frame);
		Thread.sleep(4000);
		
		WebElement create_wallet=driver_PopbitchFirstUseNoticeElements.findElement(By.id("btn_cta"));
		create_wallet.click();
		
		
		driver_PopbitchFirstUseNoticeElements.switchTo().defaultContent();
		}
		
	public void Click_On_Popbitch_First_Use_Notice_What_Is_Agate() {	
		//What is Agate from popbitch First use Notice
		driver_PopbitchFirstUseNoticeElements.findElement(First_Use_WhatIsAgate).click();
		}

	
	
	
	
	
	
	
	
	
	
	
}

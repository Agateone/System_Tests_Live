package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Popbitch_Wallet_Elements_staging {

	WebDriver driver_Popbitch_Wallet_Elements_staging;

	//login page elements finding
	By green_tab= By.id("agateposter");																				
	By Popbitch_Wallet_Elements_staging_current_total_balance= By.id("total_amount__currency__amount");	
	By Popbitch_Wallet_Elements_staging_current_wallet_balance= By.id("wallet_amount__currency__amount");
	By Popbitch_Wallet_Elements_staging_current_bonus_amount= By.id("bonus_amount__currency__amount");
	By Popbitch_Wallet_Elements_staging_topup_button= By.xpath("//*[@id=\"wallet\"]/div[2]/div/button");									//password text box
	By Popbitch_Wallet_Elements_staging_publication_name= By.xpath("//*[@id=\"wallet\"]/div[2]/div/div[2]/p[1]");								//remember me check box
	By Popbitch_Wallet_Elements_staging_price_per_article= By.xpath("//*[@id=\"wallet__price_per_article__currency__amount\"]");								//sign in button
	By Popbitch_Wallet_Elements_staging_current_free_point_balance= By.id("gauge__per_article__currency__amount");

	public Popbitch_Wallet_Elements_staging(WebDriver driver_Popbitch_Wallet_Elements_staging2) {				//constructor
		this.driver_Popbitch_Wallet_Elements_staging= driver_Popbitch_Wallet_Elements_staging2;
	}
	
	public void Click_On_popbitch_staging_agate_poster()									//Click on the green tab to open the wallet
	{
		driver_Popbitch_Wallet_Elements_staging.findElement(green_tab).click();
	}
	
	
	public void Click_On_popbitch_wallet_Top_up() throws InterruptedException									//Click on topup in the wallet
	{	Thread.sleep(3000);
	driver_Popbitch_Wallet_Elements_staging.switchTo().frame("iframe__wallet");
	
		driver_Popbitch_Wallet_Elements_staging.findElement(Popbitch_Wallet_Elements_staging_topup_button).click();
		driver_Popbitch_Wallet_Elements_staging.switchTo().defaultContent();
	}

	public String current_balance() throws InterruptedException // current wallet balance
	{
		
				Thread.sleep(2000);
				driver_Popbitch_Wallet_Elements_staging.switchTo().frame("iframe__wallet");
				String current_Balance = driver_Popbitch_Wallet_Elements_staging.findElement(Popbitch_Wallet_Elements_staging_current_total_balance).getText();
				driver_Popbitch_Wallet_Elements_staging.switchTo().defaultContent();
				return current_Balance;
				
	}
	

	public String Free_point()throws InterruptedException
	{
		
		Thread.sleep(2000);
		driver_Popbitch_Wallet_Elements_staging.switchTo().frame("iframe__wallet");
		String current_Free_Point = driver_Popbitch_Wallet_Elements_staging.findElement(Popbitch_Wallet_Elements_staging_current_free_point_balance).getText();
		driver_Popbitch_Wallet_Elements_staging.switchTo().defaultContent();
		return current_Free_Point;
		
	}
	
	
	public String Free_point_free()throws InterruptedException
	{
		
		Thread.sleep(2000);
		driver_Popbitch_Wallet_Elements_staging.switchTo().frame("iframe__wallet");
		String current_Free_Point = driver_Popbitch_Wallet_Elements_staging.findElement(By.className("textInsideGauge_perArticle__rhWV2")).getText();
		driver_Popbitch_Wallet_Elements_staging.switchTo().defaultContent();
		return current_Free_Point;
		
	}
	
	
	public String price_per_article_on_wallet() throws InterruptedException
	{
		
		Thread.sleep(2000);
		driver_Popbitch_Wallet_Elements_staging.switchTo().frame("iframe__wallet");
		String Popbitch_wallet_price_per_article = driver_Popbitch_Wallet_Elements_staging.findElement(Popbitch_Wallet_Elements_staging_price_per_article).getText();
		driver_Popbitch_Wallet_Elements_staging.switchTo().defaultContent();
		return Popbitch_wallet_price_per_article;
		
	}
	
}

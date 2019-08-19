package Elements;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Cricketer_first_use_notice_Elements {

WebDriver driver_Cricketer_first_use_noticeElements;														//driver_PopbitchFirstUseNoticeElements
	
	//Cricketer First use Notice elements finding
	By green_tab= By.className("triangle__3TvaE");																	//green tab
								//stories
	
	By Cricketer_First_use_Login=By.xpath("/html/body/div/div/div/div/section/section[2]/button[1]");												//login to agate
	By Cricketer_First_Use_CreateWallet= By.xpath("//*[@id=\"first_use__btn_pay\"]");
	By Cricketer_First_Use_I_Got_Digital_Subs = By.xpath("/html/body/div/div/div/div/section/section[2]/button[2]");
	By Cricketer_First_use_Login_button = By.xpath("/html/body/div/div/div/div/section/section[2]/button[1]");
	By Cricketer_First_Use_Subscribe_to_cricketers_magazine = By.xpath("/html/body/div/div/div/div/section/section[2]/button[3]");
	By Cricketer_First_Use_Learn_More = By.xpath("/html/body/div/div/div/div/section/button[2]");
	By Cricketer_First_use_Pop_Up_Price_Per_Article = By.xpath("//*[@id=\"__currency__amount\"]");
	By Cricketer_First_use_Pop_Up_Free_point = By.xpath("//*[@id=\"__currency__amount\"]");
	By Cricketer_First_use_Pop_Up_Free_Period = By.xpath("/html/body/div/div/div/div/section/section[1]/p[2]/text()[2]");
	By Cricketer_first_use_Learn_More_Here = By.linkText("here");
	By Cricketer_First_Use_learn_more_faq= By.linkText("our FAQs");
	By Cricketer_First_Use_Learn_More_Cricketer_Magazine_digital_subscription = By.xpath("/html/body/div/div/div/div/section/section[3]/div/p[4]/text()");
	By Cricketer_First_Use_Learn_More_reaction = By.linkText("reaction.life");
	By Cricketer_First_Use_Learn_More_popbitch = By.linkText("popbitch.com");
	By Cricketer_First_Use_Learn_More_TNE = By.linkText("theneweuropean.co.uk");
	By Cricketer_First_Use_Learn_More_completefrance = By.linkText("reaction.life");
			
	
	


	public Cricketer_first_use_notice_Elements(WebDriver driver_Cricketer_first_use_notice2) {							//constructor
		this.driver_Cricketer_first_use_noticeElements= driver_Cricketer_first_use_notice2;
		}
	
	public void click_on_green_tab() throws InterruptedException {
		Thread.sleep(2000);
		WebElement svgobject = driver_Cricketer_first_use_noticeElements.findElement(green_tab);
		Actions builder = new Actions(driver_Cricketer_first_use_noticeElements);
		builder.click(svgobject).build().perform();
						
	}
	
	public void Popbitch_premium_Story_Elements_Displayed()													//Check if all elements displayed on First use notice
	{
		//add a switch to frame 
		
		//pay per article button
		Boolean Cricketer_First_Use_CreateWallet_Displayed = driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_CreateWallet).isDisplayed();
		if(Cricketer_First_Use_CreateWallet_Displayed==true)
		{
			System.out.println("Pay per article button displayed");
		}
		else
		{
			System.out.println("Pay per article button not displayed, please check");
		}
		
		//i got digital subscription button
		Boolean Cricketer_First_Use_I_Got_Digital_Subs_Displayed = driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_I_Got_Digital_Subs).isDisplayed();
		if(Cricketer_First_Use_I_Got_Digital_Subs_Displayed==true)
		{
			System.out.println("Cricketer first use I got Digital subscription button displayed");
		}
		else
		{
			System.out.println("Cricketer first use I got Digital subscription button not displayed, please check");
		}
		
		//login button
		Boolean Cricketer_First_use_Login_button_Displayed = driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_use_Login_button).isDisplayed();
		if(Cricketer_First_use_Login_button_Displayed==true)
		{
			System.out.println("Cricketer first use Login button displayed");
		}
		else
		{
			System.out.println("Cricketer first use Login button  not displayed, please check");
		}
		
		//Subscribe to cricketer button 
		Boolean Cricketer_First_Use_Subscribe_to_cricketers_magazine_Displayed = driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_Subscribe_to_cricketers_magazine).isDisplayed();
		if(Cricketer_First_Use_Subscribe_to_cricketers_magazine_Displayed==true)
		{
			System.out.println("Cricketer first use subscribe to cricketer magazine button  displayed");
		}
		else
		{
			System.out.println("Cricketer first use subscribe to cricketer magazine button not displayed, please check");
		}
		
		//learn more button
		Boolean Cricketer_First_Use_Learn_More_Displayed = driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_Learn_More).isDisplayed();
		if(Cricketer_First_Use_Learn_More_Displayed==true)
		{
			System.out.println("Cricketer first use learn more  displayed");
		}
		else
		{
			System.out.println("Cricketer first use learn more button not displayed, please check");
		}
		
		
		//click on learn more to access learn more elements
		driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_Learn_More).click();
		
		
		//here link on learn more section
		Boolean Cricketer_first_use_Learn_More_Here_Displayed = driver_Cricketer_first_use_noticeElements.findElement(Cricketer_first_use_Learn_More_Here).isDisplayed();
		if(Cricketer_first_use_Learn_More_Here_Displayed==true)
		{
			System.out.println("Cricketer first use learn more link for agat.one  displayed");
		}
		else
		{
			System.out.println("Cricketer first use learn more button not displayed, please check");
		}
		
		
		//learn more faq's link
		Boolean Cricketer_First_Use_learn_more_faq_Displayed = driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_learn_more_faq).isDisplayed();
		if(Cricketer_First_Use_learn_more_faq_Displayed==true)
		{
			System.out.println("Cricketer first use learn more faq's  displayed");
		}
		else
		{
			System.out.println("Cricketer first use learn more faq's not displayed, please check");
		}
		
		
		//learn more cricketer magazine
		Boolean Cricketer_First_Use_Learn_More_Cricketer_Magazine_digital_subscription_displayed = driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_Learn_More_Cricketer_Magazine_digital_subscription).isDisplayed();
		if(Cricketer_First_Use_Learn_More_Cricketer_Magazine_digital_subscription_displayed==true)
		{
			System.out.println("Cricketer first use learn more cricketer magazine, and digital subscription displayed");
		}
		else
		{
			System.out.println("Cricketer first use learn more cricketer magazine, and digital subscriptions not displayed, please check");
		}
		
		
		//price per article
		Boolean Cricketer_First_use_Pop_Up_Price_Per_Article_displayed = driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_use_Pop_Up_Price_Per_Article).isDisplayed();
		if(Cricketer_First_use_Pop_Up_Price_Per_Article_displayed==true)
		{
			System.out.println("Cricketer first use  price per article isplayed");
		}
		else
		{
			System.out.println("Cricketer first use price per article not displayed, please check");
		}
		
		
		
		//free point
		Boolean Cricketer_First_use_Pop_Up_Free_point_Displayed = driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_use_Pop_Up_Free_point).isDisplayed();
		if(Cricketer_First_use_Pop_Up_Free_point_Displayed==true)
		{
			System.out.println("Cricketer first use  free point is displayed");
		}
		else
		{
			System.out.println("Cricketer first use free point not displayed, please check");
		}
		
		//free period
		
		Boolean Cricketer_First_use_Pop_Up_Free_Period_Displayed = driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_use_Pop_Up_Free_Period).isDisplayed();
		if(Cricketer_First_use_Pop_Up_Free_Period_Displayed==true)
		{
			System.out.println("Cricketer first use  free period is displayed");
		}
		else
		{
			System.out.println("Cricketer first use free period not displayed, please check");
		}
		
		
		//reaction link 
		Boolean Cricketer_First_Use_Learn_More_reaction_Displayed = driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_Learn_More_reaction).isDisplayed();
		if(Cricketer_First_Use_Learn_More_reaction_Displayed==true)
		{
			System.out.println("Cricketer first use Learn more reaction link is displayed");
		}
		else
		{
			System.out.println("Cricketer first use Learn more reaction link not displayed, please check");
		}
		
		
		//popbitch link 
				Boolean Cricketer_First_Use_Learn_More_popbitch_Displayed = driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_Learn_More_popbitch).isDisplayed();
				if(Cricketer_First_Use_Learn_More_popbitch_Displayed==true)
				{
					System.out.println("Cricketer first use Learn more popbitch link is displayed");
				}
				else
				{
					System.out.println("Cricketer first use Learn more popbitch link not displayed, please check");
				}
		
				
				//TNE link 
				Boolean Cricketer_First_Use_Learn_More_TNE_Displayed = driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_Learn_More_TNE).isDisplayed();
				if(Cricketer_First_Use_Learn_More_TNE_Displayed==true)
				{
					System.out.println("Cricketer first use Learn more TNE link is displayed");
				}
				else
				{
					System.out.println("Cricketer first use Learn more TNE link not displayed, please check");
				}		
				
		}
	
	
	
	//Clicking on buttons and links
	
	public void Click_On_Cricketer_First_use_Login_button() throws InterruptedException {					

		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver_Cricketer_first_use_noticeElements;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		
	WebElement frame = 	driver_Cricketer_first_use_noticeElements.findElement(By.xpath("//*[@id=\"iframe__inpage_notices\"]"));
	driver_Cricketer_first_use_noticeElements.switchTo().frame(frame);
	
	WebElement yourelement= driver_Cricketer_first_use_noticeElements.findElement(By.id("btn_login"));
	JavascriptExecutor executor = (JavascriptExecutor)driver_Cricketer_first_use_noticeElements;
	executor.executeScript("arguments[0].click();", yourelement);
	
		
		}
	
	public void Click_On_Cricketer_First_Use_CreateWallet() throws InterruptedException {					
		
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver_Cricketer_first_use_noticeElements;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		
	WebElement frame = 	driver_Cricketer_first_use_noticeElements.findElement(By.xpath("//*[@id=\"iframe__inpage_notices\"]"));
	driver_Cricketer_first_use_noticeElements.switchTo().frame(frame);
	
	WebElement yourelement= driver_Cricketer_first_use_noticeElements.findElement(By.id("btn_cta"));
	JavascriptExecutor executor = (JavascriptExecutor)driver_Cricketer_first_use_noticeElements;
	executor.executeScript("arguments[0].click();", yourelement);
	
	
	//driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_CreateWallet).click();
	
		Thread.sleep(4000);
		driver_Cricketer_first_use_noticeElements.switchTo().defaultContent();
		}
	
	public void Click_On_Cricketer_First_Use_I_Got_Digital_Subs() throws InterruptedException {					
		Thread.sleep(4000);
		driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_I_Got_Digital_Subs).click();
		}
	
	public void Click_On_Cricketer_First_Use_Subscribe_to_cricketers_magazine() throws InterruptedException {										
		Thread.sleep(2000);
		
		driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_Subscribe_to_cricketers_magazine).click();
		}
		
	public void Click_On_Cricketer_First_Use_Learn_More() {										
		driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_Learn_More).click();
		}

	public void Click_On_Cricketer_first_use_Learn_More_Here() {										
		driver_Cricketer_first_use_noticeElements.findElement(Cricketer_first_use_Learn_More_Here).click();
		}
	
	public void Click_On_Cricketer_First_Use_learn_more_faq() {										
		driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_learn_more_faq).click();
		}
	
	
	public void Click_On_Cricketer_First_Use_Learn_More_reaction() {										
		driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_Learn_More_reaction).click();
		}
	
	public void Click_On_Cricketer_First_Use_Learn_More_popbitch() {										
		driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_Learn_More_popbitch).click();
		}
	
	
	public void Cricketer_First_Use_Learn_More_TNE() {										
		driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_Learn_More_popbitch).click();
		}
	
	

	//getting Price per articles and free points and environments
	
	public String Cricketer_First_use_get_price_per_article() 
	{										
		String Cricketer_First_use_Price_Per_Article_text= driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_use_Pop_Up_Price_Per_Article).getText();
	return 	Cricketer_First_use_Price_Per_Article_text;	
	}

	public String Cricketer_first_use_get_free_point() 
	{										
		String Cricketer_frist_use_free_point_text= driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_use_Pop_Up_Free_point).getText();
	return 	Cricketer_frist_use_free_point_text;	
	}
	
	public String Cricketer_first_use_get_free_period() 
	{										
		String Cricketer_frist_use_free_period_Text= driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_use_Pop_Up_Free_Period).getText();
	return 	Cricketer_frist_use_free_period_Text;	
	}
	
	public String Cricketer_First_Use_Learn_More_Cricketer_Magazine() 
	{										
		String Cricketer_First_Use_Learn_More_Cricketer_Magazine_digital_subscription_Text= driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_Learn_More_Cricketer_Magazine_digital_subscription).getText();
	return 	Cricketer_First_Use_Learn_More_Cricketer_Magazine_digital_subscription_Text;	
	}
	
	
	
	public String Cricketer_First_Use_Learn_More_digital_subscription() 
	{										
		String Cricketer_First_Use_Learn_More_digital_subscription_Text= driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_Learn_More_Cricketer_Magazine_digital_subscription).getText();
	return 	Cricketer_First_Use_Learn_More_digital_subscription_Text;	
	}
	
	
	//getting texts on buttons and lables
	
	public String Cricketer_First_use_Login_spell_check() 
	{		
		String Cricketer_First_use_Login_spell_check= driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_use_Login).getText();
	return 	Cricketer_First_use_Login_spell_check;	
	}

	public String Cricketer_First_use_pay_per_article_spell_check() 
	{										
		String Cricketer_First_use_pay_per_article_spell_check= driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_use_Login).getText();
	return 	Cricketer_First_use_pay_per_article_spell_check;	
	}
	
	
	public String Cricketer_First_Use_I_Got_Digital_Subs_spell_check() 
	{										
		String Cricketer_First_Use_I_Got_Digital_Subs_spell_check= driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_I_Got_Digital_Subs).getText();
	return 	Cricketer_First_Use_I_Got_Digital_Subs_spell_check;	
	}
	
	public String Cricketer_First_Use_Learn_More_Spell_check() 
	{										
		String Cricketer_First_Use_Learn_More_Spell_check= driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_Learn_More).getText();
	return 	Cricketer_First_Use_Learn_More_Spell_check;	
	}
	
	public String Cricketer_First_Use_Subscribe_to_cricketers_magazine_Spell_check() 
	{										
		String Cricketer_First_Use_Subscribe_to_cricketers_magazine_Spell_check= driver_Cricketer_first_use_noticeElements.findElement(Cricketer_First_Use_Subscribe_to_cricketers_magazine).getText();
	return 	Cricketer_First_Use_Subscribe_to_cricketers_magazine_Spell_check;	
	}
	

}

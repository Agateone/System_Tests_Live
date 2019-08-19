package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Newbury_LoggedOut_Wallet {

	WebDriver driver_Logged_out_wallet;
	
	//LoggedOut wallet Green_tab
		By green_tab= By.className("triangle__3TvaE");
	//Logged out wallet Axate Logo 
		By LoggedOut_Walet_Axate_logo = By.xpath("//*[@id=\"Fill-4\"]");
	//Logged out wallet Read paid content with Axate text 
		By Text_line_Read_paid_content = By.xpath("/html/body/div/div/div/div/div/p");
	//Logged out wallet Learn more Link  	
		
		
		
		
		
		
		
		
	//Clicking on green_Tab
	public void click_on_green_tab() throws InterruptedException {
		Thread.sleep(2000);
		WebElement svgobject = driver_Logged_out_wallet.findElement(green_tab);
		Actions builder = new Actions(driver_Logged_out_wallet);
		builder.click(svgobject).build().perform();
						
	}
	
	
	//Verify if Axate logo is present on the logged out wallet
	public boolean  verify_logged_out_wallet_Axate_logo_present() {
		boolean Logged_out_axate_logo_present = driver_Logged_out_wallet.findElement(LoggedOut_Walet_Axate_logo).isDisplayed();
		if(Logged_out_axate_logo_present== true)
		{
			System.out.println("Axate Logo is present on the Logged out wallet");
			
		}
		
		if(Logged_out_axate_logo_present== false)
		{
			System.out.println("Alert!! Axate Logo not present on the Logged out wallet, please check!!");
			
		}
		return Logged_out_axate_logo_present;
		
	}
	
	
	
	//Verify if Text line "Read paid content is present on the logged out wallet
		public String  verify_logged_out_wallet_Text_line_read_paid_content() {
			String Logged_out_axate_Text_Read_paid = driver_Logged_out_wallet.findElement(Text_line_Read_paid_content).getText();
			if(Logged_out_axate_Text_Read_paid== "Read paid content with Axate")
			{
				System.out.println("Text line  "+Logged_out_axate_Text_Read_paid+" is present on the logged out wallet");
				
			}
			
			else
			{
				System.out.println("Alert!! Text line is different from Read Paid content with Axate , It is "+Logged_out_axate_Text_Read_paid+"Please check!!");
				
			}
			return Logged_out_axate_Text_Read_paid;
			
		}
	
	
	
	
	
	
	
}

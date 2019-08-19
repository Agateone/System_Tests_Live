package Stepdef;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
//import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import Elements.Login_Page_Elements;
import Elements.PopbitchFirstUseNoticeElements;
import Elements.Popbitch_Wallet_Elements_staging;
import Elements.Top_up_Elements_Staging;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Top_up_from_wallet_staging_popbitch {
	WebDriver driverTop_up_from_wallet_staging_popbitch;

	@Given("^I am a user of agate$")
	@Test(priority=18)
	@Parameters("browser")
	public void i_am_a_user_of_agate(String browser) throws Throwable {
		
		if(browser.equalsIgnoreCase("firefox")) {
			driverTop_up_from_wallet_staging_popbitch = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("safari")) { 

			driverTop_up_from_wallet_staging_popbitch= new SafariDriver();
		} 

		else if (browser.equalsIgnoreCase("chrome")) { 
			driverTop_up_from_wallet_staging_popbitch= new ChromeDriver();
		} 
		System.out.println("\n"+"POPBITCH WALLET TOPUP"+"\n");
		System.out.println("\n"+""+"\n");
		
		//with popbitch url
		driverTop_up_from_wallet_staging_popbitch.get("http://popbitch.agate.one");
		//delay
		Thread.sleep(1000);
		//maximise window
		//driverTop_up_from_wallet_staging_popbitch.manage().window().maximize();
		//calling the first use elements to perform operations on the elements
		PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet1 = new PopbitchFirstUseNoticeElements(driverTop_up_from_wallet_staging_popbitch);
		//click on popbitch stories menu
		//pop_first_use_top_up_from_wallet1.Click_On_Popbitch_Stories_Menu();
		System.out.println("\n"+"Opened a List of premium stories"+"\n");
		Thread.sleep(3000);
		//pop_first_use_top_up_from_wallet1.Click_On_Popbitch_Premium_Story();//click on a premium story
		System.out.println("\n"+"Premium story selected"+"\n");
		Thread.sleep(6000);	
		pop_first_use_top_up_from_wallet1.Click_On_Popbitch_First_Use_Notice_Login();//click on login from the first use notice
		System.out.println("\n"+"Clicked on login"+"\n");
		Login_Page_Elements Login_Pop_First_Use = new Login_Page_Elements(driverTop_up_from_wallet_staging_popbitch);//calling login page elements to perform operations on the elements
		Thread.sleep(3000);
		Login_Pop_First_Use.Login_Process("ajjukanna");//enter username and password
		System.out.println("\n"+"Login successfull"+"\n");
		Thread.sleep(6000);

		@SuppressWarnings("unused")
		String current_url_after_login= driverTop_up_from_wallet_staging_popbitch.getCurrentUrl();
			
		pop_first_use_top_up_from_wallet1.click_on_green_tab();//click on the green tab to pen the wallet
		//Get balance before topup
		Thread.sleep(2000);
		Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driverTop_up_from_wallet_staging_popbitch); 
		String Balance_before_top_up= wallet_elements_1.current_balance();
		System.out.println("\n"+"Balance before top up is "+Balance_before_top_up+"\n");//balance before top up
		//String parentwin = driverTop_up_from_wallet_staging_popbitch.getWindowHandle();
		Popbitch_Wallet_Elements_staging top_up_wallet_1 = new Popbitch_Wallet_Elements_staging(driverTop_up_from_wallet_staging_popbitch); 
		top_up_wallet_1.Click_On_popbitch_wallet_Top_up();
		System.out.println("\n"+"clicked on top up"+"\n");
		//Thread.sleep(6000);
		String parentWindowHandler = driverTop_up_from_wallet_staging_popbitch.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;
		Set<String> handles = driverTop_up_from_wallet_staging_popbitch.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driverTop_up_from_wallet_staging_popbitch.switchTo().window(subWindowHandler); // switch to popup window
		//for(String winHandle : driverTop_up_from_wallet_staging_popbitch.getWindowHandles()){
		//driverTop_up_from_wallet_staging_popbitch.switchTo().window(winHandle);
		//}
		Top_up_Elements_Staging top_up_elements_2 = new Top_up_Elements_Staging(driverTop_up_from_wallet_staging_popbitch);
		top_up_elements_2.Click_On_3_recharge();
		Thread.sleep(4000);
		top_up_elements_2.topup_process_from_wallet_staging_popbitch();
		System.out.println("\n"+"topped up"+"\n");
		Thread.sleep(4000);		
		driverTop_up_from_wallet_staging_popbitch.switchTo().window(parentWindowHandler);
		Thread.sleep(3000);
		String Balance_after_top_up = wallet_elements_1.current_balance();
		System.out.println("\n"+"Balance after top up is "+Balance_after_top_up+"\n");
		double Balance_after = Double.parseDouble(Balance_after_top_up);
		double Balance_before= Double.parseDouble(Balance_before_top_up);
		double new_total_balance = Balance_after-Balance_before;
		//£3.0
		System.out.println("\n"+"Your account has been incremented by £"+ new_total_balance+"\n");
	}
	@When("^I click on topup from the wallet$")
	@Test(priority=19)
	public void i_click_on_topup_from_the_wallet() throws Throwable {
		System.out.println("\n"+""+"\n");
	}
	@Then("^the wallet  opens a saperate window$")
	@Test(priority=20)
	public void the_wallet_opens_a_saperate_window() throws Throwable {
		System.out.println("\n"+""+"\n");
	}
	@Then("^successfully top up with the selected amount and card$")
	@Test(priority=21)
	public void successfully_top_up_with_the_selected_amount_and_card() throws Throwable {
		System.out.println("\n"+""+"\n");
	}
	@Then("^the wallet balance and total balance are incremented by the amount topped up$")
	@Test(priority=22)
	public void the_wallet_balance_and_total_balance_are_incremented_by_the_amount_topped_up() throws Throwable {
		System.out.println("\n"+""+"\n");
		Thread.sleep(3000);
		driverTop_up_from_wallet_staging_popbitch.quit();
	}
}

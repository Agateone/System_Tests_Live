package Stepdef;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import Elements.Authorise_charge_notice_popbitch;
import Elements.Login_Page_Elements;
import Elements.PopbitchFirstUseNoticeElements;
import Elements.Popbitch_Wallet_Elements_staging;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Popbitch_login_First_Use_Notice {
	static WebDriver driver_Login_From_PopBitch_Frist_Use_Notice ;					//driver_Login_From_PopBitch_Frist_Use_Notice
	PopbitchFirstUseNoticeElements pop_first_use = new PopbitchFirstUseNoticeElements(driver_Login_From_PopBitch_Frist_Use_Notice);	
	
	@Given("^I am a registered user , I open the browser$")
	@Test(priority=10)
	@Parameters("browser")
	public void i_am_a_registered_user_I_open_the_browser(String browser) throws Throwable {
		if(browser.equalsIgnoreCase("firefox")) {

			driver_Login_From_PopBitch_Frist_Use_Notice = new FirefoxDriver();

		// If browser is IE, then do this	  

		}else if (browser.equalsIgnoreCase("safari")) { 

			driver_Login_From_PopBitch_Frist_Use_Notice= new SafariDriver();
		} 
		else if (browser.equalsIgnoreCase("chrome")) { 
			driver_Login_From_PopBitch_Frist_Use_Notice= new ChromeDriver();

		} 
		System.out.println("\n"+"POPBITCH LOGIN"+"\n");
		System.out.println("\n"+""+"\n");
		
		System.out.println("\n"+"Browser opened"+"\n");
	}

	@Given("^I navigate to popbitch\\.com$")
	@Test(priority=11)
	public void i_navigate_to_popbitch_com() throws Throwable {
		
		driver_Login_From_PopBitch_Frist_Use_Notice.get("https://popbitch.com/2019/02/tat-for-tits/");
		Thread.sleep(3000);
		String popbitch_navigation= driver_Login_From_PopBitch_Frist_Use_Notice.getCurrentUrl();
	    try
		{
	    	AssertJUnit.assertTrue(popbitch_navigation.contains("https://popbitch.com/2019/02/tat-for-tits/"));
		}catch(AssertionError e0)
		{
			System.out.println("Browser did not open popbitch staging ");
			throw e0;
		}
	    System.out.println("Popbitch staging is ready to be tested");
		
	}
	
	@When("^I Click on Login to Agate from the Pop Bitch First use notice$")
	@Test(priority=14)
	public void i_Click_on_Login_to_Agate_from_the_Pop_Bitch_First_use_notice() throws Throwable {
		Thread.sleep(4000);
		PopbitchFirstUseNoticeElements pop_first_use = new PopbitchFirstUseNoticeElements(driver_Login_From_PopBitch_Frist_Use_Notice);
		pop_first_use.Click_On_Popbitch_First_Use_Notice_Login();
		System.out.println("\n"+"Clicked on login"+"\n");
	}

	
	@Then("^I verify that the Login Button Navigates me to the login page$")
	@Test(priority=15)
	public void i_verify_that_the_Login_Button_Navigates_me_to_the_login_page() throws Throwable {
		Thread.sleep(8000);
		
		Thread.sleep(2000);
		String Login_From_PopBitch_Frist_Use_Notice_Current_Url= driver_Login_From_PopBitch_Frist_Use_Notice.getCurrentUrl();
	    System.out.println("\n"+"Clicking on login redirected to login page satging"+"\n");
	    assertTrue(Login_From_PopBitch_Frist_Use_Notice_Current_Url.contains("https://account.agate.io/my-agate/sign-in?"));
	    System.out.println("\n"+"Successfully navigated to login page"+"\n");
	}
	
	
	@When("^I Login with correct Details$")
	@Test(priority=16)
	public void i_Login_with_correct_Details() throws Throwable {
		Login_Page_Elements Login_Pop_First_Use = new Login_Page_Elements(driver_Login_From_PopBitch_Frist_Use_Notice);
		Thread.sleep(2000);
		Login_Pop_First_Use.Login_Process("Ajjukanna1$$");
		Thread.sleep(2000);
		
		System.out.println("\n"+"Login successfull"+"\n");
	}
	
	@Then("^I verify that I am navigated to the full article$")
	@Test(priority=17)
	public void i_verify_that_I_am_navigated_to_the_full_article() throws Throwable {
	//verify the balance before reading the second article
		//Click on the green tab and 
				PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_Login_From_PopBitch_Frist_Use_Notice);
				pop_first_use_top_up_from_wallet2.click_on_green_tab();
					
			//get the balance after two transactions. since we topped up with £2 the balance should be 1.75
				Thread.sleep(2000);
				Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_Login_From_PopBitch_Frist_Use_Notice); 
				String Balance_after_fist_Article= wallet_elements_1.current_balance();
				Thread.sleep(1000);
				
			//convert string balances to double
				double balance_after_first_article = Double.parseDouble(Balance_after_fist_Article);
				double expected_balance_after_first_article = 9.75;
				
			//verify whether the expected balance is the actual balance
				AssertJUnit.assertEquals(expected_balance_after_first_article, balance_after_first_article);
				if(balance_after_first_article==expected_balance_after_first_article)
				{
					System.out.println("Balance after reading the first article is expected to be "+balance_after_first_article );
							
				}
				else
				{
					System.out.println("Alert!! Balance is not expected to be "+balance_after_first_article+ "please check, it should be  "+ expected_balance_after_first_article );
				}		
		
		
	
	
	//click ok on authorise charge notice
		Authorise_charge_notice_popbitch authy_popbitch = new Authorise_charge_notice_popbitch(driver_Login_From_PopBitch_Frist_Use_Notice);
		authy_popbitch.authorise_charge_notice_click_continue();
		Thread.sleep(3000);
		
		
		
		//check if the wallket is being deducted by 25 p
				String Balance_after_reading_an_article= wallet_elements_1.current_balance();
				
			//convert string balances to double
						double actual_balance_after_reacding_first_article = Double.parseDouble(Balance_after_reading_an_article);
						double expected_balance_to_be_deducted = 0.25;
						double actual_balance_being_deducted= balance_after_first_article-actual_balance_after_reacding_first_article;
						
						
					//verify whether the expected balance is the actual balance
						AssertJUnit.assertEquals(expected_balance_to_be_deducted, actual_balance_being_deducted);
						if(actual_balance_being_deducted==expected_balance_to_be_deducted)
						{
							System.out.println("Balance is expected to be deducted by"+actual_balance_being_deducted );
									
						}
						else
						{
							System.out.println("Alert!! Balance is not expected to be deducted by "+actual_balance_being_deducted+ "please check, it should be  "+ expected_balance_to_be_deducted );
						}		

	
		JavascriptExecutor js = (JavascriptExecutor)driver_Login_From_PopBitch_Frist_Use_Notice;
		js.executeScript("window.scrollBy(0,500)");
		
	
		
		Thread.sleep(3000);		
		JavascriptExecutor js1 = (JavascriptExecutor)driver_Login_From_PopBitch_Frist_Use_Notice;
		js1.executeScript("window.scrollBy(0,500)");		
		
		Thread.sleep(1000);
		
	//Verify the user landed on the same article
		String Login_From_PopBitch_Frist_Use_Notice_Current_Url1= driver_Login_From_PopBitch_Frist_Use_Notice.getCurrentUrl();	   
	    String Login_From_PopBitch_Frist_Use_Notice_Popbitch_Login_Url1 = "https://popbitch.com/2019/02/tat-for-tits/";
	    AssertJUnit.assertEquals(Login_From_PopBitch_Frist_Use_Notice_Current_Url1, Login_From_PopBitch_Frist_Use_Notice_Popbitch_Login_Url1);
	    System.out.println("\n"+"User presented with complete article"+"\n");
	    Thread.sleep(3000);
	    driver_Login_From_PopBitch_Frist_Use_Notice.quit();		
		
	}
	
}

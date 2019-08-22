package Stepdef;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.text.DecimalFormat;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Elements.Authorise_charge_notice_popbitch;
import Elements.Login_Page_Elements;
import Elements.PopbitchFirstUseNoticeElements;
import Elements.Popbitch_Wallet_Elements_staging;
import Elements.Reaction_first_use_notice;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Reaction_Login_first_use_notice {
	
	//INSTANTIATE WEBDRIVER
	WebDriver driver_Reaction_Login_first_use_notice;
	
	//OPEN THE RESPECTIVE BROWSER	
	@Test(priority=6)
	@Parameters("browser")
	@Given("I am a registered user of reaction and I open a browser")
	public void i_am_a_registered_user_of_reaction_and_I_open_a_browser(String browser) {
		
	//If browser is firefox
		if(browser.equalsIgnoreCase("firefox")) {
			driver_Reaction_Login_first_use_notice = new FirefoxDriver();	
		}
	
	//If browser is safari	
		else if (browser.equalsIgnoreCase("safari")) { 
			driver_Reaction_Login_first_use_notice= new SafariDriver();
			driver_Reaction_Login_first_use_notice.manage().window().maximize();
		} 
		
	//If browser is chrome	
		else if (browser.equalsIgnoreCase("chrome")) { 
			driver_Reaction_Login_first_use_notice= new ChromeDriver();
		} 
	}

	
	
	//OPEN A PREMIUM ARTICLE ON RECATION	
	@Test(priority=7)
	@Given("I navigate to a premium article on reaction.life")
	public void i_navigate_to_a_premium_article_on_reaction_life() throws InterruptedException, IOException {
	
	//open a premium article on reaction	
		driver_Reaction_Login_first_use_notice.get("https://reaction.life/independent-groups-new-politics-isnt-new/");
		Thread.sleep(10000);
		
	//verify that the premium article is opened	
		String reaction_navigation= driver_Reaction_Login_first_use_notice.getCurrentUrl();
	    try
		{
	    	AssertJUnit.assertTrue(reaction_navigation.contains("https://reaction.life/independent-groups-new-politics-isnt-new/"));
		}catch(AssertionError e0)
		{
			System.out.println("Browser did not open Reaction staging ");
			throw e0;
		}
	    System.out.println("Reaction staging is ready to be tested");
	
	//scroll for first use notice
	  	JavascriptExecutor js = (JavascriptExecutor)driver_Reaction_Login_first_use_notice;
	  	js.executeScript("window.scrollBy(0,500)");    
	
	
	//scroll for full article
		js.executeScript("window.scrollBy(0,500)");
	
	
	}

	
	
	//CLICK ON LOGIN FROM REACTION FIRST UISE NOTICE
	@Test(priority=8)
	@When("I click on Login from reaction First use notice")
	public void i_click_on_Login_from_reaction_First_use_notice() throws InterruptedException {
		
	//call first use notice elements of reaction
		Thread.sleep(15000);
		Reaction_first_use_notice Reac_first_use_register1 = new Reaction_first_use_notice(driver_Reaction_Login_first_use_notice);	
		Reac_first_use_register1.Click_On_Reaction_First_use_Login_button(); 
		System.out.println("\n"+"Clicked on Create wallet.. Now lets see if this takes us to Sign up page"+"\n");	
	}

	
	
	//verify that teh login button navigates to login page
	@Test(priority=9)
	@Then("I verify that the Login Button Navigates me to the login page to log me in to reaction")
	public void i_verify_that_the_Login_Button_Navigates_me_to_the_login_page_to_log_me_in_to_reaction() throws IOException, InterruptedException {
		

		Thread.sleep(2000);
		
	//get current url of login page
		String actual_click_on_login_from_reaction_FUN= driver_Reaction_Login_first_use_notice.getCurrentUrl();
	
	//verify that the actual url is equal to the expeted url 
	    assertTrue(actual_click_on_login_from_reaction_FUN.contains("https://account.agate.io/my-agate/sign-in?"));
	   if(actual_click_on_login_from_reaction_FUN.contains("https://account.agate.io/my-agate/sign-in?"))
	   {
		   System.out.println("clicking on login button from reaction first use notice, navigated to login page");
		   
	   }
	   else
	   {
		   
		   System.out.println("Alert!!!clicking on login button from reaction first use notice did not navigate to login page.. please check!!");
		   
	   }
	}

	//enter details on login page
	@Test(priority=10)
	@Then("entering the correct email and password logs me in to reaction")
	public void entering_the_correct_email_and_password_logs_me_in_to_reaction() throws IOException, InterruptedException {
		Login_Page_Elements Login_Pop_First_Use = new Login_Page_Elements(driver_Reaction_Login_first_use_notice);
		Thread.sleep(2000);
		Login_Pop_First_Use.Login_Process("Ajjukanna1$$");
		Thread.sleep(2000);
	
	}

	//Verify that I am being navigated to fulla rticle
	@Test(priority=11)
	@Then("verify that I am being navigated to the same article")
	public void verify_that_I_am_being_navigated_to_the_same_article() throws InterruptedException, IOException {
	/*//verify the balance before reading the second article
	//Click on the green tab and 
		PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_Reaction_Login_first_use_notice);
		pop_first_use_top_up_from_wallet2.click_on_green_tab();
							
	//get the balance after one transactions. since we topped up with £2 the balance should be 1.70
		Thread.sleep(2000);
		Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_Reaction_Login_first_use_notice); 
		String Balance_after_fist_Article= wallet_elements_1.current_balance();
		Thread.sleep(1000);
						
	//convert string balances to double
		double balance_after_first_article = Double.parseDouble(Balance_after_fist_Article);
		double expected_balance_after_first_article = 1.70;
						
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
								
	//String screenshot_name_2= "Popbitch_authorise_charge_notice_appears";
		Thread.sleep(2000);
		String timestamp_2 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_2 = ((TakesScreenshot)driver_Reaction_Login_first_use_notice).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile_2, new File("/Users/jay/Desktop/reaction/"+"_"+timestamp_2+"_"+"jpg" ));*/
	
		
		//scroll for first use notice
	  	JavascriptExecutor js2 = (JavascriptExecutor)driver_Reaction_Login_first_use_notice;
	  	js2.executeScript("window.scrollBy(0,800)"); 
		
		
	//click ok on authorise charge notice
		Thread.sleep(10000);
		Authorise_charge_notice_popbitch authy_popbitch = new Authorise_charge_notice_popbitch(driver_Reaction_Login_first_use_notice);
		authy_popbitch.authorise_charge_notice_click_continue();
		Thread.sleep(3000);
		
		
		//Click on the green tab and 
				PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_Reaction_Login_first_use_notice);
				pop_first_use_top_up_from_wallet2.click_on_green_tab();
						
	//check if the wallket is being deducted by 30 p
		Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_Reaction_Login_first_use_notice);
		String Balance_after_reading_an_article= wallet_elements_1.current_balance();
						
	//convert string balances to double
		double actual_balance_after_reacding_first_article = Double.parseDouble(Balance_after_reading_an_article);
		double expected_balance_to_be_deducted = 0.30;
		double balance_after_first_article= 1.70;
		double actual_balance_being_deducted= balance_after_first_article-actual_balance_after_reacding_first_article;
		DecimalFormat df = new DecimalFormat("#.##");
		actual_balance_being_deducted = Double.valueOf(df.format(actual_balance_being_deducted));						
								
	//verify whether the expected balance is the actual balance
		AssertJUnit.assertEquals(expected_balance_to_be_deducted, actual_balance_being_deducted);
		if(actual_balance_being_deducted==expected_balance_to_be_deducted)
		{
			System.out.println("Balance is expected to be deducted by"+actual_balance_after_reacding_first_article );
											
		}
		else
		{
			System.out.println("Alert!! Balance is not expected to be deducted by "+actual_balance_after_reacding_first_article+ "please check, it should be  "+ expected_balance_to_be_deducted );
		}		
		
						
	
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver_Reaction_Login_first_use_notice;
		js.executeScript("window.scrollBy(0,500)");
						
	
						
					//Verify the user landed on the same article
						String Login_From_PopBitch_Frist_Use_Notice_Current_Url1= driver_Reaction_Login_first_use_notice.getCurrentUrl();	   
					    String Login_From_PopBitch_Frist_Use_Notice_Popbitch_Login_Url1 = "https://reaction.life/independent-groups-new-politics-isnt-new/";
					    AssertJUnit.assertEquals(Login_From_PopBitch_Frist_Use_Notice_Current_Url1, Login_From_PopBitch_Frist_Use_Notice_Popbitch_Login_Url1);
					    System.out.println("\n"+"User presented with complete article"+"\n");
					    Thread.sleep(3000);
					
	}
}

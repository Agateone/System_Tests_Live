package Stepdef;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Elements.Authorise_charge_notice_popbitch;
import Elements.Boone_first_use_notice;
import Elements.PopbitchFirstUseNoticeElements;
import Elements.Popbitch_Finish_Notice_elements;
import Elements.Popbitch_Wallet_Elements_staging;
import Elements.Register_Page_Elements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Boone_Register {

	WebDriver driver_Register_from_boone_first_use_notice;

	@Given("I am not a user of agate on boone and I open a browser")
	@Test(priority=0)
	@Parameters("browser")
	public void i_am_not_a_user_of_agate_on_boone_and_I_open_a_browser(String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
			driver_Register_from_boone_first_use_notice = new FirefoxDriver();
			
		}else if (browser.equalsIgnoreCase("safari")) { 
			driver_Register_from_boone_first_use_notice= new SafariDriver();
			driver_Register_from_boone_first_use_notice.manage().window().maximize();
		} 
		else if (browser.equalsIgnoreCase("chrome")) { 
			driver_Register_from_boone_first_use_notice= new ChromeDriver();
		}   
	}

	@Given("I navigate to a premium article on boone")
	@Test(priority=1)
	public void i_navigate_to_a_premium_article_on_boone() throws InterruptedException {
		driver_Register_from_boone_first_use_notice.get("https://www.roanoke-chowannewsherald.com/2019/06/24/miracle-workers/");
		Thread.sleep(10000);
		String popbitch_navigation= driver_Register_from_boone_first_use_notice.getCurrentUrl();
	    try
		{
	    	AssertJUnit.assertTrue(popbitch_navigation.contains("https://www.roanoke-chowannewsherald.com/2019/06/24/miracle-workers/"));
		}catch(AssertionError e0)
		{
			System.out.println("Browser did not open boone");
			throw e0;
		}
	    System.out.println("Boone is ready to be tested");
	}

	@Given("I click on the create wallet button on boone")
	@Test(priority=2)
	public void i_click_on_the_create_wallet_button_on_boone() throws IOException, InterruptedException {
		Thread.sleep(3000);
		//Scroll by 200px
				JavascriptExecutor js = (JavascriptExecutor)driver_Register_from_boone_first_use_notice;
				js.executeScript("window.scrollBy(0,1200)");
				Thread.sleep(5000);
			
		Boone_first_use_notice boone_first_use_register1 = new Boone_first_use_notice(driver_Register_from_boone_first_use_notice);
		
		boone_first_use_register1.Click_On_boone_First_Use_CreateWallet();
		 
		System.out.println("\n"+"Clicked on Create wallet.. Now lets see if this takes us to Sign up page"+"\n");
	}

	@Given("I verify that the create wallet button takes me to the reg page on boone")
	@Test(priority=3)
	public void i_verify_that_the_create_wallet_button_takes_me_to_the_reg_page_on_boone() throws InterruptedException {
		Register_Page_Elements reg_page = new Register_Page_Elements(driver_Register_from_boone_first_use_notice);
		 reg_page.wait_untill_page_has_loaded();
	}

	@When("I enter all the details successfully on reg page on boone")
	@Test(priority=4)
	public void i_enter_all_the_details_successfully_on_reg_page_on_boone() throws IOException, InterruptedException {
	
Register_Page_Elements Register_elements = new Register_Page_Elements(driver_Register_from_boone_first_use_notice);
		Register_elements.Registration_Process();
		 Thread.sleep(8000);
	}

	@Then("I am registered as an agate user on boone successfully and I am shown a first use notice")
	@Test(priority=5)
	public void i_am_registered_as_an_agate_user_on_boone_successfully_and_I_am_shown_a_first_use_notice() throws IOException, InterruptedException {
		Thread.sleep(20000);
	    
	    
	    String Register_Elements_Expected_url= "https://www.roanoke-chowannewsherald.com/2019/06/24/miracle-workers/";
	    String Register_Elements_Actual_Url= driver_Register_from_boone_first_use_notice.getCurrentUrl();
	    AssertJUnit.assertEquals(Register_Elements_Expected_url, Register_Elements_Actual_Url);
	    System.out.println("\n"+"details entered successfully"+"\n");
	    System.out.println("\n"+"Successfully navigated to full article"+"\n");
	
	    

		//Verify that the finish notice appears
			Popbitch_Finish_Notice_elements pop_finish = new Popbitch_Finish_Notice_elements(driver_Register_from_boone_first_use_notice);
			Boolean finish_notice_pop = pop_finish.Verify_finish_notice_appears();
			if(finish_notice_pop==true)
			{
				System.out.println("Boone finish notice appears");
			}
			else
			{	
				System.out.println("Please check, boone finish notice does not appear");			
			}
		
		//Click off on finish notice and click on ok
			pop_finish.popbitch_click_on_authy_and_ok();
	    
		
			
		//first verify that wallet has been topped up by £2.00
			
		//Click on the green tab and 
			PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_Register_from_boone_first_use_notice);
			pop_first_use_top_up_from_wallet2.click_on_green_tab();
				
		//get the balance after before first transaction. since we topped up with £2 the balance should be £2
			Thread.sleep(2000);
			Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_Register_from_boone_first_use_notice); 
			String Balance_after_topping_up= wallet_elements_1.current_balance();
			Thread.sleep(1000);
			
		//convert string balances to double
			double balance_after = Double.parseDouble(Balance_after_topping_up);
			double expected_balance = 2.00;
			
		//verify whether the expected balance is the actual balance
			AssertJUnit.assertEquals(expected_balance, balance_after);
			if(balance_after==expected_balance)
			{
				System.out.println("Balance is expected to be "+balance_after );
						
			}
			else
			{
				System.out.println("Alert!! Balance is not expected to be "+balance_after+ "please check, it should be  "+ expected_balance );
			}		
	    
			//Click ok on authorise charge notice
			Thread.sleep(3000);
			Authorise_charge_notice_popbitch authy_popbitch = new Authorise_charge_notice_popbitch(driver_Register_from_boone_first_use_notice);
			authy_popbitch.authorise_charge_notice_click_continue();
			Thread.sleep(3000);

		//Screen shot of article 1
			String timestamp_3 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
			File scrFile_3 = ((TakesScreenshot)driver_Register_from_boone_first_use_notice).getScreenshotAs(OutputType.FILE);		
			FileUtils.copyFile(scrFile_3, new File("/Users/jay/Desktop/boone/"+"_"+timestamp_3+"_"+"jpg" ));
			Thread.sleep(3000);
			
		//check if the wallet is being deducted by 25 p after the first transaction
		//first get the current balance
			String Balance_after_reading_an_article= wallet_elements_1.current_balance();
			
		//convert string balances to double
			double actual_balance_after_reacding_first_article = Double.parseDouble(Balance_after_reading_an_article);
			double expected_balance_being_deducted = 0.20;
			double actual_balance_being_deducted= balance_after-actual_balance_after_reacding_first_article;
			DecimalFormat df = new DecimalFormat("#.##");
			 actual_balance_being_deducted = Double.valueOf(df.format(actual_balance_being_deducted));		
					
		//condition to verify whether the balance is being deducted by 20c after reading the first article 
			AssertJUnit.assertEquals(expected_balance_being_deducted, actual_balance_being_deducted);
			if(actual_balance_being_deducted==expected_balance_being_deducted)
			{
			System.out.println("Balance is expected to be deducted by"+actual_balance_being_deducted );
								
			}
			else
			{
						System.out.println("Alert!! Balance is not expected to be deducted by "+balance_after+ "please check, it should be  "+ expected_balance );
			}		
			
		//scroll for full article
			JavascriptExecutor js = (JavascriptExecutor)driver_Register_from_boone_first_use_notice;
			js.executeScript("window.scrollBy(0,500)");
		
		//Screen shot of article 2
			String timestamp_4 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
			File scrFile_4 = ((TakesScreenshot)driver_Register_from_boone_first_use_notice).getScreenshotAs(OutputType.FILE);		
			FileUtils.copyFile(scrFile_4, new File("/Users/jay/Desktop/boone/"+"_"+timestamp_4+"_"+"jpg" ));
			JavascriptExecutor js1 = (JavascriptExecutor)driver_Register_from_boone_first_use_notice;
			js1.executeScript("window.scrollBy(0,500)");
		
			
		//scroll for full article
			js.executeScript("window.scrollBy(0,500)");
			
		//Screen shot of article 3		
			String timestamp_5 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
			File scrFile_5 = ((TakesScreenshot)driver_Register_from_boone_first_use_notice).getScreenshotAs(OutputType.FILE);		
			FileUtils.copyFile(scrFile_5, new File("/Users/jay/Desktop/boone/"+"_"+timestamp_5+"_"+"jpg" ));

















}
}

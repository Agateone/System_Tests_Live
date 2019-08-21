package Stepdef;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import Elements.Authorise_charge_notice_popbitch;
import Elements.PopbitchFirstUseNoticeElements;
import Elements.Popbitch_Finish_Notice_elements;
import Elements.Popbitch_Wallet_Elements_staging;
import Elements.Register_Page_Elements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Popbitch_register_First_Use_notice {
	
	//Instantiate web driver
	WebDriver Driver_Register_From_Popbitch_Firstuse_Notice;

	//Given I am not a user of Agate I open a browser
	@Given("^I am not a user of Agate I open a browser$")
	@Test(priority=0)
	@Parameters("browser")
	public void i_am_not_a_user_of_Agate_I_open_a_browser(String browser) throws Throwable {	
		if(browser.equalsIgnoreCase("firefox")) {
			Driver_Register_From_Popbitch_Firstuse_Notice = new FirefoxDriver();
		}	
			else if (browser.equalsIgnoreCase("safari")) { 
			Driver_Register_From_Popbitch_Firstuse_Notice= new SafariDriver();
			Driver_Register_From_Popbitch_Firstuse_Notice.manage().window().maximize();
		} 
			else if (browser.equalsIgnoreCase("chrome")) { 
			Driver_Register_From_Popbitch_Firstuse_Notice= new ChromeDriver();
		} 
	}

	//And I navigate to popbitch.com from the browser	
	@Given("^I navigate to popbitch from the browser$")
	@Test(priority=1)
	public void i_navigate_to_popbitch_com_from_the_browser() throws Throwable {		
		//Navigate to the user article
		Driver_Register_From_Popbitch_Firstuse_Notice.get("https://popbitch.com/2019/02/a-doggy-shag-tale/");
		String popbitch_navigation= Driver_Register_From_Popbitch_Firstuse_Notice.getCurrentUrl();
		try
		{
			AssertJUnit.assertTrue(popbitch_navigation.contains("https://popbitch.com/2019/02/a-doggy-shag-tale/"));
		}	catch(AssertionError e0)
		{
			System.out.println("Browser did not open popbitch staging ");
			throw e0;
		}
		System.out.println("Popbitch staging is ready to be tested oo lala ");
		//Scroll by 200px
		JavascriptExecutor js = (JavascriptExecutor)Driver_Register_From_Popbitch_Firstuse_Notice;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);	
		//Screen shot of browser navigated to article
		File scrFile = ((TakesScreenshot)Driver_Register_From_Popbitch_Firstuse_Notice).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		FileUtils.copyFile(scrFile, new File("/Users/jay/Desktop/popbitch/"+"_"+timestamp+"_"+"jpg" ));	
	}

	//Click on create wallet on popbitch first use notice
	@Then("^I click on the create agate wallet from the first use notice$")
	@Test(priority=2)
	public void i_click_on_the_create_agate_wallet_from_the_first_use_notice() throws Throwable {
		//click on create wallet on Popbitch first use notice
		Thread.sleep(2000);
		PopbitchFirstUseNoticeElements pop_first_use_register2 = new PopbitchFirstUseNoticeElements(Driver_Register_From_Popbitch_Firstuse_Notice);
		pop_first_use_register2.Click_On_Popbitch_First_Use_Notice_Create_Wallet();		
		System.out.println("\n"+"Clicked on Create wallet.. Now lets see if this takes us to Sign up page"+"\n");
	}
	
	//Verify that the create wallet button navigates to reg page 1
	@Then("^I verify that the create wallet button navigates me to the sign up page$")
	@Test(priority=3)
	public void i_verify_that_the_create_wallet_button_navigates_me_to_the_sign_up_page() throws Throwable {			
		//screenshot of reg page
		Thread.sleep(8000);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile = ((TakesScreenshot)Driver_Register_From_Popbitch_Firstuse_Notice).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("/Users/jay/Desktop/popbitch/"+"_"+timestamp+"_"+"jpg" ));	
		Thread.sleep(3000);		
		//Scoll to the second half of Reg page
		JavascriptExecutor js = (JavascriptExecutor)Driver_Register_From_Popbitch_Firstuse_Notice;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);		
		//Screen shot of second half of reg page
		String timestamp_2 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());		
		//String screenshot_name_2= "Popbitch_FUN_to_Register_1";
		File scrFile1 = ((TakesScreenshot)Driver_Register_From_Popbitch_Firstuse_Notice).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1, new File("/Users/jay/Desktop/popbitch/"+"_"+timestamp_2+"_"+"jpg" ));
		//wait to check for url untill page has loaded
		Register_Page_Elements Register_elements2 = new Register_Page_Elements(Driver_Register_From_Popbitch_Firstuse_Notice);
		Register_elements2.wait_untill_page_has_loaded();
		Thread.sleep(6000);
		String Register_From_PopBitch_Frist_Use_Notice_Current_Url= Driver_Register_From_Popbitch_Firstuse_Notice.getCurrentUrl();	    
		try
		{	
			AssertJUnit.assertTrue(Register_From_PopBitch_Frist_Use_Notice_Current_Url.contains("https://account.agate.io/my-agate/sign-up?"));
		}catch(AssertionError e)
		{
	
			System.out.println("create wallet does not  navigate to the register page, please check ");
			throw e;
		}	
	    System.out.println("\n"+"Successfully navigated to Signup page"+"\n");	    
	}

	
//Enter details on reg page
	@When("^I enter the correct details and hit the Register button$")
	@Test(priority=4) 
	public void i_enter_the_correct_details_and_hit_the_Register_button() throws Throwable {
		Thread.sleep(5000);
		Register_Page_Elements Register_elements = new Register_Page_Elements(Driver_Register_From_Popbitch_Firstuse_Notice);
	 	Register_elements.Registration_Process();
	}
	
//Verify that the user is navigated to the article
	@Then("^I login successfully$")	
	@Test(priority=5)
	public void i_login_successfully() throws Throwable {
	    Thread.sleep(5000); 
	    String Register_Elements_Expected_url= "https://popbitch.com/2019/02/a-doggy-shag-tale/";
	    String Register_Elements_Actual_Url= Driver_Register_From_Popbitch_Firstuse_Notice.getCurrentUrl();
	    AssertJUnit.assertEquals(Register_Elements_Expected_url, Register_Elements_Actual_Url);
	    System.out.println("\n"+"details entered successfully"+"\n");
	    System.out.println("\n"+"Successfully navigated to the article"+"\n");
	    
	  }
	
//Verify that the finsih notice appears and click on off on finish notice
	@Then("^Finish Notice appears$")
	@Test(priority=6)
	public void finish_Notice_appears() throws Throwable {
		Thread.sleep(5000);
	
	//Screen shot of finish notice
		String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile = ((TakesScreenshot)Driver_Register_From_Popbitch_Firstuse_Notice).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile, new File("/Users/jay/Desktop/popbitch/"+"_"+timestamp+"_"+"jpg" ));
	
	//Verify that the finish notice appears
		Popbitch_Finish_Notice_elements pop_finish = new Popbitch_Finish_Notice_elements(Driver_Register_From_Popbitch_Firstuse_Notice);
		Boolean finish_notice_pop = pop_finish.Verify_finish_notice_appears();
		if(finish_notice_pop==true)
		{
			System.out.println("Popbitch finish notice appears");
		}
		else
		{	
			System.out.println("Please check, Popbitch finish notice does not appear");			
		}
	
	//Click off on finish notice and click on ok
		pop_finish.popbitch_click_on_authy_and_ok();	
	}

	
//Verify teh balance, free point, balance being deducted by, and also that the authorise charge notice appears and click on authorise charge, then verify that the complete article is displayed
	@Then("^all finish notice elements are displayed$")
	@Test(priority=7)
	public void finish_notice_elements_are_displayed() throws Throwable {

	//Screen shot of authorise charge notice
		String timestamp_2 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_2 = ((TakesScreenshot)Driver_Register_From_Popbitch_Firstuse_Notice).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile_2, new File("/Users/jay/Desktop/popbitch/"+"_"+timestamp_2+"_"+"jpg" ));
	
		
	//first verify that wallet has been topped up by £2.00
		
	//Click on the green tab and 
		PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(Driver_Register_From_Popbitch_Firstuse_Notice);
		pop_first_use_top_up_from_wallet2.click_on_green_tab();
			
	//get the balance after before first transaction. since we topped up with £2 the balance should be £2
		Thread.sleep(2000);
		Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(Driver_Register_From_Popbitch_Firstuse_Notice); 
		String Balance_after_topping_up= wallet_elements_1.current_balance();
	
		Thread.sleep(1000);
		
	//convert string balances to double
		double balance_after = Double.parseDouble(Balance_after_topping_up);
		double expected_balance = 10.00;
		
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
		

	//Before reading an article check the free point
		String Freepoint_on_popbitch_Before_reading_first_article= wallet_elements_1.Free_point();
		int Popbitch_actual_initial_free_point = Integer.parseInt(Freepoint_on_popbitch_Before_reading_first_article);	
		int Popbitch_expected_initial_free_point = 50;
		
	//Check if free point initially is 50p
		AssertJUnit.assertEquals(Popbitch_expected_initial_free_point, Popbitch_actual_initial_free_point);
		if(Popbitch_actual_initial_free_point==Popbitch_expected_initial_free_point)
		{
			System.out.println("Popbitch initial free point is "+Popbitch_actual_initial_free_point );
		}
		else
		{
			
			System.out.println("ALERT!!! Popbitch initial free point is NOT "+Popbitch_expected_initial_free_point+ "IT IS " +Popbitch_actual_initial_free_point );
		}
		
		
	//Click ok on authorise charge notice
		Thread.sleep(3000);
		Authorise_charge_notice_popbitch authy_popbitch = new Authorise_charge_notice_popbitch(Driver_Register_From_Popbitch_Firstuse_Notice);
		authy_popbitch.authorise_charge_notice_click_continue();
		Thread.sleep(3000);

	//Screen shot of article 1
		String timestamp_3 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_3 = ((TakesScreenshot)Driver_Register_From_Popbitch_Firstuse_Notice).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile_3, new File("/Users/jay/Desktop/popbitch/"+"_"+timestamp_3+"_"+"jpg" ));
		Thread.sleep(3000);
		
	//check if the wallet is being deducted by 25 p after the first transaction
	//first get the current balance
		String Balance_after_reading_an_article= wallet_elements_1.current_balance();
		
	//convert string balances to double
		double actual_balance_after_reacding_first_article = Double.parseDouble(Balance_after_reading_an_article);
		double expected_balance_being_deducted = 0.25;
		double actual_balance_being_deducted= balance_after-actual_balance_after_reacding_first_article;
				
				
	//condition to verify whether the balance is being deducted by 25p after reading the first article 
		AssertJUnit.assertEquals(expected_balance_being_deducted, actual_balance_being_deducted);
		if(actual_balance_being_deducted==expected_balance_being_deducted)
		{
		System.out.println("Balance is expected to be deducted by"+actual_balance_being_deducted );
							
		}
		else
		{
					System.out.println("Alert!! Balance is not expected to be deducted by "+actual_balance_being_deducted+ "please check, it should be  "+ expected_balance_being_deducted );
		}	
		
		//After reading one article check the free point
				String Freepoint_on_popbitch_After_reading_first_article= wallet_elements_1.Free_point();
				int Popbitch_actual_free_point_after_one_article = Integer.parseInt(Freepoint_on_popbitch_After_reading_first_article);	
				int Popbitch_expected_free_point_after_article_one = 25;
				
			//Check if free point after frist artilce is 25
				AssertJUnit.assertEquals(Popbitch_expected_free_point_after_article_one, Popbitch_actual_free_point_after_one_article);
				if(Popbitch_actual_initial_free_point==Popbitch_expected_initial_free_point)
				{
					System.out.println("Popbitch free point after readig the first article is  "+Popbitch_actual_free_point_after_one_article );
				}
				else
				{
					System.out.println("ALERT!!! Popbitch free point after readig the first article should NOT be "+Popbitch_expected_free_point_after_article_one+ "IT IS " +Popbitch_actual_free_point_after_one_article );
				}
				
		
	//scroll for full article
		JavascriptExecutor js = (JavascriptExecutor)Driver_Register_From_Popbitch_Firstuse_Notice;
		js.executeScript("window.scrollBy(0,500)");
	
	//Screen shot of article 2
		String timestamp_4 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_4 = ((TakesScreenshot)Driver_Register_From_Popbitch_Firstuse_Notice).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile_4, new File("/Users/jay/Desktop/popbitch/"+"_"+timestamp_4+"_"+"jpg" ));
		JavascriptExecutor js1 = (JavascriptExecutor)Driver_Register_From_Popbitch_Firstuse_Notice;
		js1.executeScript("window.scrollBy(0,500)");
	
		
	//scroll for full article
		js.executeScript("window.scrollBy(0,500)");
		
	//Screen shot of article 3		
		String timestamp_5 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_5 = ((TakesScreenshot)Driver_Register_From_Popbitch_Firstuse_Notice).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile_5, new File("/Users/jay/Desktop/popbitch/"+"_"+timestamp_5+"_"+"jpg" ));

		
	
	}

	
	
	
	
	
}

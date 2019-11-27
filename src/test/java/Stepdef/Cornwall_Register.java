package Stepdef;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Elements.Authorise_charge_notice_popbitch;
import Elements.Cornwall_Reports_First_Use_Notice;
import Elements.PopbitchFirstUseNoticeElements;
import Elements.Popbitch_Finish_Notice_elements;
import Elements.Popbitch_Wallet_Elements_staging;
import Elements.Register_Page_Elements;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Cornwall_Register {

	//Instantiate webdriver
	WebDriver driver_Register_from_Cornwall_first_use_notice;
	
	
	@Test(priority=0)
	@Parameters("browser")
	@Given("I am not a user of agate on cornwall and I open a browser")
	public void i_am_not_a_user_of_agate_on_cornwall_and_I_open_a_browser(String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
			driver_Register_from_Cornwall_first_use_notice = new FirefoxDriver();
			
		}else if (browser.equalsIgnoreCase("safari")) { 
			driver_Register_from_Cornwall_first_use_notice= new SafariDriver();
			driver_Register_from_Cornwall_first_use_notice.manage().window().maximize();
		} 
		else if (browser.equalsIgnoreCase("chrome")) { 
			driver_Register_from_Cornwall_first_use_notice= new ChromeDriver();
		} 
	}

	@Given("I navigate to a premium article on cornwall")
	@Test(priority=1)
	public void i_navigate_to_a_premium_article_on_cornwall() throws InterruptedException {
		driver_Register_from_Cornwall_first_use_notice.get("https://cornwallreports.co.uk/cruel-december-radio-cornwall-back-in-the-doldrums-as-audience-figures-surrender-to-gravity/");
		Thread.sleep(10000);
		String reaction_navigation= driver_Register_from_Cornwall_first_use_notice.getCurrentUrl();
	    try
		{
	    	AssertJUnit.assertTrue(reaction_navigation.contains("https://cornwallreports.co.uk/cruel-december-radio-cornwall-back-in-the-doldrums-as-audience-figures-surrender-to-gravity/"));
		}catch(AssertionError e0)
		{
			System.out.println("Browser did not open Cornwall Reports ");
			throw e0;
		}
	    System.out.println("Cornwall Reports is ready for testing");
	}

	@Given("I click on the create wallet button of reaction first use notice cornwall")
	@Test(priority=2)
	public void i_click_on_the_create_wallet_button_of_reaction_first_use_notice_cornwall() throws IOException, InterruptedException {
		Thread.sleep(6000);
		//Scroll by 200px
		JavascriptExecutor js = (JavascriptExecutor)driver_Register_from_Cornwall_first_use_notice;
		js.executeScript("window.scrollBy(0,50)");
		Thread.sleep(1500);
	

		
		
		
		driver_Register_from_Cornwall_first_use_notice.findElement(By.xpath("/html/body/div[1]/button")).click();
		Thread.sleep(30000);
	
		
		//Screen shot of browser navigated to article
				File scrFile1 = ((TakesScreenshot)driver_Register_from_Cornwall_first_use_notice).getScreenshotAs(OutputType.FILE);
				String timestamp1 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				FileUtils.copyFile(scrFile1, new File("/Users/jay/Desktop/api/"+"_"+timestamp1+"_"+"jpg" ));	
				Thread.sleep(15000);
		
		Cornwall_Reports_First_Use_Notice Cornwall_First_Use_Notice = new Cornwall_Reports_First_Use_Notice(driver_Register_from_Cornwall_first_use_notice);
		
		Cornwall_First_Use_Notice.Click_On_Cornwall_First_Use_CreateWallet();
		
		 
		System.out.println("\n"+"Clicked on Create wallet.. Now lets see if this takes us to Sign up page"+"\n");
	   
	}

	@Given("I verify that the create wallet button on reaction first use notice takes me to the reg page on cornwall")
	@Test(priority=3)
	public void i_verify_that_the_create_wallet_button_on_reaction_first_use_notice_takes_me_to_the_reg_page_on_cornwall() throws InterruptedException {
		Thread.sleep(10000);
		 Register_Page_Elements reg_page = new Register_Page_Elements(driver_Register_from_Cornwall_first_use_notice);
		 reg_page.wait_untill_page_has_loaded();
	}

	@When("I enter all the details successfully on the reg page on cornwall")
	@Test(priority=4)
	public void i_enter_all_the_details_successfully_on_the_reg_page_on_cornwall() throws InterruptedException, IOException {
		Thread.sleep(8000);
		Register_Page_Elements Register_elements = new Register_Page_Elements(driver_Register_from_Cornwall_first_use_notice);
	 		Register_elements.Registration_Process();
	 		 Thread.sleep(8000);
	}

	@Then("I am registered as an agate user on cornwall successfully and I am shown a first use notice")
	@Test(priority=5)
	public void i_am_registered_as_an_agate_user_on_cornwall_successfully_and_I_am_shown_a_first_use_notice() throws IOException, InterruptedException {
		Thread.sleep(20000);
	    String Register_Elements_Expected_url= "https://cornwallreports.co.uk/cruel-december-radio-cornwall-back-in-the-doldrums-as-audience-figures-surrender-to-gravity/";
	    String Register_Elements_Actual_Url= driver_Register_from_Cornwall_first_use_notice.getCurrentUrl();
	    AssertJUnit.assertEquals(Register_Elements_Expected_url, Register_Elements_Actual_Url);
	    System.out.println("\n"+"details entered successfully"+"\n");
	    System.out.println("\n"+"Successfully navigated to full article"+"\n");
	    
	  //Screen shot of finish notice
	  		String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
	  		File scrFile = ((TakesScreenshot)driver_Register_from_Cornwall_first_use_notice).getScreenshotAs(OutputType.FILE);		
	  		FileUtils.copyFile(scrFile, new File("/Users/jay/Desktop/api/"+"_"+timestamp+"_"+"jpg" ));
	  	
	  //Verify that the finish notice appears
	  		Popbitch_Finish_Notice_elements pop_finish = new Popbitch_Finish_Notice_elements(driver_Register_from_Cornwall_first_use_notice);
	  		Boolean finish_notice_pop = pop_finish.Verify_finish_notice_appears();
	  		if(finish_notice_pop==true)
	  		{
	  			System.out.println("reaction finish notice appears");
	  		}
	  		else
	  		{	
	  			System.out.println("Please check, reaction finish notice does not appear");			
	  		}
	  	
	  		
/*//first verify that wallet has been topped up by £2.00
			
			//Click on the green tab and 
				PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_Register_from_reaction_first_use_notice);
				pop_first_use_top_up_from_wallet2.click_on_green_tab();
					
			//get the balance after before first transaction. since we topped up with £2 the balance should be £2
				Thread.sleep(2000);
				Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_Register_from_reaction_first_use_notice); 
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
			
	  		
	  	
	  
	    
	    
	//Verify the balance, free point, balance being deducted by, and also that the authorise charge notice appears and click on authorise charge, then verify that the complete article is displayed
*/
	  		
	  		
	  		//Click off on finish notice and click on ok
	  		pop_finish.popbitch_click_on_authy_and_ok();
	  		double balance_after = 10.00;
	  		
	  		//Screen shot of authorise charge notice
			String timestamp_2 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
			File scrFile_2 = ((TakesScreenshot)driver_Register_from_Cornwall_first_use_notice).getScreenshotAs(OutputType.FILE);		
			FileUtils.copyFile(scrFile_2, new File("/Users/jay/Desktop/api/"+"_"+timestamp_2+"_"+"jpg" ));
		
		
			
			//scroll for full article
			JavascriptExecutor js0 = (JavascriptExecutor)driver_Register_from_Cornwall_first_use_notice;
			js0.executeScript("window.scrollBy(0,800)");
			
			
		
			//Click ok on authorise charge notice
			Thread.sleep(10000);
			//Boolean authy= driver_Register_from_reaction_first_use_notice.findElement(By.xpath("//*[@id=\"agate_payNow\"]/span[3]")).isDisplayed();
			//System.out.println(authy);
			
			
			
			
			driver_Register_from_Cornwall_first_use_notice.findElement(By.xpath("/html/body/div[1]/button")).click();
			
			js0.executeScript("window.scrollBy(0,150)");
			
			
			
			Thread.sleep(5000);
			Authorise_charge_notice_popbitch authy_popbitch = new Authorise_charge_notice_popbitch(driver_Register_from_Cornwall_first_use_notice);
			authy_popbitch.authorise_charge_notice_click_continue();
			Thread.sleep(3000);

			//Screen shot of authorise charge notice
			String timestamp_12 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
			File scrFile_12 = ((TakesScreenshot)driver_Register_from_Cornwall_first_use_notice).getScreenshotAs(OutputType.FILE);		
			FileUtils.copyFile(scrFile_12, new File("/Users/jay/Desktop/api/"+"_"+timestamp_12+"_"+"jpg" ));
			
			
			//Click on the green tab and 
			PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_Register_from_Cornwall_first_use_notice);
			pop_first_use_top_up_from_wallet2.click_on_green_tab();
			
			
		//Screen shot of article 1
			String timestamp_3 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
			File scrFile_3 = ((TakesScreenshot)driver_Register_from_Cornwall_first_use_notice).getScreenshotAs(OutputType.FILE);		
			FileUtils.copyFile(scrFile_3, new File("/Users/jay/Desktop/api/"+"_"+timestamp_3+"_"+"jpg" ));
			Thread.sleep(3000);
			
		//check if the wallet is being deducted by 25 p after the first transaction
		//first get the current balance
			Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_Register_from_Cornwall_first_use_notice);
			String Balance_after_reading_an_article= wallet_elements_1.current_balance();
			
		//convert string balances to double
			double actual_balance_after_reacding_first_article = Double.parseDouble(Balance_after_reading_an_article);
			double expected_balance_being_deducted = 0.20;
			double actual_balance_being_deducted= balance_after-actual_balance_after_reacding_first_article;
				
					 DecimalFormat df = new DecimalFormat("#.##");
					 actual_balance_being_deducted = Double.valueOf(df.format(actual_balance_being_deducted));
					 
					 
					 
		//condition to verify whether the balance is being deducted by 25p after reading the first article 
			AssertJUnit.assertEquals(expected_balance_being_deducted, actual_balance_being_deducted);
			if(actual_balance_being_deducted==expected_balance_being_deducted)
			{
			System.out.println("Balance is expected to be deducted by"+actual_balance_after_reacding_first_article );
								
			}
			else
			{
						System.out.println("Alert!! Balance is not expected to be deducted by "+actual_balance_after_reacding_first_article+ "please check, it should be  "+ expected_balance_being_deducted );
			}		
			
		//scroll for full article
			JavascriptExecutor js = (JavascriptExecutor)driver_Register_from_Cornwall_first_use_notice;
			js.executeScript("window.scrollBy(0,500)");
		
		//Screen shot of article 2
			String timestamp_4 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
			File scrFile_4 = ((TakesScreenshot)driver_Register_from_Cornwall_first_use_notice).getScreenshotAs(OutputType.FILE);		
			FileUtils.copyFile(scrFile_4, new File("/Users/jay/Desktop/api/"+"_"+timestamp_4+"_"+"jpg" ));
			JavascriptExecutor js1 = (JavascriptExecutor)driver_Register_from_Cornwall_first_use_notice;
			js1.executeScript("window.scrollBy(0,500)");
		
			
		//scroll for full article
			js.executeScript("window.scrollBy(0,500)");
			
		//Screen shot of article 3		
			String timestamp_5 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
			File scrFile_5 = ((TakesScreenshot)driver_Register_from_Cornwall_first_use_notice).getScreenshotAs(OutputType.FILE);		
			FileUtils.copyFile(scrFile_5, new File("/Users/jay/Desktop/api/"+"_"+timestamp_5+"_"+"jpg" ));
	  		
	  		
			driver_Register_from_Cornwall_first_use_notice.quit();
	  		
	  		
	  		
	  		
	  		
	  		
	  		
	  		
	  		
	  		
	  		
	  		
	}












































}

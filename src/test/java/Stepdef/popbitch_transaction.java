package Stepdef;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.io.IOException;
//import java.text.DecimalFormat;
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
import Elements.Login_Page_Elements;
import Elements.Authorise_charge_notice_popbitch;
import Elements.New_Pub_Notice;
import Elements.PopbitchFirstUseNoticeElements;
import Elements.Popbitch_Wallet_Elements_staging;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class popbitch_transaction {
	WebDriver driver_transaction_staging_popbitch;
	double expected_balance_global;
	double expected_balance;
	
	@Given("^I am a registered Agate User and I login in to popbitch staging with username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	@Test(priority=23)
	@Parameters("browser")
	public void i_am_a_registered_Agate_User_and_I_login_in_to_popbitch_staging_with_username_as_and_password_as(String browser) throws Throwable {
		if(browser.equalsIgnoreCase("firefox")) {
			driver_transaction_staging_popbitch = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("safari")) { 

			driver_transaction_staging_popbitch= new SafariDriver();
		} 

		else if (browser.equalsIgnoreCase("chrome")) { 
			driver_transaction_staging_popbitch= new ChromeDriver();
		} 
		
		
		System.out.println("\n"+"POPBITCH TRANSACTION"+"\n");
		System.out.println("\n"+""+"\n");
	
		driver_transaction_staging_popbitch.get("https://popbitch.com/2019/02/tat-for-tits/");
		Thread.sleep(3000);
		String popbitch_navigation= driver_transaction_staging_popbitch.getCurrentUrl();
	    try
		{
	    	AssertJUnit.assertTrue(popbitch_navigation.contains("https://popbitch.com/2019/02/tat-for-tits/"));
		}catch(AssertionError e0)
		{
			System.out.println("Browser did not open popbitch staging ");
			throw e0;
		}
	    System.out.println("Popbitch staging is ready to be tested");
		
	
		Thread.sleep(4000);
		PopbitchFirstUseNoticeElements pop_first_use = new PopbitchFirstUseNoticeElements(driver_transaction_staging_popbitch);
		pop_first_use.Click_On_Popbitch_First_Use_Notice_Login();
		System.out.println("\n"+"Clicked on login"+"\n");
	
		Thread.sleep(8000);
		
		Thread.sleep(2000);
		String Login_From_PopBitch_Frist_Use_Notice_Current_Url= driver_transaction_staging_popbitch.getCurrentUrl();
	    System.out.println("\n"+"Clicking on login redirected to login page satging"+"\n");
	    assertTrue(Login_From_PopBitch_Frist_Use_Notice_Current_Url.contains("https://account.agate.io/my-agate/sign-in?"));
	    System.out.println("\n"+"Successfully navigated to login page"+"\n");
	
	
	    Login_Page_Elements Login_Pop_First_Use = new Login_Page_Elements(driver_transaction_staging_popbitch);
		Thread.sleep(2000);
		Login_Pop_First_Use.Login_Process("Ajjukanna1$$");
		Thread.sleep(10000);
		
		System.out.println("\n"+"Login successfull"+"\n");
	
	
	
	
	}
	
	@When("^I read a premium article$")
	@Test(priority=24)
	public void i_read_a_premium_article() throws Throwable {
		
	//Navigate to a third article which is supposed to be free
		driver_transaction_staging_popbitch.navigate().to("https://popbitch.com/2019/02/love-letters/");
		Thread.sleep(4000);	
		
	
		
	//Click on the green tab and 
		PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_staging_popbitch);
		pop_first_use_top_up_from_wallet2.click_on_green_tab();
	
	//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
		Thread.sleep(2000);
		Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_staging_popbitch); 
		String Balance_after_reading_an_article= wallet_elements_1.current_balance();
		Thread.sleep(1000);
	//convert string balances to double
		double balance_after = Double.parseDouble(Balance_after_reading_an_article);
		expected_balance = 9.50;
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
	//DecimalFormat df = new DecimalFormat("#.###");
		expected_balance_global= balance_after;	
	}
	


	@Then("^the wallet balance and free point are deducted by x amount")
	@Test(priority=25)
	public void the_wallet_balance_and_free_point_are_deducted_by_p() throws Throwable {
		
	//GET FREE POINT AFTER THE TWO TRANSACTIONS
		Thread.sleep(2000);
		
		
		
		
			
			
	
	
	
		
		
	
	
	}

	
	@Then("^The New European wallet balance is updated , same as popbitch and free point remains uneffected$")
	@Test(priority=26)
	public void the_New_European_wallet_balance_is_updated_same_as_popbitch_and_free_point_remains_uneffected() throws Throwable {
		
		
		
	}

	@Then("^Reactions wallet balance is updated and free point remains uneffected$")
	@Test(priority=27)
	public void reactions_wallet_balance_is_updated_and_free_point_remains_uneffected() throws Throwable {

		driver_transaction_staging_popbitch.navigate().to("https://reaction.life/independent-groups-new-politics-isnt-new/");
	
		//Click on the green tab and 
		PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_staging_popbitch);
		pop_first_use_top_up_from_wallet2.click_on_green_tab();
		
		
		
			
		//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
		Thread.sleep(2000);
		Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_staging_popbitch); 
		String Balance_after_reading_an_article= wallet_elements_1.current_balance();
		Thread.sleep(1000);

		//convert string balances to double
		double balance_after = Double.parseDouble(Balance_after_reading_an_article);
		expected_balance = 9.50;

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
		
		//DecimalFormat df = new DecimalFormat("#.###");
				expected_balance_global= balance_after;	

		System.out.println("\n"+"wallet balance on reaction is "+balance_after+"\n");
		Thread.sleep(5000);
		Boolean enab =driver_transaction_staging_popbitch.findElement(By.id("CybotCookiebotDialogBodyButtonAccept")).isDisplayed();
		if(enab== true )
		{
			
			driver_transaction_staging_popbitch.findElement(By.id("CybotCookiebotDialogBodyButtonAccept")).click();	
			
			
		}
		
		
		//click ok on New pub notice charge notice
				Thread.sleep(10000);
				New_Pub_Notice New_pub = new New_Pub_Notice(driver_transaction_staging_popbitch);
				New_pub.Newpub_charge_off();
				Thread.sleep(3000);
				New_pub.authorise_charge_notice_click_continue();
				
				
		//click ok on Authorise charge notice
				Thread.sleep(5000);
				Authorise_charge_notice_popbitch authy2 = new Authorise_charge_notice_popbitch(driver_transaction_staging_popbitch);
				authy2.authorise_charge_notice_click_continue();
				Thread.sleep(3000);
				
				
				
				JavascriptExecutor js = (JavascriptExecutor)driver_transaction_staging_popbitch;
				js.executeScript("window.scrollBy(0,500)");
				
			
				Thread.sleep(3000);		
				JavascriptExecutor js1 = (JavascriptExecutor)driver_transaction_staging_popbitch;
				js1.executeScript("window.scrollBy(0,500)");		
			
				
				
			//Verify the user landed on the same article
				String Login_From_PopBitch_Frist_Use_Notice_Current_Url1= driver_transaction_staging_popbitch.getCurrentUrl();	   
			    String Login_From_PopBitch_Frist_Use_Notice_Popbitch_Login_Url1 = "https://reaction.life/independent-groups-new-politics-isnt-new/";
			    AssertJUnit.assertEquals(Login_From_PopBitch_Frist_Use_Notice_Current_Url1, Login_From_PopBitch_Frist_Use_Notice_Popbitch_Login_Url1);
			    System.out.println("\n"+"User presented with complete article"+"\n");
			    Thread.sleep(3000);
				
			    
			  //Click on the green tab and 
				pop_first_use_top_up_from_wallet2.click_on_green_tab();
				
				
			
					
			//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
				Thread.sleep(2000);
				
				String Balance_after_reading_an_article_as_a_new_pub= wallet_elements_1.current_balance();
				Thread.sleep(1000);
			//convert string balances to double
				double Balance_after_reading_an_article_as_a_new_pub_parsed = Double.parseDouble(Balance_after_reading_an_article_as_a_new_pub);
				double expected_balance_after_new_pub = 9.20;
			//verify whether the expected balance is the actual balance
				AssertJUnit.assertEquals(expected_balance_after_new_pub, Balance_after_reading_an_article_as_a_new_pub_parsed);
				if(Balance_after_reading_an_article_as_a_new_pub_parsed==Balance_after_reading_an_article_as_a_new_pub_parsed)
				{
					System.out.println("Balance is expected to be "+Balance_after_reading_an_article_as_a_new_pub_parsed );
							
				}
				else
				{
					System.out.println("Alert!! Balance is not expected to be "+Balance_after_reading_an_article_as_a_new_pub_parsed+ "please check, it should be  "+ expected_balance );
				}	
			//DecimalFormat df = new DecimalFormat("#.###");
						expected_balance_global= Balance_after_reading_an_article_as_a_new_pub_parsed;	
				
				
	}

	@Then("^Cornwall reports wallet balance is updated and free point remains uneffected$")
	@Test(priority=28)
	public void Cornwall_wallet_balance_is_updated_and_free_point_remains_uneffected() throws Throwable {
		
		driver_transaction_staging_popbitch.navigate().to("https://cornwallreports.co.uk/cruel-december-radio-cornwall-back-in-the-doldrums-as-audience-figures-surrender-to-gravity/");
		//Click on the green tab and 
			PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_staging_popbitch);
			pop_first_use_top_up_from_wallet2.click_on_green_tab();
		
		
				
		//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
			Thread.sleep(2000);
			Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_staging_popbitch); 
			String Balance_after_reading_an_article= wallet_elements_1.current_balance();
			Thread.sleep(1000);
		//convert string balances to double
			double balance_after = Double.parseDouble(Balance_after_reading_an_article);
			expected_balance = 9.20;
		//verify whether the expected balance is the actual balance
			AssertJUnit.assertEquals(expected_balance,balance_after);
			if(balance_after==expected_balance)
			{
				System.out.println("Balance is expected to be "+balance_after );
						
			}
			else
			{
				System.out.println("Alert!! Balance is not expected to be "+balance_after+ "please check, it should be  "+ expected_balance );
			}	
		//DecimalFormat df = new DecimalFormat("#.###");
					expected_balance_global= balance_after;	
					
					pop_first_use_top_up_from_wallet2.click_on_green_tab();
					
			
			
			
			System.out.println("\n"+"wallet balance on reaction is "+balance_after+"\n");
			//System.out.println("\n"+"free point on reaction is £1.20"+"\n");
			
			

			driver_transaction_staging_popbitch.findElement(By.xpath("/html/body/div[1]/button")).click();
			Thread.sleep(30000);
		
		
			//click ok on New pub notice charge notice
			Thread.sleep(10000);
			New_Pub_Notice New_pub = new New_Pub_Notice(driver_transaction_staging_popbitch);
			New_pub.Newpub_charge_off();
			Thread.sleep(3000);
			New_pub.authorise_charge_notice_click_continue();
			
			
	//click ok on Authorise charge notice
			Thread.sleep(5000);
			Authorise_charge_notice_popbitch authy2 = new Authorise_charge_notice_popbitch(driver_transaction_staging_popbitch);
			authy2.authorise_charge_notice_click_continue();
			Thread.sleep(3000);
			
		
			JavascriptExecutor js = (JavascriptExecutor)driver_transaction_staging_popbitch;
			js.executeScript("window.scrollBy(0,500)");
			
			
			Thread.sleep(3000);		
			JavascriptExecutor js1 = (JavascriptExecutor)driver_transaction_staging_popbitch;
			js1.executeScript("window.scrollBy(0,500)");		
			
			
		//Verify the user landed on the same article
			String Login_From_PopBitch_Frist_Use_Notice_Current_Url1= driver_transaction_staging_popbitch.getCurrentUrl();	   
		    String Login_From_PopBitch_Frist_Use_Notice_Popbitch_Login_Url1 = "https://cornwallreports.co.uk/cruel-december-radio-cornwall-back-in-the-doldrums-as-audience-figures-surrender-to-gravity/";
		    AssertJUnit.assertEquals(Login_From_PopBitch_Frist_Use_Notice_Current_Url1, Login_From_PopBitch_Frist_Use_Notice_Popbitch_Login_Url1);
		    System.out.println("\n"+"User presented with complete article"+"\n");
		    Thread.sleep(3000);
			
		    
		  //Click on the green tab and 
			pop_first_use_top_up_from_wallet2.click_on_green_tab();
			
			
		
		//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
			Thread.sleep(2000);
			
			String Balance_after_reading_an_article_as_a_new_pub= wallet_elements_1.current_balance();
			Thread.sleep(1000);
		//convert string balances to double
			double Balance_after_reading_an_article_as_a_new_pub_parsed = Double.parseDouble(Balance_after_reading_an_article_as_a_new_pub);
			double expected_balance_after_new_pub = 9.00;
		//verify whether the expected balance is the actual balance
			AssertJUnit.assertEquals(expected_balance_after_new_pub, Balance_after_reading_an_article_as_a_new_pub_parsed);
			if(Balance_after_reading_an_article_as_a_new_pub_parsed==Balance_after_reading_an_article_as_a_new_pub_parsed)
			{
				System.out.println("Balance is expected to be "+Balance_after_reading_an_article_as_a_new_pub_parsed );
						
			}
			else
			{
				System.out.println("Alert!! Balance is not expected to be "+Balance_after_reading_an_article_as_a_new_pub_parsed+ "please check, it should be  "+ expected_balance );
			}	
		//DecimalFormat df = new DecimalFormat("#.###");
					expected_balance_global= Balance_after_reading_an_article_as_a_new_pub_parsed;	
		
		
		
		
		
		
		
	
	}

	@Then("^cricketer wallet balance remains and is uneffected$")
	@Test(priority=29)
	public void cricketer_wallet_balance_remains_and_is_uneffected() throws Throwable {
		
		driver_transaction_staging_popbitch.navigate().to("https://www.thecricketer.com/Topics/premimum_features/englishman_in_antigua_johnny_grave_is_in_charge_of_west_indies_cricket_trying_to_lead_a_renaissance_and_beating_joe_roots_men_did_no_harm.html");
		//Click on the green tab and 
			PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_staging_popbitch);
			pop_first_use_top_up_from_wallet2.click_on_green_tab();
		
		
				
		//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
			Thread.sleep(2000);
			Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_staging_popbitch); 
			String Balance_after_reading_an_article= wallet_elements_1.current_balance();
			Thread.sleep(1000);
		//convert string balances to double
			double balance_after = Double.parseDouble(Balance_after_reading_an_article);
			expected_balance = 9.00;
		//verify whether the expected balance is the actual balance
			AssertJUnit.assertEquals(expected_balance,balance_after);
			if(balance_after==expected_balance)
			{
				System.out.println("Balance is expected to be "+balance_after );
						
			}
			else
			{
				System.out.println("Alert!! Balance is not expected to be "+balance_after+ "please check, it should be  "+ expected_balance );
			}	
		//DecimalFormat df = new DecimalFormat("#.###");
					expected_balance_global= balance_after;	
					
			
					//click ok on New pub notice charge notice
					Thread.sleep(10000);
					New_Pub_Notice New_pub = new New_Pub_Notice(driver_transaction_staging_popbitch);
					New_pub.Newpub_charge_off();
					Thread.sleep(3000);
					New_pub.authorise_charge_notice_click_continue();
					
					
			//click ok on Authorise charge notice
					Thread.sleep(5000);
					Authorise_charge_notice_popbitch authy2 = new Authorise_charge_notice_popbitch(driver_transaction_staging_popbitch);
					authy2.authorise_charge_notice_click_continue();
					Thread.sleep(3000);
					
					
					
					JavascriptExecutor js = (JavascriptExecutor)driver_transaction_staging_popbitch;
					js.executeScript("window.scrollBy(0,500)");
					
					
					JavascriptExecutor js1 = (JavascriptExecutor)driver_transaction_staging_popbitch;
					js1.executeScript("window.scrollBy(0,500)");		
					
					
				//Verify the user landed on the same article
					String Login_From_PopBitch_Frist_Use_Notice_Current_Url1= driver_transaction_staging_popbitch.getCurrentUrl();	   
				    String Login_From_PopBitch_Frist_Use_Notice_Popbitch_Login_Url1 = "https://www.thecricketer.com/Topics/premimum_features/englishman_in_antigua_johnny_grave_is_in_charge_of_west_indies_cricket_trying_to_lead_a_renaissance_and_beating_joe_roots_men_did_no_harm.html";
				    AssertJUnit.assertEquals(Login_From_PopBitch_Frist_Use_Notice_Current_Url1, Login_From_PopBitch_Frist_Use_Notice_Popbitch_Login_Url1);
				    System.out.println("\n"+"User presented with complete article"+"\n");
				    Thread.sleep(3000);
					
				    
				  //Click on the green tab and 
					pop_first_use_top_up_from_wallet2.click_on_green_tab();
					
					
			
						
				//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
					Thread.sleep(2000);
					
					String Balance_after_reading_an_article_as_a_new_pub= wallet_elements_1.current_balance();
					Thread.sleep(1000);
				//convert string balances to double
					double Balance_after_reading_an_article_as_a_new_pub_parsed = Double.parseDouble(Balance_after_reading_an_article_as_a_new_pub);
					double expected_balance_after_new_pub = 8.70;
				//verify whether the expected balance is the actual balance
					AssertJUnit.assertEquals(expected_balance_after_new_pub, Balance_after_reading_an_article_as_a_new_pub_parsed);
					if(Balance_after_reading_an_article_as_a_new_pub_parsed==Balance_after_reading_an_article_as_a_new_pub_parsed)
					{
						System.out.println("Balance is expected to be "+Balance_after_reading_an_article_as_a_new_pub_parsed );
								
					}
					else
					{
						System.out.println("Alert!! Balance is not expected to be "+Balance_after_reading_an_article_as_a_new_pub_parsed+ "please check, it should be  "+ expected_balance );
					}	
				//DecimalFormat df = new DecimalFormat("#.###");
							expected_balance_global= Balance_after_reading_an_article_as_a_new_pub_parsed;	
	}

	
	
	
	
	
	@Test(priority=30)
	@When("Maidenhead wallet balance remains and is uneffected by popbitch")
	public void slough_wallet_balance_remains_and_is_uneffected_by_popbitch() throws InterruptedException, IOException {
		driver_transaction_staging_popbitch.navigate().to("https://www.maidenhead-advertiser.co.uk/news/remember-when/144177/remember-when-when-mary-had-a-little-lamb-and-the-outdoor-pool-closed-for-good.html");
		Thread.sleep(4000);
		//Click on the green tab and 
			PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_staging_popbitch);
			pop_first_use_top_up_from_wallet2.click_on_green_tab();
			
			
		//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
			Thread.sleep(2000);
			Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_staging_popbitch); 
			String Balance_after_reading_an_article= wallet_elements_1.current_balance();
			Thread.sleep(1000);
		//convert string balances to double
			double balance_after = Double.parseDouble(Balance_after_reading_an_article);
			expected_balance = 8.70;
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
		//DecimalFormat df = new DecimalFormat("#.###");
					expected_balance_global= balance_after;	
					
			
					//click ok on New pub notice charge notice
					Thread.sleep(10000);
					New_Pub_Notice New_pub = new New_Pub_Notice(driver_transaction_staging_popbitch);
					New_pub.Newpub_charge_off();
					Thread.sleep(3000);
					New_pub.authorise_charge_notice_click_continue();
					
					
			//click ok on Authorise charge notice
					Thread.sleep(5000);
					Authorise_charge_notice_popbitch authy2 = new Authorise_charge_notice_popbitch(driver_transaction_staging_popbitch);
					authy2.authorise_charge_notice_click_continue();
					Thread.sleep(3000);
					
					
					
					JavascriptExecutor js = (JavascriptExecutor)driver_transaction_staging_popbitch;
					js.executeScript("window.scrollBy(0,500)");
					
			
					Thread.sleep(3000);		
					JavascriptExecutor js1 = (JavascriptExecutor)driver_transaction_staging_popbitch;
					js1.executeScript("window.scrollBy(0,500)");		
					
					Thread.sleep(1000);
					
				
				    
				  //Click on the green tab and 
					pop_first_use_top_up_from_wallet2.click_on_green_tab();
					
					
				
						
				//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
					Thread.sleep(2000);
					
					String Balance_after_reading_an_article_as_a_new_pub= wallet_elements_1.current_balance();
					Thread.sleep(1000);
				//convert string balances to double
					double Balance_after_reading_an_article_as_a_new_pub_parsed = Double.parseDouble(Balance_after_reading_an_article_as_a_new_pub);
					double expected_balance_after_new_pub = 8.50;
				//verify whether the expected balance is the actual balance
					AssertJUnit.assertEquals(expected_balance_after_new_pub, Balance_after_reading_an_article_as_a_new_pub_parsed);
					if(Balance_after_reading_an_article_as_a_new_pub_parsed==Balance_after_reading_an_article_as_a_new_pub_parsed)
					{
						System.out.println("Balance is expected to be "+Balance_after_reading_an_article_as_a_new_pub_parsed );
								
					}
					else
					{
						System.out.println("Alert!! Balance is not expected to be "+Balance_after_reading_an_article_as_a_new_pub_parsed+ "please check, it should be  "+ expected_balance );
					}	
				//DecimalFormat df = new DecimalFormat("#.###");
							expected_balance_global= Balance_after_reading_an_article_as_a_new_pub_parsed;	
	}
	
	
	
/*	@Test(priority=31)
	@When("Slough wallet balance remains and is uneffected by Maiadenhead")
	public void slough_wallet_balance_remains_and_is_uneffected_by_Maiadenhead() throws InterruptedException, IOException {
		driver_transaction_staging_popbitch.navigate().to("https://www.sloughexpress.co.uk/news/remember-when/144177/remember-when-when-mary-had-a-little-lamb-and-the-outdoor-pool-closed-for-good.html");
		Thread.sleep(4000);
		//Click on the green tab and 
			PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_staging_popbitch);
			pop_first_use_top_up_from_wallet2.click_on_green_tab();
			
			//get screen shot of the wallet
			File scrFile6 = ((TakesScreenshot)driver_transaction_staging_popbitch).getScreenshotAs(OutputType.FILE);
			String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
			FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp6+"_"+"jpg" ));
				
		//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
			Thread.sleep(2000);
			Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_staging_popbitch); 
			String Balance_after_reading_an_article= wallet_elements_1.current_balance();
			Thread.sleep(1000);
		//convert string balances to double
			double balance_after = Double.parseDouble(Balance_after_reading_an_article);
			expected_balance = 8.50;
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
		//DecimalFormat df = new DecimalFormat("#.###");
					expected_balance_global= balance_after;	
					
			

					//click ok on New pub notice charge notice
					Thread.sleep(10000);
					New_Pub_Notice New_pub = new New_Pub_Notice(driver_transaction_staging_popbitch);
					New_pub.Newpub_charge_off();
					Thread.sleep(3000);
					New_pub.authorise_charge_notice_click_continue();
					
					
			//click ok on Authorise charge notice
					Thread.sleep(5000);
					Authorise_charge_notice_popbitch authy2 = new Authorise_charge_notice_popbitch(driver_transaction_staging_popbitch);
					authy2.authorise_charge_notice_click_continue();
					Thread.sleep(3000);
					
					
					//String screenshot_name_3= "Popbitch_full_article_appears";
					String timestamp_3 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
					File scrFile_3 = ((TakesScreenshot)driver_transaction_staging_popbitch).getScreenshotAs(OutputType.FILE);		
					FileUtils.copyFile(scrFile_3, new File("/Users/jay/Desktop/popbitch/"+"_"+timestamp_3+"_"+"jpg" ));
					Thread.sleep(3000);
					JavascriptExecutor js = (JavascriptExecutor)driver_transaction_staging_popbitch;
					js.executeScript("window.scrollBy(0,500)");
					
				//String screenshot_name_4= "Popbitch_full_article_appears_2";
					String timestamp_4 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
					File scrFile_4 = ((TakesScreenshot)driver_transaction_staging_popbitch).getScreenshotAs(OutputType.FILE);		
					FileUtils.copyFile(scrFile_4, new File("/Users/jay/Desktop/popbitch/"+"_"+timestamp_4+"_"+"jpg" ));		
					Thread.sleep(3000);		
					JavascriptExecutor js1 = (JavascriptExecutor)driver_transaction_staging_popbitch;
					js1.executeScript("window.scrollBy(0,500)");		
					String timestamp_5 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
					File scrFile_5 = ((TakesScreenshot)driver_transaction_staging_popbitch).getScreenshotAs(OutputType.FILE);		
					FileUtils.copyFile(scrFile_5, new File("/Users/jay/Desktop/popbitch/"+"_"+timestamp_5+"_"+"jpg" ));
					Thread.sleep(1000);
					
				
				    
				  //Click on the green tab and 
					pop_first_use_top_up_from_wallet2.click_on_green_tab();
					
					
				//get screen shot of the wallet
					File scrFile7 = ((TakesScreenshot)driver_transaction_staging_popbitch).getScreenshotAs(OutputType.FILE);
					String timestamp7 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
					FileUtils.copyFile(scrFile7, new File("/Users/jay/Desktop/popbitch/"+"_"+timestamp7+"_"+"jpg" ));
						
				//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
					Thread.sleep(2000);
					
					String Balance_after_reading_an_article_as_a_new_pub= wallet_elements_1.current_balance();
					Thread.sleep(1000);
				//convert string balances to double
					double Balance_after_reading_an_article_as_a_new_pub_parsed = Double.parseDouble(Balance_after_reading_an_article_as_a_new_pub);
					double expected_balance_after_new_pub = 8.30;
				//verify whether the expected balance is the actual balance
					AssertJUnit.assertEquals(expected_balance_after_new_pub, Balance_after_reading_an_article_as_a_new_pub_parsed);
					if(Balance_after_reading_an_article_as_a_new_pub_parsed==Balance_after_reading_an_article_as_a_new_pub_parsed)
					{
						System.out.println("Balance is expected to be "+Balance_after_reading_an_article_as_a_new_pub_parsed );
								
					}
					else
					{
						System.out.println("Alert!! Balance is not expected to be "+Balance_after_reading_an_article_as_a_new_pub_parsed+ "please check, it should be  "+ expected_balance );
					}	
				//DecimalFormat df = new DecimalFormat("#.###");
							expected_balance_global= Balance_after_reading_an_article_as_a_new_pub_parsed;	
	}

	@Test(priority=32)
	@When("Windsor wallet balance remains and is uneffected by Maiadenhead")
	public void windsor_wallet_balance_remains_and_is_uneffected_by_Maiadenhead() throws InterruptedException, IOException {
		driver_transaction_staging_popbitch.navigate().to("https://www.windsorexpress.co.uk/gallery/windsor/143020/public-inquiry-begins-into-proposed-development-on-former-imperial-house-site.html");
		Thread.sleep(4000);
		//Click on the green tab and 
			PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_staging_popbitch);
			pop_first_use_top_up_from_wallet2.click_on_green_tab();
			
			//get screen shot of the wallet
			File scrFile6 = ((TakesScreenshot)driver_transaction_staging_popbitch).getScreenshotAs(OutputType.FILE);
			String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
			FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp6+"_"+"jpg" ));
				
		//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
			Thread.sleep(2000);
			Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_staging_popbitch); 
			String Balance_after_reading_an_article= wallet_elements_1.current_balance();
			Thread.sleep(1000);
		//convert string balances to double
			double balance_after = Double.parseDouble(Balance_after_reading_an_article);
			expected_balance = 8.30;
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
		//DecimalFormat df = new DecimalFormat("#.###");
					expected_balance_global= balance_after;	
					
			

					//click ok on New pub notice charge notice
					Thread.sleep(10000);
					New_Pub_Notice New_pub = new New_Pub_Notice(driver_transaction_staging_popbitch);
					New_pub.Newpub_charge_off();
					Thread.sleep(3000);
					New_pub.authorise_charge_notice_click_continue();
					
					
			//click ok on Authorise charge notice
					Thread.sleep(5000);
					Authorise_charge_notice_popbitch authy2 = new Authorise_charge_notice_popbitch(driver_transaction_staging_popbitch);
					authy2.authorise_charge_notice_click_continue();
					Thread.sleep(3000);
					
					
					//String screenshot_name_3= "Popbitch_full_article_appears";
					String timestamp_3 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
					File scrFile_3 = ((TakesScreenshot)driver_transaction_staging_popbitch).getScreenshotAs(OutputType.FILE);		
					FileUtils.copyFile(scrFile_3, new File("/Users/jay/Desktop/popbitch/"+"_"+timestamp_3+"_"+"jpg" ));
					Thread.sleep(3000);
					JavascriptExecutor js = (JavascriptExecutor)driver_transaction_staging_popbitch;
					js.executeScript("window.scrollBy(0,500)");
					
				//String screenshot_name_4= "Popbitch_full_article_appears_2";
					String timestamp_4 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
					File scrFile_4 = ((TakesScreenshot)driver_transaction_staging_popbitch).getScreenshotAs(OutputType.FILE);		
					FileUtils.copyFile(scrFile_4, new File("/Users/jay/Desktop/popbitch/"+"_"+timestamp_4+"_"+"jpg" ));		
					Thread.sleep(3000);		
					JavascriptExecutor js1 = (JavascriptExecutor)driver_transaction_staging_popbitch;
					js1.executeScript("window.scrollBy(0,500)");		
					String timestamp_5 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
					File scrFile_5 = ((TakesScreenshot)driver_transaction_staging_popbitch).getScreenshotAs(OutputType.FILE);		
					FileUtils.copyFile(scrFile_5, new File("/Users/jay/Desktop/popbitch/"+"_"+timestamp_5+"_"+"jpg" ));
					Thread.sleep(1000);
					
				
				    
				  //Click on the green tab and 
					pop_first_use_top_up_from_wallet2.click_on_green_tab();
					
					
				//get screen shot of the wallet
					File scrFile7 = ((TakesScreenshot)driver_transaction_staging_popbitch).getScreenshotAs(OutputType.FILE);
					String timestamp7 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
					FileUtils.copyFile(scrFile7, new File("/Users/jay/Desktop/popbitch/"+"_"+timestamp7+"_"+"jpg" ));
						
				//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
					Thread.sleep(2000);
					
					String Balance_after_reading_an_article_as_a_new_pub= wallet_elements_1.current_balance();
					Thread.sleep(1000);
				//convert string balances to double
					double Balance_after_reading_an_article_as_a_new_pub_parsed = Double.parseDouble(Balance_after_reading_an_article_as_a_new_pub);
					double expected_balance_after_new_pub = 8.10;
				//verify whether the expected balance is the actual balance
					AssertJUnit.assertEquals(expected_balance_after_new_pub, Balance_after_reading_an_article_as_a_new_pub_parsed);
					if(Balance_after_reading_an_article_as_a_new_pub_parsed==Balance_after_reading_an_article_as_a_new_pub_parsed)
					{
						System.out.println("Balance is expected to be "+Balance_after_reading_an_article_as_a_new_pub_parsed );
								
					}
					else
					{
						System.out.println("Alert!! Balance is not expected to be "+Balance_after_reading_an_article_as_a_new_pub_parsed+ "please check, it should be  "+ expected_balance );
					}	
				//DecimalFormat df = new DecimalFormat("#.###");
							expected_balance_global= Balance_after_reading_an_article_as_a_new_pub_parsed;	
					
	}
	
	
	
	
	@Test(priority=33)
	@When("Slug recognition works on maidenhead from popbitch")
	public void slug_recognition_works_on_maidenhead_from_popbitch() throws InterruptedException, IOException {
		//Read a sixth article on cricketer
		driver_transaction_staging_popbitch.navigate().to("https://www.maidenhead-advertiser.co.uk/news/remember-when/144446/remember-when-oliver-cast-back-for-more-and-cub-pack-welcomes-first-girls.html");
				Thread.sleep(4000);	
				String popbitch_navigation2= driver_transaction_staging_popbitch.getCurrentUrl();
			    try
				{
			    	AssertJUnit.assertTrue (popbitch_navigation2.contains("https://www.maidenhead-advertiser.co.uk/news/remember-when/144446/remember-when-oliver-cast-back-for-more-and-cub-pack-welcomes-first-girls.html"));
				}catch(AssertionError e0)
				{
					System.out.println("Browser did not open popbitch staging ");
					throw e0;
				}
			    System.out.println("Popbitch staging is ready to be tested");
			    
			    Thread.sleep(4000);
			    
			  //Click on the green tab and 
				PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_staging_popbitch);
				pop_first_use_top_up_from_wallet2.click_on_green_tab();
				
				//get screen shot of the wallet
				File scrFile6 = ((TakesScreenshot)driver_transaction_staging_popbitch).getScreenshotAs(OutputType.FILE);
				String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp6+"_"+"jpg" ));
					
			//get the balance after two transactions. 
				Thread.sleep(2000);
				Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_staging_popbitch); 
				String Balance_after_reading_an_article= wallet_elements_1.current_balance();
				Thread.sleep(1000);
			//convert string balances to double
				double balance_after = Double.parseDouble(Balance_after_reading_an_article);
				expected_balance = 8.10;
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
			//DecimalFormat df = new DecimalFormat("#.###");
						expected_balance_global= balance_after;	
						
					    
			    
					
	}


	@Test(priority=34)
	@When("Slug recognition works on Slough")
	public void slug_recognition_works_on_Slough() throws InterruptedException, IOException {
		//Read a sixth article on cricketer
		driver_transaction_staging_popbitch.navigate().to("https://www.sloughexpress.co.uk/news/remember-when/144446/remember-when-oliver-cast-back-for-more-and-cub-pack-welcomes-first-girls.html");
				Thread.sleep(4000);	
				String popbitch_navigation2= driver_transaction_staging_popbitch.getCurrentUrl();
			    try
				{
			    	AssertJUnit.assertTrue (popbitch_navigation2.contains("https://www.sloughexpress.co.uk/news/remember-when/144446/remember-when-oliver-cast-back-for-more-and-cub-pack-welcomes-first-girls.html"));
				}catch(AssertionError e0)
				{
					System.out.println("Browser did not open popbitch staging ");
					throw e0;
				}
			    System.out.println("Popbitch staging is ready to be tested");
			    
			    Thread.sleep(4000);
			    
			  //Click on the green tab and 
				PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_staging_popbitch);
				pop_first_use_top_up_from_wallet2.click_on_green_tab();
				
				//get screen shot of the wallet
				File scrFile6 = ((TakesScreenshot)driver_transaction_staging_popbitch).getScreenshotAs(OutputType.FILE);
				String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp6+"_"+"jpg" ));
					
			//get the balance after two transactions. 
				Thread.sleep(2000);
				Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_staging_popbitch); 
				String Balance_after_reading_an_article= wallet_elements_1.current_balance();
				Thread.sleep(1000);
			//convert string balances to double
				double balance_after = Double.parseDouble(Balance_after_reading_an_article);
				expected_balance = 8.10;
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
			//DecimalFormat df = new DecimalFormat("#.###");
						expected_balance_global= balance_after;	
						
					    
			    
					
	}

	@Test(priority=35)
	@When("Slug recognition works on Windsor")
	public void slug_recognition_works_on_Windsor() throws InterruptedException, IOException {
		//Read a sixth article on cricketer
				driver_transaction_staging_popbitch.navigate().to("https://www.windsorexpress.co.uk/news/remember-when/144446/remember-when-oliver-cast-back-for-more-and-cub-pack-welcomes-first-girls.html");
						Thread.sleep(4000);	
						String popbitch_navigation2= driver_transaction_staging_popbitch.getCurrentUrl();
					    try
						{
					    	AssertJUnit.assertTrue (popbitch_navigation2.contains("https://www.windsorexpress.co.uk/news/remember-when/144446/remember-when-oliver-cast-back-for-more-and-cub-pack-welcomes-first-girls.html"));
						}catch(AssertionError e0)
						{
							System.out.println("Browser did not open popbitch staging ");
							throw e0;
						}
					    System.out.println("Popbitch staging is ready to be tested");
					    
					    Thread.sleep(4000);
					    
					  //Click on the green tab and 
						PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_staging_popbitch);
						pop_first_use_top_up_from_wallet2.click_on_green_tab();
						
						//get screen shot of the wallet
						File scrFile6 = ((TakesScreenshot)driver_transaction_staging_popbitch).getScreenshotAs(OutputType.FILE);
						String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
						FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp6+"_"+"jpg" ));
							
					//get the balance after two transactions. 
						Thread.sleep(2000);
						Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_staging_popbitch); 
						String Balance_after_reading_an_article= wallet_elements_1.current_balance();
						Thread.sleep(1000);
					//convert string balances to double
						double balance_after = Double.parseDouble(Balance_after_reading_an_article);
						expected_balance = 8.10;
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
					//DecimalFormat df = new DecimalFormat("#.###");
								expected_balance_global= balance_after;	
	}
	
	




*/





}

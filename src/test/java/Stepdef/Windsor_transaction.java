package Stepdef;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
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
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Elements.Authorise_charge_notice_popbitch;
import Elements.Login_Page_Elements;
import Elements.Maidenhead_first_use_notice;
import Elements.PopbitchFirstUseNoticeElements;
import Elements.Popbitch_Wallet_Elements_staging;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Windsor_transaction {
	

		
		WebDriver driver_windsor_Transaction;
		double expected_balance_global;
		double expected_balance;
		
		
		
		@Test(priority=12)
		@Parameters("browser")
		@Given("I am a registered Agate User and I login in to windsor")
		public void i_am_a_registered_Agate_User_and_I_login_in_to_windsor(String browser) throws IOException, InterruptedException {
			if(browser.equalsIgnoreCase("firefox")) {
				driver_windsor_Transaction = new FirefoxDriver();
			}else if (browser.equalsIgnoreCase("safari")) { 

				driver_windsor_Transaction= new SafariDriver();
			} 

			else if (browser.equalsIgnoreCase("chrome")) { 
				driver_windsor_Transaction= new ChromeDriver();
			} 
			
			
			System.out.println("\n"+"Maidenhead TTransaction"+"\n");
			System.out.println("\n"+""+"\n");
		
			driver_windsor_Transaction.get("https://www.windsorexpress.co.uk/news/remember-when/144446/remember-when-oliver-cast-back-for-more-and-cub-pack-welcomes-first-girls.html");
			Thread.sleep(3000);
			String popbitch_navigation= driver_windsor_Transaction.getCurrentUrl();
		    try
			{
		    	AssertJUnit.assertTrue(popbitch_navigation.contains("https://www.windsorexpress.co.uk/news/remember-when/144446/remember-when-oliver-cast-back-for-more-and-cub-pack-welcomes-first-girls.html"));
			}catch(AssertionError e0)
			{
				System.out.println("Browser did not open Maidenhead Live ");
				throw e0;
			}
		    System.out.println("Maidenhead Live is ready to be tested");
			File scrFile = ((TakesScreenshot)driver_windsor_Transaction).getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
			FileUtils.copyFile(scrFile, new File("/Users/jay/Desktop/Maidenhead/"+"_"+timestamp+"_"+"jpg" ));
			
			//call first use notice elements of Maidenhead
			Thread.sleep(15000);
			Thread.sleep(15000);
			Maidenhead_first_use_notice Maidenhead_f_u_n = new Maidenhead_first_use_notice(driver_windsor_Transaction);
			Maidenhead_f_u_n.Click_On_Maidenhead_First_use_Login_button();
			System.out.println("\n"+"Clicked on Maidenhead Login.. Now lets see if this takes us to login page"+"\n");
			Thread.sleep(8000);
			File scrFile5 = ((TakesScreenshot)driver_windsor_Transaction).getScreenshotAs(OutputType.FILE);
			String timestamp5 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
			FileUtils.copyFile(scrFile5, new File("/Users/jay/Desktop/maidenhead/"+"_"+timestamp5+"_"+"jpg" ));	
			Thread.sleep(2000);
			String Login_From_PopBitch_Frist_Use_Notice_Current_Url= driver_windsor_Transaction.getCurrentUrl();
		    System.out.println("\n"+"Clicking on login redirected to login page satging"+"\n");
		    assertTrue(Login_From_PopBitch_Frist_Use_Notice_Current_Url.contains("https://account.agate.io/my-agate/sign-in?"));
		    System.out.println("\n"+"Successfully navigated to login page"+"\n");
		    
		    Login_Page_Elements Login_Pop_First_Use = new Login_Page_Elements(driver_windsor_Transaction);
			Thread.sleep(2000);
			Login_Pop_First_Use.Login_Process("Ajjukanna1$$");
			Thread.sleep(10000);
			File scrFile6 = ((TakesScreenshot)driver_windsor_Transaction).getScreenshotAs(OutputType.FILE);
			String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
			FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/maidenhead/"+"_"+timestamp6+"_"+"jpg" ));	
			System.out.println("\n"+"Login successfull"+"\n");		
			
		}
		
		@Test(priority=13)
		@When("I read a premium article on windsor")
		public void i_read_a_premium_article_on_windsor() throws InterruptedException, IOException {
			//click ok on authorise charge notice
			//scroll for full article
			JavascriptExecutor js0 = (JavascriptExecutor)driver_windsor_Transaction;
			js0.executeScript("window.scrollBy(0,800)");
			
			
			
			
			Thread.sleep(10000);
					Authorise_charge_notice_popbitch authy_popbitch = new Authorise_charge_notice_popbitch(driver_windsor_Transaction);
					authy_popbitch.authorise_charge_notice_click_continue();
					Thread.sleep(3000);
				
					
					//Click on the green tab and 
					PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_windsor_Transaction);
					pop_first_use_top_up_from_wallet2.click_on_green_tab();
					
					
					
				//check if the wallet is being deducted by 30 p
					Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_windsor_Transaction);
					String Balance_after_reading_an_article= wallet_elements_1.current_balance();
					//convert string balances to double
					double actual_balance_after_reacding_first_article = Double.parseDouble(Balance_after_reading_an_article);
					double expected_balance_to_be_deducted = 0.20;
					double balance_after_first_article= 1.60;
					double actual_balance_being_deducted= balance_after_first_article-actual_balance_after_reacding_first_article;
					DecimalFormat df = new DecimalFormat("#.##");
					actual_balance_being_deducted = Double.valueOf(df.format(actual_balance_being_deducted));						
			
					
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
					
					
					
					
					
		}

		
		@Test(priority=14)
		@Then("The popbitch wallet balance is updated , same as windsor and free point remains uneffected")
		public void the_popbitch_wallet_balance_is_updated_same_as_windsor_and_free_point_remains_uneffected() throws InterruptedException, IOException {
			driver_windsor_Transaction.navigate().to("https://popbitch.com/2019/02/tat-for-tits/");
			Thread.sleep(4000);
			//Click on the green tab and 
				PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_windsor_Transaction);
				pop_first_use_top_up_from_wallet2.click_on_green_tab();
				//get screen shot of the wallet
				File scrFile6 = ((TakesScreenshot)driver_windsor_Transaction).getScreenshotAs(OutputType.FILE);
				String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp6+"_"+"jpg" ));
					
			//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
				Thread.sleep(2000);
				Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_windsor_Transaction); 
				String Balance_after_reading_an_article= wallet_elements_1.current_balance();
				Thread.sleep(1000);
			//convert string balances to double
				double balance_after = Double.parseDouble(Balance_after_reading_an_article);
				expected_balance = 1.40;
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
						
				
			//GET FREE POINT AFTER THE TWO TRANSACTIONS
				Thread.sleep(2000); 
				String free_point_after_2_articles_string= wallet_elements_1.Free_point();
				//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
				String Popbitch_expected_free_point_after_2_articles= "until free";
				//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
				//int Popbitch_expected_free_point_after_2_articles= 0;
					
					//Verify if actual free point matches expected free point
						AssertJUnit.assertEquals(free_point_after_2_articles_string, Popbitch_expected_free_point_after_2_articles);
						if(Popbitch_expected_free_point_after_2_articles==free_point_after_2_articles_string)
						{
							System.out.println("Free point is expected to be "+	free_point_after_2_articles_string  );
							
						}
						else
						{
							
							System.out.println("Alert!!! Free point is not expected to be "+free_point_after_2_articles_string+ "please check, it should be " + Popbitch_expected_free_point_after_2_articles );
					
						}
		}
		
		@Test(priority=15)
		@Then("Reaction wallet balance is updated and free point remains uneffected same as windsor")
		public void reaction_wallet_balance_is_updated_and_free_point_remains_uneffected_same_as_windsor() throws InterruptedException, IOException {
			driver_windsor_Transaction.navigate().to("https://reaction.life/independent-groups-new-politics-isnt-new/");
			Thread.sleep(4000);
			//Click on the green tab and 
				PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_windsor_Transaction);
				pop_first_use_top_up_from_wallet2.click_on_green_tab();
				
				//get screen shot of the wallet
				File scrFile6 = ((TakesScreenshot)driver_windsor_Transaction).getScreenshotAs(OutputType.FILE);
				String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp6+"_"+"jpg" ));
					
			//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
				Thread.sleep(2000);
				Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_windsor_Transaction); 
				String Balance_after_reading_an_article= wallet_elements_1.current_balance();
				Thread.sleep(1000);
			//convert string balances to double
				double balance_after = Double.parseDouble(Balance_after_reading_an_article);
				expected_balance = 1.40;
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
						
				
			//GET FREE POINT AFTER THE TWO TRANSACTIONS
				Thread.sleep(2000); 
				String free_point_after_2_articles_string= wallet_elements_1.Free_point();
				//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
				String Popbitch_expected_free_point_after_2_articles= "until free";
				//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
				//int Popbitch_expected_free_point_after_2_articles= 0;
					
					//Verify if actual free point matches expected free point
						AssertJUnit.assertEquals(free_point_after_2_articles_string, Popbitch_expected_free_point_after_2_articles);
						if(Popbitch_expected_free_point_after_2_articles==free_point_after_2_articles_string)
						{
							System.out.println("Free point is expected to be "+	free_point_after_2_articles_string  );
							
						}
						else
						{
							
							System.out.println("Alert!!! Free point is not expected to be "+free_point_after_2_articles_string+ "please check, it should be " + Popbitch_expected_free_point_after_2_articles );
					
						}
				
				
				System.out.println("\n"+"wallet balance on cricketer is "+balance_after+"\n");
				//System.out.println("\n"+"free point on reaction is £1.20"+"\n");

		}

		@Test(priority=16)
		@Then("Cricketer wallet balance remains and is uneffected by windsor")
		public void cricketer_wallet_balance_remains_and_is_uneffected_by_windsor() throws InterruptedException, IOException {
			driver_windsor_Transaction.navigate().to("https://www.thecricketer.com/Topics/premimum_features/stats_life_nathan_lyons_test_sixes_record_is_a_badge_of_honour.html");
			Thread.sleep(4000);
			//Click on the green tab and 
				PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_windsor_Transaction);
				pop_first_use_top_up_from_wallet2.click_on_green_tab();
				
				//get screen shot of the wallet
				File scrFile6 = ((TakesScreenshot)driver_windsor_Transaction).getScreenshotAs(OutputType.FILE);
				String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/api/"+"_"+timestamp6+"_"+"jpg" ));
					
			//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
				Thread.sleep(2000);
				Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_windsor_Transaction); 
				String Balance_after_reading_an_article= wallet_elements_1.current_balance();
				Thread.sleep(1000);
			//convert string balances to double
				double balance_after = Double.parseDouble(Balance_after_reading_an_article);
				expected_balance = 1.40;
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
						
				
			//GET FREE POINT AFTER THE TWO TRANSACTIONS
				Thread.sleep(2000); 
				String free_point_after_2_articles_string= wallet_elements_1.Free_point();
				//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
				String Popbitch_expected_free_point_after_2_articles= "until free";
				//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
				//int Popbitch_expected_free_point_after_2_articles= 0;
					
					//Verify if actual free point matches expected free point
						AssertJUnit.assertEquals(free_point_after_2_articles_string, Popbitch_expected_free_point_after_2_articles);
						if(Popbitch_expected_free_point_after_2_articles==free_point_after_2_articles_string)
						{
							System.out.println("Free point is expected to be "+	free_point_after_2_articles_string  );
							
						}
						else
						{
							
							System.out.println("Alert!!! Free point is not expected to be "+free_point_after_2_articles_string+ "please check, it should be " + Popbitch_expected_free_point_after_2_articles );
					
						}

		}

		@Test(priority=17)
		@Then("Cornwall wallet balance remains and is uneffected by windsor")
		public void cornwall_wallet_balance_remains_and_is_uneffected_by_windsor() throws InterruptedException, IOException {
			driver_windsor_Transaction.navigate().to("https://cornwallreports.co.uk/cruel-december-radio-cornwall-back-in-the-doldrums-as-audience-figures-surrender-to-gravity/");
			Thread.sleep(4000);
			//Click on the green tab and 
				PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_windsor_Transaction);
				pop_first_use_top_up_from_wallet2.click_on_green_tab();
				
				//get screen shot of the wallet
				File scrFile6 = ((TakesScreenshot)driver_windsor_Transaction).getScreenshotAs(OutputType.FILE);
				String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp6+"_"+"jpg" ));
					
			//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
				Thread.sleep(2000);
				Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_windsor_Transaction); 
				String Balance_after_reading_an_article= wallet_elements_1.current_balance();
				Thread.sleep(1000);
			//convert string balances to double
				double balance_after = Double.parseDouble(Balance_after_reading_an_article);
				expected_balance = 1.40;
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
						
				
			//GET FREE POINT AFTER THE TWO TRANSACTIONS
				Thread.sleep(2000); 
				String free_point_after_2_articles_string= wallet_elements_1.Free_point();
				//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
				String Popbitch_expected_free_point_after_2_articles= "until free";
				//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
				//int Popbitch_expected_free_point_after_2_articles= 0;
					
					//Verify if actual free point matches expected free point
						AssertJUnit.assertEquals(free_point_after_2_articles_string, Popbitch_expected_free_point_after_2_articles);
						if(Popbitch_expected_free_point_after_2_articles==free_point_after_2_articles_string)
						{
							System.out.println("Free point is expected to be "+	free_point_after_2_articles_string  );
							
						}
						else
						{
							
							System.out.println("Alert!!! Free point is not expected to be "+free_point_after_2_articles_string+ "please check, it should be " + Popbitch_expected_free_point_after_2_articles );
					
						}
		}


		@Test(priority=18)
		@When("Maidenhead wallet balance remains and is uneffected by windsor")
		public void windsor_wallet_balance_remains_and_is_uneffected_by_windsor() throws InterruptedException, IOException {
			driver_windsor_Transaction.navigate().to("https://www.maidenhead-advertiser.co.uk/news/remember-when/144177/remember-when-when-mary-had-a-little-lamb-and-the-outdoor-pool-closed-for-good.html");
			Thread.sleep(4000);
			//Click on the green tab and 
				PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_windsor_Transaction);
				pop_first_use_top_up_from_wallet2.click_on_green_tab();
				
				//get screen shot of the wallet
				File scrFile6 = ((TakesScreenshot)driver_windsor_Transaction).getScreenshotAs(OutputType.FILE);
				String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp6+"_"+"jpg" ));
					
			//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
				Thread.sleep(2000);
				Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_windsor_Transaction); 
				String Balance_after_reading_an_article= wallet_elements_1.current_balance();
				Thread.sleep(1000);
			//convert string balances to double
				double balance_after = Double.parseDouble(Balance_after_reading_an_article);
				expected_balance = 1.40;
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
						
				
			//GET FREE POINT AFTER THE TWO TRANSACTIONS
				Thread.sleep(2000); 
				String free_point_after_2_articles_string= wallet_elements_1.Free_point();
				//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
				String Popbitch_expected_free_point_after_2_articles= "until free";
				//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
				//int Popbitch_expected_free_point_after_2_articles= 0;
					
					//Verify if actual free point matches expected free point
						AssertJUnit.assertEquals(free_point_after_2_articles_string, Popbitch_expected_free_point_after_2_articles);
						if(Popbitch_expected_free_point_after_2_articles==free_point_after_2_articles_string)
						{
							System.out.println("Free point is expected to be "+	free_point_after_2_articles_string  );
							
						}
						else
						{
							
							System.out.println("Alert!!! Free point is not expected to be "+free_point_after_2_articles_string+ "please check, it should be " + Popbitch_expected_free_point_after_2_articles );
					
						}
		}

		@Test(priority=19)
		@When("Slough wallet balance remains and is uneffected by windsor")
		public void slough_wallet_balance_remains_and_is_uneffected_by_windsor() throws InterruptedException, IOException {
			driver_windsor_Transaction.navigate().to("https://www.windsorexpress.co.uk/gallery/windsor/143020/public-inquiry-begins-into-proposed-development-on-former-imperial-house-site.html");
			Thread.sleep(4000);
			//Click on the green tab and 
				PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_windsor_Transaction);
				pop_first_use_top_up_from_wallet2.click_on_green_tab();
				
				//get screen shot of the wallet
				File scrFile6 = ((TakesScreenshot)driver_windsor_Transaction).getScreenshotAs(OutputType.FILE);
				String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp6+"_"+"jpg" ));
					
			//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
				Thread.sleep(2000);
				Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_windsor_Transaction); 
				String Balance_after_reading_an_article= wallet_elements_1.current_balance();
				Thread.sleep(1000);
			//convert string balances to double
				double balance_after = Double.parseDouble(Balance_after_reading_an_article);
				expected_balance = 1.40;
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
						
				
			//GET FREE POINT AFTER THE TWO TRANSACTIONS
				Thread.sleep(2000); 
				String free_point_after_2_articles_string= wallet_elements_1.Free_point();
				//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
				String Popbitch_expected_free_point_after_2_articles= "until free";
				//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
				//int Popbitch_expected_free_point_after_2_articles= 0;
					
					//Verify if actual free point matches expected free point
						AssertJUnit.assertEquals(free_point_after_2_articles_string, Popbitch_expected_free_point_after_2_articles);
						if(Popbitch_expected_free_point_after_2_articles==free_point_after_2_articles_string)
						{
							System.out.println("Free point is expected to be "+	free_point_after_2_articles_string  );
							
						}
						else
						{
							
							System.out.println("Alert!!! Free point is not expected to be "+free_point_after_2_articles_string+ "please check, it should be " + Popbitch_expected_free_point_after_2_articles );
					
						}
		}

		@Test(priority=20)
		@When("Slug recognition works on maidenhead from windsor")
		public void slug_recognition_works_on_maidenhead_from_windsor() throws InterruptedException, IOException {
			//Read a sixth article on cricketer
			driver_windsor_Transaction.navigate().to("https://www.maidenhead-advertiser.co.uk/news/remember-when/144446/remember-when-oliver-cast-back-for-more-and-cub-pack-welcomes-first-girls.html");
					Thread.sleep(4000);	
					String popbitch_navigation2= driver_windsor_Transaction.getCurrentUrl();
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
					PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_windsor_Transaction);
					pop_first_use_top_up_from_wallet2.click_on_green_tab();
					
					//get screen shot of the wallet
					File scrFile6 = ((TakesScreenshot)driver_windsor_Transaction).getScreenshotAs(OutputType.FILE);
					String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
					FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp6+"_"+"jpg" ));
						
				//get the balance after two transactions. 
					Thread.sleep(2000);
					Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_windsor_Transaction); 
					String Balance_after_reading_an_article= wallet_elements_1.current_balance();
					Thread.sleep(1000);
				//convert string balances to double
					double balance_after = Double.parseDouble(Balance_after_reading_an_article);
					expected_balance = 1.40;
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

		@Test(priority=21)
		@When("Slug recognition works on Slough from windsor")
		public void slug_recognition_works_on_Windsor_from_windsor() throws InterruptedException, IOException {
			//Read a sixth article on cricketer
					driver_windsor_Transaction.navigate().to("https://www.windsorexpress.co.uk/news/remember-when/144446/remember-when-oliver-cast-back-for-more-and-cub-pack-welcomes-first-girls.html");
							Thread.sleep(4000);	
							String popbitch_navigation2= driver_windsor_Transaction.getCurrentUrl();
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
							PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_windsor_Transaction);
							pop_first_use_top_up_from_wallet2.click_on_green_tab();
							
							//get screen shot of the wallet
							File scrFile6 = ((TakesScreenshot)driver_windsor_Transaction).getScreenshotAs(OutputType.FILE);
							String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
							FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp6+"_"+"jpg" ));
								
						//get the balance after two transactions. 
							Thread.sleep(2000);
							Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_windsor_Transaction); 
							String Balance_after_reading_an_article= wallet_elements_1.current_balance();
							Thread.sleep(1000);
						//convert string balances to double
							double balance_after = Double.parseDouble(Balance_after_reading_an_article);
							expected_balance = 1.40;
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
		
		
		
		
		
		
		
		
	}

	


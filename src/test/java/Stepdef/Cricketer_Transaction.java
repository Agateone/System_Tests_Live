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
import Elements.Cricketer_first_use_notice_Elements;
import Elements.Login_Page_Elements;
import Elements.PopbitchFirstUseNoticeElements;
import Elements.Popbitch_Wallet_Elements_staging;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Cricketer_Transaction {

	
	WebDriver driver_Cricketer_Transaction;
	double expected_balance_global;
	double expected_balance;
	@Given("I am a registered Agate User and I login in to Cricketer")
	@Test(priority=12)
	@Parameters("browser")
	public void i_am_a_registered_Agate_User_and_I_login_in_to_Cricketer(String browser) throws InterruptedException, IOException {
		if(browser.equalsIgnoreCase("firefox")) {
			driver_Cricketer_Transaction = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("safari")) { 

			driver_Cricketer_Transaction= new SafariDriver();
		} 

		else if (browser.equalsIgnoreCase("chrome")) { 
			driver_Cricketer_Transaction= new ChromeDriver();
		} 
		
		
		System.out.println("\n"+"POPBITCH TRANSACTION"+"\n");
		System.out.println("\n"+""+"\n");
	
		driver_Cricketer_Transaction.get("https://www.thecricketer.com/Topics/news/crickets_last_post_when_hobbs_met_barnes_in_the_bradford_league.html");
		Thread.sleep(3000);
		String popbitch_navigation= driver_Cricketer_Transaction.getCurrentUrl();
	    try
		{
	    	AssertJUnit.assertTrue(popbitch_navigation.contains("https://www.thecricketer.com/Topics/news/crickets_last_post_when_hobbs_met_barnes_in_the_bradford_league.html"));
		}catch(AssertionError e0)
		{
			System.out.println("Browser did not open popbitch staging ");
			throw e0;
		}
	    System.out.println("Popbitch staging is ready to be tested");
		File scrFile = ((TakesScreenshot)driver_Cricketer_Transaction).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		FileUtils.copyFile(scrFile, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp+"_"+"jpg" ));	
	
		//call first use notice elements of reaction
				Thread.sleep(15000);
				Thread.sleep(15000);
				Cricketer_first_use_notice_Elements Cric_first_use_register1 = new Cricketer_first_use_notice_Elements(driver_Cricketer_Transaction);
				
				Cric_first_use_register1.Click_On_Cricketer_First_use_Login_button();
				System.out.println("\n"+"Clicked on Create wallet.. Now lets see if this takes us to Sign up page"+"\n");	
	
		Thread.sleep(8000);
		File scrFile5 = ((TakesScreenshot)driver_Cricketer_Transaction).getScreenshotAs(OutputType.FILE);
		String timestamp5 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		FileUtils.copyFile(scrFile5, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp5+"_"+"jpg" ));	
		Thread.sleep(2000);
		String Login_From_PopBitch_Frist_Use_Notice_Current_Url= driver_Cricketer_Transaction.getCurrentUrl();
	    System.out.println("\n"+"Clicking on login redirected to login page satging"+"\n");
	    assertTrue(Login_From_PopBitch_Frist_Use_Notice_Current_Url.contains("https://account.agate.io/my-agate/sign-in?"));
	    System.out.println("\n"+"Successfully navigated to login page"+"\n");
	
	
	    Login_Page_Elements Login_Pop_First_Use = new Login_Page_Elements(driver_Cricketer_Transaction);
		Thread.sleep(2000);
		Login_Pop_First_Use.Login_Process("Ajjukanna1$$");
		Thread.sleep(10000);
		File scrFile6 = ((TakesScreenshot)driver_Cricketer_Transaction).getScreenshotAs(OutputType.FILE);
		String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp6+"_"+"jpg" ));	
		System.out.println("\n"+"Login successfull"+"\n");
	}

	@When("I read a premium article on cricketer")
	@Test(priority=13)
	public void i_read_a_premium_article_on_cricketer() throws IOException, InterruptedException {
		//click ok on authorise charge notice
				//scroll for full article
				JavascriptExecutor js0 = (JavascriptExecutor)driver_Cricketer_Transaction;
				js0.executeScript("window.scrollBy(0,800)");
				
				
				
				
				Thread.sleep(10000);
						Authorise_charge_notice_popbitch authy_popbitch = new Authorise_charge_notice_popbitch(driver_Cricketer_Transaction);
						authy_popbitch.authorise_charge_notice_click_continue();
						Thread.sleep(3000);
					
						
						//Click on the green tab and 
						PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_Cricketer_Transaction);
						pop_first_use_top_up_from_wallet2.click_on_green_tab();
						
						
						
					//check if the wallet is being deducted by 30 p
						Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_Cricketer_Transaction);
						String Balance_after_reading_an_article= wallet_elements_1.current_balance();
										
					//convert string balances to double
						double actual_balance_after_reacding_first_article = Double.parseDouble(Balance_after_reading_an_article);
						double expected_balance_to_be_deducted = 0.30;
						double balance_after_first_article= 1.40;
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

	@Then("the wallet balance and free point are deducted by x amount on cricketer wallet")
	@Test(priority=14)
	public void the_wallet_balance_and_free_point_are_deducted_by_x_amount_on_cricketer_wallet() throws InterruptedException, IOException {
		//Read a fourth article on cricketer
				driver_Cricketer_Transaction.navigate().to("https://www.thecricketer.com/Topics/features/back_to_the_future_when_packer_changed_cricket.html");
						Thread.sleep(4000);	
						String popbitch_navigation= driver_Cricketer_Transaction.getCurrentUrl();
					    try
						{
					    	AssertJUnit.assertTrue(popbitch_navigation.contains("https://www.thecricketer.com/Topics/features/back_to_the_future_when_packer_changed_cricket.html"));
						}catch(AssertionError e0)
						{
							System.out.println("Browser did not open popbitch staging ");
							throw e0;
						}
					    System.out.println("Popbitch staging is ready to be tested");
						File scrFile = ((TakesScreenshot)driver_Cricketer_Transaction).getScreenshotAs(OutputType.FILE);
						String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
						FileUtils.copyFile(scrFile, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp+"_"+"jpg" ));	
						
						//click ok on authorise charge notice
						
						//scroll for full article
						JavascriptExecutor js0 = (JavascriptExecutor)driver_Cricketer_Transaction;
						js0.executeScript("window.scrollBy(0,800)");
						
						
						
						
						Thread.sleep(10000);
						Authorise_charge_notice_popbitch authy_popbitch = new Authorise_charge_notice_popbitch(driver_Cricketer_Transaction);
						authy_popbitch.authorise_charge_notice_click_continue();
						Thread.sleep(3000);
					
						
						//Click on the green tab and 
						PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_Cricketer_Transaction);
						pop_first_use_top_up_from_wallet2.click_on_green_tab();
						
						
						
					//check if the wallet is being deducted by 30 p
						Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_Cricketer_Transaction);
						String Balance_after_reading_an_article= wallet_elements_1.current_balance();
										
					//convert string balances to double
						double actual_balance_after_reacding_first_article = Double.parseDouble(Balance_after_reading_an_article);
						double expected_balance_to_be_deducted = 0.30;
						double balance_after_first_article= 1.10;
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
						
						//Navigate to a fifth article which is supposed to be free
						driver_Cricketer_Transaction.navigate().to("https://reaction.life/chequers-dead-maybot-reset-required/");
						Thread.sleep(4000);	
	//***********************************************************************************************************************************
						
						//Read a fifth article on reaction
						driver_Cricketer_Transaction.navigate().to("https://www.thecricketer.com/Topics/features/the_googly_doliveira_made_a_century.html");
								Thread.sleep(4000);	
								String popbitch_navigation1= driver_Cricketer_Transaction.getCurrentUrl();
							    try
								{
							    	AssertJUnit.assertTrue(popbitch_navigation1.contains("https://www.thecricketer.com/Topics/features/the_googly_doliveira_made_a_century.html"));
								}catch(AssertionError e0)
								{
									System.out.println("Browser did not open popbitch staging ");
									throw e0;
								}
							    System.out.println("Popbitch staging is ready to be tested");
								File scrFile10 = ((TakesScreenshot)driver_Cricketer_Transaction).getScreenshotAs(OutputType.FILE);
								String timestamp10 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
								FileUtils.copyFile(scrFile10, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp10+"_"+"jpg" ));	
								
								//click ok on authorise charge notice
								
								//scroll for full article
								JavascriptExecutor js10 = (JavascriptExecutor)driver_Cricketer_Transaction;
								js10.executeScript("window.scrollBy(0,800)");
								
								
								
								
								Thread.sleep(10000);
								Authorise_charge_notice_popbitch authy_popbitch1 = new Authorise_charge_notice_popbitch(driver_Cricketer_Transaction);
								authy_popbitch1.authorise_charge_notice_click_continue();
								Thread.sleep(3000);
							
								
								//Click on the green tab and 
								PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet3 = new PopbitchFirstUseNoticeElements(driver_Cricketer_Transaction);
								pop_first_use_top_up_from_wallet3.click_on_green_tab();
								
								
								
							//check if the wallet is being deducted by 30 p
								Popbitch_Wallet_Elements_staging wallet_elements_4 = new Popbitch_Wallet_Elements_staging(driver_Cricketer_Transaction);
								String Balance_after_reading_an_article1= wallet_elements_4.current_balance();
												
							//convert string balances to double
								double actual_balance_after_reacding_first_article1 = Double.parseDouble(Balance_after_reading_an_article1);
								double expected_balance_to_be_deducted1 = 0.30;
								double balance_after_first_article1= 0.80;
								double actual_balance_being_deducted1= balance_after_first_article1-actual_balance_after_reacding_first_article1;
								DecimalFormat df1 = new DecimalFormat("#.##");
								actual_balance_being_deducted1 = Double.valueOf(df1.format(actual_balance_being_deducted1));						
						
								
								//verify whether the expected balance is the actual balance
								AssertJUnit.assertEquals(expected_balance_to_be_deducted1, actual_balance_being_deducted1);
								if(actual_balance_being_deducted1==expected_balance_to_be_deducted1)
								{
									System.out.println("Balance is expected to be deducted by"+actual_balance_being_deducted1 );
																	
								}
								else
								{
									System.out.println("Alert!! Balance is not expected to be deducted by "+actual_balance_being_deducted1+ "please check, it should be  "+ expected_balance_to_be_deducted1 );
								}		
		//***********************************************************************************************************************************							

								//Read a sixth article on cricketer
								driver_Cricketer_Transaction.navigate().to("https://www.thecricketer.com/Topics/premimum_features/stats_life_nathan_lyons_test_sixes_record_is_a_badge_of_honour.html");
										Thread.sleep(4000);	
										String popbitch_navigation2= driver_Cricketer_Transaction.getCurrentUrl();
									    try
										{
									    	AssertJUnit.assertTrue (popbitch_navigation2.contains("https://www.thecricketer.com/Topics/premimum_features/stats_life_nathan_lyons_test_sixes_record_is_a_badge_of_honour.html"));
										}catch(AssertionError e0)
										{
											System.out.println("Browser did not open popbitch staging ");
											throw e0;
										}
									    System.out.println("Popbitch staging is ready to be tested");
											
										
										//click ok on authorise charge notice
										
										//scroll for full article				
										js10.executeScript("window.scrollBy(0,400)");
										Thread.sleep(4000);
										File scrFile11 = ((TakesScreenshot)driver_Cricketer_Transaction).getScreenshotAs(OutputType.FILE);
										String timestamp11 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
										FileUtils.copyFile(scrFile11, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp11+"_"+"jpg" ));
										
										//click ok on authorise cahrge notice
										
										Thread.sleep(10000);
										authy_popbitch1.authorise_charge_notice_click_continue();
										Thread.sleep(3000);
									
										
										//Click on the green tab and 								
										pop_first_use_top_up_from_wallet3.click_on_green_tab();
										
										
										
									//check if the wallet is being deducted by 30 p
										String Balance_after_reading_an_article2= wallet_elements_4.current_balance();
														
									//convert string balances to double
										double actual_balance_after_reacding_first_article2 = Double.parseDouble(Balance_after_reading_an_article2);
										double expected_balance_to_be_deducted2 = 0.30;
										double balance_after_first_article2= 0.50;
										double actual_balance_being_deducted2= balance_after_first_article2-actual_balance_after_reacding_first_article2;
										DecimalFormat df2 = new DecimalFormat("#.##");
										actual_balance_being_deducted2 = Double.valueOf(df2.format(actual_balance_being_deducted2));						
								
										
										//verify whether the expected balance is the actual balance
										AssertJUnit.assertEquals(expected_balance_to_be_deducted2, actual_balance_being_deducted2);
										if(actual_balance_being_deducted2==expected_balance_to_be_deducted2)
										{
											System.out.println("Balance is expected to be deducted by"+actual_balance_being_deducted2);
																			
										}
										else
										{
											System.out.println("Alert!! Balance is not expected to be deducted by "+actual_balance_being_deducted2+ "please check, it should be  "+ expected_balance_to_be_deducted2 );
										}		
								
								
								
								
						
						
						
	}

	@Then("The popbitch wallet balance is updated , same as cricketer and free point remains uneffected")
	@Test(priority=15)
	public void the_popbitch_wallet_balance_is_updated_same_as_cricketer_and_free_point_remains_uneffected() throws InterruptedException, IOException {
		driver_Cricketer_Transaction.navigate().to("https://popbitch.com/2019/02/tat-for-tits/");
		Thread.sleep(4000);
		//Click on the green tab and 
			PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_Cricketer_Transaction);
			pop_first_use_top_up_from_wallet2.click_on_green_tab();
			//get screen shot of the wallet
			File scrFile6 = ((TakesScreenshot)driver_Cricketer_Transaction).getScreenshotAs(OutputType.FILE);
			String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
			FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp6+"_"+"jpg" ));
				
		//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
			Thread.sleep(2000);
			Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_Cricketer_Transaction); 
			String Balance_after_reading_an_article= wallet_elements_1.current_balance();
			Thread.sleep(1000);
		//convert string balances to double
			double balance_after = Double.parseDouble(Balance_after_reading_an_article);
			expected_balance = 0.20;
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

	@Then("Reaction wallet balance is updated and free point remains uneffected")
	@Test(priority=16)
	public void reaction_wallet_balance_is_updated_and_free_point_remains_uneffected() throws InterruptedException, IOException {
		driver_Cricketer_Transaction.navigate().to("https://reaction.life/independent-groups-new-politics-isnt-new/");
		Thread.sleep(4000);
		//Click on the green tab and 
			PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_Cricketer_Transaction);
			pop_first_use_top_up_from_wallet2.click_on_green_tab();
			
			//get screen shot of the wallet
			File scrFile6 = ((TakesScreenshot)driver_Cricketer_Transaction).getScreenshotAs(OutputType.FILE);
			String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
			FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp6+"_"+"jpg" ));
				
		//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
			Thread.sleep(2000);
			Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_Cricketer_Transaction); 
			String Balance_after_reading_an_article= wallet_elements_1.current_balance();
			Thread.sleep(1000);
		//convert string balances to double
			double balance_after = Double.parseDouble(Balance_after_reading_an_article);
			expected_balance = 0.20;
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

	@Then("Cornwall wallet balance remains and is uneffected according to cricketer")
	@Test(priority=17)
	public void cornwall_wallet_balance_remains_and_is_uneffected_according_to_cricketer() throws InterruptedException, IOException {
		driver_Cricketer_Transaction.navigate().to("https://cornwallreports.co.uk/cruel-december-radio-cornwall-back-in-the-doldrums-as-audience-figures-surrender-to-gravity/");
		Thread.sleep(4000);
		//Click on the green tab and 
			PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_Cricketer_Transaction);
			pop_first_use_top_up_from_wallet2.click_on_green_tab();
			
			//get screen shot of the wallet
			File scrFile6 = ((TakesScreenshot)driver_Cricketer_Transaction).getScreenshotAs(OutputType.FILE);
			String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
			FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp6+"_"+"jpg" ));
				
		//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
			Thread.sleep(2000);
			Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_Cricketer_Transaction); 
			String Balance_after_reading_an_article= wallet_elements_1.current_balance();
			Thread.sleep(1000);
		//convert string balances to double
			double balance_after = Double.parseDouble(Balance_after_reading_an_article);
			expected_balance = 0.20;
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














































}

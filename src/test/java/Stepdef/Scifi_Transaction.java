package Stepdef;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Elements.Login_Page_Elements;
import Elements.Scifi_First_Use_Notice;
import Elements.PopbitchFirstUseNoticeElements;
import Elements.Popbitch_Wallet_Elements_staging;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Scifi_Transaction {

	

	

	public class scifi_Transaction {


			WebDriver driver_transaction_scifi;
			double expected_balance_global;
			double expected_balance;

			@Given("I am a registered Agate User and I login in to scifi")
			@Test(priority=6)
			@Parameters("browser")
			public void i_am_a_registered_Agate_User_and_I_login_in_to_scifi(String browser) throws IOException, InterruptedException {
			 
				
				
				if(browser.equalsIgnoreCase("firefox")) {
					driver_transaction_scifi = new FirefoxDriver();
				}else if (browser.equalsIgnoreCase("safari")) { 

					driver_transaction_scifi= new SafariDriver();
				} 

				else if (browser.equalsIgnoreCase("chrome")) { 
					driver_transaction_scifi= new ChromeDriver();
				} 
				
				
				System.out.println("\n"+"scifi TRANSACTION"+"\n");
				System.out.println("\n"+""+"\n");
			
				driver_transaction_scifi.get("https://www.scifinow.co.uk/interviews/cocoon-lead-alien-brian-dennehy-the-antagonist-in-a-philosophical-sense-is-non-existence/");
				Thread.sleep(3000);
				String popbitch_navigation= driver_transaction_scifi.getCurrentUrl();
			    try
				{
			    	AssertJUnit.assertTrue(popbitch_navigation.contains("https://www.scifinow.co.uk/interviews/cocoon-lead-alien-brian-dennehy-the-antagonist-in-a-philosophical-sense-is-non-existence/"));
				}catch(AssertionError e0)
				{
					System.out.println("Browser did not open scifi live ");
					throw e0;
				}
			    System.out.println("scifi live is ready to be tested");
				File scrFile = ((TakesScreenshot)driver_transaction_scifi).getScreenshotAs(OutputType.FILE);
				String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				FileUtils.copyFile(scrFile, new File("/Users/jay/Desktop/scifi/"+"_"+timestamp+"_"+"jpg" ));	
			
				Thread.sleep(4000);
				Scifi_First_Use_Notice scifi_first_use = new Scifi_First_Use_Notice(driver_transaction_scifi);
				scifi_first_use.Click_On_scifi_First_use_Login_button();
				System.out.println("\n"+"Clicked on login"+"\n");
			
				Thread.sleep(8000);
				File scrFile5 = ((TakesScreenshot)driver_transaction_scifi).getScreenshotAs(OutputType.FILE);
				String timestamp5 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				FileUtils.copyFile(scrFile5, new File("/Users/jay/Desktop/scifi/"+"_"+timestamp5+"_"+"jpg" ));	
				Thread.sleep(2000);
				String Login_From_PopBitch_Frist_Use_Notice_Current_Url= driver_transaction_scifi.getCurrentUrl();
			    System.out.println("\n"+"Clicking on login redirected to login page satging"+"\n");
			    assertTrue(Login_From_PopBitch_Frist_Use_Notice_Current_Url.contains("https://account.agate.io/my-agate/sign-in?"));
			    System.out.println("\n"+"Successfully navigated to login page"+"\n");
			
			
			    Login_Page_Elements Login_Pop_First_Use = new Login_Page_Elements(driver_transaction_scifi);
				Thread.sleep(2000);
				Login_Pop_First_Use.Login_Process("Ajjukanna1$$");
				Thread.sleep(10000);
				File scrFile6 = ((TakesScreenshot)driver_transaction_scifi).getScreenshotAs(OutputType.FILE);
				String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/scifi/"+"_"+timestamp6+"_"+"jpg" ));	
				System.out.println("\n"+"Login successfull"+"\n");
				
				
			}

			@When("I read a premium article on scifi")
			@Test(priority=7)
			public void i_read_a_premium_article_on_scifi() throws InterruptedException, IOException {
				
				
						Thread.sleep(4000);	
						
					//get screen shot of the wallet
						File scrFile6 = ((TakesScreenshot)driver_transaction_scifi).getScreenshotAs(OutputType.FILE);
						String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
						FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/scifi/"+"_"+timestamp6+"_"+"jpg" ));
						
					//Click on the green tab and 
						PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_scifi);
						pop_first_use_top_up_from_wallet2.click_on_green_tab();
					
					//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
						Thread.sleep(2000);
						Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_scifi); 
						String Balance_after_reading_an_article= wallet_elements_1.current_balance();
						Thread.sleep(1000);
					//convert string balances to double
						double balance_after = Double.parseDouble(Balance_after_reading_an_article);
						expected_balance = 9.75;
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

			@Then("the wallet balance and free point are deducted by x amount on scifi wallet")
			@Test(priority=8)
			public void the_wallet_balance_and_free_point_are_deducted_by_x_amount_on_scifi_wallet() throws InterruptedException {
				//GET FREE POINT AFTER THE TWO TRANSACTIONS
						Thread.sleep(2000);
						Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_scifi); 
						//GET FREE POINT AFTER THE TWO TRANSACTIONS
						Thread.sleep(2000); 
						String free_point_after_1_articles_string= wallet_elements_1.Free_point_free();
						//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
						String Popbitch_expected_free_point_after_2_articles= "Free";
						//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
						//int Popbitch_expected_free_point_after_2_articles= 0;
							
							//Verify if actual free point matches expected free point
								AssertJUnit.assertEquals(free_point_after_1_articles_string,Popbitch_expected_free_point_after_2_articles);
								if(Popbitch_expected_free_point_after_2_articles==free_point_after_1_articles_string)
								{
									System.out.println("Free point is expected to be "+	free_point_after_1_articles_string  );
									
								}
								else
								{
									
									System.out.println("Alert!!! Free point is not expected to be "+free_point_after_1_articles_string+ "please check, it should be " + Popbitch_expected_free_point_after_2_articles );
							
								}
					
					// verify price per article on the wallet
						Thread.sleep(2000);
						String Popbitch_price_per_article= wallet_elements_1.price_per_article_on_wallet();
						int scifi_wallet_actual_price_per_article = Integer.parseInt(Popbitch_price_per_article);
						int scifi_wallet_expected_price_per_article= 25;
					
					//Verify if actual price per article matches expected free point
						AssertJUnit.assertEquals(scifi_wallet_actual_price_per_article,scifi_wallet_expected_price_per_article);
						if(scifi_wallet_actual_price_per_article==scifi_wallet_expected_price_per_article)
						{
							System.out.println("Price per article on the wallet is expected to be "+	scifi_wallet_actual_price_per_article  );
							
						}
						else
						{
							
							System.out.println("Alert!!! Price per article on the wallet is not expected to be "+scifi_wallet_actual_price_per_article+ "please check, it should be " + scifi_wallet_expected_price_per_article );
					
						}
						
						
			}

			@Then("The popbitch wallet balance is updated , same as scifi and free point remains uneffected")
			@Test(priority=9)
			public void the_popbitch_wallet_balance_is_updated_same_as_scifi_and_free_point_remains_uneffected() throws InterruptedException, IOException {
				driver_transaction_scifi.navigate().to("https://popbitch.com/2019/02/tat-for-tits/");
				Thread.sleep(4000);
				//Click on the green tab and 
					PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_scifi);
					pop_first_use_top_up_from_wallet2.click_on_green_tab();
					//get screen shot of the wallet
					File scrFile6 = ((TakesScreenshot)driver_transaction_scifi).getScreenshotAs(OutputType.FILE);
					String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
					FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/Boone/"+"_"+timestamp6+"_"+"jpg" ));
						
				//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
					Thread.sleep(2000);
					Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_scifi); 
					String Balance_after_reading_an_article= wallet_elements_1.current_balance();
					Thread.sleep(1000);
				//convert string balances to double
					double balance_after = Double.parseDouble(Balance_after_reading_an_article);
					expected_balance = 9.75;
				//verify whether the expected balance is the actual balance
					AssertJUnit.assertEquals(expected_balance, balance_after);
					if(balance_after==expected_balance)
					{
						System.out.println("Balance is expected to be "+ balance_after );
								
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
							AssertJUnit.assertEquals(free_point_after_2_articles_string,Popbitch_expected_free_point_after_2_articles);
							if(Popbitch_expected_free_point_after_2_articles==free_point_after_2_articles_string)
							{
								System.out.println("Free point is expected to be "+	free_point_after_2_articles_string  );
								
							}
							else
							{
								
								System.out.println("Alert!!! Free point is not expected to be "+free_point_after_2_articles_string+ "please check, it should be " + Popbitch_expected_free_point_after_2_articles );
						
							}
			}
			
			
			@Then("^Reactions wallet balance is updated and free point remains uneffected as on scifi")
			@Test(priority=10)
			public void Reactions_wallet_balance_is_updated_and_free_point_remains_uneffected_as_on_scifi() throws Throwable {
				
				
				
				
				

				driver_transaction_scifi.navigate().to("https://reaction.life/independent-groups-new-politics-isnt-new/");
			//Click on the green tab and 
				PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_scifi);
				pop_first_use_top_up_from_wallet2.click_on_green_tab();
				
				
			//get screen shot of the wallet
				File scrFile6 = ((TakesScreenshot)driver_transaction_scifi).getScreenshotAs(OutputType.FILE);
				String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/Boone/"+"_"+timestamp6+"_"+"jpg" ));
					
			//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
				Thread.sleep(2000);
				Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_scifi); 
				String Balance_after_reading_an_article= wallet_elements_1.current_balance();
				Thread.sleep(1000);
			//convert string balances to double
				double balance_after = Double.parseDouble(Balance_after_reading_an_article);
				expected_balance = 9.75;
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
						String Popbitch_expected_free_point_after_2_articles= "1.20";
						//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
						//int Popbitch_expected_free_point_after_2_articles= 0;
							
							//Verify if actual free point matches expected free point
								AssertJUnit.assertEquals(Popbitch_expected_free_point_after_2_articles,free_point_after_2_articles_string);
								if(Popbitch_expected_free_point_after_2_articles==free_point_after_2_articles_string)
								{
									System.out.println("Free point is expected to be "+	free_point_after_2_articles_string+"p" );
									
								}
								else
								{
									
									System.out.println("Alert!!! Free point is not expected to be "+free_point_after_2_articles_string+ "please check, it should be " + Popbitch_expected_free_point_after_2_articles );
							
								}
				
				
				System.out.println("\n"+"wallet balance on reaction is "+balance_after+"\n");
				//System.out.println("\n"+"free point on reaction is £1.20"+"\n");
			}

			@Then("Cricketer wallet balance is updated and free point remains unaffected by scifi")
			@Test(priority=11)
			public void cricketer_wallet_balance_is_updated_and_free_point_remains_unaffected_by_scifi() throws InterruptedException, IOException {
				driver_transaction_scifi.navigate().to("https://www.thecricketer.com/Topics/premimum_features/englishman_in_antigua_johnny_grave_is_in_charge_of_west_indies_cricket_trying_to_lead_a_renaissance_and_beating_joe_roots_men_did_no_harm.html");
				//Click on the green tab and 
					PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_scifi);
					pop_first_use_top_up_from_wallet2.click_on_green_tab();
				
				//get screen shot of the wallet
					File scrFile6 = ((TakesScreenshot)driver_transaction_scifi).getScreenshotAs(OutputType.FILE);
					String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
					FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/Boone/"+"_"+timestamp6+"_"+"jpg" ));
						
				//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
					Thread.sleep(2000);
					Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_scifi); 
					String Balance_after_reading_an_article= wallet_elements_1.current_balance();
					Thread.sleep(1000);
				//convert string balances to double
					double balance_after = Double.parseDouble(Balance_after_reading_an_article);
					expected_balance = 9.80;
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
							
					
				//GET FREE POINT AFTER THE TWO TRANSACTIONS
					Thread.sleep(2000); 
					String free_point_after_2_articles_string= wallet_elements_1.Free_point();
					System.out.println("******"+free_point_after_2_articles_string+"****");
					
					//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
					String Popbitch_expected_free_point_after_2_articles= "1.80";
					//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
					//int Popbitch_expected_free_point_after_2_articles= 0;
						
						//Verify if actual free point matches expected free point
							AssertJUnit.assertEquals(free_point_after_2_articles_string,Popbitch_expected_free_point_after_2_articles);
							if(Popbitch_expected_free_point_after_2_articles==free_point_after_2_articles_string)
							{
								System.out.println("Free point is expected to be "+	free_point_after_2_articles_string+"p"  );
								
							}
							else
							{
								
								System.out.println("Alert!!! Free point is not expected to be "+free_point_after_2_articles_string+ "please check, it should be " + Popbitch_expected_free_point_after_2_articles );
						
							}
				
			}

			
			

			@Then("Cornwall wallet balance remains and is uneffected according to scifi")
			@Test(priority=12)
			public void cornwall_wallet_balance_remains_and_is_uneffected_according_to_scifi() throws InterruptedException, IOException {
				driver_transaction_scifi.navigate().to("https://cornwallreports.co.uk/cruel-december-radio-cornwall-back-in-the-doldrums-as-audience-figures-surrender-to-gravity/");
				//Click on the green tab and 
					PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_scifi);
					pop_first_use_top_up_from_wallet2.click_on_green_tab();
				
				//get screen shot of the wallet
					File scrFile6 = ((TakesScreenshot)driver_transaction_scifi).getScreenshotAs(OutputType.FILE);
					String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
					FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/Boone/"+"_"+timestamp6+"_"+"jpg" ));
						
				//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
					Thread.sleep(2000);
					Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_scifi); 
					String Balance_after_reading_an_article= wallet_elements_1.current_balance();
					Thread.sleep(1000);
				//convert string balances to double
					double balance_after = Double.parseDouble(Balance_after_reading_an_article);
					expected_balance = 9.80;
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
							
					
							//GET FREE POINT AFTER THE TWO TRANSACTIONS
							Thread.sleep(2000); 
							String free_point_after_2_articles_string= wallet_elements_1.Free_point();
							//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
							String Popbitch_expected_free_point_after_2_articles= "60";
							//int Popbitch_actual_free_point_after_2_articles = Integer.parseInt(free_point_after_2_articles_string);
							//int Popbitch_expected_free_point_after_2_articles= 0;
								
								//Verify if actual free point matches expected free point
									AssertJUnit.assertEquals(free_point_after_2_articles_string,Popbitch_expected_free_point_after_2_articles);
									if(Popbitch_expected_free_point_after_2_articles==free_point_after_2_articles_string)
									{
										System.out.println("Free point is expected to be "+	free_point_after_2_articles_string+"p"  );
										
									}
									else
									{
										
										System.out.println("Alert!!! Free point is not expected to be "+free_point_after_2_articles_string+ "please check, it should be " + Popbitch_expected_free_point_after_2_articles );
								
									}
					
					
					System.out.println("\n"+"wallet balance on reaction is "+balance_after+"\n");
					//System.out.println("\n"+"free point on reaction is £1.20"+"\n");

			}

			@Then("maidenhead wallet balance remains and is uneffected by scifi")
			@Test(priority=13)
			public void maidenhead_wallet_balance_remains_and_is_uneffected_by_scifi() throws InterruptedException, IOException {
				driver_transaction_scifi.navigate().to("https://www.maidenhead-advertiser.co.uk/news/remember-when/144177/remember-when-when-mary-had-a-little-lamb-and-the-outdoor-pool-closed-for-good.html");
				Thread.sleep(4000);
				//Click on the green tab and 
					PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_scifi);
					pop_first_use_top_up_from_wallet2.click_on_green_tab();
					
					//get screen shot of the wallet
					File scrFile6 = ((TakesScreenshot)driver_transaction_scifi).getScreenshotAs(OutputType.FILE);
					String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
					FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/Boone/"+"_"+timestamp6+"_"+"jpg" ));
						
				//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
					Thread.sleep(2000);
					Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_scifi); 
					String Balance_after_reading_an_article= wallet_elements_1.current_balance();
					Thread.sleep(1000);
				//convert string balances to double
					double balance_after = Double.parseDouble(Balance_after_reading_an_article);
					expected_balance = 9.80;
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

			@Then("Slough wallet balance remains and is uneffected by scifi")
			@Test(priority=14)
			public void slough_wallet_balance_remains_and_is_uneffected_by_scifi() throws InterruptedException, IOException {
				driver_transaction_scifi.navigate().to("https://www.sloughexpress.co.uk/news/remember-when/144177/remember-when-when-mary-had-a-little-lamb-and-the-outdoor-pool-closed-for-good.html");
				Thread.sleep(4000);
				//Click on the green tab and 
					PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_scifi);
					pop_first_use_top_up_from_wallet2.click_on_green_tab();
					
					//get screen shot of the wallet
					File scrFile6 = ((TakesScreenshot)driver_transaction_scifi).getScreenshotAs(OutputType.FILE);
					String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
					FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/Boone/"+"_"+timestamp6+"_"+"jpg" ));
						
				//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
					Thread.sleep(2000);
					Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_scifi); 
					String Balance_after_reading_an_article= wallet_elements_1.current_balance();
					Thread.sleep(1000);
				//convert string balances to double
					double balance_after = Double.parseDouble(Balance_after_reading_an_article);
					expected_balance = 9.80;
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

			@Then("Windsor wallet balance remains and is uneffected by scifi")
			@Test(priority=15)
			public void windsor_wallet_balance_remains_and_is_uneffected_by_scifi() throws InterruptedException, IOException {
				driver_transaction_scifi.navigate().to("https://www.windsorexpress.co.uk/gallery/windsor/143020/public-inquiry-begins-into-proposed-development-on-former-imperial-house-site.html");
				Thread.sleep(4000);
				//Click on the green tab and 
					PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_transaction_scifi);
					pop_first_use_top_up_from_wallet2.click_on_green_tab();
					
					//get screen shot of the wallet
					File scrFile6 = ((TakesScreenshot)driver_transaction_scifi).getScreenshotAs(OutputType.FILE);
					String timestamp6 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
					FileUtils.copyFile(scrFile6, new File("/Users/jay/Desktop/Boone/"+"_"+timestamp6+"_"+"jpg" ));
						
				//get the balance after two transactions. since we topped up with £2 the balance should be 1.50
					Thread.sleep(2000);
					Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_transaction_scifi); 
					String Balance_after_reading_an_article= wallet_elements_1.current_balance();
					Thread.sleep(1000);
				//convert string balances to double
					double balance_after = Double.parseDouble(Balance_after_reading_an_article);
					expected_balance = 9.80;
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



























}

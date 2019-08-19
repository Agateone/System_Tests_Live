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

import Elements.Login_Page_Elements;
import Elements.Iliffe_First_Use_Notice;
import Elements.PopbitchFirstUseNoticeElements;
import Elements.Popbitch_Wallet_Elements_staging;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stamford_Login {
	
	
	
	
	
	



			//INSTANTIATE WEBDRIVER
				WebDriver driver_stamford_login_first_use_notice;
				
				@Given("I am a registered user of stamford and I open a browser")
				@Test(priority=6)
				@Parameters("browser")
			public void i_am_a_registered_user_of_stamford_and_I_open_a_browser(String browser) {
					//If browser is firefox
					if(browser.equalsIgnoreCase("firefox")) {
						driver_stamford_login_first_use_notice = new FirefoxDriver();	
					}
				
				//If browser is safari	
					else if (browser.equalsIgnoreCase("safari")) { 
						driver_stamford_login_first_use_notice= new SafariDriver();
						driver_stamford_login_first_use_notice.manage().window().maximize();
					} 
					
				//If browser is chrome	
					else if (browser.equalsIgnoreCase("chrome")) { 
						driver_stamford_login_first_use_notice= new ChromeDriver();
					} 
			}

			@Given("I navigate to a premium article on stamford")
			@Test(priority=7)
			public void i_navigate_to_a_premium_article_on_stamford() throws IOException, InterruptedException {
				//open a premium article on reaction	
				driver_stamford_login_first_use_notice.get("https://www.stamfordmercury.co.uk/news/army-reservists-learn-animal-first-aid-9062137/");
						Thread.sleep(10000);
						
					//verify that the premium article is opened	
						String reaction_navigation= driver_stamford_login_first_use_notice.getCurrentUrl();
					    try
						{
					    	AssertJUnit.assertTrue(reaction_navigation.contains("https://www.stamfordmercury.co.uk/news/army-reservists-learn-animal-first-aid-9062137/"));
						}catch(AssertionError e0)
						{
							System.out.println("Browser did not open Cricketer ");
							throw e0;
						}
					    System.out.println("The cricketer is ready to be tested");
					
					//scroll for first use notice
					  	JavascriptExecutor js = (JavascriptExecutor)driver_stamford_login_first_use_notice;
					  	js.executeScript("window.scrollBy(0,500)");    
					
					//Screenshot 1 of reaction first use notice
						File scrFile = ((TakesScreenshot)driver_stamford_login_first_use_notice).getScreenshotAs(OutputType.FILE);
						String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
						FileUtils.copyFile(scrFile, new File("/Users/jay/Desktop/stamford/"+"_"+timestamp+"_"+"jpg" ));	
					
					//scroll for full article
						js.executeScript("window.scrollBy(0,500)");
					
					//Screenshot 2 of reaction first use notice
						File scrFile1 = ((TakesScreenshot)driver_stamford_login_first_use_notice).getScreenshotAs(OutputType.FILE);
						String timestamp1 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
						FileUtils.copyFile(scrFile1, new File("/Users/jay/Desktop/stamford/"+"_"+timestamp1+"_"+"jpg" ));	
			}

			@When("I click on Login from stamford First use notice")
			@Test(priority=8)
			public void i_click_on_Login_from_stamford_First_use_notice() throws InterruptedException {
				//call first use notice elements of reaction
						Thread.sleep(15000);
						Iliffe_First_Use_Notice stamford_f_u_n = new Iliffe_First_Use_Notice(driver_stamford_login_first_use_notice);
						stamford_f_u_n.Click_On_Iliffe_First_use_Login_button();
						System.out.println("\n"+"Clicked on stamford Login.. Now lets see if this takes us to login page"+"\n");
			}

			@Then("I verify that the Login Button Navigates me to the login page to log me in to stamford")
			@Test(priority=9)
			public void i_verify_that_the_Login_Button_Navigates_me_to_the_login_page_to_log_me_in_to_stamford() throws IOException, InterruptedException {
				//get screen shot of the login page	
						Thread.sleep(8000);
						System.out.println("Popbitch staging is ready to be tested");
						File scrFile = ((TakesScreenshot)driver_stamford_login_first_use_notice).getScreenshotAs(OutputType.FILE);
						String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
						FileUtils.copyFile(scrFile, new File("/Users/jay/Desktop/stamford/"+"_"+timestamp+"_"+"jpg" ));
						Thread.sleep(2000);
						
					//get current url of login page
						String actual_click_on_login_from_reaction_FUN= driver_stamford_login_first_use_notice.getCurrentUrl();
					
					//verify that the actual url is equal to the expeted url 
					    assertTrue(actual_click_on_login_from_reaction_FUN.contains("https://account.agate.io/my-agate/sign-in?"));
					   if(actual_click_on_login_from_reaction_FUN.contains("https://account.agate.io/my-agate/sign-in?"))
					   {
						   System.out.println("clicking on login button from reaction first use notice, navigated to login page");
						   
					   }
					   else
					   {
						   
						   System.out.println("Alert!!!clicking on login button from stamford first use notice did not navigate to login page.. please check!!");
						   
					   }
			}

			@Then("entering the correct email and password logs me in to stamford")
			@Test(priority=10)
			public void entering_the_correct_email_and_password_logs_me_in_to_stamford() throws IOException, InterruptedException {
				Login_Page_Elements Login_Pop_First_Use = new Login_Page_Elements(driver_stamford_login_first_use_notice);
				Thread.sleep(2000);
				Login_Pop_First_Use.Login_Process("Ajjukanna1$$");
				Thread.sleep(2000);
			//Screenshot 1 of login details from reaction fun
				File scrFile1 = ((TakesScreenshot)driver_stamford_login_first_use_notice).getScreenshotAs(OutputType.FILE);
				String timestamp1 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				FileUtils.copyFile(scrFile1, new File("/Users/jay/Desktop/stamford/"+"_"+timestamp1+"_"+"jpg" ));	
			}

			@Then("verify that I am being navigated to thej  same article on stamford")
			@Test(priority=11)
			public void verify_that_I_am_being_navigated_to_the_same_article_on_stamford() throws IOException, InterruptedException {
				//scroll for first use notice
			  	JavascriptExecutor js2 = (JavascriptExecutor)driver_stamford_login_first_use_notice;
			  	js2.executeScript("window.scrollBy(0,800)"); 
				
				
		/*	//click ok on authorise charge notice
				Thread.sleep(10000);
				Authorise_charge_notice_popbitch authy_popbitch = new Authorise_charge_notice_popbitch(driver_stamford_login_first_use_notice);
				authy_popbitch.authorise_charge_notice_click_continue();
				Thread.sleep(3000);
				*/
				
				
				//Click on the green tab and 
						PopbitchFirstUseNoticeElements pop_first_use_top_up_from_wallet2 = new PopbitchFirstUseNoticeElements(driver_stamford_login_first_use_notice);
						pop_first_use_top_up_from_wallet2.click_on_green_tab();
								
			//check if the wallket is being deducted by 30 p
				Popbitch_Wallet_Elements_staging wallet_elements_1 = new Popbitch_Wallet_Elements_staging(driver_stamford_login_first_use_notice);
				String Balance_after_reading_an_article= wallet_elements_1.current_balance();
								
			//convert string balances to double
				double actual_balance_after_reacding_first_article = Double.parseDouble(Balance_after_reading_an_article);
				double expected_balance_to_be_deducted = 0.20;
				double balance_after_first_article= 9.80;
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
				
								
			//String screenshot_name_3= "Popbitch_full_article_appears";
				String timestamp_3 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
				File scrFile_3 = ((TakesScreenshot)driver_stamford_login_first_use_notice).getScreenshotAs(OutputType.FILE);		
				FileUtils.copyFile(scrFile_3, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp_3+"_"+"jpg" ));
				Thread.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor)driver_stamford_login_first_use_notice;
				js.executeScript("window.scrollBy(0,500)");
								
			//String screenshot_name_4= "Popbitch_full_article_appears_2";
				String timestamp_4 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
								File scrFile_4 = ((TakesScreenshot)driver_stamford_login_first_use_notice).getScreenshotAs(OutputType.FILE);		
								FileUtils.copyFile(scrFile_4, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp_4+"_"+"jpg" ));		
								Thread.sleep(3000);		
					
								JavascriptExecutor js1 = (JavascriptExecutor)driver_stamford_login_first_use_notice;
								js1.executeScript("window.scrollBy(0,500)");		
								String timestamp_5 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
								File scrFile_5 = ((TakesScreenshot)driver_stamford_login_first_use_notice).getScreenshotAs(OutputType.FILE);		
								FileUtils.copyFile(scrFile_5, new File("/Users/jay/Desktop/cricketer/"+"_"+timestamp_5+"_"+"jpg" ));
								Thread.sleep(1000);
								
							//Verify the user landed on the same article
								String Login_From_PopBitch_Frist_Use_Notice_Current_Url1= driver_stamford_login_first_use_notice.getCurrentUrl();	   
							    String Login_From_PopBitch_Frist_Use_Notice_Popbitch_Login_Url1 = "https://www.stamfordmercury.co.uk/news/army-reservists-learn-animal-first-aid-9062137/";
							    AssertJUnit.assertEquals(Login_From_PopBitch_Frist_Use_Notice_Current_Url1, Login_From_PopBitch_Frist_Use_Notice_Popbitch_Login_Url1);
							    System.out.println("\n"+"User presented with complete article"+"\n");
							    Thread.sleep(3000);
							
			}

		}











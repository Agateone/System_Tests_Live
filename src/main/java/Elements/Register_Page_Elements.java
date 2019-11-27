package Elements;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;

public class Register_Page_Elements {
	 static String  randomEmail;
	
	 WebDriver driver_Register_Page_Elements;

	//login page elements finding
	By green_tab= By.id("agateposter");																					
	By Register_Page_email= By.id("email");																															//email text box
	By Register_Page_password= By.id("password");																													//password text box
	By Register_Page_Confirm_Password= By.id("password_confirmation");																									//confirm password textbox
	By Register_Page_topup_3= By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div/form/section[1]/div/div[2]/label[1]");
	By Register_Page_topup_5= By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div/form/section[1]/div/div[2]/label[2]");											//top up 5 button
	By Register_Page_topup_1= By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]");											//top up 5 button
	By Register_Page_pay_by_card=By.className("braintree-option__label");	//card payment button
	By Register_Page_Card_Number= By.name("credit-card-number");			//card number text box
	By Register_Page_Card_Expiry_Date= By.id("expiration");																											//card expiration date textbox
	By Register_Page_Terms_conditions_Checkbox= By.id("terms");																								//Terms & conditions check box
	By Register_Page_Privacy_checkbox= By.id("privacy");																										//privacy check box
	By Register_Page_marketing_checkbox= By.id("marketing_rejection");																									//marketing check box																						//over sixteen check box
	By Register_Page_Register_Button= By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button")	;																									// Register button
	By Register_Page_Find_out_more_cookies= By.linkText("Find out more");	
	
	By Register_Page_Voucher = By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div/form/button[1]/div");
	//find out more link
	
	By Register_Page_country = By.id("country");
	By Register_page_2_Continue = By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[2]/div");
	

	public Register_Page_Elements(WebDriver driver_Register_Page_Elements2) {			//constructor
		this.driver_Register_Page_Elements= driver_Register_Page_Elements2;
	}
	
	public static String randomEmail() {
        return "jay" + UUID.randomUUID().toString() + "+test@gmail.com";
   
        
	}

	
	/*public void Register_Page_Elements_Displayed()										//Elements Display
	{
		Boolean Login_Page_Email_Box_Displayed = driver_Login_Page_Elements.findElement(Login_Page_email).isDisplayed();
		System.out.println(Login_Page_Email_Box_Displayed);
		Boolean Login_Page_Password_box_Displayed = driver_Login_Page_Elements.findElement(Login_Page_password).isDisplayed();
		System.out.println(Login_Page_Password_box_Displayed);
		Boolean Login_Page_Remember_Me_Button_Displayed = driver_Login_Page_Elements.findElement(Login_Page_remember_me).isDisplayed();
		System.out.println(Login_Page_Remember_Me_Button_Displayed);
		Boolean Login_Page_Login_Button_Displayed = driver_Login_Page_Elements.findElement(Login_Page_Login_Button).isDisplayed();
		System.out.println(Login_Page_Login_Button_Displayed);
		Boolean Login_Page_Register_Button_Displayed = driver_Login_Page_Elements.findElement(Login_Page_register).isDisplayed();
		System.out.println(Login_Page_Register_Button_Displayed);
		Boolean Login_Page_Forgot_Password_Link_Displayed = driver_Login_Page_Elements.findElement(Login_Page_forgot_password).isDisplayed();
		System.out.println(Login_Page_Forgot_Password_Link_Displayed);
		Boolean Login_Page_Cookies_FindoutMore_Link_Displayed = driver_Login_Page_Elements.findElement(Login_Page_cookies_findoutmore).isDisplayed();
		System.out.println(Login_Page_Cookies_FindoutMore_Link_Displayed);
	}*/

	
	
	public void Registration_Process() throws InterruptedException, IOException  {		//enter values to Register page elements and hit Register
		
	
		
		randomEmail = randomEmail();
		
		
		
		driver_Register_Page_Elements.findElement(Register_Page_email).sendKeys(randomEmail);
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(Register_Page_password).sendKeys("Ajjukanna1$$");
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(Register_Page_Confirm_Password).sendKeys("Ajjukanna1$$");
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(Register_Page_Terms_conditions_Checkbox).click();
		Thread.sleep(3000);
		driver_Register_Page_Elements.findElement(Register_Page_Privacy_checkbox).click();
		Thread.sleep(3000);
		driver_Register_Page_Elements.findElement(Register_Page_marketing_checkbox).click();
		Thread.sleep(1000);
		Thread.sleep(1000);
		
		
	String url= 	driver_Register_Page_Elements.getCurrentUrl();
		
	if(url.contains("reaction"))
	{
		
	
		
		
		
Thread.sleep(1000);
		
		driver_Register_Page_Elements.findElement(Register_Page_Register_Button).click();
		Thread.sleep(10000);
		
		
		
		
		
		
		//driver_Register_Page_Elements.findElement(Register_Page_topup_3).click();
		//Thread.sleep(2000);
		//driver_Register_Page_Elements.findElement(Register_Page_pay_by_card).click();
		//System.out.println("\n"+"clciked on credit card"+"\n");
		Thread.sleep(5000);
		
		
	//	boolean one_pound_top_up = driver_Register_Page_Elements.findElement(Register_Page_topup_1).isDisplayed();
		
	//	boolean expected_one_pound = false;
		
	//	if(one_pound_top_up==expected_one_pound)
	/*	{
			
			System.out.println("No one pound top up active on reaction ");
			
		}
		else
		{
			System.out.println("1£ top up active on reaction :::: java programm has stopped!!!, Please fix it ");
		       System.exit(1);
			
		}*/
		
		
		
		
		
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div")).click();
		Thread.sleep(2000);
		driver_Register_Page_Elements.findElement(By.id("voucher_code")).sendKeys("jay1234567");
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div/span")).click();
		Thread.sleep(3000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]")).click();
		Thread.sleep(1000);
		
		
		
		
		
		
		
		
		
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-number");
		
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Number).sendKeys("4111111111111111");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-expirationDate");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Expiry_Date).sendKeys("0319");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		
		
		
		
		
		
		
	}	
		
		
	
	if(url.contains("popbitch"))
	{
		
	
		
		
Thread.sleep(1000);
		
		driver_Register_Page_Elements.findElement(Register_Page_Register_Button).click();
		Thread.sleep(10000);
		
		
/*boolean one_pound_top_up = driver_Register_Page_Elements.findElement(Register_Page_topup_1).isDisplayed();
		
		boolean expected_one_pound = false;
		
		if(one_pound_top_up==expected_one_pound)
		{
			
			System.out.println("No one pound top up active on popbitch ");
			
		}
		else
		{
			System.out.println("1£ top up active on popbitch :::: java programm has stopped!!!, Please fix it ");
		       System.exit(1);
			
		}*/
		
		
		
		
		//driver_Register_Page_Elements.findElement(Register_Page_topup_3).click();
		//Thread.sleep(2000);
		//driver_Register_Page_Elements.findElement(Register_Page_pay_by_card).click();
		//System.out.println("\n"+"clciked on credit card"+"\n");
		Thread.sleep(5000);
		
		
		
		
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div")).click();
		Thread.sleep(2000);
		driver_Register_Page_Elements.findElement(By.id("voucher_code")).sendKeys("jay1111");
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div/span")).click();
		Thread.sleep(3000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]")).click();
		Thread.sleep(1000);
		
	
		
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-number");
		
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Number).sendKeys("4111111111111111");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-expirationDate");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Expiry_Date).sendKeys("0319");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		
		
		
		
		
		
		
	}	
	

	if(url.contains("cricketer"))
	{
		
	
Thread.sleep(1000);
		
		driver_Register_Page_Elements.findElement(Register_Page_Register_Button).click();
		Thread.sleep(10000);
		
		
/*boolean one_pound_top_up = driver_Register_Page_Elements.findElement(Register_Page_topup_1).isDisplayed();
		
		boolean expected_one_pound = false;
		
		if(one_pound_top_up==expected_one_pound)
		{
			
			System.out.println("No one pound top up active on cricketer ");
			
		}
		else
		{
			System.out.println("1£ top up active on cricketer :::: java programm has stopped!!!, Please fix it ");
		       System.exit(1);
			
		}*/
		
		
		
		
		//driver_Register_Page_Elements.findElement(Register_Page_topup_3).click();
		//Thread.sleep(2000);
		//driver_Register_Page_Elements.findElement(Register_Page_pay_by_card).click();
		//System.out.println("\n"+"clciked on credit card"+"\n");
		Thread.sleep(5000);
		
		
		
		
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div")).click();
		Thread.sleep(2000);
		driver_Register_Page_Elements.findElement(By.id("voucher_code")).sendKeys("JAY1234567");
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div/span")).click();
		Thread.sleep(3000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]")).click();
		Thread.sleep(1000);
		
	
		
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-number");
		
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Number).sendKeys("4111111111111111");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-expirationDate");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Expiry_Date).sendKeys("0319");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		
		
		
		
		
	}	
	

	if(url.contains("cornwall"))
	{
		
	
		
Thread.sleep(1000);
		
		driver_Register_Page_Elements.findElement(Register_Page_Register_Button).click();
		Thread.sleep(10000);
		
	/*	boolean one_pound_top_up = driver_Register_Page_Elements.findElement(Register_Page_topup_1).isDisplayed();
		
		boolean expected_one_pound = false;
		
		if(one_pound_top_up==expected_one_pound)
		{
			
			System.out.println("1£ top up is not active on cornwall :::: java programm has stopped!!!, Please fix it ");
		       System.exit(1);
			
		}
		else
		{
			System.out.println("one pound top up active on cornwall ");
			
			
		}*/
		
		
		
		//driver_Register_Page_Elements.findElement(Register_Page_topup_3).click();
		//Thread.sleep(2000);
		//driver_Register_Page_Elements.findElement(Register_Page_pay_by_card).click();
		//System.out.println("\n"+"clciked on credit card"+"\n");
		Thread.sleep(5000);
		
		
		
		
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div")).click();
		Thread.sleep(2000);
		driver_Register_Page_Elements.findElement(By.id("voucher_code")).sendKeys("JAY1111");
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div/span")).click();
		Thread.sleep(3000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]")).click();
		Thread.sleep(1000);
		
	
		
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-number");
		
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Number).sendKeys("4111111111111111");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-expirationDate");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Expiry_Date).sendKeys("0319");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		
		
		
		
	}	
	
	if(url.contains("maidenhead"))
	{
		
	
		
Thread.sleep(1000);
		
		driver_Register_Page_Elements.findElement(Register_Page_Register_Button).click();
		Thread.sleep(10000);
		
/*boolean one_pound_top_up = driver_Register_Page_Elements.findElement(Register_Page_topup_1).isDisplayed();
		
		boolean expected_one_pound = false;
		
		if(one_pound_top_up==expected_one_pound)
		{
			
			System.out.println("1£ top up is not active on cornwall :::: java programm has stopped!!!, Please fix it ");
		       System.exit(1);
			
		}
		else
		{
			System.out.println("one pound top up active on cornwall ");
			
			
		}
		
		//driver_Register_Page_Elements.findElement(Register_Page_topup_3).click();
		//Thread.sleep(2000);
		//driver_Register_Page_Elements.findElement(Register_Page_pay_by_card).click();
		//System.out.println("\n"+"clciked on credit card"+"\n");
		Thread.sleep(5000);*/
		
		
		
		
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div")).click();
		Thread.sleep(2000);
		driver_Register_Page_Elements.findElement(By.id("voucher_code")).sendKeys("JAY1234567");
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div/span")).click();
		Thread.sleep(3000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]")).click();
		Thread.sleep(1000);
		
	
		
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-number");
		
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Number).sendKeys("4111111111111111");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-expirationDate");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Expiry_Date).sendKeys("0319");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		
		
		
	
		
		
	}	
	
	
	if(url.contains("slough"))
	{
		
	
Thread.sleep(1000);
		
		driver_Register_Page_Elements.findElement(Register_Page_Register_Button).click();
		Thread.sleep(10000);
		
/*boolean one_pound_top_up = driver_Register_Page_Elements.findElement(Register_Page_topup_1).isDisplayed();
		
		boolean expected_one_pound = false;
		
		if(one_pound_top_up==expected_one_pound)
		{
			
			System.out.println("1£ top up is not active on cornwall :::: java programm has stopped!!!, Please fix it ");
		       System.exit(1);
			
		}
		else
		{
			System.out.println("one pound top up active on cornwall ");
			
			
		}
		
		//driver_Register_Page_Elements.findElement(Register_Page_topup_3).click();
		//Thread.sleep(2000);
		//driver_Register_Page_Elements.findElement(Register_Page_pay_by_card).click();
		//System.out.println("\n"+"clciked on credit card"+"\n");
		Thread.sleep(5000);*/
		
		
		
		
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div")).click();
		Thread.sleep(2000);
		driver_Register_Page_Elements.findElement(By.id("voucher_code")).sendKeys("JAY1234567");
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div/span")).click();
		Thread.sleep(3000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]")).click();
		Thread.sleep(1000);
		
	
		
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-number");
		
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Number).sendKeys("4111111111111111");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-expirationDate");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Expiry_Date).sendKeys("0319");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		
		
		
		
		
		
	}	
	
	if(url.contains("windsor"))
	{
		
	
		
Thread.sleep(1000);
		
		driver_Register_Page_Elements.findElement(Register_Page_Register_Button).click();
		Thread.sleep(10000);
		
		
/*boolean one_pound_top_up = driver_Register_Page_Elements.findElement(Register_Page_topup_1).isDisplayed();
		
		boolean expected_one_pound = false;
		
		if(one_pound_top_up==expected_one_pound)
		{
			
			System.out.println("1£ top up is not active on cornwall :::: java programm has stopped!!!, Please fix it ");
		       System.exit(1);
			
		}
		else
		{
			System.out.println("one pound top up active on cornwall ");
			
			
		}
		
		
		//driver_Register_Page_Elements.findElement(Register_Page_topup_3).click();
		//Thread.sleep(2000);
		//driver_Register_Page_Elements.findElement(Register_Page_pay_by_card).click();
		//System.out.println("\n"+"clciked on credit card"+"\n");
		Thread.sleep(5000);*/
		
		
		
		
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div")).click();
		Thread.sleep(2000);
		driver_Register_Page_Elements.findElement(By.id("voucher_code")).sendKeys("JAY1234567");
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div/span")).click();
		Thread.sleep(3000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]")).click();
		Thread.sleep(1000);
		
	
		
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-number");
		
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Number).sendKeys("4111111111111111");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-expirationDate");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Expiry_Date).sendKeys("0319");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		
		
		
		
		
		
	}	
	
	
	if(url.contains("newburytoday"))
	{
		
	
		
		
/*Thread.sleep(1000);
		
		driver_Register_Page_Elements.findElement(Register_Page_Register_Button).click();
		Thread.sleep(10000);
		
		
boolean one_pound_top_up = driver_Register_Page_Elements.findElement(Register_Page_topup_1).isDisplayed();
		
		boolean expected_one_pound = false;
		
		if(one_pound_top_up==expected_one_pound)
		{
			
			System.out.println("1£ top up is not active on newbury :::: java programm has stopped!!!, Please fix it ");
		       System.exit(1);
			
		}
		else
		{
			System.out.println("one pound top up active on newbury ");
			
			
		}
		
		//driver_Register_Page_Elements.findElement(Register_Page_topup_3).click();
		//Thread.sleep(2000);
		//driver_Register_Page_Elements.findElement(Register_Page_pay_by_card).click();
		//System.out.println("\n"+"clciked on credit card"+"\n");
		Thread.sleep(5000);*/
		
		
		
		
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div")).click();
		Thread.sleep(2000);
		driver_Register_Page_Elements.findElement(By.id("voucher_code")).sendKeys("jay1111");
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div/span")).click();
		Thread.sleep(3000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]")).click();
		Thread.sleep(1000);
		
	
		
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-number");
		
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Number).sendKeys("4111111111111111");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-expirationDate");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Expiry_Date).sendKeys("0319");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		
		
		
		
		
	}	
	
	
	if(url.contains("roanoke-chowannewsherald"))
	{
	
		
Thread.sleep(1000);
		
		driver_Register_Page_Elements.findElement(Register_Page_Register_Button).click();
		Thread.sleep(10000);
		
		
		
		
		//driver_Register_Page_Elements.findElement(Register_Page_topup_3).click();
		//Thread.sleep(2000);
		//driver_Register_Page_Elements.findElement(Register_Page_pay_by_card).click();
		//System.out.println("\n"+"clciked on credit card"+"\n");
		Thread.sleep(5000);
		
		
		
		
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div")).click();
		Thread.sleep(2000);
		driver_Register_Page_Elements.findElement(By.id("voucher_code")).sendKeys("jay1111");
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div/span")).click();
		Thread.sleep(3000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]")).click();
		Thread.sleep(1000);
		
	
		
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-number");
		
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Number).sendKeys("4111111111111111");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-expirationDate");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Expiry_Date).sendKeys("0319");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		
		
		
		
	}	
	
	
	
	if(url.contains("scifinow"))
	{
		
	
		
Thread.sleep(1000);
		
		driver_Register_Page_Elements.findElement(Register_Page_Register_Button).click();
		Thread.sleep(10000);
		
		//Screenshot
		//String screenshot_name_2= "Registration_step1_2";
		String timestamp_2 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_2 = ((TakesScreenshot)driver_Register_Page_Elements).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile_2, new File("/Users/jay/Desktop/scifi/"+"_"+timestamp_2+"_"+"jpg" ));
		
		
		
		
		//driver_Register_Page_Elements.findElement(Register_Page_topup_3).click();
		//Thread.sleep(2000);
		//driver_Register_Page_Elements.findElement(Register_Page_pay_by_card).click();
		//System.out.println("\n"+"clciked on credit card"+"\n");
		Thread.sleep(5000);
		
		
		
		
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div")).click();
		Thread.sleep(2000);
		driver_Register_Page_Elements.findElement(By.id("voucher_code")).sendKeys("jay1111");
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div/span")).click();
		Thread.sleep(3000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]")).click();
		Thread.sleep(1000);
		
	
		
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-number");
		
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Number).sendKeys("4111111111111111");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-expirationDate");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Expiry_Date).sendKeys("0319");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		
		
		
		//Screenshot
		//String screenshot_name_3= "Registration_step1_2";
		String timestamp_3 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_3 = ((TakesScreenshot)driver_Register_Page_Elements).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile_3, new File("/Users/jay/Desktop/scifi/" +"_"+timestamp_3+"_"+"jpg" ));
		
		
		
	}	
	
	if(url.contains("examinerlive"))
	{	
		
		driver_Register_Page_Elements.findElement(Register_Page_Register_Button).click();
		Thread.sleep(10000);
		
		
/*boolean one_pound_top_up = driver_Register_Page_Elements.findElement(Register_Page_topup_1).isDisplayed();
		
		boolean expected_one_pound = false;
		
		if(one_pound_top_up==expected_one_pound)
		{
			
			System.out.println("1£ top up is not active on cornwall :::: java programm has stopped!!!, Please fix it ");
		       System.exit(1);
			
		}
		else
		{
			System.out.println("one pound top up active on cornwall ");
			
			
		}*/
		
		driver_Register_Page_Elements.findElement(Register_Page_topup_1).click();
		Thread.sleep(2000);
		driver_Register_Page_Elements.findElement(Register_Page_pay_by_card).click();
		System.out.println("\n"+"clciked on credit card"+"\n");
		Thread.sleep(5000);
			
		//driver_Register_Page_Elements.findElement(Register_Page_topup_3).click();
		//Thread.sleep(2000);
		//driver_Register_Page_Elements.findElement(Register_Page_pay_by_card).click();
		//System.out.println("\n"+"clciked on credit card"+"\n");
		//Thread.sleep(5000);		
		//driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div")).click();
		//Thread.sleep(2000);
		//driver_Register_Page_Elements.findElement(By.id("voucher_code")).sendKeys("jay1111");
		//Thread.sleep(1000);
		//driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div/span")).click();
		//Thread.sleep(3000);
		//driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]")).click();
		//Thread.sleep(1000);		
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-number");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Number).sendKeys("4111111111111111");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-expirationDate");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Expiry_Date).sendKeys("0319");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();		
		//Screenshot
		//String screenshot_name_3= "Registration_step1_2";
		
driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-number");
		
		driver_Register_Page_Elements.findElement(Register_Page_Card_Number).sendKeys("4751290228503710");
		Thread.sleep(400);
		driver_Register_Page_Elements.switchTo().defaultContent();
		driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-expirationDate");
		driver_Register_Page_Elements.findElement(Register_Page_Card_Expiry_Date).sendKeys("0223");
		driver_Register_Page_Elements.switchTo().defaultContent();
		Thread.sleep(400);
		
		driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-cvv");
		
		driver_Register_Page_Elements.findElement(By.id("cvv")).sendKeys("986");
		driver_Register_Page_Elements.switchTo().defaultContent();
		Thread.sleep(400);
		
		driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-postalCode");
		
		driver_Register_Page_Elements.findElement(By.id("postal-code")).sendKeys("Hp22 7BH");
		
		driver_Register_Page_Elements.switchTo().defaultContent();
		
		
		
	}	
	
	
	if(url.contains("grantham"))
	{	
		
		
		
				
Thread.sleep(1000);		
		driver_Register_Page_Elements.findElement(Register_Page_Register_Button).click();
		Thread.sleep(10000);
		
/*boolean one_pound_top_up = driver_Register_Page_Elements.findElement(Register_Page_topup_1).isDisplayed();
		
		boolean expected_one_pound = false;
		
		if(one_pound_top_up==expected_one_pound)
		{
			
			System.out.println("1£ top up is not active on cornwall :::: java programm has stopped!!!, Please fix it ");
		       System.exit(1);
			
		}
		else
		{
			System.out.println("one pound top up active on cornwall ");
			
			
		}*/
		
		//driver_Register_Page_Elements.findElement(Register_Page_topup_3).click();
		//Thread.sleep(2000);
		//driver_Register_Page_Elements.findElement(Register_Page_pay_by_card).click();
		//System.out.println("\n"+"clciked on credit card"+"\n");
		Thread.sleep(5000);		
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div")).click();
		Thread.sleep(2000);
		driver_Register_Page_Elements.findElement(By.id("voucher_code")).sendKeys("jay1111");
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div/span")).click();
		Thread.sleep(3000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]")).click();
		Thread.sleep(1000);		
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-number");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Number).sendKeys("4111111111111111");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-expirationDate");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Expiry_Date).sendKeys("0319");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();		
		//Screenshot
		//String screenshot_name_3= "Registration_step1_2";
		String timestamp_3 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_3 = ((TakesScreenshot)driver_Register_Page_Elements).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile_3, new File("/Users/jay/Desktop/grantham/" +"_"+timestamp_3+"_"+"jpg" ));
		
	}	
	
	
	
	if(url.contains("stamfordmercury"))
	{	
boolean one_pound_top_up = driver_Register_Page_Elements.findElement(Register_Page_topup_1).isDisplayed();
		
		boolean expected_one_pound = false;
		
		if(one_pound_top_up==expected_one_pound)
		{
			
			System.out.println("1£ top up is not active on cornwall :::: java programm has stopped!!!, Please fix it ");
		       System.exit(1);
			
		}
		else
		{
			System.out.println("one pound top up active on cornwall ");
			
			
		}
		
		
		//Screenshot
		//String screenshot_name_1= "Registration_step1_2";
		String timestamp_1 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_1 = ((TakesScreenshot)driver_Register_Page_Elements).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile_1, new File("/Users/jay/Desktop/stamfordmercury/" +"_"+timestamp_1+"_"+"jpg" ));		
Thread.sleep(1000);		
		driver_Register_Page_Elements.findElement(Register_Page_Register_Button).click();
		Thread.sleep(10000);
		//Screenshot
		//String screenshot_name_2= "Registration_step1_2";
		String timestamp_2 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_2 = ((TakesScreenshot)driver_Register_Page_Elements).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile_2, new File("/Users/jay/Desktop/stamfordmercury/"+"_"+timestamp_2+"_"+"jpg" ));		
		//driver_Register_Page_Elements.findElement(Register_Page_topup_3).click();
		//Thread.sleep(2000);
		//driver_Register_Page_Elements.findElement(Register_Page_pay_by_card).click();
		//System.out.println("\n"+"clciked on credit card"+"\n");
		Thread.sleep(5000);		
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div")).click();
		Thread.sleep(2000);
		driver_Register_Page_Elements.findElement(By.id("voucher_code")).sendKeys("jay1111");
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div/span")).click();
		Thread.sleep(3000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]")).click();
		Thread.sleep(1000);		
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-number");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Number).sendKeys("4111111111111111");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-expirationDate");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Expiry_Date).sendKeys("0319");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();		
		//Screenshot
		//String screenshot_name_3= "Registration_step1_2";
		String timestamp_3 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_3 = ((TakesScreenshot)driver_Register_Page_Elements).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile_3, new File("/Users/jay/Desktop/stamfordmercury/" +"_"+timestamp_3+"_"+"jpg" ));
		
	}	
	
	if(url.contains("spaldingtoday"))
	{	
		
boolean one_pound_top_up = driver_Register_Page_Elements.findElement(Register_Page_topup_1).isDisplayed();
		
		boolean expected_one_pound = false;
		
		if(one_pound_top_up==expected_one_pound)
		{
			
			System.out.println("1£ top up is not active on cornwall :::: java programm has stopped!!!, Please fix it ");
		       System.exit(1);
			
		}
		else
		{
			System.out.println("one pound top up active on cornwall ");
			
			
		}
		
		
		//Screenshot
		//String screenshot_name_1= "Registration_step1_2";
		String timestamp_1 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_1 = ((TakesScreenshot)driver_Register_Page_Elements).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile_1, new File("/Users/jay/Desktop/spalding/" +"_"+timestamp_1+"_"+"jpg" ));		
Thread.sleep(1000);		
		driver_Register_Page_Elements.findElement(Register_Page_Register_Button).click();
		Thread.sleep(10000);
		//Screenshot
		//String screenshot_name_2= "Registration_step1_2";
		String timestamp_2 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_2 = ((TakesScreenshot)driver_Register_Page_Elements).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile_2, new File("/Users/jay/Desktop/spalding/"+"_"+timestamp_2+"_"+"jpg" ));		
		//driver_Register_Page_Elements.findElement(Register_Page_topup_3).click();
		//Thread.sleep(2000);
		//driver_Register_Page_Elements.findElement(Register_Page_pay_by_card).click();
		//System.out.println("\n"+"clciked on credit card"+"\n");
		Thread.sleep(5000);		
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div")).click();
		Thread.sleep(2000);
		driver_Register_Page_Elements.findElement(By.id("voucher_code")).sendKeys("jay1111");
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div/span")).click();
		Thread.sleep(3000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]")).click();
		Thread.sleep(1000);		
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-number");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Number).sendKeys("4111111111111111");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-expirationDate");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Expiry_Date).sendKeys("0319");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();		
		//Screenshot
		//String screenshot_name_3= "Registration_step1_2";
		String timestamp_3 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_3 = ((TakesScreenshot)driver_Register_Page_Elements).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile_3, new File("/Users/jay/Desktop/spalding/" +"_"+timestamp_3+"_"+"jpg" ));
		
	}	
	
	if(url.contains("fenlandcitizen"))
	{	
		
boolean one_pound_top_up = driver_Register_Page_Elements.findElement(Register_Page_topup_1).isDisplayed();
		
		boolean expected_one_pound = false;
		
		if(one_pound_top_up==expected_one_pound)
		{
			
			System.out.println("1£ top up is not active on cornwall :::: java programm has stopped!!!, Please fix it ");
		       System.exit(1);
			
		}
		else
		{
			System.out.println("one pound top up active on cornwall ");
			
			
		}
		
		
		//Screenshot
		//String screenshot_name_1= "Registration_step1_2";
		String timestamp_1 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_1 = ((TakesScreenshot)driver_Register_Page_Elements).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile_1, new File("/Users/jay/Desktop/fenland/" +"_"+timestamp_1+"_"+"jpg" ));		
Thread.sleep(1000);		
		driver_Register_Page_Elements.findElement(Register_Page_Register_Button).click();
		Thread.sleep(10000);
		//Screenshot
		//String screenshot_name_2= "Registration_step1_2";
		String timestamp_2 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_2 = ((TakesScreenshot)driver_Register_Page_Elements).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile_2, new File("/Users/jay/Desktop/fenland/"+"_"+timestamp_2+"_"+"jpg" ));		
		//driver_Register_Page_Elements.findElement(Register_Page_topup_3).click();
		//Thread.sleep(2000);
		//driver_Register_Page_Elements.findElement(Register_Page_pay_by_card).click();
		//System.out.println("\n"+"clciked on credit card"+"\n");
		Thread.sleep(5000);		
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div")).click();
		Thread.sleep(2000);
		driver_Register_Page_Elements.findElement(By.id("voucher_code")).sendKeys("jay1111");
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div/span")).click();
		Thread.sleep(3000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]")).click();
		Thread.sleep(1000);		
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-number");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Number).sendKeys("4111111111111111");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-expirationDate");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Expiry_Date).sendKeys("0319");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();		
		//Screenshot
		//String screenshot_name_3= "Registration_step1_2";
		String timestamp_3 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_3 = ((TakesScreenshot)driver_Register_Page_Elements).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile_3, new File("/Users/jay/Desktop/fenland/" +"_"+timestamp_3+"_"+"jpg" ));
		
	}	
	
	
	if(url.contains("newarkadvertiser"))
	{	
		
boolean one_pound_top_up = driver_Register_Page_Elements.findElement(Register_Page_topup_1).isDisplayed();
		
		boolean expected_one_pound = false;
		
		if(one_pound_top_up==expected_one_pound)
		{
			
			System.out.println("1£ top up is not active on cornwall :::: java programm has stopped!!!, Please fix it ");
		       System.exit(1);
			
		}
		else
		{
			System.out.println("one pound top up active on cornwall ");
			
			
		}
		
		
		
		
		//Screenshot
		//String screenshot_name_1= "Registration_step1_2";
		String timestamp_1 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_1 = ((TakesScreenshot)driver_Register_Page_Elements).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile_1, new File("/Users/jay/Desktop/newark/" +"_"+timestamp_1+"_"+"jpg" ));		
Thread.sleep(1000);		
		driver_Register_Page_Elements.findElement(Register_Page_Register_Button).click();
		Thread.sleep(10000);
		//Screenshot
		//String screenshot_name_2= "Registration_step1_2";
		String timestamp_2 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_2 = ((TakesScreenshot)driver_Register_Page_Elements).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile_2, new File("/Users/jay/Desktop/newark/"+"_"+timestamp_2+"_"+"jpg" ));		
		//driver_Register_Page_Elements.findElement(Register_Page_topup_3).click();
		//Thread.sleep(2000);
		//driver_Register_Page_Elements.findElement(Register_Page_pay_by_card).click();
		//System.out.println("\n"+"clciked on credit card"+"\n");
		Thread.sleep(5000);		
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div")).click();
		Thread.sleep(2000);
		driver_Register_Page_Elements.findElement(By.id("voucher_code")).sendKeys("jay1111");
		Thread.sleep(1000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div/span")).click();
		Thread.sleep(3000);
		driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]")).click();
		Thread.sleep(1000);		
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-number");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Number).sendKeys("4111111111111111");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();
		//driver_Register_Page_Elements.switchTo().frame("braintree-hosted-field-expirationDate");
		//driver_Register_Page_Elements.findElement(Register_Page_Card_Expiry_Date).sendKeys("0319");
		//Thread.sleep(400);
		//driver_Register_Page_Elements.switchTo().defaultContent();		
		//Screenshot
		//String screenshot_name_3= "Registration_step1_2";
		String timestamp_3 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
		File scrFile_3 = ((TakesScreenshot)driver_Register_Page_Elements).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile_3, new File("/Users/jay/Desktop/newark/" +"_"+timestamp_3+"_"+"jpg" ));
		
	}	
	Thread.sleep(10000);
		driver_Register_Page_Elements.findElement(Register_page_2_Continue).click();
		
		System.out.println("\n"+"Registered with the email "+ randomEmail +"\n");
		
	}
	
	
	
	

	

	public void wait_untill_page_has_loaded() throws InterruptedException									//Click Register from login page
	{
		
		
		
		Thread.sleep(12000);
		WebElement email = driver_Register_Page_Elements.findElement(Register_Page_email);
		Boolean email_displayed = email.isDisplayed();
		if(email_displayed==true)
		{
			System.out.println("navigated to registration page");
		}
		else
		{
			System.out.println("did not navigate to registration page, please check ");
		}
		
	}

	/*public void Capture_Login_Details() {											//display values of login page elements
		String Login_Page_email_value = driver_Login_Page_Elements.findElement(Login_Page_email).getAttribute("value");
		System.out.println(Login_Page_email_value);
		String Login_Page_password_value= driver_Login_Page_Elements.findElement(Login_Page_password).getAttribute("value");
		System.out.println(Login_Page_password_value);
		driver_Login_Page_Elements.findElement(Login_Page_remember_me).isSelected();
	}
			
	public void Click_On_Register_From_Login_Page()									//Click Register from login page
	{
		driver_Login_Page_Elements.findElement(Login_Page_register).click();
	}

	public void Click_on_Forgot_Password_link()										//Click on Forgot password from login page
	{
		driver_Login_Page_Elements.findElement(Login_Page_forgot_password).click();
	}

	public void Click_On_Login_Page_Find_out_More()
	{								//Find out more of cookies from login page
		driver_Login_Page_Elements.findElement(Login_Page_cookies_findoutmore).click();
	}
*/
	
	}
	

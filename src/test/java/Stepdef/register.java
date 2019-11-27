package Stepdef;

import java.io.IOException;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class register {
	
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
		
	
	public static String randomEmail() {
        return "jay" + UUID.randomUUID().toString() + "+test@gmail.com";
   
        
	}
	
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
	
	
Thread.sleep(1000);
	
	driver_Register_Page_Elements.findElement(Register_Page_Register_Button).click();
	Thread.sleep(10000);
	driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div")).click();
	Thread.sleep(2000);
	driver_Register_Page_Elements.findElement(By.id("voucher_code")).sendKeys("jay1234567");
	Thread.sleep(1000);
	driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/button[1]/div/span")).click();
	Thread.sleep(3000);
	driver_Register_Page_Elements.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/section[1]/div/div[2]/label[1]")).click();
	Thread.sleep(1000);
	Thread.sleep(10000);
	driver_Register_Page_Elements.findElement(Register_page_2_Continue).click();
	
	System.out.println("\n"+"Registered with the email "+ randomEmail +"\n");
}
	
}

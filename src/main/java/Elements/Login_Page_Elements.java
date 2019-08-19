package Elements;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Login_Page_Elements {
WebDriver driver_Login_Page_Elements;

//login page elements finding
By green_tab= By.id("agateposter");																					
By Login_Page_email= By.id("email");											//email text box
By Login_Page_password= By.id("password");										//password text box
By Login_Page_remember_me= By.name("remember");									//remember me check box
By Login_Page_Login_Button= By.id("signInSubmit");								//sign in button
By Login_Page_register= By.linkText("Not registered? Register now!");			//Register link
By Login_Page_forgot_password= By.xpath("//*[@id=\"app\"]/div[2]/div/div/div/div[2]/form/div[6]/div/a[2]");			//forgot password link
By Login_Page_cookies_findoutmore=By.linkText("Find out more");					//find out more cookies link

public Login_Page_Elements(WebDriver driver_Login_Page_Elements2) {				//constructor
	this.driver_Login_Page_Elements= driver_Login_Page_Elements2;
}

public void Login_Page_Elements_Displayed()										//Elements Display
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
}



public void Login_Process(String login_password1) throws IOException, InterruptedException {	//enter values to login page elements and hit submit
	
	
	
	
	
	
	String elements= Register_Page_Elements.randomEmail;
	System.out.println(elements);
	
	
	
	driver_Login_Page_Elements.findElement(Login_Page_email).sendKeys(elements);
	driver_Login_Page_Elements.findElement(Login_Page_password).sendKeys(login_password1);
	driver_Login_Page_Elements.findElement(Login_Page_remember_me).click();
	Thread.sleep(2000);
	File scrFile = ((TakesScreenshot)driver_Login_Page_Elements).getScreenshotAs(OutputType.FILE);
	String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
	FileUtils.copyFile(scrFile, new File("/Users/jay/Desktop/api/"+"_"+timestamp+"_"+"jpg" ));	
	driver_Login_Page_Elements.findElement(Login_Page_Login_Button).click();
	}


public void Capture_Login_Details() {											//display values of login page elements
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

}

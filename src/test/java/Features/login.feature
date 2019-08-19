Feature: Successfull login 

 
Scenario: Testcase 147 Login from First use notice popbitch 
Given I am a registered user , I open the browser
And I navigate to popbitch.com 
When I click on the Stories Menu
And I click on the Premium Story
And I Click on Login to Agate from the Pop Bitch First use notice
Then I verify that the Login Button Navigates me to the login page

Scenario: Testcase 148 All elements in the logn page are displayed
And I verify that the email textbox is displayed
And I verify that the password textbox is displayed
And I verify that the login button is displayed 
And I verify that the remember me button is displayed
And I verify that the register link is displayed
And I verify that the forgot password link is displayed
And I verify that the find  out more link regarding cookies in displayed

Scenario: Testcase 149 Successfull login from First use notice with Correct email and correct password
And I Login with correct Details
Then I verify that I am navigated to the full article














 



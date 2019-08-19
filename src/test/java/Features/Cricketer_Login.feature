Feature: Successfull login on cricketer 

 
Scenario: Testcase Login from First use notice Cricketer
Given I am a registered user of Cricketer and I open a browser
And I navigate to a premium article on Cricketer
When I click on Login from Cricketer First use notice
Then I verify that the Login Button Navigates me to the login page to log me in to Cricketer
And entering the correct email and password logs me in to Cricketer
And verify that I am being navigated to the same article on cricketer
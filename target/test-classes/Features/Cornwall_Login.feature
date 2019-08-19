Feature: Successfull login on Cornwall 

 
Scenario: Testcase Login from First use notice Cornwall
Given I am a registered user of Cornwall and I open a browser
And I navigate to a premium article on Cornwall
When I click on Login from Cornwall First use notice
Then I verify that the Login Button Navigates me to the login page to log me in to Cornwall
And entering the correct email and password logs me in to Cornwall
And verify that I am being navigated to the same article on Cornwall
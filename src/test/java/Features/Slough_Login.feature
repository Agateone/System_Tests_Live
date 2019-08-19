Feature: Successfull login on Maidenhead 

 
Scenario: Testcase Login from First use notice slough
Given I am a registered user of slough and I open a browser
And I navigate to a premium article on slough
When I click on Login from slough First use notice
Then I verify that the Login Button Navigates me to the login page to log me in to slough
And entering the correct email and password logs me in to slough
And verify that I am being navigated to the same article on slough
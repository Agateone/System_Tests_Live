Feature: Successfull login on Maidenhead 

 
Scenario: Testcase Login from First use notice Maidenhead
Given I am a registered user of Maidenhead and I open a browser
And I navigate to a premium article on Maidenhead
When I click on Login from Maidenhead First use notice
Then I verify that the Login Button Navigates me to the login page to log me in to Maidenhead
And entering the correct email and password logs me in to Maidenhead
And verify that I am being navigated to the same article on Maidenhead
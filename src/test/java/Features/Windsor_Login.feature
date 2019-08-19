Feature: Successfull login on Windsor 

 
Scenario: Testcase Login from First use notice slough
Given I am a registered user of Windsor and I open a browser
And I navigate to a premium article on Windsor
When I click on Login from Windsor First use notice
Then I verify that the Login Button Navigates me to the login page to log me in to windsor
And entering the correct email and password logs me in to windsor
And verify that I am being navigated to the same article on windsor
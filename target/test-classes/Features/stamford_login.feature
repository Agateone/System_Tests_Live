Feature: Successfull login on stamford 

 
Scenario: Testcase Login from First use notice stamford
Given I am a registered user of stamford and I open a browser
And I navigate to a premium article on stamford
When I click on Login from stamford First use notice
Then I verify that the Login Button Navigates me to the login page to log me in to stamford
And entering the correct email and password logs me in to stamford
And verify that I am being navigated to the same article on stamford
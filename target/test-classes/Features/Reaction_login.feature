Feature: Successfull login 

 
Scenario: Testcase Login from First use notice Reaction 
Given I am a registered user of reaction and I open a browser
And I navigate to a premium article on reaction.life 
When I click on Login from reaction First use notice
Then I verify that the Login Button Navigates me to the login page to log me in to reaction
And entering the correct email and password logs me in to reaction
And verify that I am being navigated to the same article 
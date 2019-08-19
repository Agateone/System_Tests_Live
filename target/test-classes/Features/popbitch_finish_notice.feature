Feature: Popbitch finish notice



Scenario: finish notice elements are all displayed
Given I am not a user of Agate I open a browser
And I navigate to popbitch.com from the browser
And I click on the stories menu on from the homepage
And I click on any of the premium articles
Then I click on the create agate wallet from the first use notice
Then I verify that the create wallet button navigates me to the sign up page 
When I enter the correct details and hit the Register button
Then I login successfully
And Finish Notice appears

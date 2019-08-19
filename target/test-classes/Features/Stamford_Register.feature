Feature: Register from stamford first use notice



Scenario: Register from stamford first use notice staging 
Given I am not a user of agate on stamford and I open a browser
And I navigate to a premium article on stamford
And I click on the create wallet button on stamford
And I verify that the create wallet button takes me to the reg page on stamford
When I enter all the details successfully on reg page of stamford 
Then I am registered as an agate user on stamford successfully and I am shown a first use notice
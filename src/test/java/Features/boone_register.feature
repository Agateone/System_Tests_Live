Feature: Register from Boone first use notice



Scenario: Register from boone first use notice staging 
Given I am not a user of agate on boone and I open a browser
And I navigate to a premium article on boone
And I click on the create wallet button on boone
And I verify that the create wallet button takes me to the reg page on boone
When I enter all the details successfully on reg page on boone
Then I am registered as an agate user on boone successfully and I am shown a first use notice
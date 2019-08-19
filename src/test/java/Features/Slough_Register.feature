Feature: Register from Slough first use notice



Scenario: Register from Slough first use notice staging 
Given I am not a user of agate on Slough and I open a browser
And I navigate to a premium article on Slough
And I click on the create wallet button on Slough
And I verify that the create wallet button takes me to the reg page on Slough
When I enter all the details successfully on reg page on slough
Then I am registered as an agate user on Slough successfully and I am shown a first use notice
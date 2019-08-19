Feature: Register from windsor first use notice



Scenario: Register from Slough first use notice staging 
Given I am not a user of agate on windsor and I open a browser
And I navigate to a premium article on windsor
And I click on the create wallet button on windsor
And I verify that the create wallet button takes me to the reg page on windsor
When I enter all the details successfully on reg page on windsor
Then I am registered as an agate user on windsor successfully and I am shown a first use notice
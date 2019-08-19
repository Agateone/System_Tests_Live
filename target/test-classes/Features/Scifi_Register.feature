Feature: Register from Scifi first use notice



Scenario: Register from Scifi first use notice staging 
Given I am not a user of agate on Scifi and I open a browser
And I navigate to a premium article on Scifi
And I click on the create wallet button on Scifi
And I verify that the create wallet button takes me to the reg page on Scifi
When I enter all the details successfully on reg page on Scifi
Then I am registered as an agate user on Scifi successfully and I am shown a first use notice
Feature: Register from Maidenhead first use notice



Scenario: Register from maidenhead first use notice staging 
Given I am not a user of agate on maidenhead and I open a browser
And I navigate to a premium article on maidenhead
And I click on the create wallet button on maidenhead
And I verify that the create wallet button takes me to the reg page on maidenhead
When I enter all the details successfully on reg page 
Then I am registered as an agate user on maidenhead successfully and I am shown a first use notice
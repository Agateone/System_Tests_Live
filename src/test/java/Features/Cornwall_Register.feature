Feature: Register from cornwall first use notice



Scenario: Register from Cornwall first use notice staging 
Given I am not a user of agate on cornwall and I open a browser
And I navigate to a premium article on cornwall
And I click on the create wallet button of reaction first use notice cornwall
And I verify that the create wallet button on reaction first use notice takes me to the reg page on cornwall
When I enter all the details successfully on the reg page on cornwall
Then I am registered as an agate user on cornwall successfully and I am shown a first use notice
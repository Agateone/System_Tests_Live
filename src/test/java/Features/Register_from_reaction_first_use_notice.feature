Feature: Register from cricketer first use notice



Scenario: Register from reaction first use notice staging 
Given I am not a user of agate on reaction and I open a browser
And I navigate to a premium article on reaction
And I click on the create wallet button of reaction first use notice
And I verify that the create wallet button on reaction first use notice takes me to the reg page
When I enter all the details successfully on the reg page
Then I am registered as an agate user on reaction successfully and I am shown a first use notice

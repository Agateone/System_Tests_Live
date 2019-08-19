Feature: Register from cricketer first use notice



Scenario: Register from cricketer first use notice staging 
Given I am not a user of agate on cricketer and I open a browser
And I navigate to a premium article on cricketer
And I click on the create wallet button
And I verify that the create wallet button takes me to the reg page
When I enter all the details successfully
Then I am registered as an agate user on cricketer successfully and I am shown a first use notice





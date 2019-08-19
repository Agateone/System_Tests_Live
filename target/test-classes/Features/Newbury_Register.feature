Feature: Register from Newbury first use notice



Scenario: Register from Newbury first use notice staging 
Given I am not a user of agate on Newbury and I open a browser
And I navigate to a premium article on Newbury
And I click on the create wallet button on Newbury
And I verify that the create wallet button takes me to the reg page on Newbury
When I enter all the details successfully on reg page on Newbury
Then I am registered as an agate user on newbury successfully and I am shown a first use notice
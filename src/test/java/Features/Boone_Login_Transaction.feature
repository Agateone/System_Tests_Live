Feature: Successfull Boone Transaction



Scenario: Successfull boone transaction with correct free point and total balance
Given I am a registered Agate User and I login in to Boone
When I read a premium article on Boone
Then the wallet balance and free point are deducted by x amount on Boone wallet
And The popbitch wallet balance is updated , same as Boone and free point remains uneffected 
And Reaction wallet balance is updated and free point remains uneffected by boone
And Cricketer wallet balance is updated and free point remains unaffected by boone
And Cornwall wallet balance remains and is uneffected according to boone
And maidenhead wallet balance remains and is uneffected by boone
And Slough wallet balance remains and is uneffected by boone
And Windsor wallet balance remains and is uneffected by boone




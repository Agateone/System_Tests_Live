Feature: Successfull Reaction Transaction



Scenario: Successfull Reaction transaction with correct free point and total balance
Given I am a registered Agate User and I login in to Reaction  
When I read a premium article on reaction
Then the wallet balance and free point are deducted by x amount on reaction wallet
And The popbitch wallet balance is updated , same as reaction and free point remains uneffected 
And Cricketer wallet balance is updated and free point remains uneffected
And Cornwall wallet balance remains and is uneffected
And maidenhead wallet balance remains and is uneffected by popbitch
And Slough wallet balance remains and is uneffected by popbitch
And Windsor wallet balance remains and is uneffected by popbitch
And Slug recognition works on Slough
And Slug recognition works on Windsor
And Slug recognition works on Maidenhead
And Boone wallet balance remains and is uneffected by popbitch
And scifi now wallet balance remains and is unaffected by popbitch
And Newbury Today wallet balance remains and is unaffected by popbitch
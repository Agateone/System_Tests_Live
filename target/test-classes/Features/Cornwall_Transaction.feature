Feature: Successfull Cornwall Transaction



Scenario: Successfull Cornwall transaction with correct free point and total balance
Given I am a registered Agate User and I login in to Cornwall
When I read a premium article on Cornwall
Then the wallet balance and free point are deducted by x amount on Cornwall wallet
And The popbitch wallet balance is updated , same as Cornwall and free point remains uneffected 
And Reaction wallet balance is updated and free point remains uneffected same as cornwall
And Cricketer wallet balance remains and is uneffected according to cricketer
And maidenhead wallet balance remains and is uneffected by popbitch
And Slough wallet balance remains and is uneffected by popbitch
And Windsor wallet balance remains and is uneffected by popbitch
And Slug recognition works on Slough
And Slug recognition works on Windsor
And Slug recognition works on Maidenhead
And Boone wallet balance remains and is uneffected by popbitch
And scifi now wallet balance remains and is unaffected by popbitch
And Newbury Today wallet balance remains and is unaffected by popbitch
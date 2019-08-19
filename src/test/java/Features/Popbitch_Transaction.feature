Feature: Successfull popbitch transaction



Scenario: Successfull popbitch transaction with correct free point and total balance
Given I am a registered Agate User and I login in to popbitch staging with username as "jay2@gmail.com" and password as "ajjukanna" 
When I read a premium article
Then the wallet balance and free point are deducted by x amount
And The New European wallet balance is updated , same as popbitch and free point remains uneffected 
And Reactions wallet balance is updated and free point remains uneffected
And Aoa wallet  balance is updated and free point remains uneffected 
And cricketer wallet balance remains and is uneffected
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



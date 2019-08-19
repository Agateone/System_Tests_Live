Feature: Successfull slough Transaction



Scenario: Successfull slough transaction with correct free point and total balance
Given I am a registered Agate User and I login in to slough
When I read a premium article on slough
And The popbitch wallet balance is updated , same as slough and free point remains uneffected 
And Reaction wallet balance is updated and free point remains uneffected same as slough
And Cricketer wallet balance remains and is uneffected by slough
And Cornwall wallet balance remains and is uneffected by slough
And Maidenhead wallet balance remains and is uneffected by slough
And Windsor wallet balance remains and is uneffected by slough
And Slug recognition works on Maidenhead from slough
And Slug recognition works on Windsor from slough
And Boone wallet balance remains and is uneffected by popbitch
And scifi now wallet balance remains and is unaffected by popbitch
And Newbury Today wallet balance remains and is unaffected by popbitch
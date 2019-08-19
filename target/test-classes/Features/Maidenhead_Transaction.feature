Feature: Successfull Maiadenhead Transaction



Scenario: Successfull Maiadenhead transaction with correct free point and total balance
Given I am a registered Agate User and I login in to Maiadenhead
When I read a premium article on Maiadenhead
And The popbitch wallet balance is updated , same as Maiadenhead and free point remains uneffected 
And Reaction wallet balance is updated and free point remains uneffected same as Maiadenhead
And Cricketer wallet balance remains and is uneffected by Maiadenhead
And Cornwall wallet balance remains and is uneffected by Maiadenhead
And Slough wallet balance remains and is uneffected by Maiadenhead
And Windsor wallet balance remains and is uneffected by Maiadenhead
And Slug recognition works on Slough
And Slug recognition works on Windsor
And Boone wallet balance remains and is uneffected by popbitch
And scifi now wallet balance remains and is unaffected by popbitch
And Newbury Today wallet balance remains and is unaffected by popbitch
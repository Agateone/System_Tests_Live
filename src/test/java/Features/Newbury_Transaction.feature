Feature: Successfull Newbury Transaction





Scenario: Successfull Newbury transaction with correct free point and total balance
Given I am a registered Agate User and I login in to Newbury
When I read a premium article on Newbury
Then the wallet balance and free point are deducted by x amount on Newbury wallet
And The popbitch wallet balance is updated , same as Newbury and free point remains uneffected 
And Reaction wallet balance is updated and free point remains uneffected as on Newbury
And Cricketer wallet balance is updated and free point remains unaffected by Newbury
And Cornwall wallet balance remains and is uneffected according to Newbury
And maidenhead wallet balance remains and is uneffected by Newbury
And Slough wallet balance remains and is uneffected by Newbury
And Windsor wallet balance remains and is uneffected by Newbury
And Slug recognition works on Slough as on boone
And Slug recognition works on Windsor as on boone
And Slug recognition works on Maidenhead as on boone



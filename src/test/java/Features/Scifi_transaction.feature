Feature: Successfull Scifi Transaction





Scenario: Successfull Scifi transaction with correct free point and total balance
Given I am a registered Agate User and I login in to scifi
When I read a premium article on scifi
Then the wallet balance and free point are deducted by x amount on scifi wallet
And The popbitch wallet balance is updated , same as scifi and free point remains uneffected 
And Reactions wallet balance is updated and free point remains uneffected as on scifi
And Cricketer wallet balance is updated and free point remains unaffected by scifi
And Cornwall wallet balance remains and is uneffected according to scifi
And maidenhead wallet balance remains and is uneffected by scifi
And Slough wallet balance remains and is uneffected by scifi
And Windsor wallet balance remains and is uneffected by scifi


Feature: Successfull windsor Transaction



Scenario: Successfull slough transaction with correct free point and total balance
Given I am a registered Agate User and I login in to windsor
When I read a premium article on windsor
And The popbitch wallet balance is updated , same as windsor and free point remains uneffected 
And Reaction wallet balance is updated and free point remains uneffected same as windsor
And Cricketer wallet balance remains and is uneffected by windsor
And Cornwall wallet balance remains and is uneffected by windsor
And Maidenhead wallet balance remains and is uneffected by windsor
And slough wallet balance remains and is uneffected by windsor
And Slug recognition works on Maidenhead from windsor
And Slug recognition works on slough from windsor
And Boone wallet balance remains and is uneffected by windsor
And scifi now wallet balance remains and is unaffected by windsor
And Newbury Today wallet balance remains and is unaffected by windsor
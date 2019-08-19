Feature: Successfull top up from wallet




Scenario: Successfull top up from wallet 
Given I am a user of agate
When I click on topup from the wallet
Then the wallet  opens a saperate window 
And successfully top up with the selected amount and card
And the wallet balance and total balance are incremented by the amount topped up 

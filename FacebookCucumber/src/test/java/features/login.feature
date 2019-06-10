Feature: Faceboook Login 

Scenario Outline: Positive test Validating login 
	Given Initialize the browser with Chrome 
	And Navigate to <site> Site 
	When User enters <username> 
	And enters <password> 
	Then Verify that User is successfully logged in 
	And close all browsers 
	
	Examples: 
	
		|site|username|password|
		|https://www.facebook.com/|test123@gmail.com |12345|
		|https://www.facebook.com/|test987@gmail.com |98765|
Feature: Google Search 

@SmokeTest 
Scenario Outline: Positive flow 

	Given Initialize the browser with chrome browser 
	When Navigate to <site> Sites 
	And Type in Field 
	Then Click on Search button 
	#And close browser 
	
	Examples: 
	
		|site|
		|https://www.google.co.in/|
		|https://www.google.com/|
		
	Scenario Outline: Positive flow 
	
		Given Initialize the browser with chrome browser 
		When Navigate to <site> Sites 
		And Type in Field 
		Then Click on Search button 
		And close browser 
		
		Examples: 
		
			|site|
			|https://www.google.co.uk/|
			|https://www.google.com/|
			
		Scenario Outline: Positive flow 
		
			Given Initialize the browser with chrome browser 
			When Navigate to <site> Sites 
			And close browser 
			
			Examples: 
			
				|site|
				|https://www.facebook.com/|
				
				
				
	
Feature: Amazon Login 

Scenario Outline: Positive Test Scenario

	Given I initialize the browser with Chrome 
	And I navigate to <site> site 
	When I enter <search> in the search field 
	Then the search is successful 
	#And i quit the browser 
	
	Examples: 
	
		|site|search|
		|https://www.amazon.co.in/|Mi Speakers|
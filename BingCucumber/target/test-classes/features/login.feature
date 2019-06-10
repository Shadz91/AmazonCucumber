Feature: Bing Login 

Scenario Outline: Positive Test Scenarios 
	Given I have Initialized the Browser with Chrome 
	And I navigate to <site> Site 
	When I enter <stringQuery> in the searchBox 
	And Click on the Search button 
	Then I get results 
	And I quit browser 
	
	Examples: 
	
		|site|stringQuery|
		|https://www.bing.com/|Selenium|
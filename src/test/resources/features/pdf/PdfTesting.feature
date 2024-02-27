@api
Feature: PDF Testing
	As a registered user, I want to test the generated PDF files if everything is according to the template

	Scenario Outline: Successful PDF Test
		Given User verifies PDF file '<PDF_1>' to '<PDF_2>'
		Then User sees PDF file similarity should be above 90%

		Examples:
			| PDF_1  								| PDF_2   									|
			| C:\Users\rolan\Downloads\Invoice.pdf 	| C:\Users\rolan\Downloads\Invoice.pdf    	|

# mvn clean verify "-Dproperties=serenity.properties -Dcucumber.filter.tags=@api"
# mvn clean verify "-Dproperties=serenity.properties -Dcucumber.filter.tags=not @mobile"
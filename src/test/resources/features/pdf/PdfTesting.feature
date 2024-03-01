@pdf
Feature: PDF Testing
	As a registered user, I want to test the generated PDF files if everything is according to the baseline

	Scenario Outline: Successful PDF Test
		Given User verifies PDF file '<PDF_1>' to '<PDF_2>'
		Then User sees PDF file similarity should be above 90%

		Examples:
			| PDF_1  							         	| PDF_2   				         					|
			| C:\Users\joshua.leow\Downloads\Invoice.pdf 	| C:\Users\joshua.leow\Downloads\Invoice.pdf    	|
			| C:\Users\joshua.leow\Downloads\Invoice.pdf 	| C:\Users\joshua.leow\Downloads\Invoice2.pdf    	|


# mvn clean verify "-Dproperties=serenity.properties -Dcucumber.filter.tags=@pdf"
@web
Feature: Web User Authentication
	As a registered user, I want to authenticate successfully so that I can access my account and perform actions within the system.

	Background:
		Given User is on the login page

#	LOGIN_TC01
	Scenario Outline: Successful User Authentication
		When User input username '<Username>' and password '<Password>'
		And User submit the login form
		Then User should be authenticated successfully
		Examples:
			| Username  | Password   |
			| user01    | user01     |

#	LOGIN_TC02
	Scenario Outline: Login with invalid credentials
		When User input username '<Username>' and password '<Password>'
		And User submit the login form
		Then User should see Error Message displayed "Invalid username and password"
		Examples:
			| Username  | Password   |
			| TEST99    | TEST99     |

#	REG_TC02
	Scenario Outline: Successful User Registration
		When User clicks Sign Up button
		And User enters first name "<firstname>"
		And User enters last name "<lastname>"
		And User enters phone "<phone>"
		And User enters email "<email>"
		And User enters username "<username>"
		And User enters password "<password>"
		And User clicks Sign Up Register button
		Then User redirects to login page
		Examples:
			| firstname | lastname | phone | email  | username | password |
			| user      | user     | 12345 | ab@cde | user999  | user01   |
		# email and username cannot exist

#	REG_TC06
	Scenario Outline: Successfully Cancel User Registration
		When User clicks Sign Up button
		And User enters first name "<firstname>"
		And User enters last name "<lastname>"
		And User enters phone "<phone>"
		And User enters email "<email>"
		And User enters username "<username>"
		And User enters password "<password>"
		And User clicks Cancel Register button
		Then User redirects to login page
		When User clicks Sign Up button
		And User clicks Cancel Register button
		Then User redirects to login page
		Examples:
			| firstname | lastname | phone | email  | username | password |
			| user      | user     | 12345 | ab@cde | user999  | user01   |
# mvn clean verify "-Dproperties=serenity.properties -Dcucumber.filter.tags=@web"
# mvn clean verify "-Dproperties=serenity.properties -Dcucumber.filter.tags=not @mobile"
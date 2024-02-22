@mobile
Feature: Mobile User Authentication
	As a registered user, I want to authenticate successfully so that I can access my account and perform actions within the system.

	Background:
		Given User is on the mobile login page

#	REG_TC02
	Scenario Outline: Successful User Registration
		When User clicks Sign Up button on the mobile
		And User enters first name "<firstname>" on the mobile
		And User enters last name "<lastname>" on the mobile
		And User enters phone "<phone>" on the mobile
		And User enters email "<email>" on the mobile
		And User enters username "<username>" on the mobile
		And User enters password "<password>" on the mobile
		And User clicks Sign Up Register button on the mobile
		Then User redirects to login page on the mobile
		Examples:
			| firstname | lastname | phone | email  | username | password |
			| user      | user     | 12345 | ab@cde | user01   | user01   |
		# email and username cannot exist

#	LOGIN_TC01
	Scenario Outline: Successful User Authentication
		When User input username '<Username>' and password '<Password>' on the mobile
		And User submit the login form on the mobile
		Then User should be authenticated successfully on the mobile
		Examples:
			| Username | Password |
			| user01   | user01   |

# mvn clean verify -Dwebdriver.driver=appium -Dcucumber.filter.tags=@mobile
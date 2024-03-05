
Feature: Web User Authentication
	As a registered user, I want to authenticate successfully so that I can access my account and perform actions within the system.

	Background:
		Given User is on the login page

#	LOGIN_TC01
	Scenario Outline: Successful User Authentication
		When User input username '<Username>' and password '<Password>'
		And User submit the login form
		Then User should be authenticated successfully
		Then User should be able to see the record '<Username>' in the Users table in the database

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

		#	PRIMARY_TC01
	Scenario Outline: View Primary Balance Page
		When User input username '<Username>' and password '<Password>'
		And User submit the login form
		Then User should be authenticated successfully
		When User clicks Primary Balance View Details
		Then User should see Primary Balance page
		Examples:
			| Username  | Password   |
			| user99    | user99     |

  		#	PRIMARY_TC02
		#	put on hold
	Scenario Outline: Sort Primary Balance table
		When User input username '<Username>' and password '<Password>'
		And User submit the login form
		Then User should be authenticated successfully
		When User clicks Primary Balance View Details
		Then User should see Primary Balance page
		#add steps to sort
		Examples:
			| Username  | Password   |
			| user99    | user99     |

		#	LANDING_TC01
	Scenario: Verify the display on the Landing Page
		Then User should see sign in elements

		#	REG_TC01
	Scenario: Verify the display on the Sign Up Page
		When User clicks Sign Up button
		Then User should see sign up elements

			#	REG_TC03
	Scenario Outline: Validation on sign up page
		When User clicks Sign Up button
		And User enters first name "<firstname>"
		And User enters last name "<lastname>"
		And User enters phone "<phone>"
		And User enters email "<email>"
		And User enters username "<username>"
		And User enters password "<password>"
		And User clicks Sign Up Register button
		Then User registration should be unsuccessful
		Examples:
			| firstname | lastname  | phone     | email     | username  | password  |
			| !@#$%^&*( | !@#$%^&*( | !@#$%^&*( | !@#$%^&*( | !@#$%^&*( | !@#$%^&*( |
			| 123456789 | 123456789 | 123456789 | 123456789 | 123456789 | 123456789 |
			| qwertyuio | qwertyuio | qwertyuio | qwertyuio | qwertyuio | qwertyuio |

		#	REG_TC04
	Scenario: Show password
		When User clicks Sign Up button
		And User enters password "qwerty"
		And User clicks show password
		Then User should see password not masked
	@web
		#	REG_TC07
	Scenario: Access Sign up page
		When User clicks Sign Up button
		Then User redirects to Sign up page

		# 	REG_TC08
	Scenario Outline: Register Existing User
		When User clicks Sign Up button
		And User enters first name "<firstname>"
		And User enters last name "<lastname>"
		And User enters phone "<phone>"
		And User enters email "<email>"
		And User enters username "<username>"
		And User enters password "<password>"
		And User clicks Sign Up Register button
		Then User should see existing error message
		Examples:
			| firstname | lastname  | phone     | email     | username  | password  |
			| 123456789 | 123456789 | 123456789 | 123456789 | enfeimedo | 123456789 |
			| 123456789 | 123456789 | 123456789 | jnwreuhfe | 123456789 | 123456789 |
			| qwertyuio | qwertyuio | qwertyuio | qwertyuio | qwertyuio | qwertyuio |
			| asdfghjkl | asdfghjkl | asdfghjkl | asdfghjkl | asdfghjkl | asdfghjkl |

# mvn clean verify "-Dproperties=serenity.properties -Dcucumber.filter.tags=@web"
# mvn clean verify "-Dproperties=serenity.properties -Dcucumber.filter.tags=not @mobile"
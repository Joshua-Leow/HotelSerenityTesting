
Feature: Mobile User Authentication
	As a registered user, I want to authenticate successfully so that I can access my account and perform actions within the system.

	Background:
		Given User is on the mobile login page

#	LANDING_TC01
	Scenario: Verify the display on the Landing Page
		Then User should see sign in elements on the mobile
	@mobile
 #	REG_TC01
	Scenario: Verify the display on the Sign Up Page
		When User clicks Sign Up button on the mobile
		Then User should see sign up elements on the mobile

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
			| user      | user     | 12345 | az@jkk | user98   | user99   |
		# email and username cannot exist

				#	REG_TC03
	Scenario Outline: Validation on sign up page
		When User clicks Sign Up button on the mobile
		And User enters first name "<firstname>" on the mobile
		And User enters last name "<lastname>" on the mobile
		And User enters phone "<phone>" on the mobile
		And User enters email "<email>" on the mobile
		And User enters username "<username>" on the mobile
		And User enters password "<password>" on the mobile
		And User clicks Sign Up Register button on the mobile
		Then User registration should be unsuccessful on the mobile
		Examples:
			| firstname | lastname  | phone     | email     | username  | password  |
			| !@#$%^&*( | !@#$%^&*( | !@#$%^&*( | !@#$%^&*( | !@#$%^&*( | !@#$%^&*( |
			| 123456789 | 123456789 | 123456789 | 123456789 | 123456789 | 123456789 |
			| qwertyuio | qwertyuio | qwertyuio | qwertyuio | qwertyuio | qwertyuio |

#	LOGIN_TC01
	Scenario Outline: Successful User Authentication
		When User input username '<Username>' and password '<Password>' on the mobile
		And User submit the login form on the mobile
		Then User should be authenticated successfully on the mobile
		Examples:
			| Username | Password |
			| user01   | user01   |

#	LOGIN_TC02
	Scenario Outline: Login with invalid credentials
		When User input username '<Username>' and password '<Password>' on the mobile
		And User submit the login form on the mobile
		Then User should see Error Message displayed "Invalid username and password" on the mobile
		Examples:
			| Username  | Password   |
			| TEST99    | TEST99     |

	#	REG_TC06
	Scenario Outline: Successfully Cancel User Registration
		When User clicks Sign Up button on the mobile
		And User enters first name "<firstname>" on the mobile
		And User enters last name "<lastname>" on the mobile
		And User enters phone "<phone>" on the mobile
		And User enters email "<email>" on the mobile
		And User enters username "<username>" on the mobile
		And User enters password "<password>" on the mobile
		And User clicks Cancel Register button on the mobile
		Then User redirects to login page on the mobile
		When User clicks Sign Up button on the mobile
		And User clicks Cancel Register button on the mobile
		Then User redirects to login page on the mobile
		Examples:
			| firstname | lastname | phone | email  | username | password |
			| user      | user     | 12345 | ab@cde | user999  | user01   |

	#	PRIMARY_TC01
	Scenario Outline: View Primary Balance Page
		When User input username '<Username>' and password '<Password>' on the mobile
		And User submit the login form on the mobile
		Then User should be authenticated successfully on the mobile
		When User clicks Primary Balance View Details on the mobile
		Then User should see Primary Balance page on the mobile
		Examples:
			| Username  | Password   |
			| TEST99    | TEST99     |

# mvn clean verify -Dwebdriver.driver=appium -Dcucumber.filter.tags=@mobile
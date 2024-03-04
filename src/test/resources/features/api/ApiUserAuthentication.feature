
Feature: API User Authentication
	As a registered user, I want to authenticate successfully so that I can access my account and perform actions within the system.

#	LOGIN_TC01
	Scenario Outline: Login with valid credentials
		Given User is logged in using username '<Username>' and password '<Password>'
		Then User should see the signin response authenticated successfully
		Examples:
			| Username  | Password   |
			| user01    | user01     |

  #	LOGIN_TC02
	Scenario Outline: Login with invalid credentials
		Given User is logged in using username '<Username>' and password '<Password>'
		Then User should see the signin response failed
		Examples:
			| Username  | Password   |
			| TEST123   | TEST123    |

#	DEPOSIT_TC02, DEPOSIT_TC03
	Scenario Outline: Successful Deposit
		Given User is logged in using username '<Username>' and password '<Password>'
		When User deposit amount '<Amount>' into account '<Account>'
		Then User should see the deposit response authenticated successfully

		Examples:
			| Username  | Password   | Amount   | Account   |
			| user01    | user01     | 1000     | Primary   |
			| user01    | user01     | 1000     | Savings   |

#	REG_TC03
	@api
	Scenario Outline: Validation on sign up page
		Given User is on Sign Up page
		When User enters the following:
			| first_name   | <firstname>|
			| last_name    | <lastname> |
			| phone        | <phone>    |
			| email        | <email>    |
			| username     | <username> |
			| password     | <password> |
		Then User should see some error

		Examples:
			| firstname | lastname  | phone     | email     | username  | password  |
			| !@#$%^&*( | !@#$%^&*( | !@#$%^&*( | !@#$%^&*( | !@#$%^&*( | !@#$%^&*( |
			| 123456789 | 123456789 | 123456789 | 123456789 | 123456789 | 123456789 |
			| qwertyuio | qwertyuio | qwertyuio | qwertyuio | qwertyuio | qwertyuio |

	#	REG_TC07
	Scenario: Access Sign up page
		Given User is on Sign Up page
		Then User should see no errors


# mvn clean verify "-Dproperties=serenity.properties -Dcucumber.filter.tags=@api"
# mvn clean verify "-Dproperties=serenity.properties -Dcucumber.filter.tags=not @mobile"
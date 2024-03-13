
Feature: API User Authentication
	As a registered user, I want to authenticate successfully so that I can access my account and perform actions within the system.


#	API_REG_TC02
	Scenario Outline: API_REG_TC02_Successful User Registration
		Given User is on Sign Up page
		When User enters the following:
			| first_name   | <firstname>|
			| last_name    | <lastname> |
			| phone        | <phone>    |
			| email        | <email>    |
			| username     | <username> |
			| password     | <password> |
		Then User should see no errors
		Examples:
			| firstname  | lastname   | phone      | email         | username  | password  |
			| testing123 | testing456 | 1234567890 | test@test.com | test234   | test234   |

#	API_REG_TC03 (N/A test case)
	Scenario Outline: API_REG_TC03_Validation on sign up page
		Given User is on Sign Up page
		When User enters the following:
			| first_name   | <firstname>|
			| last_name    | <lastname> |
			| phone        | <phone>    |
			| email        | <email>    |
			| username     | <username> |
			| password     | <password> |
		Then User should see some errors
		Examples:
			| firstname | lastname  | phone     | email     | username  | password  |
			| !@#$%^&*( | !@#$%^&*( | !@#$%^&*( | !@#$%^&*( | !@#$%^&*( | !@#$%^&*( |
			| 123456789 | 123456789 | 123456789 | 123456789 | 123456789 | 123456789 |
			| qwertyuio | qwertyuio | qwertyuio | qwertyuio | qwertyuio | qwertyuio |

#	REG_TC08 Manual fail already, no need to automate - Register Existing User

#	API_LOGIN_TC01
	Scenario Outline: API_LOGIN_TC01_Login with valid credentials
		Given User is logged in using username '<Username>' and password '<Password>'
		Then User should see the signin response authenticated successfully
		Examples:
			| Username  | Password   |
			| user01    | user01     |

  #	API_LOGIN_TC02
	Scenario Outline: API_LOGIN_TC02_Login with invalid credentials
		Given User is logged in using username '<Username>' and password '<Password>'
		Then User should see the signin response failed
		Examples:
			| Username  | Password   |
			| TEST123   | TEST123    |
@api
	#	API_DASHBOARD_TC02
	Scenario Outline: API_DASHBOARD_TC02_View Primary Balance
		Given User is logged in using username '<Username>' and password '<Password>'
		When User checks balance in accounts
		Then User should see primary account balance
		Examples:
			| Username  | Password   |
			| user01    | user01     |

   #	API_DASHBOARD_TC03
	Scenario Outline: API_DASHBOARD_TC03_View Savings Balance
		Given User is logged in using username '<Username>' and password '<Password>'
		When User checks balance in accounts
		Then User should see savings account balance
		Examples:
			| Username  | Password   |
			| user01    | user01     |

#	DEPOSIT_TC02, DEPOSIT_TC03
	Scenario Outline: Successful Deposit
		Given User is logged in using username '<Username>' and password '<Password>'
		When User deposit amount '<Amount>' into account '<Account>'
		Then User should see the deposit response authenticated successfully

		Examples:
			| Username  | Password   | Amount   | Account   |
			| user01    | user01     | 1000     | Primary   |
			| user01    | user01     | 1000     | Savings   |

# mvn clean verify "-Dproperties=serenity.properties -Dcucumber.filter.tags=@api"
# mvn clean verify "-Dproperties=serenity.properties -Dcucumber.filter.tags=not @mobile"
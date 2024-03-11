
Feature: Web User Authentication
	As a registered user, I want to authenticate successfully so that I can access my account and perform actions within the system.

	Background:
		Given User is on the login page

#	Roland's database check
	Scenario Outline: Successful User Authentication
		And User ensures username '<Username>' and password '<Password>' account exists
		When User input username '<Username>' and password '<Password>'
		And User submit the login form
		Then User should be authenticated successfully
		Then User should be able to see the record '<Username>' in the Users table in the database

		Examples:
			| Username  | Password   |
			| user69    | user69     |

  #	LANDING_TC01
	Scenario: Verify the display on the Landing Page
		Then User should see sign in elements

  #	REG_TC01
	Scenario: Verify the display on the Sign Up Page
		When User clicks Sign Up button
		Then User should see sign up elements


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

   #	REG_TC05
	Scenario: Submit Registration without filling up the Sign Up field
		When User clicks Sign Up button
		And User clicks Sign Up Register button
		Then User should see Please fill out this fill message

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

		#	REG_TC07
	Scenario: Access Sign up page
		When User clicks Sign Up button
		Then User redirects to Sign up page

		#	REG_TC08
	Scenario Outline: Register Existing User
		And User ensures username '<Username>' and password '<Password>' account exists
		When User clicks Sign Up button
		And User enters first name "<Firstname>"
		And User enters last name "<Lastname>"
		And User enters phone "<Phone>"
		And User enters email "<Email>"
		And User enters username "<Username>"
		And User enters password "<Password>"
		And User clicks Sign Up Register button
		Then User should see existing error message
		Examples:
			| Firstname | Lastname  | Phone     | Email            | Username  | Password  |
			| john      | doe       | 123456789 | johndoe@test.com | johnydoe  | password1 |

  #	LOGIN_TC01
	Scenario Outline: Successful User Authentication
		And User ensures username '<Username>' and password '<Password>' account exists
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
			| TEST99*&  | TEST99*&   |

  #	LOGIN_TC03
	Scenario Outline: Remember Me function
		And User ensures username '<Username>' and password '<Password>' account exists
		When User input username '<Username>' and password '<Password>'
		And User checks Remember Me checkbox
		And User submit the login form
		And User logout
		Then User should see '<Username>' on the username field
		Examples:
			| Username  | Password   |
			| user01    | user01     |

  #	WEB_DASHBOARD_TC01
	Scenario Outline: WEB_DASHBOARD_TC01_Verify the display on the Landing Page
		And User ensures username '<Username>' and password '<Password>' account exists
		When User input username '<Username>' and password '<Password>'
		And User submit the login form
		Then User should be authenticated successfully
		And User should see Dashboard page elements
		Examples:
			| Username  | Password   |
			| user69    | user69     |

   #	WEB_DASHBOARD_TC02
	Scenario Outline: WEB_DASHBOARD_TC02_View Primary Balance
		And User ensures username '<Username>' and password '<Password>' account exists
		When User input username '<Username>' and password '<Password>'
		And User submit the login form
		Then User should be authenticated successfully
		When User clicks Primary Balance View Details
		Then User should see Primary Balance page
		Examples:
			| Username  | Password   |
			| user69    | user69     |

	 #	WEB_DASHBOARD_TC03
	Scenario Outline: WEB_DASHBOARD_TC03_View Savings Balance
		And User ensures username '<Username>' and password '<Password>' account exists
		When User input username '<Username>' and password '<Password>'
		And User submit the login form
		Then User should be authenticated successfully
		When User clicks Savings Balance View Details
		Then User should see Savings Balance page
		Examples:
			| Username  | Password   |
			| user69    | user69     |

	 #	WEB_DASHBOARD_TC04
	Scenario Outline: WEB_DASHBOARD_TC04_View Deposit
		And User ensures username '<Username>' and password '<Password>' account exists
		When User input username '<Username>' and password '<Password>'
		And User submit the login form
		Then User should be authenticated successfully
		When User clicks Deposit View Details
		Then User should see Deposit page
		Examples:
			| Username  | Password   |
			| user69    | user69     |
@web
	 #	WEB_DASHBOARD_TC05
	Scenario Outline: WEB_DASHBOARD_TC05_View Withdrawal
		And User ensures username '<Username>' and password '<Password>' account exists
		When User input username '<Username>' and password '<Password>'
		And User submit the login form
		Then User should be authenticated successfully
		When User clicks Withdrawal View Details
		Then User should see Withdrawal page
		Examples:
			| Username  | Password   |
			| user69    | user69     |

	 #	WEB_DASHBOARD_TC06
	Scenario Outline: WEB_DASHBOARD_TC06_Main Menu navigation
		And User ensures username '<Username>' and password '<Password>' account exists
		When User input username '<Username>' and password '<Password>'
		And User submit the login form
		Then User should be authenticated successfully
		When User clicks dropdown '<Dropdown>' and option '<Option>'
		Then User should see url '<Url>' page
		Examples:
			| Username  | Password   | Dropdown    | Option                  | Url              |
			| user69    | user69     | Accounts    | Primary                 | Primary          |
			| user69    | user69     | Accounts    | Savings                 | Savings          |
			| user69    | user69     | Transfer    | Between Accounts        | BetweenAccounts  |
			| user69    | user69     | Transfer    | To Someone Else         | ToSomeoneElse    |
			| user69    | user69     | Transfer    | Add/Edit Recipient      | Recipient        |
			| user69    | user69     | Appointment | Schedule an Appointment | Create           |
			| user69    | user69     | Me          | Profile                 | Profile          |
			| user69    | user69     | Me          | Logout                  | Logout           |

		  #	WEB_DEPOSIT_TC01
	Scenario Outline: WEB_DEPOSIT_TC01_Verify the display on the Deposit Page
		And User ensures username '<Username>' and password '<Password>' account exists
		When User input username '<Username>' and password '<Password>'
		And User submit the login form
		Then User should be authenticated successfully
		When User clicks Deposit View Details
		Then User should see Deposit page elements
		Examples:
			| Username  | Password   |
			| user69    | user69     |

	 #	PRIMARY_TC02
	#	put on hold, complex test case to sort
	Scenario Outline: Sort Primary Balance table
		And User ensures username '<Username>' and password '<Password>' account exists
		When User input username '<Username>' and password '<Password>'
		And User submit the login form
		Then User should be authenticated successfully
		When User clicks Primary Balance View Details
		Then User should see Primary Balance page
		#add steps to sort
		Examples:
			| Username  | Password   |
			| user99    | user99     |

# mvn clean verify "-Dproperties=serenity.properties -Dcucumber.filter.tags=@web"
# mvn clean verify "-Dproperties=serenity.properties -Dcucumber.filter.tags=not @mobile"
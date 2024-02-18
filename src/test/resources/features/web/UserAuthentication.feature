@web
Feature: Web User Authentication
	As a registered user, I want to authenticate successfully so that I can access my account and perform actions within the system.

	Background:
		Given User is on the login page

	Scenario Outline: Successful User Authentication
		When User input username '<Username>' and password '<Password>'
		And User submit the login form
		Then User should be authenticated successfully

		Examples:
			| Username  | Password   |
			| user01    | user01    |

# mvn clean verify "-Dproperties=serenity.properties -Dcucumber.filter.tags=@web"
# mvn clean verify "-Dproperties=serenity.properties -Dcucumber.filter.tags=not @mobile"
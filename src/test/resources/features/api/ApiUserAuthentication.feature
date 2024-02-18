@api
Feature: API User Authentication
	As a registered user, I want to authenticate successfully so that I can access my account and perform actions within the system.

	Scenario Outline: Successful User Authentication
		Given User is logged in using username '<Username>' and password '<Password>'
		Then User should see the response authenticated successfully

		Examples:
			| Username  | Password   |
			| user01    | user01    |

# mvn clean verify "-Dproperties=serenity.properties -Dcucumber.filter.tags=@api"
# mvn clean verify "-Dproperties=serenity.properties -Dcucumber.filter.tags=not @mobile"
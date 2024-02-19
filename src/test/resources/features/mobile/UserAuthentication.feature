@mobile
Feature: Mobile User Authentication
	As a registered user, I want to authenticate successfully so that I can access my account and perform actions within the system.

	Background:
		Given User is on the mobile login page

	Scenario Outline: Successful User Authentication
		When User input username '<Username>' and password '<Password>' on the mobile
		And User submit the login form on the mobile
		Then User should be authenticated successfully on the mobile
		Examples:
			| Username | Password |
			| user01   | user01   |

# mvn clean verify -Dwebdriver.driver=appium -Dcucumber.filter.tags=@mobile
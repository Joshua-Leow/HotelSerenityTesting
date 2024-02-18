@web

Feature: Mobile User Authentication
	As a registered user, I want to authenticate successfully so that I can access my account and perform actions within the system.

	Background:
		Given User is on the login page using mobile

	Scenario Outline: Successful User Authentication using mobile
		When User input username '<Username>' and password '<Password>' using mobile

		Examples:
			| Username  | Password   |
			| user01    | user01    |
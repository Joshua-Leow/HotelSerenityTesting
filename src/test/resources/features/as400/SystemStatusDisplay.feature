
Feature: System Status Display on AS400 Terminal
	As a system administrator, I want to be able to view the current status of the AS400 system so that I can quickly assess its operational state and address any issues promptly.

	Background:
		Given User is connected to the AS400 terminal

	Scenario Outline: Viewing AS400 System Status 1
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'General system tasks'
		And User select the 'Status' option
		And User choose the 'Display system status' option
		Then User should see the text 'Display System Status' on the screen

		Examples:
			| Username | Password |
			| RRHADI   | K$$ja01  |

	Scenario Outline: Viewing AS400 System Status 2
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'General system tasks'
		And User select the 'Status' option
		And User choose the 'Display system status' option
		Then User should see the text 'Display System Status' on the screen
		Examples:
			| Username | Password |
			| RRHADI   | K$$ja01  |

#		TC01
	Scenario Outline: Login successfully to AS400
		When User log in with username '<Username>' and password '<Password>'
		Then User should see the text 'IBM i Main Menu' or text 'Display Messages' on the screen
		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |

#		TC02
	Scenario Outline: Unsuccessful Login using invalid credentials
		When User log in with username '<Username>' and password '<Password>'
		Then User should see the text 'does not exist or password not correct for user profile' on the screen
#		CPF1120 - User TEST does not exist or password not correct for user profile.
		Examples:
			| Username | Password |
			| TEST     | TEST123  |
	@as400
#		TC05
	Scenario Outline: Verify display of job status attributes
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'User Task'
		And User navigate to 'Display or Change your Job'
		And User navigate to 'Display job status attributes'
		Then User should see the following options on the screen:
			| System:   PUB400                                             |
			| Job:                                                         |
			| User:                                                        |
			| Number:                                                      |
			| Status of job . . . . . . . . . . . . . . . :                |
			| Current user profile  . . . . . . . . . . . :                |
			| Job user identity . . . . . . . . . . . . . :                |
			| Set by  . . . . . . . . . . . . . . . . . :                  |
			| Entered system:                                              |
			|   Date  . . . . . . . . . . . . . . . . . . :                |
			|   Time  . . . . . . . . . . . . . . . . . . :                |
			| Started:                                                     |
			|   Date  . . . . . . . . . . . . . . . . . . :                |
			|   Time  . . . . . . . . . . . . . . . . . . :                |
			| Subsystem . . . . . . . . . . . . . . . . . :                |
			|   Subsystem pool ID . . . . . . . . . . . . :                |
			| Type of job . . . . . . . . . . . . . . . . :                |
			| Program return code . . . . . . . . . . . . :                |
		Examples:
			| Username | Password |
			| RHADI     | K$$ja01  |
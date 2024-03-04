
Feature: System Status Display on AS400 Terminal
	As a system administrator, I want to be able to view the current status of the AS400 system so that I can quickly assess its operational state and address any issues promptly.

	Background:
		Given User is connected to the AS400 terminal

	Scenario Outline: Viewing AS400 System Status
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

#		TC03
	Scenario Outline: View User Task
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'User Task'
		Then User should see the following options on the screen:
			| 1. Display or Change your Job     |
			| 2. Display Messages               |
			| 3. Send a Message                 |
			| 4. Submit a Job                   |
			| 5. Programming                    |
			| 6. Communications                 |
			| 7. Define or Change the System    |
			| 8. Problem Handling               |
			| 9. Display a Menu                 |
			| 10. Information Assistant Options |
			| 11. IBM i Access tasks            |
		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |


   #		TC04
	Scenario Outline: Verify the display on "Display or Change your Job" under User
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'User Task'
		And User navigate to 'Display or Change your Job'
		Then User should see the following options on the screen:
			| 1. Display job status attributes                         |
			| 2. Display job definition attributes                     |
			| 3. Display job run attributes, if active                 |
			| 4. Work with spooled files                               |
			| 10. Display job log, if active, on job queue, or pending |
			| 11. Display call stack, if active                        |
			| 12. Work with locks, if active                           |
			| 13. Display library list, if active                      |
			| 14. Display open files, if active                        |
			| 15. Display file overrides, if active                    |
			| 16. Display commitment control status, if active        |
		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |

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
			| RHADI    | K$$ja01  |

      #		TC06
	Scenario Outline: Verify the display on "Display job definition attributes" under the Display or Change your Job on User Task
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'User Task'
		And User navigate to 'Display or Change your Job'
		And User navigate to 'Display job definition attributes'
		Then User should see the following options on the screen:
			| System:   PUB400                                    |
			| Job:                                                |
			| User:                                               |
			| Number:                                             |
			| Job description . . . . . . . . . . . . . . . . . : |
			| Library . . . . . . . . . . . . . . . . . . . . :   |
			| ASP device  . . . . . . . . . . . . . . . . . . :   |
			| Job queue . . . . . . . . . . . . . . . . . . . . : |
			| Job priority (on job queue) . . . . . . . . . . . : |
			| Output priority (on output queue) . . . . . . . . : |
			| End severity  . . . . . . . . . . . . . . . . . . : |
			| Message logging:                                    |
			| Level . . . . . . . . . . . . . . . . . . . . . :   |
			| Severity  . . . . . . . . . . . . . . . . . . . :   |
			| Text  . . . . . . . . . . . . . . . . . . . . . :   |
			| Log CL program commands . . . . . . . . . . . . . : |
			| Program return code . . . . . . . . . . . . :       |
		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |

      #		TC07
	Scenario Outline: Verify the display on "Work with spooled files" under the Display or Change your Job on User Task
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'User Task'
		And User navigate to 'Display or Change your Job'
		And User navigate to 'Display job run attributes, if active'
		Then User should see the following options on the screen:
			| System:   PUB400                                    |
			| Job:                                                |
			| User:                                               |
			| Number:                                             |
			| Run priority  . . . . . . . . . . . . . . . . . . : |
			| Time slice in milliseconds  . . . . . . . . . . . : |
			| Eligible for purge  . . . . . . . . . . . . . . . : |
			| Default wait time in seconds  . . . . . . . . . . : |
			| Maximum CPU time in milliseconds  . . . . . . . . : |
			| CPU time used . . . . . . . . . . . . . . . . . :   |
			| Maximum temporary storage in megabytes  . . . . . : |
			| Temporary storage used  . . . . . . . . . . . . :   |
			| Peak temporary storage used . . . . . . . . . . :   |
			| Maximum threads . . . . . . . . . . . . . . . . . : |
			| Threads . . . . . . . . . . . . . . . . . . . . :   |
			| Thread resources affinity:                          |
			| Group . . . . . . . . . . . . . . . . . . . . . :   |
			| Level . . . . . . . . . . . . . . . . . . . . . :   |
			| Resources affinity group  . . . . . . . . . . . . : |
		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |
	@as400
      #		TC08
	Scenario Outline: Verify the display on "Display job run attributes, if active" under the Display or Change your Job on User Task
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'User Task'
		And User navigate to 'Display or Change your Job'
		And User navigate to 'Work with spooled files'
		Then User should see the following options on the screen:
			| Device or    |
			| Total        |
			| Current      |
			| Opt  File    |
			| Queue        |
			| User Data    |
			| Status       |
			| Pages        |
			| Page         |
			| Copies       |
		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |

	#		TC09
	Scenario Outline: Verify the display on "Display job log; if active, on job queue, or pending" under the Display or Change your Job on User Task
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'User Task'
		And User navigate to 'Display or Change your Job'
		And User navigate to 'Display job log, if active, on job queue, or pending'
		Then User should see the following options on the screen:
			| System:   PUB400 |
			| Job:             |
			| User:            |
			| Number:          |
			| >> /*      */    |
		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |

  	#		TC10
	Scenario Outline: Verify the display on "Work with spooled files" under the Display or Change your Job on User Task
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'User Task'
		And User navigate to 'Display or Change your Job'
		And User navigate to 'Display call stack, if active'
		Then User should see the following options on the screen:
			| System:   PUB400 |
			| Job:             |
			| User:            |
			| Number:          |
			| Thread:          |
			| Type             |
			| Program          |
			| Statement        |
			| Procedure        |
		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |

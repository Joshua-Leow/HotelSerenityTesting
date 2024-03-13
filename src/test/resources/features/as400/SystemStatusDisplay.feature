
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

#		AS400_TC01
	Scenario Outline: AS400_TC01_Login successfully to AS400
		When User log in with username '<Username>' and password '<Password>'
		Then User should see the text 'IBM i Main Menu' or text 'Display Messages' on the screen
		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |

#		AS400_TC02
	Scenario Outline: AS400_TC02_Unsuccessful Login using invalid credentials
		When User log in with username '<Username>' and password '<Password>'
		Then User should see the text 'does not exist or password not correct for user profile' on the screen
#		CPF1120 - User TEST does not exist or password not correct for user profile.
		Examples:
			| Username | Password |
			| TEST     | TEST123  |

#		AS400_TC03
	Scenario Outline: AS400_TC03_View User Task
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'User Task'
		Then User should see the following options on the screen:
			| 1. Display or change your job          |
			| 2. Display messages                    |
			| 3. Send a message                      |
			| 4. Submit a job                        |
			| 5. Work with your spooled output files |
			| 6. Work with your batch jobs           |
			| 7. Display or change your library list |
			| 8. Change your password                |
			| 9. Change your user profile            |
			| 60. More user task options             |
			| 90. Sign off                           |
		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |

   #		AS400_TC04
	Scenario Outline: AS400_TC04_Verify the display on "Display or Change your Job" under User
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
			| 16. Display commitment control status, if active         |
		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |

#		AS400_TC05
	Scenario Outline: AS400_TC05_Verify display of job status attributes
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

      #		AS400_TC06
	Scenario Outline: AS400_TC06_Verify the display on "Display job definition attributes" under the Display or Change your Job on User Task
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
			| Job log output  . . . . . . . . . . . . . . . . . : |
		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |

      #		AS400_TC07
	Scenario Outline: AS400_TC07_Verify the display on "Work with spooled files" under the Display or Change your Job on User Task
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

      #		AS400_TC08
	Scenario Outline: AS400_TC08_Verify the display on "Display job run attributes, if active" under the Display or Change your Job on User Task
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

	#		AS400_TC09
	Scenario Outline: AS400_TC09_Verify the display on "Display job log; if active, on job queue, or pending" under the Display or Change your Job on User Task
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'User Task'
		And User navigate to 'Display or Change your Job'
		And User navigate to 'Display job log, if active, on job queue, or pending'
		Then User should see the following options on the screen:
			| System:   PUB400 |
			| Job . . :        |
			| User . . :       |
			| Number . . . :   |
			| >> /*      */    |
		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |

  	#		AS400_TC10
	Scenario Outline: AS400_TC10_Verify the display on "Work with spooled files" under the Display or Change your Job on User Task
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

	#		AS400_TC11
	Scenario Outline: AS400_TC11_Verify the display on "Work with locks, if active" under the Display or Change your Job on User Task
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'User Task'
		And User navigate to 'Display or Change your Job'
		And User navigate to 'Work with locks, if active'
		Then User should see the following options on the screen:
			| System:   PUB400                                                        |
			| Job:                                                                    |
			| User:                                                                   |
			| Number:                                                                 |
			| Job status:                                                             |
			| Type options, press Enter.                                              |
			| Work with job member locks                                              |
			| Work with object locks                                                  |
			| Object                                                                  |
			| Member  ASP                                                             |
			| Opt  Object      Library     Type       Lock     Status  Locks   Device |
			| GAMES400    QSYS        *LIB       *SHRRD    HELD                       |
			| MAIN        QSYS        *MENU      *SHRNUP   HELD                       |
			| PUB400SYS   QSYS        *LIB       *SHRRD    HELD                       |
			| QDUI80      QSYS        *FILE-DSP  *SHRNUP   HELD                       |
			| QGPL        QSYS        *LIB       *SHRRD    HELD                       |
			| QGWCJLCK    QSYS        *PNLGRP    *SHRNUP   HELD                       |
			| QGWCJOB     QSYS        *PNLGRP    *SHRNUP   HELD                       |
			| QHLPSYS     QSYS        *LIB       *SHRRD    HELD                       |
			| QPAD0                                                                   |
			| QSYS        *DEVD      *EXCLRD   HELD                                   |

		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |

	#		AS400_TC12
	Scenario Outline: AS400_TC12_Verify the display on "Display library list, if active" under the Display or Change your Job on User Task
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'User Task'
		And User navigate to 'Display or Change your Job'
		And User navigate to 'Display library list, if active'
		Then User should see the following options on the screen:
			| System:   PUB400                                                        |
			| Job:                                                                    |
			| User:                                                                   |
			| Number:                                                                 |
			| Type options, press Enter.                                              |
			| Display objects in library                                              |
			| ASP                                                                     |
			| Opt  Library     Type      Device      Text                             |
			| PUB400SYS   SYS                   $ PUB400.COM global programs          |
			| QSYS        SYS                   System Library                        |
			| QSYS2       SYS                   System Library for CPI's              |
			| QUSRSYS     SYS                   System Library for Users              |
			| QHLPSYS     SYS                                                         |
			| RHADI1      CUR                   RHADI (*CURLIB your current library)  |
			| QGPL        USR                   General Purpose Library               |
			| QTEMP       USR                                                         |
			|GAMES400    USR                   $ fun library                          |

		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |

	#		AS400_TC13
	Scenario Outline: AS400_TC13_Verify the display on "Display open files, if active" under the Display or Change your Job on User Task
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'User Task'
		And User navigate to 'Display or Change your Job'
		And User navigate to 'Display open files, if active'
		Then User should see the following options on the screen:
			| Job . . :                                      |
			| User . . :                                      |
			| Number . . . :                                  |
			| Number of open data paths . . . . . . . . . . : |
			| Member/                                         |
			| QDUI80     QSYS       QPAD0                     |
			| *ACTGRPDFN  *DFTACTGRP 0000000000000002         |
			| QDDSPOF    QSYS       QPAD                      |
			| *ACTGRPDFN  *DFTACTGRP 0000000000000002         |

		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |

	#		AS400_TC14
	Scenario Outline: AS400_TC14_Verify the display on "Display file overrides, if active" under the Display or Change your Job on User Task
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'User Task'
		And User navigate to 'Display or Change your Job'
		And User navigate to 'Display file overrides, if active'
		Then User should see the following options on the screen:
			| Job  . . :                                              |
			| User . . :                                              |
			| Number . . :                                            |
			| Call level . . . . . . . . . . . . . :                  |
			| Opt  File          Level   Type  Keyword Specifications |
			| (No file overrides)                                     |

		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |

	#		AS400_TC15
	Scenario Outline: AS400_TC15_Verify the display on "Display commitment control status, if active" under the Display or Change your Job on User Task
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'User Task'
		And User navigate to 'Display or Change your Job'
		And User navigate to 'Display commitment control status, if active'
		Then User should see the following options on the screen:
			| Commitment                             |
			| Opt     Definition     Text            |
			| (No commitment definitions are active) |

		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |
	@as400
	#		AS400_TC16
	Scenario Outline: AS400_TC16_Verify the display on "Display messages" under User Task
		When User log in with username '<Username>' and password '<Password>'
		And User navigate to 'User Task'
		And User navigate to 'Display messages'
		Then User should see the following options on the screen:
			| System:   PUB400                       |
			| Queue . . . . . :                      |
			| Program . . . . :                      |
			| Library . . . :                        |
			| Severity  . . . :                      |
			| Delivery  . . . :                      |
			| Type reply (if required), press Enter. |

		Examples:
			| Username | Password |
			| RHADI    | K$$ja01  |

## Pre requisite and tools (VPN Setup)
	Java 1.8
	maven
	testng(should be configured with IDE)
	
	* Setup JAVA_HOME and MVN_HOME path properly.

### Setup of the project on local system
	Git pull from repo

### Ways to RUN
	1. If you are using intelij as IDE move to demo.feature and run the Feature File
	2. Also you can run in using the Runner defined in test/java/Runners

### Directory Structure(Test data)
	src
		main
			java
				common
					Contants - This will save all the contanst variables
            		Init - Consist of objects Used accross 					
				stepDefs
					demo - Page level Step Definitions would be defined so that class layer has less and clean code
				    .
				utils
					utils - Consist of Java Methods

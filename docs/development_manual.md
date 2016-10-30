# GitCatGo - Development manual

The following document assumes that you are on a fresh machine.

This has only been confirmed to run on 64-bit operating systems.

1. Make sure you are using a bash shell.
	* If you are on Windows, then you can use the Git Bash application which you will then install in step 4.
	* We are unsure if this will work with other shells. This has only been tested using a 		bash shell.
2. Install [Java Development Kit 8 (JDK8)](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and make sure java is in your PATH.
3. Install [PhantomJS](http://phantomjs.org/download.html) and make sure it's in your PATH.
4. Install [Git](https://git-scm.com/).
5. Clone the [Tic-Tac-Hugbunarfockers repository](https://github.com/Hugbunarfockers/Tic-Tac-Hugbunarfockers) to your machine.
6. In order to build the project, we use [Gradle](https://gradle.org/). Use one of the following steps:
	* Use the gradle wrapper file (gradlew)
		* Execute "./gradlew task --all" for a list of tasks.
	* Use the scripts in the bin folder in the root of the project.
		* They use the wrapper.
	* Install [Gradle 3.1](https://gradle.org/gradle-download/) and use your local installation.


If you are a new member to Hugbunarfockers, you must also do the following:

1. Login or register on [GitHub](https://github.com/)
2. Request an invite to [Hugbunarfockers](https://github.com/Hugbunarfockers) from an existing member.

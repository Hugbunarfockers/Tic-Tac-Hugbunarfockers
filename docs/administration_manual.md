# GitCatGo - Administration manual

The following document assumes that you are on a fresh machine.

### Downloading / Updating

The master branch in the GitHub repository [Tic-Tac-Hugbunarfockers](https://github.com/Hugbunarfockers/Tic-Tac-Hugbunarfockers) always contains a stable and up-to-date version of GitCatGo.

In order to update, you must re-download this repository.

### Database

 1. Set up a [MySQL](http://dev.mysql.com/downloads/) database with the "Players" and "Scores" tables in the directory sql/ddl/.
 2. Replace the MySQL connection string in servers/sql/server.txt with the connection string to your MySQL database.

### Server

 1. The port 4567 must be open.
 2. Install [Java Development Kit 8 (JDK8)](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and make sure java is in your PATH.
 3. In order to build the project, we use [Gradle](https://gradle.org/). Use one of the following steps:
	* Use the gradle wrapper file (gradlew).
	* Use the scripts in the bin folder in the root of the project.
		* They use the wrapper.
	* Install [Gradle 3.1](https://gradle.org/gradle-download/) and use your local installation.
 4. You can run the script "bin/createJar", use the command "./gradlew fatJar" or, if you want to use the local installation of Gradle, use the command "gradle fatJar" to create an executable jar file in the build/libs/directory.
 5. Run the newly created jar file to start up the server.

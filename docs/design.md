# GitCatGo - Design document

##

## Intro

The initial design is for a command-line version of GitCatGo.

The base package name should be "<B>com.hugbunarfockers.gitcatgo.*</B>", without quotes and replace the asterisk with the actual name (which can go deeper down with more dots).

## Layout

We decided on a simple 3-tier architecture.

### Entities

Package name: <B>com.hugbunarfockers.gitcatgo.entities</B>

Entities contain no logic, they only contain public variables.

Entities are allowed to be used anywhere.

Classes:
 * GameBoard
 	* int[3][3] - Board
 	* int - Winner  

   Glossary for integer values:
   	* 0 - No player
   	* 1 - Player 1
   	* 2 - Player 2
   	* 3 - Tie (only used for Winner variable)
 * Player
 	* int - ID
	* string - Name
	* string - Key
 * Score
 	* int - ID
	* int - Player1ID
	* int - Player2ID
	* int - WinnerID

### Data

Package name: <B>com.hugbunarfockers.gitcatgo.data</B>

Data classes contain methods to persistently store data.

Classes:
 * SQLConnection

### Services

Package name: <B>com.hugbunarfockers.gitcatgo.services</B>

Services contain the main logic of the game and acts as a gateway to the Data classes for UI classes.

Classes:
 * DataService
 	* private variable: SQLConnection - DBCon
 	* public method: addPlayer()
 	* public method: addScore()
 	* public method: getPlayer()
 	* public method: getScore()
 	* public method: getLeaderboard()
 * GameService
 	* private variable: GameBoard - ticTacToe
 	* private variable: Player - player1
 	* private variable: Player - player2
 	* public method: playGame()
 	* private method: makeMove()

### UI

Package name: <B>com.hugbunarfockers.gitcatgo.ui</B>

UI classes only interact with the classes in Services.

Classes:
 * CommandLine
 	* private variable: DataService - dataService
 	* private variable: GameService - gameService

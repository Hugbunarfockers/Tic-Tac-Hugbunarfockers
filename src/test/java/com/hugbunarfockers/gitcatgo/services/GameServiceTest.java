package com.hugbunarfockers.gitcatgo.services;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.hugbunarfockers.gitcatgo.entities.*;

public class GameServiceTest
{
	@Test
	public void testFillBoard()
	{
        Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");
        GameBoard board = new GameBoard();
		GameService testBoard = new GameService(board, p1, p2);
       	char[][] newBoard = testBoard.getBoard();
		assertEquals('2', newBoard[0][1]);
	}

	@Test
	public void testGetBoard()
	{
		Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");
        GameBoard board = new GameBoard();
		GameService testBoard = new GameService(board, p1, p2);
		assertEquals(board.getBoard(), testBoard.getBoard());
	}

	@Test
	public void testGetCurrentPlayer()
	{
		Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");
        GameBoard board = new GameBoard();
		GameService testBoard = new GameService(board, p1, p2);
		assertEquals(p1, testBoard.getCurrentPlayer());
	}

	@Test
	public void testChangeCurrentPlayer()
	{
		Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");
        GameBoard board = new GameBoard();
		GameService testBoard = new GameService(board, p1, p2);
		testBoard.changeCurrentPlayer();
		assertEquals(p2, testBoard.getCurrentPlayer());
	}

	@Test
	public void testSetBoardValue()
	{
		Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");
        GameBoard board = new GameBoard();
		GameService testBoard = new GameService(board, p1, p2);
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				testBoard.setBoardValue(i, j, 'x');
			}
		}

		testBoard.setBoardValue(1,1, 'o');
		char[][] newBoard = testBoard.getBoard();
		assertEquals('x', newBoard[0][1]);
		assertEquals('x', newBoard[1][2]);
		assertEquals('o', newBoard[1][1]);
	}

	@Test
	public void testCheckWinner()
	{
		Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");

        GameBoard board = new GameBoard();
		GameService testBoard = new GameService(board, p1, p2);

		testBoard.setBoardValue(0,0, 'x');
		testBoard.setBoardValue(0,1, 'x');
		testBoard.setBoardValue(0,2, 'x');
		testBoard.setBoardValue(1,0, 'o');
		testBoard.setBoardValue(1,1, 'o');
		testBoard.setBoardValue(2,0, 'x');
		testBoard.setBoardValue(2,1, 'o');
		assertEquals(true, testBoard.checkWinner());

		board = new GameBoard();
		testBoard = new GameService(board, p1, p2);

		testBoard.setBoardValue(0,0, '0');
		testBoard.setBoardValue(0,2, '0');
		testBoard.setBoardValue(1,0, 'x');
		testBoard.setBoardValue(1,1, 'x');
		testBoard.setBoardValue(1,2, 'x');
		testBoard.setBoardValue(2,1, 'o');
		assertEquals(true, testBoard.checkWinner());
		
		board = new GameBoard();
		testBoard = new GameService(board, p1, p2);

		testBoard.setBoardValue(0,1, 'o');
		testBoard.setBoardValue(1,0, 'o');
		testBoard.setBoardValue(1,2, 'o');
		testBoard.setBoardValue(2,0, 'x');
		testBoard.setBoardValue(2,1, 'x');
		testBoard.setBoardValue(2,2, 'x');
		assertEquals(true, testBoard.checkWinner());
		
		board = new GameBoard();
		testBoard = new GameService(board, p1, p2);

		testBoard.setBoardValue(0,0, 'x');
		testBoard.setBoardValue(0,1, 'o');
		testBoard.setBoardValue(1,0, 'x');
		testBoard.setBoardValue(1,2, 'o');
		testBoard.setBoardValue(2,0, 'x');
		testBoard.setBoardValue(2,1, 'o');
		assertEquals(true, testBoard.checkWinner());

		board = new GameBoard();
		testBoard = new GameService(board, p1, p2);	
		
		testBoard.setBoardValue(0,1, 'x');
		testBoard.setBoardValue(0,2, 'o');
		testBoard.setBoardValue(1,0, 'o');
		testBoard.setBoardValue(1,1, 'x');
		testBoard.setBoardValue(2,1, 'x');
		testBoard.setBoardValue(2,2, 'o');	
		assertEquals(true, testBoard.checkWinner());

		board = new GameBoard();
		testBoard = new GameService(board, p1, p2);

		testBoard.setBoardValue(0,1, 'o');
		testBoard.setBoardValue(0,2, 'x');
		testBoard.setBoardValue(1,0, 'o');
		testBoard.setBoardValue(1,2, 'x');
		testBoard.setBoardValue(2,1, 'o');
		testBoard.setBoardValue(2,2, 'x');	
		assertEquals(true, testBoard.checkWinner());

		board = new GameBoard();
		testBoard = new GameService(board, p1, p2);

		testBoard.setBoardValue(0,0, 'o');
		testBoard.setBoardValue(0,2, 'x');
		testBoard.setBoardValue(1,1, 'o');
		testBoard.setBoardValue(2,0, 'x');
		testBoard.setBoardValue(2,1, 'x');
		testBoard.setBoardValue(2,2, 'o');	
		assertEquals(true, testBoard.checkWinner());

		board = new GameBoard();
		testBoard = new GameService(board, p1, p2);

		testBoard.setBoardValue(0,0, 'x');
		testBoard.setBoardValue(0,1, 'x');
		testBoard.setBoardValue(0,2, 'o');
		testBoard.setBoardValue(1,1, 'o');
		testBoard.setBoardValue(2,0, 'o');
		testBoard.setBoardValue(2,1, 'x');	
		assertEquals(true, testBoard.checkWinner());

		board = new GameBoard();
		testBoard = new GameService(board, p1, p2);

		testBoard.setBoardValue(0,0, 'x');
		testBoard.setBoardValue(0,1, 'o');
		testBoard.setBoardValue(0,2, 'x');
		testBoard.setBoardValue(1,0, 'x');
		testBoard.setBoardValue(1,1, 'o');
		testBoard.setBoardValue(1,2, 'x');
		testBoard.setBoardValue(2,0, 'o');
		testBoard.setBoardValue(2,1, 'x');
		testBoard.setBoardValue(2,2, 'o');	
		assertEquals(false, testBoard.checkWinner());
	}

	@Test
	public void testCheckDraw()
	{
		Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");
        GameBoard board = new GameBoard();
		GameService testBoard = new GameService(board, p1, p2);
		
		testBoard.setBoardValue(0,0, 'x');
		testBoard.setBoardValue(0,1, 'o');
		testBoard.setBoardValue(0,2, 'x');
		testBoard.setBoardValue(1,0, 'x');
		testBoard.setBoardValue(1,1, 'o');
		testBoard.setBoardValue(1,2, 'x');
		testBoard.setBoardValue(2,0, 'o');
		testBoard.setBoardValue(2,1, 'x');
		testBoard.setBoardValue(2,2, 'o');	
		assertEquals(false, testBoard.isBoardFull());
	}

	@Test
	public void testMakeMove()
	{
		Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");
        GameBoard board = new GameBoard();
		GameService testBoard = new GameService(board, p1, p2);		
		testBoard.makeMove('1');
		
		char[][] newBoard = testBoard.getBoard();
		assertEquals('x', newBoard[0][0]);
		assertEquals('2', newBoard[0][1]);

		board = new GameBoard();
		testBoard = new GameService(board, p1, p2);
		
		testBoard.changeCurrentPlayer();
		testBoard.makeMove('3');
		
		char[][] newBoardTwo = testBoard.getBoard();
		assertEquals('o', newBoardTwo[0][2]);
	}

	@Test
	public void testMakeMoveInputCheck()
	{
		Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");
        GameBoard board = new GameBoard();
		GameService testBoard = new GameService(board, p1, p2);		
		assertEquals(false, testBoard.makeMove('B'));

		board = new GameBoard();
		testBoard = new GameService(board, p1, p2);
		assertEquals(true, testBoard.makeMove('1'));

		board = new GameBoard();
		testBoard = new GameService(board, p1, p2);
		assertEquals(true, testBoard.makeMove('9'));

		board = new GameBoard();
		testBoard = new GameService(board, p1, p2);
		assertEquals(false, testBoard.makeMove(';'));
	}


	@Test
	public void testCheckWinnerSetWinner(){
		Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");

        GameBoard board = new GameBoard();
		GameService testBoard = new GameService(board, p1, p2);

		testBoard.setBoardValue(0,0, 'x');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(1,0, 'o');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(0,1, 'x');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(1,1, 'o');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(0,2, 'x');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(2,1, 'o');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(2,0, 'x');
		
		testBoard.checkWinner();
		assertEquals(p1, testBoard.getWinner());

		board = new GameBoard();
		testBoard = new GameService(board, p1, p2);

		testBoard.setBoardValue(0,0, 'x');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(0,2, 'o');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(0,1, 'x');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(1,1, 'o');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(2,1, 'x');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(2,0, 'o');
			
		testBoard.checkWinner();
		assertEquals(p2, testBoard.getWinner());

		board = new GameBoard();
		testBoard = new GameService(board, p1, p2);

		testBoard.setBoardValue(0,0, 'x');
		testBoard.setBoardValue(0,1, 'o');
		testBoard.setBoardValue(0,2, 'x');
		testBoard.setBoardValue(1,0, 'x');
		testBoard.setBoardValue(1,1, 'o');
		testBoard.setBoardValue(1,2, 'x');
		testBoard.setBoardValue(2,0, 'o');
		testBoard.setBoardValue(2,1, 'x');
		testBoard.setBoardValue(2,2, 'o');
		testBoard.checkWinner();	
		assertEquals(null, testBoard.getWinner());
	}
}

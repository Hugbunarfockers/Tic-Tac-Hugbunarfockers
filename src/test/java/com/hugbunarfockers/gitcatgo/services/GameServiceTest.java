package com.hugbunarfockers.gitcatgo.services;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.hugbunarfockers.gitcatgo.entities.*;

public class GameServiceTest
{
	@Test
	public void testAddEmptyGameService()
	{
		GameService testBoard = new GameService();

		assertEquals(null, testBoard.getPlayer1());
		assertEquals(null, testBoard.getPlayer2());
		assertEquals(null, testBoard.getCurrentPlayer());
		assertEquals(null, testBoard.getBoard());
	}

	@Test
	public void testFillBoard()
	{
        Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");
        GameBoard board = new GameBoard();
		IGameService testBoard = new GameService(board, p1, p2);
       	char[][] newBoard = testBoard.getBoard();
		assertEquals('2', newBoard[0][1]);
	}

	@Test
	public void testGetBoard()
	{
		Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");
        GameBoard board = new GameBoard();
		IGameService testBoard = new GameService(board, p1, p2);
		assertEquals(board.getBoard(), testBoard.getBoard());
	}

	@Test
	public void testGetCurrentPlayer()
	{
		Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");
        GameBoard board = new GameBoard();
		IGameService testBoard = new GameService(board, p1, p2);
		assertEquals(p1, testBoard.getCurrentPlayer());
	}

	@Test
	public void testChangeCurrentPlayer()
	{
		Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");
        GameBoard board = new GameBoard();
		IGameService testBoard = new GameService(board, p1, p2);
		testBoard.changeCurrentPlayer();
		assertEquals(p2, testBoard.getCurrentPlayer());
	}

	@Test
	public void testSetBoardValue()
	{
		Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");
        GameBoard board = new GameBoard();
		IGameService testBoard = new GameService(board, p1, p2);

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
		IGameService testBoard = new GameService(board, p1, p2);

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
		IGameService testBoard = new GameService(board, p1, p2);

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
		IGameService testBoard = new GameService(board, p1, p2);
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
		IGameService testBoard = new GameService(board, p1, p2);
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
	public void testCheckWinnerSetWinner()
	{
		Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");

        GameBoard board = new GameBoard();
		IGameService testBoard = new GameService(board, p1, p2);

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

	@Test
	public void testCheckWinnerForCrossWin()
	{
		Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");

        GameBoard board = new GameBoard();
		IGameService testBoard = new GameService(board, p1, p2);

		testBoard.setBoardValue(0,0, 'x');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(1,0, 'o');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(1,1, 'x');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(0,1, 'o');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(0,2, 'x');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(2,1, 'o');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(2,2, 'x');

		testBoard.checkWinner();
		assertEquals(p1, testBoard.getWinner());

		board = new GameBoard();
		testBoard = new GameService(board, p1, p2);

		testBoard.setBoardValue(0,2, 'x');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(1,0, 'o');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(1,1, 'x');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(0,1, 'o');
		testBoard.changeCurrentPlayer();
		testBoard.setBoardValue(2,0, 'x');

		testBoard.checkWinner();
		assertEquals(p1, testBoard.getWinner());

		board = new GameBoard();
		testBoard = new GameService(board, p1, p2);

		testBoard.setBoardValue(0,2, 'x');
		testBoard.setBoardValue(1,1, 'x');
		testBoard.setBoardValue(2,0, 'x');
		testBoard.setBoardValue(0,0, 'x');
		testBoard.setBoardValue(1,1, 'x');
		testBoard.setBoardValue(2,2, 'x');

		testBoard.checkWinner();
		assertEquals(p1, testBoard.getWinner());
	}

	@Test
	public void testIsBoardFull()
	{
		Player p1 = new Player(1, "s", "b");
		Player p2 = new Player(2, "h", "l");
		GameBoard board = new GameBoard();
		IGameService testBoard = new GameService(board, p1, p2);

		assertEquals(false, testBoard.isBoardFull());

		for(int i = 1; i < 10; i++)
		{
			testBoard.makeMove((char)(i + 48));
		}

		assertEquals(true, testBoard.isBoardFull());
	}

	@Test
	public void testcheckIfOccupied()
	{
		Player p1 = new Player(1, "s", "b");
		Player p2 = new Player(2, "h", "l");
		GameBoard board = new GameBoard();
		IGameService testBoard = new GameService(board, p1, p2);

		testBoard.setBoardValue(0,2, 'x');
		
		assertEquals(true, testBoard.checkIfOccupied('3'));
	}

	@Test
	public void testSetBoard()
	{
		GameService gs = new GameService();
		GameBoard board = new GameBoard();

		gs.setBoard(board);
		char[][] checkBoard = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
		assertEquals(checkBoard, gs.getBoard());
	}

	@Test
	public void testSetPlayer1()
	{
		Player p1 = new Player(1, "s", "b");
		GameService gs = new GameService();
		gs.setPlayer1(p1);

		assertEquals(p1, gs.getPlayer1());
	}

	@Test
	public void testSetPlayer2()
	{
		Player p2 = new Player(1, "s", "b");
		GameService gs = new GameService();
		gs.setPlayer2(p2);

		assertEquals(p2, gs.getPlayer2());
	}
}

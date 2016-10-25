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


}

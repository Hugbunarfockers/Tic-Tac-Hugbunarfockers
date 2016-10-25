package com.hugbunarfockers.gitcatgo.services;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameServiceTest
{
	@Test
	public void testFillBoard()
	{
        Player p1 = new Player(1, "s", "b");
        Player p2 = new Player(2, "h", "l");
        Gameboard board = new Gameboard();
		GameService testBoard = new GameService(board, p1, p2);
		testBoard.fillBoard();
        int[][] testBoard = board.getBoard();
		assertEquals(1, testBoard[0][0]);
	}
}

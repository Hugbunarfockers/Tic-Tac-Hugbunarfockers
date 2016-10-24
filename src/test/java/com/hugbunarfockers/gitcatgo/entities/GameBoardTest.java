package com.hugbunarfockers.gitcatgo.entities;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameBoardTest
{
	@Test
	public void testSetBoardValue()
	{
		GameBoard testBoard = new GameBoard();
		testBoard.setBoardValue(1, 1, 1);
		assertEquals(1, testBoard.getBoard()[1][1]);
	}

	@Test
	public void testSetSize()
	{
		assertEquals(3, GameBoard.getSize());
	}

	@Test
	public void testWinner()
	{
		GameBoard testBoard = new GameBoard();
		testBoard.setWinner(2);
		assertEquals(2, testBoard.getWinner());
	}
}

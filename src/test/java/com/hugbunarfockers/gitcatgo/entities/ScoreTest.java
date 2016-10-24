package com.hugbunarfockers.gitcatgo.entities;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ScoreTest
{
	@Test
	public void TestGetPlayer1ID()
	{
		Score score = new Score(1, 2, 1);
		assertEquals(1, score.getPlayer1ID());	
	}

	@Test
	public void TestGetPlayer2ID()
	{
		Score score = new Score(1, 2, 1);
		assertEquals(2, score.getPlayer2ID());	
	}

	@Test
	public void TestGetWinnerID()
	{
		Score score = new Score(1, 2, 3);
		assertEquals(3, score.getWinnerID());	
	}

	@Test
	public void TestSetPlayer1ID()
	{
		Score score = new Score(1, 2, 3);
		score.setPlayer1ID(5);
		assertEquals(5, score.getPlayer1ID());	
	}

	@Test
	public void TestSetPlayer2ID()
	{
		Score score = new Score(1, 2, 3);
		score.setPlayer1ID(6);
		assertEquals(6, score.getPlayer1ID());	
	}

	@Test
	public void TestSetWinnerID()
	{
		Score score = new Score(1, 2, 3);
		score.setPlayer1ID(6);
		assertEquals(6, score.getPlayer1ID());	
	}
}
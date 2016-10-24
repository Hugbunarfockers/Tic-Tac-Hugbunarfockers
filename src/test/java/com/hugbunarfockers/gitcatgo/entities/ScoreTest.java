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
}
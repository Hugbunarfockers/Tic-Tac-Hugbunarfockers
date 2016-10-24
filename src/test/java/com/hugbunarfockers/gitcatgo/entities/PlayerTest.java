package com.hugbunarfockers.gitcatgo.entities;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.hamcrest.Matcher;

public class PlayerTest
{
	@Test
	public void testGetId()
	{
		Player newPlayer = new Player(1, "Sigrún", "666");
		assertEquals(1, newPlayer.getId());
	}
	
}
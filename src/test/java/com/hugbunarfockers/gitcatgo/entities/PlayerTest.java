package com.hugbunarfockers.gitcatgo.entities;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlayerTest
{
	@Test
	public void testGetId()
	{
		Player newPlayer = new Player(1, "Sigrún", "666");
		assertEquals(1, newPlayer.getId());
	}

	@Test
	public void testGetName()
	{
		Player newPlayer = new Player(1, "Sigrún", "666");
		assertEquals("Sigrún", newPlayer.getName());
	}

	@Test
	public void testGetKey()
	{
		Player newPlayer = new Player(1, "Sigrún", "666");
		assertEquals("666", newPlayer.getKey());
	}
	
}
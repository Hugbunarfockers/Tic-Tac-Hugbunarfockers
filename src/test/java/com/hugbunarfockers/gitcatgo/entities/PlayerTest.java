package com.hugbunarfockers.gitcatgo.entities;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlayerTest
{
	@Test
	public void testEmptyConstructor()
	{
		Player newPlayer = new Player();
		assertEquals(0, newPlayer.getID());
		assertEquals(null, newPlayer.getName());
		assertEquals(null, newPlayer.getKey());
	}

	@Test
	public void testGetID()
	{
		Player newPlayer = new Player(1, "Sigrún", "666");
		assertEquals(1, newPlayer.getID());
	}

	@Test
	public void testSetID()
	{
		Player newPlayer = new Player();
		int ID = 10;
		newPlayer.setID(ID);
		assertEquals(10, newPlayer.getID());
	}

	@Test
	public void testGetName()
	{
		Player newPlayer = new Player(1, "Sigrún", "666");
		assertEquals("Sigrún", newPlayer.getName());
	}

	@Test
	public void testSetName()
	{
		Player newPlayer = new Player();
		String name = "Unnur";
		newPlayer.setName(name);
		assertEquals("Unnur", newPlayer.getName());
	}

	@Test
	public void testGetKey()
	{
		Player newPlayer = new Player(1, "Sigrún", "666");
		assertEquals("666", newPlayer.getKey());
	}

	@Test
	public void testSetKey()
	{
		Player newPlayer = new Player();
		String key = "666";
		newPlayer.setKey(key);
		assertEquals("666", newPlayer.getKey());
	}

}

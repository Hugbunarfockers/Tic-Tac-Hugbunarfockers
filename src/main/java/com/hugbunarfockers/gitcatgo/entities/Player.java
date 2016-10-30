package com.hugbunarfockers.gitcatgo.entities;

public class Player
{
	private int playerID;
	private String playerName;
	private String playerKey;

	public Player()
	{
		playerID = 0;
		playerName = null;
		playerKey = null;
	}

	public Player(int ID, String name, String key)
	{
		playerID = ID;
		playerName = name;
		playerKey = key;
	}

	public int getID()
	{
		return playerID;
	}

	public void setID(int ID)
	{
		playerID = ID;
	}

	public String getName()
	{
		return playerName;
	}

	public void setName(String playerName)
	{
		this.playerName = playerName;
	}

	public String getKey()
	{
		return playerKey;
	}

	public void setKey(String playerKey)
	{
		this.playerKey = playerKey;
	}

}

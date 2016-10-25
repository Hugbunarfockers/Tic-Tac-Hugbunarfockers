package com.hugbunarfockers.gitcatgo.entities;

public class Player
{
	private int playerID;
	private String playerName;
	private String playerKey;

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

	public String getName()
	{
		return playerName;
	}

	public String getKey()
	{
		return playerKey;
	}

}

package com.hugbunarfockers.gitcatgo.entities;

public class Player
{
	private int playerId;
	private String playerName;
	private String playerKey;

	public Player(int id, String name, String key)
	{
		playerId = id;
		playerName = name;
		playerKey = key;
	}

	public int getId()
	{
		return playerId;
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
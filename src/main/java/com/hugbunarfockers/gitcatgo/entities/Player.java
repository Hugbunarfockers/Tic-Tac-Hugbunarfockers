package com.hugbunarfockers.gitcatgo.entities;

public class Player{
	
	private static int playerId;
	private static String playerName;
	private static String playerKey;

	public static Player(int id, String name, String key)
	{
		playerId = id;
		playerName = name;
		playerKey = key;
	}

	public int getId(){
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
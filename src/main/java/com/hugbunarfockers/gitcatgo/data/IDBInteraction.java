package com.hugbunarfockers.gitcatgo.data;

import com.hugbunarfockers.gitcatgo.entities.Player;

public interface IDBInteraction
{
	public boolean addPlayer(String name, String key);

	public Player getPlayer(String name, String key);

	public boolean addScore(int player1ID, int player2ID, int winnerID);

	public int getWinsBetweenPlayerIDs(int playerID, int opponentID);
}

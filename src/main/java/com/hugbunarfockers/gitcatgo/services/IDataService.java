package com.hugbunarfockers.gitcatgo.services;

import com.hugbunarfockers.gitcatgo.entities.Player;

public interface IDataService
{
    public boolean addPlayer(String name, String key);

    public Player getPlayer(String name, String key);

    public boolean addScore(int player1ID, int player2ID, int winnerID);

    public int getWinsBetweenPlayerIDs(int playerID, int opponentID);

    public void close();

    public boolean isClosed();
}

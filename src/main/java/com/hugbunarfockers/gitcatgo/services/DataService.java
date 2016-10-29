package com.hugbunarfockers.gitcatgo.services;

import com.hugbunarfockers.gitcatgo.data.*;
import com.hugbunarfockers.gitcatgo.entities.Player;

public class DataService
{
    private static DBManagement dbm;
    private static DBInteraction dbi;

    public DataService(String connectionString)
    {
        dbm = new DBManagement(connectionString);
        dbi = new DBInteraction(dbm);
    }

    public boolean addPlayer(String name, String key)
    {
        return dbi.addPlayer(name.toUpperCase(), key.toUpperCase());
    }

    public Player getPlayer(String name, String key)
    {
        return dbi.getPlayer(name.toUpperCase(), key.toUpperCase());
    }

    public boolean addScore(int player1ID, int player2ID, int winnerID)
    {
        return dbi.addScore(player1ID, player2ID, winnerID);
    }

    public int getWinsBetweenPlayerIDs(int playerID, int opponentID)
    {
        return dbi.getWinsBetweenPlayerIDs(playerID, opponentID);
    }

    public void close()
    {
        dbm.close();
    }

    public boolean isClosed()
    {
        return dbm.isClosed();
    }
}

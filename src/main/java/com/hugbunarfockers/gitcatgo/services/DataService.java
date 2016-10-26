package com.hugbunarfockers.gitcatgo.services;

import com.hugbunarfockers.gitcatgo.data.*;
import com.hugbunarfockers.gitcatgo.entities.Player;

public class DataService
{
    private static DBManagement dbm;
    private static DBInteraction dbi;

    public DataService(DBManagement dbm)
    {
        this.dbm = dbm;
        dbi = new DBInteraction(this.dbm);
    }

    public boolean addPlayer(String name, String key)
    {
        return dbi.addPlayer(name.toUpperCase(), key.toUpperCase());
    }

    public Player getPlayer(String name, String key)
    {
        return dbi.getPlayer(name.toUpperCase(), key.toUpperCase());
    }
}

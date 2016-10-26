package com.hugbunarfockers.gitcatgo.services;

import com.hugbunarfockers.gitcatgo.data.*;

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
}

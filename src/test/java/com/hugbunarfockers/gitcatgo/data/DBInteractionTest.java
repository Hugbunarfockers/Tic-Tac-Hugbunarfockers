package com.hugbunarfockers.gitcatgo.data;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBInteractionTest
{
    private final String sqliteConnectionString = "jdbc:sqlite:sql/mock/GitCatGoMock.db";

    @Test
	public void testAddPlayer()
	{
		DBManagement dbm = new DBManagement(sqliteConnectionString);
        DBInteraction dbi = new DBInteraction(dbm);

		assertEquals(true, dbi.addPlayer("Test", "tests"));
		dbm.close();
	}
}

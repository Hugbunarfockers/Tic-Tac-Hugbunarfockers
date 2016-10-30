package com.hugbunarfockers.gitcatgo.data;

import com.hugbunarfockers.gitcatgo.entities.Player;
import com.hugbunarfockers.gitcatgo.entities.Score;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBInteractionTest
{
    private final String sqliteConnectionString = "jdbc:sqlite:sql/mock/GitCatGoMock.db";

    @Test
	public void testAddPlayer()
	{
		truncateTables();

		IDBManagement dbm = new DBManagement(sqliteConnectionString);
        IDBInteraction dbi = new DBInteraction(dbm);

		assertEquals(true, dbi.addPlayer("TEST", "TESTS"));

		dbm.close();

		truncateTables();
	}

	@Test
	public void testAddSamePlayerTwice()
	{
		truncateTables();

		IDBManagement dbm = new DBManagement(sqliteConnectionString);
        IDBInteraction dbi = new DBInteraction(dbm);

		assertEquals(true, dbi.addPlayer("TEST", "TESTS"));
		assertEquals(false, dbi.addPlayer("TEST", "TESTS"));

		dbm.close();

		truncateTables();
	}

	@Test
	public void testGetPlayer()
	{
		truncateTables();

		IDBManagement dbm = new DBManagement(sqliteConnectionString);
        IDBInteraction dbi = new DBInteraction(dbm);

		// Create compare player
		Player comparePlayer = new Player(1, "TEST", "TESTS");

		// Add the player
		assertEquals(true, dbi.addPlayer("TEST", "TESTS"));

		// Compare
		Player dbPlayer = dbi.getPlayer("TEST", "TESTS");

		assertEquals(comparePlayer.getID(), dbPlayer.getID());
		assertEquals(comparePlayer.getName(), dbPlayer.getName());
		assertEquals(comparePlayer.getKey(), dbPlayer.getKey());

		dbm.close();

		truncateTables();
	}

	@Test
	public void testAddScore()
	{
		truncateTables();

		IDBManagement dbm = new DBManagement(sqliteConnectionString);
        IDBInteraction dbi = new DBInteraction(dbm);

		// Add players
		assertEquals(true, dbi.addPlayer("PLAYER1", "TESTS"));
		assertEquals(true, dbi.addPlayer("PLAYER2", "TESTS"));

		// Add score
		assertEquals(true, dbi.addScore(1, 2, 1));

		dbm.close();

		truncateTables();
	}

	@Test
	public void testAddDraw()
	{
		truncateTables();

		IDBManagement dbm = new DBManagement(sqliteConnectionString);
        IDBInteraction dbi = new DBInteraction(dbm);

        // Add players
		assertEquals(true, dbi.addPlayer("PLAYER1", "TESTS"));
		assertEquals(true, dbi.addPlayer("PLAYER2", "TESTS"));

		// Getting players
		Player p1 = dbi.getPlayer("PLAYER1", "TESTS");
		Player p2 = dbi.getPlayer("PLAYER2", "TESTS");

		// Add score
		assertEquals(true, dbi.addScore(1, 2, 0));

		// Asserting both players have 0 victories agains one another
		assertEquals(0, dbi.getWinsBetweenPlayerIDs(p1.getID(), p2.getID()));
		assertEquals(0, dbi.getWinsBetweenPlayerIDs(p2.getID(), p1.getID()));

		truncateTables();
	}

	@Test
	public void testGetWinsBetweenPlayerIDs()
	{
		truncateTables();

		IDBManagement dbm = new DBManagement(sqliteConnectionString);
        IDBInteraction dbi = new DBInteraction(dbm);

		// Add players
		assertEquals(true, dbi.addPlayer("PLAYER1", "TESTS"));
		assertEquals(true, dbi.addPlayer("PLAYER2", "TESTS"));

		// Add scores
		assertEquals(true, dbi.addScore(1, 2, 1));
		assertEquals(true, dbi.addScore(2, 1, 1));
		assertEquals(true, dbi.addScore(1, 2, 1));
		assertEquals(true, dbi.addScore(1, 2, 2));
		assertEquals(true, dbi.addScore(2, 1, 2));

		assertEquals(3, dbi.getWinsBetweenPlayerIDs(1, 2));
		assertEquals(2, dbi.getWinsBetweenPlayerIDs(2, 1));

		dbm.close();

		truncateTables();
	}

    @Test
	public void testAddPlayerIsClosed()
	{
		truncateTables();

		IDBManagement dbm = new DBManagement(sqliteConnectionString);
        IDBInteraction dbi = new DBInteraction(dbm);

        dbm.close();
		assertEquals(false, dbi.addPlayer("PLAYER1", "TEST"));

		truncateTables();
	}

    @Test
	public void testGetPlayerIsClosed()
	{
		truncateTables();

		IDBManagement dbm = new DBManagement(sqliteConnectionString);
        IDBInteraction dbi = new DBInteraction(dbm);

        dbm.close();
		assertEquals(null, dbi.getPlayer("PLAYER1", "TEST"));

		truncateTables();
	}

    @Test
	public void testAddScoreIsClosed()
	{
		truncateTables();

		IDBManagement dbm = new DBManagement(sqliteConnectionString);
        IDBInteraction dbi = new DBInteraction(dbm);

        dbm.close();
		assertEquals(false, dbi.addScore(1, 2, 2));

		truncateTables();
	}

    @Test
	public void testgetWinsBetweenPlayerIDsIsClosed()
	{
		truncateTables();

		IDBManagement dbm = new DBManagement(sqliteConnectionString);
        IDBInteraction dbi = new DBInteraction(dbm);

        dbm.close();
		assertEquals(0, dbi.getWinsBetweenPlayerIDs(1, 2));

		truncateTables();
	}

	private void truncateTables()
	{
		IDBManagement dbm = new DBManagement(sqliteConnectionString);

		try
		{
			PreparedStatement stmt = dbm.prepareStatement("DELETE FROM sqlite_sequence");
			stmt.executeUpdate();
			stmt.close();

			stmt = dbm.prepareStatement("DELETE FROM Scores");
			stmt.executeUpdate();
			stmt.close();

			stmt = dbm.prepareStatement("DELETE FROM Players");
			stmt.executeUpdate();
			stmt.close();
		}
		catch(SQLException ex)
		{
			dbm.printSQLException(ex);
		}

		dbm.close();
	}
}

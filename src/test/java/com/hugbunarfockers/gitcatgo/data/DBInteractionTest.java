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

		DBManagement dbm = new DBManagement(sqliteConnectionString);
        DBInteraction dbi = new DBInteraction(dbm);

		assertEquals(true, dbi.addPlayer("TEST", "TESTS"));

		dbm.close();

		truncateTables();
	}

	@Test
	public void testAddSamePlayerTwice()
	{
		truncateTables();

		DBManagement dbm = new DBManagement(sqliteConnectionString);
        DBInteraction dbi = new DBInteraction(dbm);

		assertEquals(true, dbi.addPlayer("TEST", "TESTS"));
		assertEquals(false, dbi.addPlayer("TEST", "TESTS"));

		dbm.close();

		truncateTables();
	}

	@Test
	public void testGetPlayer()
	{
		truncateTables();

		DBManagement dbm = new DBManagement(sqliteConnectionString);
        DBInteraction dbi = new DBInteraction(dbm);

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

		DBManagement dbm = new DBManagement(sqliteConnectionString);
        DBInteraction dbi = new DBInteraction(dbm);

		// Add players
		assertEquals(true, dbi.addPlayer("PLAYER1", "TESTS"));
		assertEquals(true, dbi.addPlayer("PLAYER2", "TESTS"));

		// Add score
		assertEquals(true, dbi.addScore(1, 2, 1));

		dbm.close();

		truncateTables();
	}

	@Test
	public void testGetWinsBetweenPlayerIDs()
	{
		truncateTables();

		DBManagement dbm = new DBManagement(sqliteConnectionString);
        DBInteraction dbi = new DBInteraction(dbm);

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

	private void truncateTables()
	{
		DBManagement dbm = new DBManagement(sqliteConnectionString);

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
			DBManagement.printSQLException(ex);
		}

		dbm.close();
	}
}
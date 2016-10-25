package com.hugbunarfockers.gitcatgo.data;

import com.hugbunarfockers.gitcatgo.entities.Player;
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
		truncateTables();

		DBManagement dbm = new DBManagement(sqliteConnectionString);
        DBInteraction dbi = new DBInteraction(dbm);

		assertEquals(true, dbi.addPlayer("Test", "tests"));

		dbm.close();

		truncateTables();
	}

	@Test
	public void testAddSamePlayerTwice()
	{
		truncateTables();

		DBManagement dbm = new DBManagement(sqliteConnectionString);
        DBInteraction dbi = new DBInteraction(dbm);

		assertEquals(true, dbi.addPlayer("Test", "tests"));
		assertEquals(false, dbi.addPlayer("Test", "tests"));

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
		assertEquals(true, dbi.addPlayer("Test", "tests"));

		// Compare
		Player dbPlayer = dbi.getPlayer("TEST", "TESTS");

		assertEquals(comparePlayer.getID(), dbPlayer.getID());
		assertEquals(comparePlayer.getName(), dbPlayer.getName());
		assertEquals(comparePlayer.getKey(), dbPlayer.getKey());

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

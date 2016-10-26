package com.hugbunarfockers.gitcatgo.services;

import com.hugbunarfockers.gitcatgo.data.DBManagement;
import com.hugbunarfockers.gitcatgo.entities.Player;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DataServiceTest
{
    private final String sqliteConnectionString = "jdbc:sqlite:sql/mock/GitCatGoMock.db";

    @Test
	public void testAddPlayer()
	{
		truncateTables();

		DBManagement dbm = new DBManagement(sqliteConnectionString);
		DataService dataService = new DataService(dbm);

		assertEquals(true, dataService.addPlayer("Test", "tests"));

		dbm.close();

		truncateTables();
	}

	@Test
	public void testGetPlayer()
	{
		truncateTables();

		DBManagement dbm = new DBManagement(sqliteConnectionString);
        DataService dataService = new DataService(dbm);

		// Create compare player
		Player comparePlayer = new Player(1, "TEST", "TESTS");

		// Add the player
		assertEquals(true, dataService.addPlayer("TEST", "TESTS"));

		// Compare
		Player dbPlayer = dataService.getPlayer("TEST", "TESTS");

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
		DataService dataService = new DataService(dbm);

		// Add players
		assertEquals(true, dataService.addPlayer("PLAYER1", "TESTS"));
		assertEquals(true, dataService.addPlayer("PLAYER2", "TESTS"));

		// Add score
		assertEquals(true, dataService.addScore(1, 2, 1));

		dbm.close();

		truncateTables();
	}

	@Test
	public void testGetWinsBetweenPlayerIDs()
	{
		truncateTables();

		DBManagement dbm = new DBManagement(sqliteConnectionString);
        DataService dataService = new DataService(dbm);

		// Add players
		assertEquals(true, dataService.addPlayer("PLAYER1", "TESTS"));
		assertEquals(true, dataService.addPlayer("PLAYER2", "TESTS"));

		// Add scores
		assertEquals(true, dataService.addScore(1, 2, 1));
		assertEquals(true, dataService.addScore(2, 1, 1));
		assertEquals(true, dataService.addScore(1, 2, 1));
		assertEquals(true, dataService.addScore(1, 2, 2));
		assertEquals(true, dataService.addScore(2, 1, 2));

		assertEquals(3, dataService.getWinsBetweenPlayerIDs(1, 2));
		assertEquals(2, dataService.getWinsBetweenPlayerIDs(2, 1));

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

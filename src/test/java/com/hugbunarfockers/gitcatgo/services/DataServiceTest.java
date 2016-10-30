package com.hugbunarfockers.gitcatgo.services;

import com.hugbunarfockers.gitcatgo.data.IDBManagement;
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

		DataService dataService = new DataService(sqliteConnectionString);

		assertEquals(true, dataService.addPlayer("Test", "tests"));

		dataService.close();

		truncateTables();
	}

	@Test
	public void testGetPlayer()
	{
		truncateTables();

        DataService dataService = new DataService(sqliteConnectionString);

		// Create compare player
		Player comparePlayer = new Player(1, "TEST", "TESTS");

		// Add the player
		assertEquals(true, dataService.addPlayer("TEST", "TESTS"));

		// Compare
		Player dbPlayer = dataService.getPlayer("TEST", "TESTS");

		assertEquals(comparePlayer.getID(), dbPlayer.getID());
		assertEquals(comparePlayer.getName(), dbPlayer.getName());
		assertEquals(comparePlayer.getKey(), dbPlayer.getKey());

		dataService.close();

		truncateTables();
	}

	@Test
	public void testAddScore()
	{
		truncateTables();

		DataService dataService = new DataService(sqliteConnectionString);

		// Add players
		assertEquals(true, dataService.addPlayer("PLAYER1", "TESTS"));
		assertEquals(true, dataService.addPlayer("PLAYER2", "TESTS"));

		// Add score
		assertEquals(true, dataService.addScore(1, 2, 1));

		dataService.close();

		truncateTables();
	}

	@Test
	public void testGetWinsBetweenPlayerIDs()
	{
		truncateTables();

        DataService dataService = new DataService(sqliteConnectionString);

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

		dataService.close();

		truncateTables();
	}

	@Test
	public void testClose()
	{
		DataService dataService = new DataService(sqliteConnectionString);

		dataService.close();

		assertEquals(true, dataService.isClosed());
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

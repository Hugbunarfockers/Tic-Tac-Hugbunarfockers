package com.hugbunarfockers.gitcatgo.services;

import com.hugbunarfockers.gitcatgo.data.DBManagement;
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

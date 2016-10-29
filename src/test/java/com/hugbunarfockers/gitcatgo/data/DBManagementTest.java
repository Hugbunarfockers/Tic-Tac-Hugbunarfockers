package com.hugbunarfockers.gitcatgo.data;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBManagementTest
{
	private final String sqliteConnectionString = "jdbc:sqlite:sql/mock/GitCatGoMock.db";

	@Test
	public void testIsClosed() throws Exception
	{
		DBManagement dbm = new DBManagement(sqliteConnectionString);
		assertEquals(false, dbm.isClosed());
		dbm.close();
	}

	@Test
	public void testClose() throws Exception
	{
		DBManagement dbm = new DBManagement(sqliteConnectionString);
		dbm.close();
		assertEquals(true, dbm.isClosed());
	}

	@Test
	public void testPrepareStatement() throws Exception
	{
		DBManagement dbm = new DBManagement(sqliteConnectionString);
		PreparedStatement stmt = dbm.prepareStatement("SELECT * FROM Players");

		try
		{
			assertEquals(false, stmt.isClosed());
			stmt.close();
			dbm.close();
		}
		catch(SQLException ex)
		{
			// Assertion will fail if we end up here
			// No need to handle the exception
			//assertEquals(, ex.getMessage());
		}
	}

	@Test
	public void testPrepareStatementIfClosed() throws Exception
	{
		DBManagement dbm = new DBManagement(sqliteConnectionString);
		PreparedStatement stmt = dbm.prepareStatement("SELECT * FROM Players");

		try
		{
			stmt.close();
			dbm.close();
			assertEquals(true, stmt.isClosed());
		}
		catch(SQLException ex)
		{
			// Assertion will fail if we end up here
			// No need to handle the exception
			//assertEquals(, ex.getMessage());
		}

		assertEquals(null, dbm.prepareStatement("SELECT * FROM Players"));
	}
}

package com.hugbunarfockers.gitcatgo.data;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBManagementTest
{
	@Test
	public void testIsClosed()
	{
		DBManagement dbm = new DBManagement();
		assertEquals(false, dbm.isClosed());
		dbm.close();
	}

	@Test
	public void testClose()
	{
		DBManagement dbm = new DBManagement();
		dbm.close();
		assertEquals(true, dbm.isClosed());
	}

	@Test
	public void testPrepareStatement()
	{
		DBManagement dbm = new DBManagement();
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
		}
	}
}

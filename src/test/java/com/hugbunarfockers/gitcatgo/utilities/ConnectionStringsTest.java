package com.hugbunarfockers.gitcatgo.utilities;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConnectionStringsTest
{
	@Test
	public void testGetSQLiteConnectionString()
	{
		assertEquals("jdbc:sqlite:sql/mock/GitCatGoMock.db",
					ConnectionStrings.getSQLiteConnectionString());
	}

	@Test
	public void testGetMySQLConnectionString()
	{
		assertEquals("jdbc:mysql://173.248.137.197:3306/gitcatgo?"
	               + "user=gitcatgo&password=gitcatgo2016",
					ConnectionStrings.getMySQLConnectionString());
	}
}

package com.hugbunarfockers.gitcatgo.utilities;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConnectionStringsTest
{
	@Test
	public void getSQLiteConnectionString()
	{
		assertEquals("jdbc:sqlite:sql/mock/GitCatGoMock.db",
					ConnectionStrings.getSQLiteConnectionString());
	}
}

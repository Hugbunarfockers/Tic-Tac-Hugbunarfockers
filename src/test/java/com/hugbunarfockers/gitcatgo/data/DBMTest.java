package com.hugbunarfockers.gitcatgo.data;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DBMTest
{
	@Test
	public void testIsClosed()
	{
		DBM dbm = new DBM();
		assertEquals(false, dbm.isClosed());
	}
}

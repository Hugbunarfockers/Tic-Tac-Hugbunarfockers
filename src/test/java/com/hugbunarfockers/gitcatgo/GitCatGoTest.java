package com.hugbunarfockers.gitcatgo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GitCatGoTest
{
	@Test
	public void TestMain()
	{
		assertEquals("Hello World!", GitCatGo.HelloWorld());
	}
}
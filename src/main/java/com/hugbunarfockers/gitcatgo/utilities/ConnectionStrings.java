package com.hugbunarfockers.gitcatgo.utilities;

public class ConnectionStrings
{
	private static final String SQLITE = "jdbc:sqlite:sql/mock/GitCatGoMock.db";
	private static final String MYSQL = "jdbc:mysql://173.248.137.197:3306/gitcatgo?"
                                      + "user=gitcatgo&password=gitcatgo2016";

	public static String getSQLiteConnectionString()
	{
		return SQLITE;
	}
}

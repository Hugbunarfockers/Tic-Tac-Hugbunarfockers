package com.hugbunarfockers.gitcatgo.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBM
{
	private Connection db;

	public DBM()
	{
		try
		{
			db = DriverManager.getConnection("jdbc:mysql://173.248.137.197:3306/gitcatgo?"
												+ "user=gitcatgo&password=gitcatgo2016");
		}
		catch(SQLException ex)
		{
			printSQLException(ex);
		}
	}

	public boolean isClosed()
	{
		try
		{
			return db.isClosed();
		}
		catch(SQLException ex)
		{
			printSQLException(ex);
		}

		return true;
	}

	private void printSQLException(SQLException ex)
	{
		System.out.println("SQLException: " + ex.getMessage());
		System.out.println("SQLState: " + ex.getSQLState());
		System.out.println("VendorError: " + ex.getErrorCode());
	}
}

package com.hugbunarfockers.gitcatgo.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DBManagement implements IDBManagement
{
	private Connection db;

	public DBManagement(String connectionString)
	{
		try
		{
			db = DriverManager.getConnection(connectionString);
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

	public void close()
	{
		try
		{
			db.close();
		}
		catch(SQLException ex)
		{
			printSQLException(ex);
		}
	}

	public PreparedStatement prepareStatement(String sql)
	{
		if(!isClosed())
		{
			try
			{
				return db.prepareStatement(sql);
			}
			catch(SQLException ex)
			{
				printSQLException(ex);
			}
		}

		return null;
	}

	public void printSQLException(SQLException ex)
	{
		System.out.println("SQLException: " + ex.getMessage());
		System.out.println("SQLState: " + ex.getSQLState());
		System.out.println("VendorError: " + ex.getErrorCode());
	}
}

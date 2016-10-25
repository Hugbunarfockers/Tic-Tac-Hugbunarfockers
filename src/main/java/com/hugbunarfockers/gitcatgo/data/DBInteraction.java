package com.hugbunarfockers.gitcatgo.data;

import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DBInteraction
{
	private DBManagement dbm;

	public DBInteraction(DBManagement dbm)
	{
		this.dbm = dbm;
	}

	public boolean addPlayer(String name, String key)
	{
		if(!dbm.isClosed())
		{
			try
			{
				String sql = "INSERT INTO Players (Name, PKey) VALUES (?, ?)";

				PreparedStatement stmt = dbm.prepareStatement(sql);
				stmt.setString(1, name.toUpperCase());
	      		stmt.setString(2, key.toUpperCase());

	      		int rowsAffected = stmt.executeUpdate();

				stmt.close();

				if(rowsAffected == 1)
				{
					return true;
				}
			}
			catch(SQLException ex)
			{
				DBManagement.printSQLException(ex);
			}
		}

		return false;
	}
}

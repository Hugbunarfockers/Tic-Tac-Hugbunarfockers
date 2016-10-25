package com.hugbunarfockers.gitcatgo.data;

import com.hugbunarfockers.gitcatgo.entities.Player;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	public Player getPlayer(String name, String key)
	{
		Player player = null;

		if(!dbm.isClosed())
		{
			try
			{
				String sql = "SELECT * FROM Players WHERE Name = ? AND PKey = ?";

				PreparedStatement stmt = dbm.prepareStatement(sql);
				stmt.setString(1, name.toUpperCase());
	      		stmt.setString(2, key.toUpperCase());

	      		ResultSet rs = stmt.executeQuery();

				if(rs.next())
				{
					int pID = rs.getInt("ID");
					String pName = rs.getString("Name");
					String pKey = rs.getString("PKey");

					player = new Player(pID, pName, pKey);
				}

				rs.close();
				stmt.close();
			}
			catch(SQLException ex)
			{
				DBManagement.printSQLException(ex);
			}
		}

		return player;
	}
}

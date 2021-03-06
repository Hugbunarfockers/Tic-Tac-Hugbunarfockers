package com.hugbunarfockers.gitcatgo.data;

import com.hugbunarfockers.gitcatgo.entities.Player;
import com.hugbunarfockers.gitcatgo.entities.Score;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class DBInteraction implements IDBInteraction
{
	private IDBManagement dbm;

	public DBInteraction(IDBManagement dbm)
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
				stmt.setString(1, name);
	      		stmt.setString(2, key);

	      		int rowsAffected = stmt.executeUpdate();

				stmt.close();

				if(rowsAffected == 1)
				{
					return true;
				}
			}
			catch(SQLException ex)
			{
				printSQLException(ex);
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
				stmt.setString(1, name);
	      		stmt.setString(2, key);

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
				printSQLException(ex);
			}
		}

		return player;
	}

	public boolean addScore(int player1ID, int player2ID, int winnerID)
	{
		if(!dbm.isClosed())
		{
			try
			{
				String sql = "";

				if(winnerID == 0)
	      		{
	      			sql = "INSERT INTO Scores (Player1ID, Player2ID) VALUES (?, ?)";
	      		}
	      		else
	      		{
	      			sql = "INSERT INTO Scores (Player1ID, Player2ID, WinnerID) VALUES (?, ?, ?)";
	      		}

				
				PreparedStatement stmt = dbm.prepareStatement(sql);
				stmt.setInt(1, player1ID);
	      		stmt.setInt(2, player2ID);

	      		if(winnerID != 0)
	      		{
	      			stmt.setInt(3, winnerID);
	      		}

	      		int rowsAffected = stmt.executeUpdate();

				stmt.close();

				if(rowsAffected == 1)
				{
					return true;
				}
			}
			catch(SQLException ex)
			{
				printSQLException(ex);
			}
		}

		return false;
	}

	public int getWinsBetweenPlayerIDs(int playerID, int opponentID)
	{
		int wins = 0;

		if(!dbm.isClosed())
		{
			try
			{
				String sql = "SELECT COUNT(*) AS Wins FROM Scores "
							+ "WHERE ((Player1ID = ? AND Player2ID = ?) "
							+ "OR (Player1ID = ? AND Player2ID = ?))"
							+ "AND WinnerID = ?";

				PreparedStatement stmt = dbm.prepareStatement(sql);
				stmt.setInt(1, playerID);
				stmt.setInt(2, opponentID);
				stmt.setInt(3, opponentID);
				stmt.setInt(4, playerID);
				stmt.setInt(5, playerID);

	      		ResultSet rs = stmt.executeQuery();

				if(rs.next())
				{
					wins = rs.getInt("Wins");
				}

				rs.close();
				stmt.close();
			}
			catch(SQLException ex)
			{
				printSQLException(ex);
			}
		}

		return wins;
	}

	public void printSQLException(SQLException ex)
	{
		System.out.println("SQLException: " + ex.getMessage());
		System.out.println("SQLState: " + ex.getSQLState());
		System.out.println("VendorError: " + ex.getErrorCode());
	}
}

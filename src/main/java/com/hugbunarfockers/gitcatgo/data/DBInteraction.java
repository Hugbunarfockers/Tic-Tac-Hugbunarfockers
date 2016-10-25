package com.hugbunarfockers.gitcatgo.data;

import com.hugbunarfockers.gitcatgo.entities.Player;
import com.hugbunarfockers.gitcatgo.entities.Score;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

	public boolean addScore(int player1ID, int player2ID, int winnerID)
	{
		if(!dbm.isClosed())
		{
			try
			{
				String sql = "INSERT INTO Scores (Player1ID, Player2ID, WinnerID) VALUES (?, ?, ?)";

				PreparedStatement stmt = dbm.prepareStatement(sql);
				stmt.setInt(1, player1ID);
	      		stmt.setInt(2, player2ID);
				stmt.setInt(3, winnerID);

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

	public ArrayList<Score> getScoresByPlayerID(int playerID)
	{
		ArrayList<Score> list = new ArrayList<Score>();

		if(!dbm.isClosed())
		{
			try
			{
				String sql = "SELECT * FROM Scores WHERE Player1ID = ? OR Player2ID = ?";

				PreparedStatement stmt = dbm.prepareStatement(sql);
				stmt.setInt(1, playerID);
				stmt.setInt(2, playerID);

	      		ResultSet rs = stmt.executeQuery();

				while(rs.next())
				{
					int player1ID = rs.getInt("Player1ID");
					int player2ID = rs.getInt("Player2ID");
					int winnerID = rs.getInt("WinnerID");

					Score score = new Score(player1ID, player2ID, winnerID);

					list.add(score);
				}

				rs.close();
				stmt.close();
			}
			catch(SQLException ex)
			{
				DBManagement.printSQLException(ex);
			}
		}

		return list;
	}
}

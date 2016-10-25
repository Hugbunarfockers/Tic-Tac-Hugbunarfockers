package com.hugbunarfockers.gitcatgo.entities;

public class Score
{
	private int player1ID;
	private int player2ID;
	private int winnerID;

	public Score(int player1ID, int player2ID, int winnerID)
	{
		this.player1ID = player1ID;
		this.player2ID = player2ID;
		this.winnerID = winnerID;
	}

	public int getPlayer1ID()
	{
		return player1ID;
	}

	public int getPlayer2ID()
	{
		return player2ID;
	}

	public int getWinnerID()
	{
		return winnerID;
	}

	public void setPlayer1ID(int ID)
	{
		player1ID = ID;
	}

	public void setPlayer2ID(int ID)
	{
		player2ID = ID;
	}

	public void setWinnerID(int ID)
	{
		winnerID = ID;
	}
}

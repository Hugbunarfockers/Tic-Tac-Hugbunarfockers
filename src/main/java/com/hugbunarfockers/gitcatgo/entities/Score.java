package com.hugbunarfockers.gitcatgo.entities;
import java.math.*;
public class Score
{
	private int player1ID;
	private int player2ID;
	private int winnerID;

	public Score(int player1, int player2, int winner)
	{
		player1ID = player1;
		player2ID = player2;
		winnerID = winner;
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

	public void setPlayer1ID(int id)
	{
		player1ID = id;
	}

	public void setPlayer2ID(int id)
	{
		player2ID = id;
	}
}
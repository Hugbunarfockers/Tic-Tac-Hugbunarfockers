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
	
}
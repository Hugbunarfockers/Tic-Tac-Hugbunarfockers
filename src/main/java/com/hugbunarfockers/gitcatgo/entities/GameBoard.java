package com.hugbunarfockers.gitcatgo.entities;

public class GameBoard
{
	private static final int SIZE = 3;
	private int winner;
	private char[][] board;

	public GameBoard()
	{
		winner = 0;
		board = new char[SIZE][SIZE];
	}

	public char[][] getBoard()
	{
		return board;
	}

	public void setBoardValue(int x, int y, char player)
	{
		board[x][y] = player;
	}

	public int getWinner()
	{
		return winner;
	}

	public void setWinner(int w)
	{
		winner = w;
	}

	public static int getSize()
	{
		return SIZE;
	}
}

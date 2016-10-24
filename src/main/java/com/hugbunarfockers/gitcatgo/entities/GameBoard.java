package com.hugbunarfockers.gitcatgo.entities;

public class GameBoard
{
	private static final int SIZE = 3;
	private int[][] board;

	public GameBoard()
	{
		board = new int[SIZE][SIZE];
	}

	public int[][] getBoard()
	{
		return board;
	}

	public void setBoardValue(int x, int y, int player)
	{
		board[x][y] = player;
	}

	public static int getSize()
	{
		return SIZE;
	}
}

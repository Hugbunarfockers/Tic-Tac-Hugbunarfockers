package com.hugbunarfockers.gitcatgo.services;

import com.hugbunarfockers.gitcatgo.entities.*;

public class GameService
{
    private GameBoard ticTacToe;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private int count = 0;

    public GameService(GameBoard board, Player p1, Player p2)
    {
        ticTacToe = board;
        player1 = p1;
        player2 = p2;
        currentPlayer = player1;
        fillBoard();
    }

    public char[][] getBoard()
    {
        return ticTacToe.getBoard();   
    }

    public void setBoardValue(int x, int y, char player)
    {
        ticTacToe.setBoardValue(x, y, player);
    }

    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }

    public void changeCurrentPlayer()
    {
        if(currentPlayer == player1)
        {
            currentPlayer = player2;
        }
        else
        {
            currentPlayer = player1;
        }
    }

    public boolean isBoardFull()
    {
        return count == 8;
    }

    public boolean checkWinner()
    {
        char arr[][] = getBoard();
        int boardSize = ticTacToe.getSize();

        for(int i = 0; i < boardSize; i++)
        {
            if(((arr[i][0] == arr[i][1]) && (arr[i][1] == arr[i][2])) || ((arr  [0][i] == arr[1][i]) && (arr[1][i] == arr[2][i])))
            {
                return true;
            }
        }

        if(((arr[0][0] == arr[1][1]) && (arr[1][1] == arr[2][2])) || ((arr[1][1] == arr[0][2]) && (arr[0][2] == arr[2][0])))
        {
            return true;
        }

        return false;
    }

    private void fillBoard()
    {
        int boardSize = ticTacToe.getSize();
        char value = 49;
        
        for(int i = 0; i < boardSize; i++)
        {
            for(int j = 0; j < boardSize; j++)
            {
                setBoardValue(i, j, value);
                value++;  
            }
        }
    }
}

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

    private void fillBoard()
    {
        int boardSize = ticTacToe.getSize();
        char value = 49;
        
        for(int i = 0; i < boardSize; i++)
        {
            for(int j = 0; j < boardSize; j++)
            {
                ticTacToe.setBoardValue(i, j, value);
                value++;  
            }
        }
    }
}

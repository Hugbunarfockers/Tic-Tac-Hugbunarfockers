package com.hugbunarfockers.gitcatgo.services;

import com.hugbunarfockers.gitcatgo.entities.*;

public class GameService
{
    private GameBoard ticTacToe;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public GameService(GameBoard board, Player p1, Player p2)
    {
        ticTacToe = board;
        player1 = p1;
        player2 = p2;
        currentPlayer = p1;
    }

    public void playGame()
    {
        if(ticTacToe.getWinner() == 0)
        {
            makeMove();
        }
    }

    private void makeMove()
    {

    }

      // private boolean playable()
      // {
      //   int[][] board = ticTacToe.getBoard();
      //   int boardSize = ticTacToe.getSize();
      //   int count = 0;

      //   for(int i = 0; i < ticTacToe.getSize(); i++)
      //   {
      //       for(int j = 0; j < ticTacToe.getSize(); j++)
      //       {
      //           if(board[i][j] == "x" || board[i][j] == "o")
      //           {
      //               count++;
      //           }
      //       }
      //   }

      //   if(count > 0)
      //   {
      //       return true;
      //   }
      //   else
      //   {
      //       return false;
      //   }

      // }

    private void changeCurrentPlayer()
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

    public void fillBoard()
    {
        int value = 1;
        int boardSize = ticTacToe.getSize();

        for(int i = 0; i < boardSize; i++)
        {
            for(int j = 0; j < boardSize; j++)
            {
                ticTacToe.setBoardValue(i, j, value);
                value++;
            }
        }
    }

    public int[][] getBoard()
    {
        return ticTacToe.getBoard();   
    }
}

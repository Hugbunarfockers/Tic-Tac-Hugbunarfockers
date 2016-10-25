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

    public void fillBoard()
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

    public char[][] getBoard()
    {
        return ticTacToe.getBoard();   
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

    private boolean checkWinner(char[][] arr)
    {
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

    
}

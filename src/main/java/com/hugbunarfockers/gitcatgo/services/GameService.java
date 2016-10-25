package com.hugbunarfockers.gitcatgo.services;

public class GameService
{
  private GameBoard ticTacToe;
  private Player player1;
  private Player player2;

  public GameService(Gameboard board, Player p1, Player p2)
  {
    ticTacToe = board;
    player1 = p1;
    player2 = p2;
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
}

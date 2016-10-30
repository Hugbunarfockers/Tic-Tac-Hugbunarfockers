package com.hugbunarfockers.gitcatgo.services;

import com.hugbunarfockers.gitcatgo.entities.Player;
import com.hugbunarfockers.gitcatgo.entities.GameBoard;

public interface IGameService
{
    public void resetGame();

    public char[][] getBoard();

    public boolean checkIfOccupied(char input);

    public void setBoard(GameBoard board);

    public Player getPlayer1();

    public void setPlayer1(Player p1);

    public Player getPlayer2();

    public void setPlayer2(Player p2);

    public void setBoardValue(int x, int y, char player);

    public Player getCurrentPlayer();

    public void changeCurrentPlayer();

    public boolean isBoardFull();

    public boolean checkWinner();

    public boolean makeMove(char input);

    public Player getWinner();
}

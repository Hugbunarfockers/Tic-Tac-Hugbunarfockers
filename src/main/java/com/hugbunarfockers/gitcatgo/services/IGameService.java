package com.hugbunarfockers.gitcatgo.services;

import com.hugbunarfockers.gitcatgo.entities.Player;

public interface IGameService
{
    public char[][] getBoard();

    public void setBoardValue(int x, int y, char player);

    public Player getCurrentPlayer();

    public void changeCurrentPlayer();

    public boolean isBoardFull();

    public boolean checkWinner();

    public boolean makeMove(char input);

    public Player getWinner();
}

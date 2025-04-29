package ticTacToe.ticTacToeUI;

import ticTacToe.ticTacToeGameLogic.GameLogicHandler;

public class GameTileButton extends AbstractGameButton 
{
    private int row;
    private int col;
    private GameLogicHandler logic;

    protected int getRow()
    {
        return this.row;
    }
    protected int getColumn()
    {
        return this.col;
    }

    protected GameTileButton(int row, int col, GameLogicHandler logic)
    {
        super();
        this.row = row;
        this.col = col;
        this.logic = logic;

        display('\0');
    }
    private void display(char c)
    {
        this.getButton().setText(String.valueOf(c));
    }
    protected void action()
    {
        display(logic.getCurrentSymbol());
        logic.writeBoard(row, col);
        logic.nextTurn();
    }
}

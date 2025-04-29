package ticTacToe.ticTacToeUI;

import ticTacToe.ticTacToeGameLogic.GameLogicHandler;

public class GamestartButton extends AbstractGameButton
{
    private GameLogicHandler logic;

    protected GamestartButton(GameLogicHandler logic)
    {
        this.getButton().setText("Start Game");
    }
    @Override
    protected void action()
    {
        logic.newGame();
    }
}

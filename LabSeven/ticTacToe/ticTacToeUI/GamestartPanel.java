package ticTacToe.ticTacToeUI;

import javax.swing.JPanel;

import ticTacToe.ticTacToeGameLogic.GameLogicHandler;

public class GamestartPanel 
{
    private JPanel panel;
    private GameLogicHandler logic;
    GamestartButton startButton;

    public JPanel getPanel()
    {
        return this.panel;
    }
    public GamestartPanel(GameLogicHandler logic)
    {
        panel = new JPanel();
        this.logic = logic;
        startButton = new GamestartButton(this.logic);
        panel.add(startButton.getButton());
    }
}

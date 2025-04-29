package ticTacToe.ticTacToeUI;

import javax.swing.JFrame;
import ticTacToe.ticTacToeGameLogic.GameLogicHandler;

public class GameFrame
{
    private JFrame frame;
    private DisplayPanel display;
    private GameLogicHandler logic;


    protected JFrame getFrame()
    {
        return this.frame;
    }

    public GameFrame()
    {
        frame = new JFrame("Tic-Tac-Toe");
        frame.setSize(360, 360);
        display = new DisplayPanel(logic);
        frame.add(display.getPanel());
        frame.setVisible(true);
    }

    public void newGame()
    {
        display.newGame();
    }
}
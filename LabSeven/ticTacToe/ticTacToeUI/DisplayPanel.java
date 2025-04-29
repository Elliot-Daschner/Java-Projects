package ticTacToe.ticTacToeUI;

import javax.swing.JPanel;
import java.util.ArrayList;
import ticTacToe.ticTacToeGameLogic.GameLogicHandler;

public class DisplayPanel
{
    JPanel panel;
    ArrayList<JPanel> panels;
    GameLogicHandler logic;

    public JPanel getPanel()
    {
        return this.panel;
    }

    public DisplayPanel(GameLogicHandler logic)
    {
        panel = new JPanel();
        panels = new ArrayList<JPanel>();
        this.logic = logic;
    }
    
    protected void newGame()
    {
    }
}

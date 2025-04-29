package ticTacToe.ticTacToeUI;

import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.GridLayout;
import ticTacToe.ticTacToeGameLogic.GameLogicHandler;

public class GametimePanel 
{
    private ArrayList<GameTileButton> buttons;
    private JPanel panel;
    private GameLogicHandler logic;
    private GridLayout layout;

    public JPanel getPanel()
    {
        return this.panel;
    }
    //Zero-Indexed Inputs
    protected GameTileButton getGameButton(int row, int col)
    {
        return buttons.get(3*row + col);
    }

    public GametimePanel(GameLogicHandler logic)
    {
        panel = new JPanel();
        this.logic = logic;
        layout = new GridLayout(3, 3);
        panel.setLayout(layout);
        buttons = new ArrayList<GameTileButton>();
    }

    public void roundStart()
    {
        if (!buttons.isEmpty())
        {
            initializeButtons();
        }

    }
    private void initializeButtons()
    {
        buttons.clear();
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                buttons.add(new GameTileButton(i,j, logic));
            }
        }
    }
    protected void toggleButtons(boolean b)
    {
        for (GameTileButton button : buttons)
        {
            button.getButton().setVisible(b);
        }
    }
}
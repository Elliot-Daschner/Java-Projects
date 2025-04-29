package ticTacToe.ticTacToeExecute;

import ticTacToe.ticTacToeGameLogic.GameLogicHandler;
import ticTacToe.ticTacToeUI.*;
import javax.swing.JLabel;

public class Main 
{
    public static void main(String[] args)
    {
        GameFrame mainFrame = new GameFrame();
        GameLogicHandler logic = new GameLogicHandler(mainFrame);
        DisplayPanel display = new DisplayPanel(logic);
        GamestartPanel gameStart = new GamestartPanel(logic);
        GametimePanel gameTime = new GametimePanel(logic);
        display.getPanel().add(gameStart.getPanel());
        while(logic.isWin()){}
        JLabel winLabel = new JLabel("");
        gameStart.getPanel().add(winLabel);
        while (true)
        {
            logic.newGame();
            display.getPanel().remove(gameStart.getPanel());
            display.getPanel().add(gameTime.getPanel());
            gameTime.roundStart();
            while (!logic.isWin()){}
            display.getPanel().remove(gameTime.getPanel());
            display.getPanel().add(gameStart.getPanel());
            while (logic.isWin()){}
        }
    }
}
package ticTacToe.ticTacToeUI;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractGameButton 
{
    private JButton button;

    protected JButton getButton()
    {
        return this.button;
    }

    protected AbstractGameButton()
    {

        this.button = new JButton();
        button.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    action();
                }
            }
        );
    }

    protected abstract void action();
}
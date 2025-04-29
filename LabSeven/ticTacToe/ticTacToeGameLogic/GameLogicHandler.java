package ticTacToe.ticTacToeGameLogic;

import ticTacToe.ticTacToeUI.GameFrame;

public class GameLogicHandler 
{
    private static int currentPlayer;
    private static char[] playerSymbols;
    private static char[][] gameBoard;
    private GameFrame frame;
    private boolean winning;

    public boolean isWin()
    {
        return winning;
    }

    public GameLogicHandler(GameFrame frame)
    {
        playerSymbols = new char[] {'\0', 'x', 'o'};
        gameBoard = new char[3][3];
        this.frame = frame;
    }

    public void newGame()
    {
        winning = false;
        currentPlayer = 1;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                gameBoard[i][j] = playerSymbols[0];
            }
        }
        frame.newGame();
    }
    public boolean checkWinning()
    {
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] != '\0' && gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2]) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (gameBoard[0][j] != '\0' && gameBoard[0][j] == gameBoard[1][j] && gameBoard[1][j] == gameBoard[2][j]) {
                return true;
            }
        }
        if (gameBoard[0][0] != '\0' && gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]) {
            return true;
        }
        if (gameBoard[0][2] != '\0' && gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0]) {
            return true;
        }
        return false;
    }
    public void nextTurn()
    {
        winning = checkWinning();
        if (!winning)
        {
            currentPlayer = (currentPlayer + 1)/2;
        }
    }
    public void writeBoard(int row, int col)
    {
        gameBoard[row][col] = getCurrentSymbol();
    }
    public char getCurrentSymbol()
    {
        return playerSymbols[currentPlayer];
    }
}

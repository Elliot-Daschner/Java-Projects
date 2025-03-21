import java.util.Scanner;

public class Main
{
    public static void main(String[] args) 
    {
        Bank myBank = new Bank();
        myBank.setOverdraftLimit(500);
        myBank.setMinSavingsBal(500);
        Terminal myTerminal = new Terminal();
        Scanner scanner = new Scanner(System.in);
        myTerminal.logoutEnvironment(myBank, scanner);    
        scanner.close();
    }
}
import java.util.Scanner;
import java.util.ArrayList;
public class Terminal 
{
    ArrayList<BankAccount> currentUser = new ArrayList<BankAccount>();
    public void login(Bank bank)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter username.\nUsername: ");
        String username = scanner.next();
        System.out.println("Please enter password.\nPassword: ");
        String password = scanner.next();
        try 
        {
            currentUser.add(bank.authenticateUser(username, password));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Login failed.");
        }
        currentUser.remove(0);
        scanner.close();
    }
    public void createAccount(Bank bank)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your full name.\nName: ");
        String name = scanner.next();
        String accountType = this.selectAccountType(scanner);
        double deposit = this.selectDepositAmount(scanner, bank);
        this.finishAccount(bank, scanner, name, accountType, deposit);
        scanner.close();
    }
    public void finishAccount(Bank bank, Scanner scanner, String name, String accountType, double deposit)
    {
        try 
        {
            bank.createAccount(accountType, name, deposit);
            System.out.println("Your username is: " + bank.getAccounts().get((bank.getAccounts().size()-1)).getUsername() + "\nYour password is: " + bank.getAccounts().get((bank.getAccounts().size()-1)).getPassword() + "\n It would be best to save this information, but you can contact us any time you have difficulty logging in.");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid input. Please try again.");
            this.selectDepositAmount(scanner, bank);
            this.finishAccount(bank, scanner, name, accountType, deposit);
        }
    }
    public String selectAccountType(Scanner scanner)
    {
        System.out.println("Please select account type by entering '1' or '2'.\n1. Checking\n2.Savings\nChoice: ");
        try
        {
            Integer choiceWrapInteger = Integer.valueOf(scanner.next());
            int choice = choiceWrapInteger;
            switch(choice)
            {
                case 1: return "Checking";
                case 2: return "Savings";
                default: System.out.println("Invalid input. Please type '1' or '2'.");
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid input. Please type '1' or '2'.");
            return selectAccountType(scanner);
        }
        return selectAccountType(scanner);
    }
    public double selectDepositAmount(Scanner scanner, Bank bank)
    {
        System.out.println("Please select initial deposit amount. Note: minimum deposit amount is $" + bank.getMinSavingsBal() + ".\nAmount: $");
        String next = scanner.next();
        try
        {
            Double choiceWrapDouble = Double.valueOf(next);
            double amount = choiceWrapDouble;
            return amount;
        }
        catch (IllegalArgumentException e)
        {
            try 
            {
                Double choiceWrapDouble = (double)Integer.valueOf(next);
                double amount = choiceWrapDouble;
                return amount;
            }
            catch (IllegalArgumentException f)
            {
                System.out.println("Invalid value. Please enter a numerical value.");
                return selectDepositAmount(scanner, bank);
            }
        }
    }
    public void withdraw(Bank bank, String accountNumber)
    {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        try
        {
            Double choiceWrapDouble = Double.valueOf(next);
            double amount = choiceWrapDouble;
            bank.withdraw(accountNumber, amount);
        }
        catch (IllegalArgumentException e)
        {
            try 
            {
                Double choiceWrapDouble = (double)Integer.valueOf(next);
                double amount = choiceWrapDouble;
                bank.withdraw(accountNumber, amount);
            }
            catch (IllegalArgumentException f)
            {
                System.out.println("Invalid value. Please enter a numerical value.");
            }
        }
        scanner.close();
    }
    public void deposit(Bank bank, String accountNumber)
    {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        try
        {
            Double choiceWrapDouble = Double.valueOf(next);
            double amount = choiceWrapDouble;
            bank.deposit(accountNumber, amount);
        }
        catch (IllegalArgumentException e)
        {
            try 
            {
                Double choiceWrapDouble = (double)Integer.valueOf(next);
                double amount = choiceWrapDouble;
                bank.deposit(accountNumber, amount);
            }
            catch (IllegalArgumentException f)
            {
                System.out.println("Invalid value. Please enter a numerical value.");
            }
        }
        scanner.close();
    }
}
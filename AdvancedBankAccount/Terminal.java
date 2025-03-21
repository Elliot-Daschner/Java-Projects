import java.util.Scanner;
import java.util.ArrayList;
public class Terminal 
{
    ArrayList<BankAccount> currentUser = new ArrayList<BankAccount>();
    public void logoutEnvironment(Bank bank, Scanner scanner)
    {
        System.out.print("Please select choice type by entering '1' or '2'.\n1. Login\n2. Create Account\nChoice: ");
        try
        {
            Integer choiceWrapInteger = Integer.valueOf(scanner.next());
            int choice = choiceWrapInteger;
            switch(choice)
            {
                case 1: 
                {
                    login(bank, scanner);
                    break;
                }
                case 2:
                {
                    createAccount(bank, scanner);
                    break;
                }
                default: System.out.println("Invalid input. Please type '1' or '2'.");
            }
        }
        catch (NumberFormatException  e)
        {
            System.out.println("Invalid input. Please type '1' or '2'.");
            this.logoutEnvironment(bank, scanner);
        }
        this.logoutEnvironment(bank, scanner);
    }
    public void loginEnvironment(Bank bank, Scanner scanner)
    {
        System.out.print("Please select choice type by entering '1', '2', '3', '4', or '5'.\n1. Withdraw Money\n2. Deposit Money\n3. Transfer Funds\n4. See Account Information\n5. Logout\nChoice: ");
        try
        {
            Integer choiceWrapInteger = Integer.valueOf(scanner.next());
            int choice = choiceWrapInteger;
            switch(choice)
            {
                case 1: 
                {
                    this.withdraw(bank, this.currentUser.get(0).getAccountNumber(), scanner);
                    break;
                }
                case 2:
                {
                    this.deposit(bank, this.currentUser.get(0).getAccountNumber(), scanner);
                    break;
                }
                case 3:
                {
                    this.transferFunds(bank, this.currentUser.get(0).getAccountNumber(), scanner);
                    break;
                }
                case 4:
                {
                    this.currentUser.get(0).getAccountInfo();
                    break;
                }
                case 5:
                {
                    this.logout(bank, scanner);
                    break;
                }
                default: System.out.println("Invalid input. Please type '1' or '2'.");
            }
        }
        catch (NumberFormatException  e)
        {
            System.out.println("Invalid input. Please type '1' or '2'.");
            this.loginEnvironment(bank, scanner);
        }
        this.loginEnvironment(bank, scanner);
    }
    public void login(Bank bank, Scanner scanner)
    {
        System.out.print("Please enter username.\nUsername: ");
        String username = scanner.next();
        System.out.print("Please enter password.\nPassword: ");
        String password = scanner.next();
        try 
        {
            if (currentUser.size() > 0)
            {
                currentUser.set(0, bank.authenticateUser(username, password));
                this.loginEnvironment(bank, scanner);
            }
            else
            {
                currentUser.add(bank.authenticateUser(username, password));
                this.loginEnvironment(bank, scanner);
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Login failed.");
        }
        if (currentUser.size() > 1)
        {
            currentUser.remove(0);
        }
    }
    public void logout(Bank bank, Scanner scanner)
    {
        this.logoutEnvironment(bank, scanner);
    }
    public void createAccount(Bank bank, Scanner scanner)
    {
        String accountType = this.selectAccountType(scanner);
        double deposit = this.selectDepositAmount(scanner, bank);
        System.out.print("Enter full name (Firstname Lastname)\nName: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        this.finishAccount(bank, scanner, name, accountType, deposit);
    }
    public void finishAccount(Bank bank, Scanner scanner, String name, String accountType, double deposit)
    {
        try 
        {
            bank.createAccount(accountType, name, deposit);
            System.out.println("Your username is: " + bank.getAccounts().get((bank.getAccounts().size()-1)).getUsername() + "\nYour password is: " + bank.getAccounts().get((bank.getAccounts().size()-1)).getPassword() + "\nIt would be best to save this information, but you can contact us any time you have difficulty logging in.");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid input. Please try again.");
            createAccount(bank, scanner);
        }
    }
    public String selectAccountType(Scanner scanner)
    {
        System.out.print("Please select account type by entering '1' or '2'.\n1. Checking\n2. Savings\nChoice: ");
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
        catch (NumberFormatException  e)
        {
            System.out.println("Invalid input. Please type '1' or '2'.");
            return selectAccountType(scanner);
        }
        return selectAccountType(scanner);
    }
    public double selectDepositAmount(Scanner scanner, Bank bank)
    {
        System.out.print("Please select initial deposit amount. Note: minimum deposit amount is $" + bank.getMinSavingsBal() + ".\nAmount: $");
        String next = scanner.next();
        try
        {
            Double choiceWrapDouble = Double.valueOf(next);
            double amount = choiceWrapDouble;
            return amount;
        }
        catch (NumberFormatException  e)
        {
            try 
            {
                Double choiceWrapDouble = (double)Integer.valueOf(next);
                double amount = choiceWrapDouble;
                return amount;
            }
            catch (NumberFormatException  f)
            {
                System.out.println("Invalid value. Please enter a numerical value.");
                return selectDepositAmount(scanner, bank);
            }
        }
    }
    public void transferFunds(Bank bank, String accountNumber, Scanner scanner)
    {
        System.out.print("Please enter name of recipient.\nName: ");
        String name = scanner.next();
        System.out.print("Please enter amount to be transfered.\nAmount: ");
        String valString = scanner.next();
        double valDouble;
        try
        {
            valDouble = Double.valueOf(valString);
            try 
            {
                bank.transferFunds(this.currentUser.get(0).getHolderName(), name, valDouble);
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e);
            }
        }
        catch (NumberFormatException  e)
        {
            try 
            {
                valDouble = (double)Integer.valueOf(valString);
                try 
                {
                    bank.transferFunds(this.currentUser.get(0).getHolderName(), name, valDouble);
                }
                catch (IllegalArgumentException f)
                {
                    System.out.println(f);
                }
            }
            catch (NumberFormatException  f)
            {
                System.out.println("Invalid value. Please enter a numerical value.");
                this.loginEnvironment(bank, scanner);
            }
        }
        this.loginEnvironment(bank, scanner);
    }
    public void withdraw(Bank bank, String accountNumber, Scanner scanner)
    {
        System.out.print("Please select withdrawl amount.\nAmount: $");
        String next = scanner.next();
        try
        {
            Double choiceWrapDouble = Double.valueOf(next);
            double amount = choiceWrapDouble;
            bank.withdraw(accountNumber, amount);
        }
        catch (IllegalArgumentException  e)
        {
            try 
            {
                Double choiceWrapDouble = (double)Integer.valueOf(next);
                double amount = choiceWrapDouble;
                bank.withdraw(accountNumber, amount);
            }
            catch (NumberFormatException  f)
            {
                System.out.println("Invalid value. Please enter a numerical value.");
            }
        }
        this.loginEnvironment(bank, scanner);
    }
    public void deposit(Bank bank, String accountNumber, Scanner scanner)
    {
        System.out.print("Please select deposit amount.\nAmount: $");
        String next = scanner.next();
        try
        {
            Double choiceWrapDouble = Double.valueOf(next);
            double amount = choiceWrapDouble;
            bank.deposit(accountNumber, amount);
        }
        catch (NumberFormatException  e)
        {
            try 
            {
                Double choiceWrapDouble = (double)Integer.valueOf(next);
                double amount = choiceWrapDouble;
                bank.deposit(accountNumber, amount);
            }
            catch (NumberFormatException  f)
            {
                System.out.println("Invalid value. Please enter a numerical value.");
            }
        }
        this.loginEnvironment(bank, scanner);
    }
}
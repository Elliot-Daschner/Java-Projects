import java.util.ArrayList;
public class Bank implements TransactionLogger{
    ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
    ArrayList<String> transactions = new ArrayList<String>();
    private double overdraftLimit;
    private double minSavingsBal;

    public double getMinSavingsBal()
    {
        return this.minSavingsBal;
    }
    public ArrayList<BankAccount> getAccounts()
    {
        return this.accounts;
    }
    public String generatePasscode()
    {
        int rand = (int)(Math.random() * 100.0);
        String pass = new String("" + rand);
        for (BankAccount a : accounts)
        {
            if (a.getPassword().equals(pass))
            {
                return generatePasscode();
            }
        }
        return pass;
    }
    public String generateAccountNumber()
    {
        int rand = (int)(Math.random() * 100.0);
        String num = new String("" + rand);
        for (BankAccount a : accounts)
        {
            if (a.getAccountNumber().equals(num))
            {
                return generateAccountNumber();
            }
        }
        return num;
    }
    public void createAccount(String accountType, String holderName, double balance)
    {
        if (accountType.equals("Checking"))
        {
            String pass = this.generatePasscode();
            String num = this.generateAccountNumber();
            accounts.add(new CheckingAccount(num, holderName, balance, accountType, overdraftLimit, pass));
        }
        else if (accountType.equals("Savings"))
        {
            if (balance <= minSavingsBal)
            {
                throw new IllegalArgumentException("Amount entered does not exceed minimum balance of " + minSavingsBal + " to register a savings account.");
            }
            String pass = this.generatePasscode();
            String num = this.generateAccountNumber();
            accounts.add(new SavingsAccount(num, holderName, balance, accountType, minSavingsBal, pass));
        }
        else
        {
            throw new IllegalArgumentException("Undefined account type.");
        }
    }
    public BankAccount authenticateUser(String username, String password)
    {
        for (BankAccount a : accounts)
        {
            if (a.getUsername().equals(username))
            {
                if (a.getPassword().equals(password))
                {
                    a.login();
                    return a;
                }
                else
                {
                    throw new IllegalArgumentException("Invalid username or password.");
                }
            }
        }
        throw new IllegalArgumentException("Invalid username or password.");
    }
    public void deposit(String accountNumber, double amount)
    {
        ArrayList<BankAccount> dummy = new ArrayList<BankAccount>();
        for (BankAccount a : accounts)
        {
            if (a.getAccountNumber().equals(accountNumber))
            {
                dummy.add(a);
                break;
            }
        }
        if (dummy.size() != 1)
        {
            throw new IllegalArgumentException("Invalid account number.");
        }
        else
        {
            dummy.get(0).deposit(amount);
        }
    }
    public void withdraw(String accountNumber, double amount)
    {
        ArrayList<BankAccount> dummy = new ArrayList<BankAccount>();
        for (BankAccount a : accounts)
        {
            if (a.getAccountNumber().equals(accountNumber))
            {
                dummy.add(a);
                break;
            }
        }
        if (dummy.size() != 1)
        {
            throw new IllegalArgumentException("Invalid account number.");
        }
        try
        {
            dummy.get(0).withdraw(amount);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
    }
    public void transferFunds(String s, String r, double amount)
    {
        ArrayList<BankAccount> dummy = new ArrayList<BankAccount>();
        for (BankAccount a : accounts)
        {
            if (a.getAccountNumber().equals(s) || a.getAccountNumber().equals(r))
            {
                if (a.getAccountNumber().equals(s))
                {
                    dummy.add(0, a);
                }
                else
                {
                    dummy.add(1, a);
                }
                if (dummy.get(0).equals(s) && dummy.get(1).equals(r))
                {
                    break;
                }
            }
        }
        if (dummy.size() != 2)
        {
            throw new IllegalArgumentException("Invalid account number.");
        }
        try
        {
            dummy.get(0).withdraw(amount);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
        dummy.get(1).deposit(amount);
        logTransaction(dummy.get(0), dummy.get(1), amount);
    }
    public void logTransaction(BankAccount send, BankAccount receive, double val)
    {
        transactions.add(send.getHolderName() + " sent $" + val + " to " + receive.getHolderName() + "."); 
    }
    public void viewTransactionHistory(String accountNumber)
    {
        ArrayList<BankAccount> dummy = new ArrayList<BankAccount>();
        for (BankAccount a : accounts)
        {
            if (a.getAccountNumber().equals(accountNumber))
            {
                dummy.add(a);
                break;
            }
        }
        if (dummy.size() != 1)
        {
            throw new IllegalArgumentException("Invalid account number.");
        }
        for (String t : transactions)
        {
            if (t.contains(dummy.get(0).getHolderName()))
            {
                System.out.println(t);
            }
        }
    }
    public void displayAllAccounts()
    {
        for (BankAccount a : accounts)
        {
            a.displayAccountInfo();
        }
    }
}
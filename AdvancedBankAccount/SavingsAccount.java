public class SavingsAccount extends BankAccount{
    private double minSavingsBal;
    @Override
    public void deposit(double val)
    {
        this.setBalance(this.getBalance() + val);
        System.out.println("Transaction successful.");
    }
    @Override
    public void deposit(double val, boolean dummy)
    {
        this.setBalance(this.getBalance() + val);
    }
    @Override
    public void withdraw(double val)
    {
        if (this.getBalance() - val < minSavingsBal)
        {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        this.deposit(-val);
        System.out.println("Transaction successful.");
    }
    @Override
    public void withdraw(double val, boolean dummy)
    {
        if (this.getBalance() - val < minSavingsBal)
        {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        this.deposit(-val);
    }
    public void getAccountInfo()
    {
        System.out.println("User " + getHolderName() + " Account Num " + getAccountNumber() + " Balance $" + getBalance());
    }
    public SavingsAccount(String accountNumber, String holderName, double balance, String accountType, double minSavingsBal, String password)
    {
        this.setAccountNumber(accountNumber);
        this.setAccountType(accountType);
        this.setHolderName(holderName);
        this.setBalance(balance);
        this.minSavingsBal = minSavingsBal;
        this.setUsername(holderName.replace(" ", "") + "" + accountNumber);
        this.setPassword(password);
        this.setAuthentication(false);
    }
    //Dummy usage savings account
    public SavingsAccount()
    {
        this.setAccountNumber("-1");
        this.setBalance(-1.0);
    }
}

public class SavingsAccount extends BankAccount{
    private double minSavingsBal;
    @Override
    public void deposit(double val)
    {
        if (this.loginStatus())
        {
            this.setBalance(this.getBalance() + val);
        }
    }
    @Override
    public void withdraw(double val)
    {
        if (this.loginStatus())
        {
            if (this.getBalance() - val < minSavingsBal)
            {
                throw new IllegalArgumentException("Insufficient funds.");
            }
            this.deposit(-val);
        }
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
}

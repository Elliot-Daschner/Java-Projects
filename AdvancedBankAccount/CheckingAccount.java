public class CheckingAccount extends BankAccount {
    private double overdraftLimit;
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
            if (this.getBalance() - val < overdraftLimit)
            {
                throw new IllegalArgumentException("Overdraft exceeds overdraft limit.");
            }
            this.deposit(-val);
        }
    }
    public CheckingAccount(String accountNumber, String holderName, double balance, String accountType, double overdraftLimit, String password)
    {
        this.setAccountNumber(accountNumber);
        this.setAccountType(accountType);
        this.setHolderName(holderName);
        this.setBalance(balance);
        this.overdraftLimit = overdraftLimit;
        this.setUsername(holderName.replace(" ", "") + "" + accountNumber);
        this.setPassword(password);
        this.setAuthentication(false);
    }
}

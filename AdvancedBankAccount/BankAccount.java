public abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    private String accountType;
    private String username;
    private String password;
    private boolean authenticated;

public abstract void deposit(double val);
public abstract void withdraw(double val);

public boolean isAuthenticated()
{
    return authenticated;
}
public void login()
{
    this.setAuthentication(true);
}
public void logout()
{
    this.setAuthentication(false);
}
public void setAuthentication(boolean authenticated)
{
    this.authenticated = authenticated;
}
public String getUsername()
{
    return this.username;
}
public void setUsername(String username)
{
    this.username = username;
}
public String getPassword()
{
    return this.password;
}
public void setPassword(String password)
{
    this.password = password;
}
public double getBalance() {
    return this.balance;
}
public void setBalance(double balance)
{
    this.balance = balance;
}
public String getAccountNumber()
{
    return this.accountNumber;
}
public void setAccountNumber(String accountNumber)
{
    this.accountNumber = accountNumber;
}
public String getHolderName()
{
    return this.holderName;
}
public void setHolderName(String holderName)
{
    this.holderName = holderName;
}
public String getAccountType()
{
    return this.accountType;
}
public void setAccountType(String accountType)
{
    this.accountType = accountType;
}
public void displayAccountInfo() {
    System.out.println(this);
}
public boolean loginStatus()
{
    if (this.authenticated == true)
    {
        return true;
    }
    else
    {
        throw new IllegalArgumentException("User not authenticated.");
    }
}

public String toString() {
    return "Account Number: " + this.accountNumber + " | Holder Name: " + this.holderName + " | Balance: $" + this.balance + "Account Type: " + this.accountType;  
}
}
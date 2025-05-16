package LabEight;

import java.util.HashMap;

public class User 
{
    private HashMap<Integer,Double> stockMap;
    private double balance;
    private String username;

    protected void balance(double balance)
    {
        this.balance = balance;
    }
    protected void username(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }

    public String toString()
    {
        return "Username: " + username +", Balance: $" + balance;
    }

    public User()
    {
        stockMap = new HashMap<Integer,Double>();
    }

    public void incrementBalance(double balance)
    {
        if (this.balance - balance < 0)
        {
            throw new IllegalArgumentException("Insufficient Balance.");
        }
        this.balance += balance;
    }
    public void incrementVolume(int stockID, double volume)
    {
        double bal = stockMap.get(stockID);
        if (bal - volume < 0)
        {
            throw new IllegalArgumentException("Insufficient Stock Volume.");
        }
        stockMap.replace(stockID, bal - volume);
    }
    public synchronized void transact(int stockID, double volume, double value)
    {
        if (!stockMap.containsKey(stockID))
        {
            stockMap.put(stockID, 0.0);
        }
        incrementVolume(stockID,  volume);
        incrementBalance(-volume * value);
    }
}
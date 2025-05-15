package stockExchange;

import java.util.HashMap;

public class User 
{
    private HashMap<Integer,Double> stockMap;
    private double balance;
    private String username;
    private int id;

    protected void balance(double balance)
    {
        this.balance = balance;
    }
    protected void username(String username)
    {
        this.username = username;
    }
    protected void id(int id)
    {
        this.id = id;
    }

    public User()
    {
        stockMap = new HashMap<Integer,Double>();
    }
}
package LabEight;

public class Transaction 
{
    private double volume;
    private StockExchange stockExchange;
    private int stockID;
    private User user;

    protected void volume(double volume)
    {
        this.volume = volume;
    }
    protected void stockExchange(StockExchange stockExchange)
    {
        this.stockExchange = stockExchange;
    }
    protected void stockID(int stockID)
    {
        this.stockID = stockID;
    }
    protected void user(User user)
    {
        this.user = user;
    }

    protected double getVolume()
    {
        return volume;
    }
    protected StockExchange getStockExchange()
    {
        return stockExchange;
    }
    protected int getStockID()
    {
        return stockID;
    }
    protected User getUser()
    {
        return user;
    }
}
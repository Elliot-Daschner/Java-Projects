package stockExchange;

public class Transaction 
{
    private double volume;
    private Stock stock;
    private User user;

    protected void volume(double volume)
    {
        this.volume = volume;
    }
    protected void stock(Stock stock)
    {
        this.stock = stock;
    }
    protected void user(User user)
    {
        this.user = user;
    }

    protected double getVolume()
    {
        return volume;
    }
    protected Stock getStock()
    {
        return stock;
    }
    protected User getUser()
    {
        return user;
    }
}
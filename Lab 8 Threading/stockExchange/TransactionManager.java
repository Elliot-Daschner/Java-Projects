package stockExchange;

public class TransactionManager 
{
    public Runnable sell(Transaction transaction)
    {
        return () -> 
        {
            System.out.println("Test");
        };
    }
}
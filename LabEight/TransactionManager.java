package LabEight;

public class TransactionManager 
{
    public Runnable transact(Transaction transaction)
    {
        return () -> 
        {
            StockExchange e = transaction.getStockExchange();
            int id = transaction.getStockID();
            double vol = transaction.getVolume();
            try
            {
                Stock s = e.get(id);
                double val = s.getValue();
                User u = transaction.getUser();
                s.incrementVolume(vol);
                u.transact(id, vol, val);

            }
            catch (IllegalArgumentException f)
            {
                System.out.print(f);
            }
        };
    }
}
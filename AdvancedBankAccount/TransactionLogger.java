public interface TransactionLogger 
{
    void logTransaction(BankAccount send, BankAccount receive, double val);
}

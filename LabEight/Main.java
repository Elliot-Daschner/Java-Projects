package LabEight;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.ArrayList;

public class Main 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StockExchange se = new StockExchange();
        TransactionManager tm = new TransactionManager();
        UserManager um =  new UserManager();
        ArrayList<Transaction> tr = new ArrayList<Transaction>();
        ExecutorService executor = Executors.newFixedThreadPool(8);

        User u1 = new User();
        u1.balance(500.0);
        u1.username("Bob");
        User u2 = new User();
        u2.balance(600.0);
        u2.username("Jimmy");
        um.add(u1);
        um.add(u2);

        Stock s1 = new Stock();
        s1.value(50.0);
        s1.volume(20.0);
        s1.seListing("UST");
        Stock s2 = new Stock();
        s2.value(5.0);
        s2.volume(200.0);
        s1.seListing("UMN");
        se.add(s1);
        se.add(s2);

        while (true)
        {
            System.out.println("Select '1' to create a transaction, '2' to execute pending transactions, '3' to view stocks on the exchange, and '4' to view users.\nSelection: ");
            int select = sc.nextInt();
            switch (select)
            {
                case 1:
                {
                    System.out.println("Type '1' for buy order and '2' for sell order.\nOrder Type: ");
                    int type = sc.nextInt();
                    if ((type != 1) && (type != 2))
                    {
                        throw new IllegalArgumentException("Unspecified order type.");
                    }
                    type += 2 * (type % 2 - 1);
                    sc.nextLine();
                    try
                    {
                        System.out.println("Enter name of User\nName: ");
                        User u = um.get(sc.nextLine());
                        System.out.println("Enter Stock ID\nID: ");
                        int id = sc.nextInt();
                        System.out.println("Enter volume of stock to transact.\nVolume: ");
                        double vol = sc.nextDouble();
                        Transaction t = new Transaction();
                        t.volume(type * vol);
                        t.stockExchange(se);
                        t.stockID(id);
                        t.user(u);
                        tr.add(t);
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out.println(e);
                    }
                }
                case 2:
                {
                    for (Transaction t : tr)
                    {
                        executor.execute(tm.transact(t));
                    }
                }
                case 3:
                {
                    se.display();
                }
                case 4:
                {
                    um.display();
                }
                default:
                {
                    System.out.println("Selection failed. Please select a number 1 through 4.");
                }
            }
        }
    }
}
package LabEight;

import java.util.ArrayList;

public class StockExchange 
{
    public ArrayList<Stock> stocks;

    public StockExchange()
    {
        stocks = new ArrayList<Stock>();
    }

    public void add(Stock stock)
    {
        if (stocks.indexOf(stock) != -1)
        {
            throw new IllegalArgumentException("Stock already exists.");
        }
        if (stock == null)
        {
            throw new NullPointerException("Stock cannot be null.");
        }
        stock.id(stocks.size()-1);
        stocks.add(stock);
    }
    public Stock get(int id)
    {
        if (id >= stocks.size())
        {
            throw new IllegalArgumentException("ID entered not found in exchange.");
        }
        return stocks.get(id);
    }
    public void display()
    {
        for (Stock s: stocks)
        {
            System.out.println(s);
        }
    }
}
package LabEight;

public class Stock 
{
    private double value;
    private double volume;
    private int id;
    private String seListing;

    protected void value(double value)
    {
        this.value = value;
    }
    protected void volume(double volume)
    {
        this.volume = volume;
    }
    protected void id(int id)
    {
        this.id = id;
    }
    protected void seListing(String seListing)
    {
        this.seListing = seListing;
    }

    public String toString()
    {
        return seListing + " at $" + value + " with " + volume + " stocks available. ID: " + id;
    }

    public double getValue()
    {
        return value;
    }
    public synchronized void incrementVolume(double volume)
    {
        if (volume < 0.0)
        {
            throw new IllegalArgumentException("Insufficient stock volume to complete transaction.");
        }
        this.volume += volume;
    }
}
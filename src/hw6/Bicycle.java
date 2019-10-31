package hw6;

/**
 * This class implements a Carbon foot print interface for a Bicycle.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

public class Bicycle implements CarbonFootprint
{
    private String model;
    private double distance;
    private double emmissionFactor;
    
    public Bicycle()
    {
        model = "Bike";
        distance = 1.0;
        emmissionFactor = 0.5;
    }
    public Bicycle(String m, double d, double e)
    {
        model = m;
        distance = d;
        emmissionFactor = e;
    }
    
    public String getModel()
    {
        return model;
    }
    public double getDistance()
    {
        return distance;
    }
    public double getEmmissionFactor()
    {
        return emmissionFactor;
    }
    
    public void setModel(String m)
    {
        model = m;
    }
    public void setDistance(double d)
    {
        distance = d;
    }
    
    public void setEmmissionFactor(double eF)
    {
        emmissionFactor =  eF;
    }
    
    public double getCarbonFootprint()
    {
        return distance * emmissionFactor;
    }

    public String toString()
    {
        return "Bicylce model: " + getModel() + "\n" + "Distance travelled in km: " + getDistance() + "\nEmmission factor: " + getEmmissionFactor();
    }
}

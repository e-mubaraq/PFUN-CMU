package hw6;

/**
 * This class implements a Carbon foot print interface for a Building.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

public class Building implements CarbonFootprint
{
    private int numberOfHousemates;
    private double energyUsage;
    private double emmissionFactor;
    
    
    public Building()
    {
        numberOfHousemates = 1;
        energyUsage = 10.0;
        emmissionFactor = 5.0;
    }
    
    public Building(int n, double e, double ef)
    {
        numberOfHousemates = n;
        energyUsage = e;
        emmissionFactor = ef;
    }
    
    public double getCarbonFootprint()
    {
        return numberOfHousemates * energyUsage * emmissionFactor;
    }

    public double getEmmissionFactor()
    {
        return emmissionFactor;
    }
    
    public double getEnergyUsage()
    {
        return energyUsage;
    }
    
    public int getNumberOfHousemates()
    {
        return numberOfHousemates;
    }
    
    public void setEmmissionFactor(double eF)
    {
        emmissionFactor =  eF;
    }
    
    public void setEnergyUsage(double e)
    {
        energyUsage = e;
    }
    
    public void setNumberOfHousemates(int n)
    {
        numberOfHousemates = n;
    }
    
    public String toString()
    {
        return "Building with " + getNumberOfHousemates() + " housemates.\n" + "Emmission factor: " + getEmmissionFactor() +  "\nEnergy Usage per person: " + getEnergyUsage();               
    }
}

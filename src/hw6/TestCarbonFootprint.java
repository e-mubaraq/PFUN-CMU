package hw6;

import java.util.ArrayList;

/**
 * This program helps to calculate the carbon foot print of different mediums.
 * 
 * @author Mubarak Mikail
 * Andrew ID: mmikail 
 * 
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 */

public class TestCarbonFootprint
{

    public static void main(String[] args)
    {
        ArrayList<CarbonFootprint> footPrints = new ArrayList<CarbonFootprint>();
        
        Car car = new Car();
        Bicycle bike = new Bicycle();
        Building house = new Building();
        
        footPrints.add(car);
        footPrints.add(bike);
        footPrints.add(house);
        
        for (CarbonFootprint footPrint:footPrints)
            System.out.println(footPrint + "\n" + "Carbon Footprint: " + footPrint.getCarbonFootprint() + "\n");
        
    }

}

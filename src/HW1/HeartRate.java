package HW1;

import java.util.Date;

/**
 * This class gives health information about a person.
 *
 * @author Mubarak Mikail Andrew ID: mmikail
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 *
 */
public class HeartRate
{
    private String firstName;
    private String lastName;
    private int bday;
    private int bmonth;
    private int byear;

    public HeartRate(String fName, String lName, int day, int month, int year) // constructor with arguments
    {
        firstName = fName;
        lastName = lName;
        byear = year;
        bmonth = month;
        bday = day;
    }

    // getters
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public int getBday()
    {
        return bday;
    }

    public int getBmonth()
    {
        return bmonth;
    }

    public int getByear()
    {
        return byear;
    }

    // setters
    public void setFirstName(String newName)
    {
        firstName = newName;
    }

    public void setLastName(String newName)
    {
        lastName = newName;
    }

    public void setBday(int newBday)
    {
        bday = newBday;
    }

    public void setBmonth(int newBmonth)
    {
        bmonth = newBmonth;
    }

    public void setByear(int newByear)
    {
        byear = newByear;
    }

    public String toString()
    {
        String text = "\n" + "Name: " + firstName + " " + lastName + "\n" + "Birthday: " + bday + "/" + bmonth + "/"
                + byear + "\n" + "Age: " + getAge() + "\n" + "Maximum Heart Rate: " + getMaxHeartRate() + "\n"
                + "Target Heart Rate Range: " + getMinTargetHR() + " - " + getMaxTargetHR();
        return text;
    }

    @SuppressWarnings("deprecation")
    public int getAge() // This method calculates the age of a person from their birthday, month and
                        // year with respect to today's date.
    {
        int age = 0;
        int currentYear = new Date().getYear() + 1900;
        int currentMonth = new Date().getMonth() + 1;
        int currentDay = new Date().getDate();
        if (bmonth > currentMonth)
            {
                age = currentYear - byear - 1;
            }
        else if (bmonth == currentMonth)
            {
                if (bday > currentDay)
                    {
                        age = currentYear - byear - 1;
                    }
                else
                    {
                        age = currentYear - byear;
                    }
            }
        else
            {
                age = currentYear - byear;
            }
        return age;
    }

    public int getMaxHeartRate() // This method calculates the Maximum heart rate.
    {
        int maxHeartRate = 0;
        maxHeartRate = 225 - getAge();
        return maxHeartRate;
    }

    public Double getMinTargetHR() // This method calculates the minimum target heart rate.
    {
        Double mintargetHR;
        mintargetHR = 0.5 * getMaxHeartRate();
        return mintargetHR;
    }

    public Double getMaxTargetHR() // This method calculates the maximum target heart rate.
    {
        Double maxtargetHR;
        maxtargetHR = 0.85 * getMaxHeartRate();
        return maxtargetHR;
    }
}

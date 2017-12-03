package OODCwk;


/**
 * Details of your team
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Teamwork
{
    private String[] details = new String[7];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team
        // It will help us if the surname of programmer1 comes
        // alphabetically before the surname of programmer2
        details[0] = "HWRA";
        details[1] = "Abdullahi";
        details[2] = "Hamza";
        details[3] = "14047766";
        details[4] = "Rodrigues";
        details[5] = "Wayne";
        details[6] = "14156590";

    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}

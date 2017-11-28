package OODCwk;


/**
 * This class implements the behaviour expected from a SWAT
 * system as required for 6COM1037 - Nov 2017
 * 
 * @author 
 * @version 
 */

public class SpaceWars  implements SWAT 
{
    // UPDATED 21st Nov
    private String admiralName;
    private int warchest = 1000;
    boolean isDefeated = false;

    
//**************** SWAT **************************  
    /** Constructor requires the name of the admiral
     * @param admiral the name of the admiral
     */  
    public SpaceWars(String admiral)
    {
         admiralName = admiral; 
        
    }
    
    
    /**Returns a String representation of the state of the game,
     * including the name of the admiral, state of the resources,
     * whether defeated or not, and the forces currently in the 
     * FightingFleet,(or, "No forces" if FightingFleet is empty)
     * @return a String representation of the state of the game,
     * including the name of the admiral, state of the resources,
     * whether defeated or not, and the forces currently in the 
     * FightingFleet,(or, "No forces" if FightingFleet is empty)
     **/
    public String toString()
    {
      
        return "";
    }
    
    
    /** returns true if war chest <=0 and the admiral's FightingFleet has no 
     * forces which can be recalled. 
     * @returns true if resources <=0 and the admiral's FightingFleet has no 
     * forces which can be recalled. 
     */
    public boolean isDefeated()
    {
        boolean result = false;
        
        if (warchest<=0 && ASF_Force.checkRecall() == false){
            result = true;
        }
        
        return result;

  
    }
    
    
    /** returns the number of talents in the resources
     * @returns the number of talents in the resources
     */
    public int getWarchest()
    {
        return warchest;
    }
    
    
    /**Returns a String representation of all forces in the Allied Space Fleet(ASF)
     * @return a String representation of all forces in the Allied Space Fleet(ASF)
     **/
    public String getASFleet()
    {   
        String result = "";

        setupForces();
        
    
        for (ASF_Force forcemember: ASF_Force.allForces.values()){
          result = result + forcemember.toString();
        }
        
        return result; 
    }
    
    /** Returns details of an ASF force with the given reference code
     * @return details of an ASF force with the given reference code
     **/
    public String findForceInASF(String ref)
    {
        ASF_Force forceMem = ASF_Force.allForces.get(ref);
        
        String result = "";
        
        if(forceMem != null) {
            result = forceMem.toString();
        }
        
        return result;
    }
    
    /** Returns details of any force with the given reference code
     * @return details of any force with the given reference code
     **/
    public String getForce(String ref)
    {  
        
       // SAME AS ABOVE THIS METHOD GIVEN IN UNCLEAR
       ASF_Force forceMem = ASF_Force.allForces.get(ref);
        String result = "";
        
        if(forceMem != null) {
            result = forceMem.toString();
        }
        
        return result;
    }     
 
    // ***************** Fighting Fleet Forces ************************   
    /** Allows a force to be activated into the admiral's FightingFleet,  
     * if there are enough resources for the activation fee.The force's 
     * state is set to "active"
     * @param ref represents the reference code of the force
     * @return 0 if force is activated, 1 if force is not in the ASF
      * 2 if not enough money, 3 if no such force
     **/        
    public int activateForce(String ref)
    {
        return -1;
    }
    
    /** Returns true if the force with the reference code is in 
     * the admiral's FightingFleet, false otherwise.
     * @param ref is the reference code of the force
     * @return returns true if the force with the reference code
     * is in the admiral's FightingFleet, false otherwise.
     **/
    public boolean isInFightingFleet(String ref)
    {
        return false;
    }
    
    
    /** Removes a force from the FightingFleet back to the ASF dock, if they 
     * are in the FightingFleet
     * pre-condition: isInAdmiralsForce(ref)
     * @param ref is the reference code of the force
     **/
    public void recallForce(String ref)
    {
        
    }    
    
        
    /**Returns a String representation of the forces in the admiral's Fighting Fleet
     * or the message "No forces activated"
     * @return a String representation of the forces in the admiral's FightingFleet
     **/
    public String getFightingFleet()
    {
        
        return "";
    }
    
    
//**********************Fights************************* 
    /** returns true if the number represents a fight
     * @param num is the number of the fight
     * @returns true if the number represents a fight
     **/
     public boolean isFight(int num)
     {
         return false;
     }
     
    /** Retrieves the fight represented by the fight number.Finds 
      * a force from the Fighting Fleet which can engage in the fight.The  
      * results of fighting an fight will be one of the following: 
      * 0 - Fight won, add fight gains to the warchest, 
      * 1 - Fight lost as no suitable force available, deduct the fight losses 
      * from resources 
      * 2 - Fight lost on battle strength  - deduct fight losses warchest, 
      *   and destroy the force
      * 3 - If a fight is lost and admiral completely defeated (no resources and 
      * no forces to recall) 
      * -1 - no such fight
      * @param fightNo is the number of the fight
      * @return a int showing the result of the fight
      */ 
    public int fight(int fightNo)
    {
        return 99;
    }

    /** Provides a String representation of a fight given by 
     * the fight number
     * @param num the number of the fight
     * @return returns a String representation of a fight given by 
     * the fight number
     **/
    public String getFight(int num)
    {
        return "";
    }
    
    /** Provides a String representation of all fights 
     * @return returns a String representation of all fights
     **/
    public String getAllFights()
    {
        return "";
    }
    

    //****************** private methods for Task 4 functionality*******************
    //*******************************************************************************
    private void setupForces()
    {
        Wing IW1 = new Wing("Dragons", "IW1",10);
        
        Starship SS2 = new Starship("Enterprise", "SS2", 10, 20);
        WarBird WB3 = new WarBird("Droop", "WB3", 100, false);
        
        Wing IW4 = new Wing("Dragons", "IW4", 20);
        
        
        WarBird WB5 = new WarBird("Hang", "WB5", 300, true);
        Starship SS6 = new Starship("Voyager", "SS6", 15, 10);
        Starship SS7 = new Starship("Explorer", "SS7", 4, 5);
        WarBird WB9 = new WarBird("Hover", "WB9", 400, false);
        
        Wing IW10 = new Wing("Flyers", "IW10",5);
        
        

        
    }
    
    private void setupFights()
    {
        
    }
    
    

    //*******************************************************************************
    //*******************************************************************************
  

    // These methods are not needed until Task 7.3
    // ***************   file write/read  *********************
    /** Writes whole game to the specified file
     * @param fname name of file storing requests
     */
    public void saveGame(String fname)
    {    
    }
    
    /** reads all information about the game from the specified file 
     * and returns 
     * @param fname name of file storing the game
     * @return the game (as a Admiral object)
     */
    public SpaceWars restoreGame(String fname)
    {   
        return null;
    } 
    
}




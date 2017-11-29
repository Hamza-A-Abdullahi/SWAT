package OODCwk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * This class implements the behaviour expected from a SWAT
 * system as required for 6COM1037 - Nov 2017
 * 
 * @author 
 * @version 
 */

public class SpaceWars  implements SWAT 
{
    // fields
    private String name = "";
    private int warchest = 1000;
    private boolean isDefeated = false;
    
//**************** SWAT **************************  
    /** Constructor requires the name of the admiral
     * @param admiral the name of the admiral
     */  
    public SpaceWars(String admiral)
    {
        name = admiral;
        setupForces();
        setupFights();
    
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
        // Not properly done yet..
        return "SpaceWars{" + "name=" + name + ", warchest=" + warchest + ", isDefeated=" + isDefeated + '}';
    }
    
    
    
    /** returns true if war chest <=0 and the admiral's FightingFleet has no 
     * forces which can be recalled. 
     * @returns true if resources <=0 and the admiral's FightingFleet has no 
     * forces which can be recalled. 
     */
    public boolean isDefeated()
    {
        boolean result = false;
        
        boolean hasForces = false;
        
        
        for(ASF_Force force: ASF_Force.getallActive()) {
                hasForces = true;
        }
        if(warchest <=0 && !hasForces) {
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
        for(ASF_Force force: ASF_Force.getAllForces().values()) {
            result = result + force.toString();
        }
        return result;
    }
    
    /** Returns details of an ASF force with the given reference code
     * @return details of an ASF force with the given reference code
     **/
    public String findForceInASF(String ref)
    {
        String result = "";
        ASF_Force force = ASF_Force.getForce(ref);

        if(force != null) {
            
            if(force.getStatus() == ForceState.ACTIVE){
                 result = force.toString();
            } else {
                result = "This unit is not part of the ASF fleet.";
            }
        }
         else {
            result = "Invalid reference or force does not exist.";
        }
        
        return result;
    }
    
    /** Returns details of any force with the given reference code
     * @return details of any force with the given reference code
     **/
    public String getForce(String ref)
    {     
        String result = "";
        ASF_Force force = ASF_Force.getForce(ref);

        
        if(force != null) {
            result = force.toString();
        } else {
            result = "Invalid reference or force does not exist.";
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
        int result = 0;
        ASF_Force force = ASF_Force.getForce(ref);
       
        if(force != null) {
            switch(force.getStatus()) {
                case DOCKED:
                    if(warchest >= force.getActivationFee()) {
                        force.setStatus(ForceState.ACTIVE);
                        warchest = warchest - force.getActivationFee();
                        result = 0;
                    } else {
                        result = 2;
                    }
                case ACTIVE:
                    result = 0;
                default:
                    result = 1;
            }
        } else {
            result = 3;
        }
        
        return result;
    }
    
    /** Returns true if the force with the reference code is in 
     * the admiral's FightingFleet, false otherwise.
     * @param ref is the reference code of the force
     * @return returns true if the force with the reference code
     * is in the admiral's FightingFleet, false otherwise.
     **/
    public boolean isInFightingFleet(String ref)
    {
        boolean result = false;
        ASF_Force force = ASF_Force.getForce(ref);

        if(force != null) {
            
            if(force.getStatus() == ForceState.ACTIVE) {
                result = true;
            }
        }
        
        return result;
    }
    
    
    /** Removes a force from the FightingFleet back to the ASF dock, if they 
     * are in the FightingFleet
     * pre-condition: isInAdmiralsForce(ref)
     * @param ref is the reference code of the force
     **/
    public void recallForce(String ref)
    {
        ASF_Force force = ASF_Force.getForce(ref);
        
        if(force != null) {
            
            if(force.getStatus() == ForceState.ACTIVE) {
                warchest = warchest - (force.getActivationFee() / 2);
                force.setStatus(ForceState.DOCKED);
            }
        }
        
    }    
    
        
    /**Returns a String representation of the forces in the admiral's Fighting Fleet
     * or the message "No forces activated"
     * @return a String representation of the forces in the admiral's FightingFleet
     **/
    public String getFightingFleet()
    {
        String result = "";
        for(ASF_Force force: ASF_Force.getallActive()) {
            result = result + force.toString();
        }
        
        return result;
    }
    
    
//**********************Fights************************* 
    /** returns true if the number represents a fight
     * @param num is the number of the fight
     * @returns true if the number represents a fight
     **/
     public boolean isFight(int num)
     {
        Fight result = Fight.getFight(num);
       
        if(result != null) {
            return true;
        } else {
            return false;
        }
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
        int result = 0;
        Fight fight = Fight.getFight(fightNo);

        if(fight != null) {
            
            
            switch(fight.beginFight()) {
                case WON:
                    result = 0;
                case FORCE_LOST:
                    result = 1;
                case STRENGTH_LOST:
                    result = 2;
                    fight.DestroyForce();
            }
        
        // common rule
        if(result > 0) {
           warchest = warchest - fight.getLosses();
           
           if(isDefeated()) {
               result = 3;
           }
        }
            
        } else {
            result = -1;
        }
        

        return result;
    }

    /** Provides a String representation of a fight given by 
     * the fight number
     * @param num the number of the fight
     * @return returns a String representation of a fight given by 
     * the fight number
     **/
    public String getFight(int num)
    {
        String result = "";
        Fight fight = Fight.getFight(num);

        if(fight != null) {
            result = fight.toString();
        } else {
            result = "Invalid fight number";
        }
        
        return result;
    }
    
    /** Provides a String representation of all fights 
     * @return returns a String representation of all fights
     **/
    public String getAllFights()
    {
        String result = "";
        
        for(Fight fight: Fight.getAllFights().values()) {
            result = result + fight.toString() + "\n";
        }
        return result;
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
        Fight F1 = new Fight(FightType.BATTLE,new Enemy("Borg",200),300, 100);
        Fight F2 = new Fight(FightType.SKIRMISH,new Enemy("Kardassians",700),200, 120);
        Fight F3 = new Fight(FightType.AMBUSH,new Enemy("Ferengi",100),400,160);
        Fight F4 = new Fight(FightType.BATTLE,new Enemy("Ewoks",600),600, 200);
        Fight F5 = new Fight(FightType.AMBUSH,new Enemy("Borg",500),400, 90);
        Fight F6 = new Fight(FightType.SKIRMISH,new Enemy("Groaners",150),100, 100);

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
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(fname);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SpaceWars.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SpaceWars.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /** reads all information about the game from the specified file 
     * and returns 
     * @param fname name of file storing the game
     * @return the game (as a Admiral object)
     */
    public SpaceWars restoreGame(String fname)
    {
        SpaceWars result = null;
        try {
            FileInputStream fis = new FileInputStream(fname);
            ObjectInputStream ois = new ObjectInputStream(fis);
            result = (SpaceWars)ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SpaceWars.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(SpaceWars.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    } 
    
}




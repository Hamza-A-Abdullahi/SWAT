/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// EXAMPLE
// Hamza test
package OODCwk;

import java.util.ArrayList;

/**
 *
 * @author hamzaabdullahi
 */
public abstract class ASF_Force {
    private String fullname;
    private String reference;
    private ForceState status;  //docked, active or destroyed 
    protected int activationFee;
    protected int battleStrength;
    private ArrayList<ASF_Force> fightingFleet = new ArrayList();


    public String getFullname() {
        return fullname;
    }

    public String getReference() {
        return reference;
    }

    public ForceState getStatus() {
        return status;
    }

    public int getActivationFee() {
        return activationFee;
    }

    public int getBattleStrength() {
        return battleStrength;
    }
    

    public ASF_Force(String fullname, String reference, ForceState status, int activationFee, int battleStrength) {
        this.fullname = fullname;
        this.reference = reference;
        this.status = status;
        this.activationFee = activationFee;
        this.battleStrength = battleStrength;
    }
    public String findForce(String ref) {
        
           String result = "";
           for(ASF_Force force: fightingFleet) {


               if(force.getReference() == ref) {
                   result = force.toString();  // CHANGE FOR LATER 
               }
           }
           return result;
           
       }
    
       public void getFightingFleet() {
           for(ASF_Force force: fightingFleet) {
               System.out.println("Full name: " + force.getFullname());
               System.out.println("Reference: " + force.getReference());
               System.out.println("Status: " + force.getStatus());
               System.out.println("Activation Fee: " + force.getActivationFee());
               System.out.println("Battle Strength: " + force.getBattleStrength());
               System.out.println();

           }
       }
       
       public String toString() {
               String result = "";
               for(ASF_Force force: fightingFleet) {
                   result = result + "\n" + " Full name: " + force.getFullname();
                   result = result + "\n" + " Reference: " + force.getReference();
                   result = result + "\n" + "Status: " + force.getStatus();
                   result = result + "\n" + "Activation Fee: " + force.getActivationFee();
                   result = result + "\n" + "Battle Strength: " + force.getBattleStrength();
           
       }
               return result;           
       }
  
}
    
   
    
    

    
    
    
    
}

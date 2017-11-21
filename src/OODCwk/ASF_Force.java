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
    

    
    // I am keeping this just in case we need it, later on this will be removed.
//       public void getFightingFleet() {
//           for(ASF_Force force: fightingFleet) {
//               System.out.println("Full name: " + force.getFullname());
//               System.out.println("Reference: " + force.getReference());
//               System.out.println("Status: " + force.getStatus());
//               System.out.println("Activation Fee: " + force.getActivationFee());
//               System.out.println("Battle Strength: " + force.getBattleStrength());
//               System.out.println();
//
//           }
//       }
//    
//    public String findForce(String ref) {
//        
//           String result = "";
//           
//           for(ASF_Force force: fightingFleet) {
//
//
//               if(force.getReference().equals(ref)) {
//                   result = force.toString();  // CHANGE FOR LATER 
//               }
//           }
//           return result;
//           
//       }
//       
       public String toString() {
               String result = "";
                   result = result + "\n" + " Full name: " + this.getFullname();
                   result = result + "\n" + " Reference: " + this.getReference();
                   result = result + "\n" + "Status: " + this.getStatus();
                   result = result + "\n" + "Activation Fee: " + this.getActivationFee();
                   result = result + "\n" + "Battle Strength: " + this.getBattleStrength();
           
     
                   return result;           
       }
  
}
    
   
    
    

    
    
    
    


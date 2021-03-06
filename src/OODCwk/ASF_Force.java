/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//
package OODCwk;

import java.util.ArrayList;
import java.util.HashMap;


public abstract class ASF_Force {
    private String fullname;
    private String reference;
    private ForceState status;  //docked, active or destroyed 
    private int activationFee;
    private int battleStrength;

    
    /**
     * This is the parent class which is ABSTRACT. This means that an object of type ASF_Force cannot be instantiated. However all ASF Force units will have the following fields:
     * @param fullname a name must be given (String)
     * @param reference a unique reference (String)
     * @param activationFee the cost to activate this ASF force unit (int)
     * @param battleStrength a strength value (int)
     */
    public ASF_Force(String fullname, String reference, int activationFee, int battleStrength) {
        this.fullname = fullname;
        this.reference = reference;
        this.activationFee = activationFee;
        this.battleStrength = battleStrength;
        this.status = ForceState.DOCKED;
    }
    
    /** This is a getter method to retrieve the full name of an ASF Force unit.
     *
     * @return string of ASF force's full name
     */
    public String getFullname() {
        return fullname;
    }

    /** This is a getter method to retrieve the reference of an ASF Force unit.
     *
     * @return string of ASF force's reference.
     */
    public String getReference() {
        return reference;
    }

    /** This is a getter method to retrieve the enumeration state of an ASF Force unit which can have three possible values DOCKED, ACTIVE or DESTROYED (see ForceState.java).  
     *
     * @return ForceState enumeration (DOCKED, ACTIVE or DESTROYED)
     */
    public ForceState getStatus() {
        return status;
    }

    /** This is a getter method to retrieve the activation fee cost of an ASF force unit given in bit coins.
     *
     * @return integer of the ASF force's activation fee
     */
    public int getActivationFee() {
        return activationFee;
    }


    /** This is a getter method to retrieve the battle strength of an ASF force unit.
     *
     * @return integer of the ASF force's battle strength.
     */
    public int getBattleStrength() {
        return battleStrength;
    }

    /** This is a setter method to change the state of a ASF force unit.
     *  
     * @param status is of type enumeration and has three possible options ACTIVE, DESTROYED or DOCKED (see ForceState.java).
     */
    public void setStatus(ForceState status) {
        this.status = status;
    }

    /** This is a setter method to change the activation fee of a ASF force unit.
     *
     * @param activationFee
     */
    public void setActivationFee(int activationFee) {
        this.activationFee = activationFee;
    }
    
    /** This is a setter method to change the battle strength of a ASF Force unit.
     *
     * @param battleStrength
     */
    public void setBattleStrength(int battleStrength) {
        this.battleStrength = battleStrength;
    }
    
    /**
     * This method will be used to check whether the ASF force unit can be used in a fight.
     * Each unit in the game has a rule which they have to follow for specific fights. 
     * For example a Starship can only go to Skirmish or Battle fights. 
     * 
     * @param fight
     * @return boolean of whether the ASF_Force unit can be used on a fight. 
     * If it can be used in fight then it should return true, otherwise false.
     */
    public abstract boolean gameRule(Fight fight);
    
    /**
     * This method will return all data of an ASF Force unit as a String
     * @return all data of a ASF Force Unit as a String Representation.
     */
    public abstract String getDetails();
    
    @Override
    public String toString() {
               String result = "";
                   result = result + "Full name: " + this.getFullname() + "\n";
                   result = result + "Reference: " + this.getReference() + "\n";
                   result = result +  "Status: " + this.getStatus() + "\n";
                   result = result +  "Activation Fee: " + this.getActivationFee() + "\n";
                   result = result +  "Battle Strength: " + this.getBattleStrength() +"\n";
                   result = result +  "Other Details: { " + getDetails() + " }" + "\n \n";
           
                   return result;           
    }
    
    
    
    
}

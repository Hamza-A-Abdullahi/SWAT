/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
     *
     * @param fullname
     * @param reference
     * @param activationFee
     * @param battleStrength
     */
    public ASF_Force(String fullname, String reference, int activationFee, int battleStrength) {
        this.fullname = fullname;
        this.reference = reference;
        this.activationFee = activationFee;
        this.battleStrength = battleStrength;
        this.status = ForceState.DOCKED;
    }
    
    /** allForces will store all ASF force units that are in the game.
     *  The key is the ASF force unit's Reference given as a string which should uniquely identify each unit.
     *  The value will store the actual object of the ASF Force unit.
     */
    private static HashMap<String, ASF_Force> allForces = new HashMap();
    
    
    
    public static ASF_Force getForce(String ref)  {
        ASF_Force result = allForces.get(ref);
        
        return result;
    } 
    
    
    public static ArrayList<ASF_Force> getallActive() {
        ArrayList<ASF_Force> resultForces = null;
        for(ASF_Force force: allForces.values()) {
            if(force.getStatus() == ForceState.ACTIVE) {
                resultForces.add(force);
            }
        }
        
        return resultForces;
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

    /** This is a getter method to retrieve the data structure used to store all ASF forces.
     *  The data structure used is a Hash map where the key is Reference (string) and the actual ASF unit object (ASF_Force)
     * @return HashMap<String, ASF_Force> of all units.
     */
    public static HashMap<String, ASF_Force> getAllForces() {
        return allForces;
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
     * @return boolean of whether the ASF_Force unit can be used on a fight. 
     * If it can be used in fight then it should return true, otherwise false.
     */
    public abstract boolean gameRule(Fight fight);
    
    /**
     * This method will return all data of a unit as a String
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
                   result = result +  "Other Details: { " + getDetails() + " }" + "\n";
           
                   return result;           
    }
    
    
    
    
}

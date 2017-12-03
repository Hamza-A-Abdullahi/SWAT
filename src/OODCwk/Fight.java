/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OODCwk;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Wayne
 */
public class Fight {

    private static int counter;
    private int fightNo;
    private FightType fightType;
    private Enemy enemy;
    private FightResult fightResult = FightResult.NONE;
    private int gains;
    private int losses;
    
    private int forceTotalStrength;
    private ArrayList<ASF_Force> usedForces = new ArrayList();

    
    private static HashMap<Integer, Fight> allFights = new HashMap();
    
    /** 
     * This is a static getter method to retrieve a fight by the given fight number.
     * Each fight is uniquely identified by a fight number.
     * @param num  the fight number is used as a parameter.
     * @return if the fight with the given fight number does not exist it will return null, otherwise it will return an object of type Fight.
     */
    public static Fight getFight(int num) {
        Fight result = allFights.get(num);
        return result;
    } 

    /**
     *
     * @param fightType
     * @param enemy
     * @param losses
     * @param gains
     */
    public Fight(FightType fightType, Enemy enemy, int losses, int gains ) {
        this.fightType = fightType;
        this.enemy = enemy;
        this.gains = gains;
        this.losses = losses;
        
        this.fightNo = ++counter;
        allFights.put(this.fightNo, this);
        
    }    
    

    /** 
     * This is a getter method which will retrieve what type is the fight. 
     * A fight can have different types: SKIRMISH, BATTLE and AMBUSH (see FightType.java).
     * @return an enumeration of the fight type.
     */
    public FightType getFightType() {
        return fightType;
    }

    /** 
     * This is a getter method which will retrieve the enemy of the fight.
     * All fights have enemies which have different strengths
     * @return an object of the enemy used in the fight.
     */
    public Enemy getEnemy() {
        return enemy;
    }

    /** 
     * This is a getter method which will retrieve result of the fight.
     * There are four possible fight results: WON, FORCE_LOST, STRENGTH_LOST and NONE (see FightResult.java)
     * @return an enumeration of the fight result.
     */
    public FightResult getFightResult() {
        return fightResult;
    }

    /** 
     * This is a getter method which will retrieve the reward for winning a fight.
     * The reward given for winning a fight is given in bit coins.
     * @return an integer value of the gains of a fight. 
     */
    public int getGains() {
        return gains;
    }

    /** 
     * This is a getter method which will retrieve the penalty of losing a fight.
     * The penalty given for losing a fight is given in bit coins.
     * @return an integer value of the losses of a fight.
     */
    public int getLosses() {
        return losses;
    }

    /**
     * This is a getter method which will retrieve the data structure used to store all fights.
     * All fights are stored as a HashMap where the key is fight number (Integer) and the value is actual Fight object (Fight).
     * @return HashMap<Integer, Fight> of all fights.
     */
    public static HashMap<Integer, Fight> getAllFights() {
        return allFights;
    }



    /** 
     * This is a setter method which will change the type of a fight.
     * A fight can have different types: SKIRMISH, BATTLE and AMBUSH (see FightType.java).
     * @param fightType can be: FightType.SKIRMISH, FightType.BATTLE and FightType.AMBUSIH (see FightType.java).
     */
    public void setFightType(FightType fightType) {
        this.fightType = fightType;
    }

    /**
     * This is a setter method which will change the enemy of a fight.
     * All fights have an enemy which is usually fixed, but just in case the enemy needs to be changed then this method will allow you to do so.
     * @param enemy this is an Enemy object which will be used in the fight, the current enemy will be replaced with the one specified.
     */
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    /**
     * This is a getter method which will changed the reward for a fight.
     * The reward given is by the number of bit coins that should be added to the player's warchest.
     * @param gains this is the number of bit coins the player will get when the player wins the fight.
     */
    public void setGains(int gains) {
        this.gains = gains;
    }

    /**
     * This is a setter method which will change the penalty for a fight
     * The penalty given is the number of bit coins that should be taken from the player's warchest.
     * @param losses this is the number of bit coins the player will take when the player loses the fight.
     */
    public void setLosses(int losses) {
        this.losses = losses;
    }

     /**
     * This method which is PRIVATE which will retrieve all suitable forces which can participate in a fight.
     */
    private void findSuitableforce() {
        int enemyStrength = enemy.getStrength();
        int forceStrength = 0;
        
            for(ASF_Force force: ASF_Force.getallActive()) {
               
                if(force.gameRule(this)) {
                    forceStrength = forceStrength + force.getBattleStrength();
                    usedForces.add(force);
                }
                if(forceStrength >= enemyStrength) {
                    break;
                } 
            }
        
        this.forceTotalStrength = forceStrength;
        
    }
    
    /**
     * This method which will set all forces used in fight to DESTROYED
     */
    public void DestroyForce() {
        if(!usedForces.isEmpty())
            for(ASF_Force force: usedForces){
               
                force.setStatus(ForceState.DESTROYED);
            }
        
    }

    /**
     * This method will retrieve all ASF force units used in a fight. 
     * @return An ArrayList of all ASF force units used in a fight will be returned.
     * The beginFight() method must be executed before running this method or there will be an empty ArrayList returned.
     */
    public ArrayList<ASF_Force> getUsedForces() {
        return usedForces;
    }
    
    /**
     * This is a getter method which will get the result of the fight.
     * @return will return the result of a fight which can be: NONE, FORCE_LOST and STRENGTH_LOST (see FightResult.java).
     */
    public FightResult beginFight() {
        
        findSuitableforce();
        int totalStrength = this.forceTotalStrength;
        
        if(totalStrength == 0) {
            this.fightResult = FightResult.FORCE_LOST;
        } 
        else if(totalStrength < enemy.getStrength()) {
            this.fightResult = FightResult.STRENGTH_LOST;
        }
        else {
            this.fightResult = FightResult.WON;
        }
 
        
        return this.fightResult;
    }
   
    @Override
    public String toString() {
        String result = "";
        return "Fight{" + "fightNo=" + fightNo + ", fightType=" + fightType + ", enemy=" + enemy + ", fightResult=" + fightResult + ", gains=" + gains + ", losses=" + losses + result + ", forces total strength: " + forceTotalStrength + '}';
    }
    
    



    
    
    
    
    
}

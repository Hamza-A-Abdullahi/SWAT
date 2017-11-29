/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

import java.util.ArrayList;
import java.util.HashMap;


public class Fight {

    private static int fightNo = 0;
    private FightType fightType;
    private Enemy enemy;
    private FightResult fightResult = FightResult.NONE;
    private int gains;
    private int losses;
    
    private int forceTotalStrength;
    private ArrayList<ASF_Force> usedForces = new ArrayList();

    
    private static HashMap<Integer, Fight> allFights = new HashMap();
    
    public static Fight getFight(int num) throws Exception {
        Fight result = allFights.get(num);
        
        if(result == null){
            throw new Exception("Invalid Reference: The fight does not exist with the given reference.");
        } else {
            return result;
        }
    } 
    public Fight(FightType fightType, Enemy enemy, int losses, int gains ) {
        this.fightType = fightType;
        this.enemy = enemy;
        this.gains = gains;
        this.losses = losses;
        
        fightNo = fightNo + 1;
        allFights.put(fightNo, this);
        
    }    
    
    public static int getFightNo() {
        return fightNo;
    }

    public FightType getFightType() {
        return fightType;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public FightResult getFightResult() {
        return fightResult;
    }

    public int getGains() {
        return gains;
    }

    public int getLosses() {
        return losses;
    }

    public static HashMap<Integer, Fight> getAllFights() {
        return allFights;
    }

    public static void setFightNo(int fightNo) {
        Fight.fightNo = fightNo;
    }

    public void setFightType(FightType fightType) {
        this.fightType = fightType;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setFightResult(FightResult fightResult) {
        this.fightResult = fightResult;
    }

    public void setGains(int gains) {
        this.gains = gains;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setAllFights(HashMap<Integer, Fight> allFights) {
        this.allFights = allFights;
    }
    
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
    
    public void DestroyForce() {
      for(ASF_Force force: usedForces){
          force.setStatus(ForceState.DESTROYED);
      }   
    }

    public ArrayList<ASF_Force> getUsedForces() {
        return usedForces;
    }
    
    
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
        if(fightResult == FightResult.NONE) {
            result = "forceTotalStrength=" + forceTotalStrength + ", usedForces=" + usedForces;
        }
        return "Fight{" + "fightNo=" + fightNo + "fightType=" + fightType + ", enemy=" + enemy + ", fightResult=" + fightResult + ", gains=" + gains + ", losses=" + losses + result + '}';
    }
    
    



    
    
    
    
    
}

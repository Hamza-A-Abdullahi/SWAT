/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

/**
 *
 * @author hamzaabdullahi
 */
public class Enemy {
    
    private String enemyName;
    private int enemyStrength;

    public Enemy(String enemyName, int enemyStrength) {
        this.enemyName = enemyName;
        this.enemyStrength = enemyStrength;
        
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public void setEnemyStrength(int enemyStrength) {
        this.enemyStrength = enemyStrength;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getEnemyStrength() {
        return enemyStrength;
    }
    
           
    
}

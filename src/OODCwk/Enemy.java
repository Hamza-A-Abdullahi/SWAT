/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;


public class Enemy {
    private String enemyName;
    private int strength;

    public Enemy(String enemyName, int strength) {
        this.enemyName = enemyName;
        this.strength = strength;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getStrength() {
        return strength;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    
    
    
}

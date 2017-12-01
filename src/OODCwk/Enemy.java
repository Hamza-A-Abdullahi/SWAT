/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OODCwk;

/**
 *
 * @author Wayne
 */
public class Enemy {
    private String enemyName;
    private int strength;

    /**
     *
     * @param enemyName
     * @param strength
     */
    public Enemy(String enemyName, int strength) {
        this.enemyName = enemyName;
        this.strength = strength;
    }

    /**
     *
     * @return
     */
    public String getEnemyName() {
        return enemyName;
    }

    /**
     *
     * @return
     */
    public int getStrength() {
        return strength;
    }

    /**
     *
     * @param enemyName
     */
    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    /**
     *
     * @param strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Enemy{" + "enemyName=" + enemyName + ", strength=" + strength + '}';
    }
    
    
    
}

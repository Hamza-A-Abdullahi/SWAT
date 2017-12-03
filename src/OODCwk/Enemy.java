/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OODCwk;


public class Enemy {
    private String enemyName;
    private int strength;

    /**
     * To create an Enemy:
     * @param enemyName the Enemy must be given a name (String).
     * @param strength the Enemy must be given a strength value (int).
     */
    public Enemy(String enemyName, int strength) {
        this.enemyName = enemyName;
        this.strength = strength;
    }

    /**
     * This is a getter method which will retrieve the Enemy's given name.
     * @return enemyName (String)
     */
    public String getEnemyName() {
        return enemyName;
    }

    /**
     * This is a getter method which will retrieve the Enemy's strength.
     * @return strength (int)
     */
    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return "Enemy{" + "enemyName=" + enemyName + ", strength=" + strength + '}';
    }
    
    
    
}

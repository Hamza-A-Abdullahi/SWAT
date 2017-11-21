/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

import java.util.ArrayList;

/**
 *
 * @author wrmos
 */
public class Battle {

    private static int fightNo;
    private FightType fightType;        
    private ArrayList<Enemy> enemies = new ArrayList();
    // ANOTHER FIELD IS NEEDED FOR FIGHT RESULT!
     public Battle(FightType fightType) {
        this.fightNo = this.fightNo + 1;
        this.fightType = fightType;
    }
  
    
    
    
}

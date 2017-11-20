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
public class Player {
    
    private String admiralName;
    private int warchest= 1000;

   
    

    private boolean defeated= true;

    public Player(String admiralName) {
        this.admiralName = admiralName;
        //this.fightingfleet = fightingfleet;
    }
    
   
//    public boolean isDefeated(){
//       
//        if (warchest <=0 && fightingfleet==0) {
//            defeated=true;
//           
//        }
//        return defeated;
//    }

    public String getAdmiralName() {
        return admiralName;
    }

    public int getWarchest() {
        return warchest;
    }
    
   
 
    

}
    
    
    
 
    
    
    


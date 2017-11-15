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
public class Player implements SWAT {
    
    private String admiralName;
    private int warchest= 1000;
    private int fightingfleet;
    private boolean defeated= true;
    
    
   
    public String toString(){
        return "van";
  
    }
   
    public boolean isDefeated(){
       
        if (warchest <=0 && fightingfleet==0) {
            defeated=true;
           
        }
        return defeated;
    }
    
   
    public int getWarchest() {
        return warchest;
    }
    
 
//   // public String getASFleet(){
//        
//    }
//    
//    
//   
//    //public String findForceInASF(String ref);
//    
//    
//    
//    public String getForce(String ref);
//    
//  
//    public int activateForce(String ref);
//    
//        
//   
//    public boolean isInFightingFleet(String ref);
//    
//    
//
//    public void recallForce(String ref);
//        
        
    
//    public String getFightingFleet()
//       
//    
//
//     public boolean isFight(int num);
//     
//   
//    public int fight(int fightNo);
//    
//
//    
//    public String getFight(int num);
//    
//    
//    
//    public String getAllFights();
// 

    @Override
    public String getASFleet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String findForceInASF(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getForce(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int activateForce(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isInFightingFleet(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recallForce(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFightingFleet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFight(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int fight(int fightNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFight(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAllFights() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
    
    
    
 
    
    
    


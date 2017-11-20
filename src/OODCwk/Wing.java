/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

/**
 *
 * @author wr15aab
 */
public class Wing extends ASF_Force {
    int strikers;
    
    public Wing(String fullname, String reference, ForceState status, int activationFee, int battleStrength, int no_strikers) {
        super(fullname, reference, status, activationFee, battleStrength);
        
        this.strikers = no_strikers;
        
        this.battleStrength = strikers*20;
        
        this.activationFee= 200;
    }
   
    public String toString() {
        return " Number of Strikers: " + this.strikers;
    }
}

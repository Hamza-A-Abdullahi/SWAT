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
public class WarBird extends ASF_Force {
    
    private boolean cloaking_device;

    public WarBird(String fullname, String reference, ForceState status, int activationFee, int battleStrength, boolean cloaking_device) {
        
        super(fullname, reference, status, activationFee, battleStrength);
        this.activationFee = 300;
        
        
        
        if(cloaking_device) {
            this.activationFee = 400;
        }
        
        this.cloaking_device = cloaking_device;

    }
    
    public String toString() {
        String result = "";
        if(this.cloaking_device) {
            result = result + " Cloaking Device: Enabled"; 
        }
        
        return result;
        
    }
    
}

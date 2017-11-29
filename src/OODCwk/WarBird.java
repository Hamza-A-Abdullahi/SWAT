/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;


public class WarBird extends ASF_Force {
    boolean cloakingDevice;
    public WarBird(String fullname, String reference, int battleStrength, boolean cloakingDev) {
        super(fullname, reference, 0, battleStrength);
        
        if(cloakingDev){
            this.setActivationFee(300);
        }
        else{
            this.setActivationFee(400);
        }
        this.cloakingDevice = cloakingDev;
        
    }

    @Override
    public String getDetails() {
        String result;
        
        if(cloakingDevice) {
            result = "Cloaking Device: Enabled";
        } else {
            result = "Cloaking Device: Not Found";
        }
        return result;
    }

    public boolean gameRule(Fight fight) {
        boolean result = false;
        switch(fight.getFightType()) {
            case AMBUSH:
                if(cloakingDevice) {
                    result = true;
                }
            case BATTLE:
                result =  true;
            default:
                result = false;
                
        }
        
        return result;
    }
    
}

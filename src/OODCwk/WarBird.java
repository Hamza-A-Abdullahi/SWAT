/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

/**
 *
 * @author 
 */
public class WarBird extends ASF_Force {
    boolean cloakingDevice;

    /**
     * To create a WarBird:
     * @param fullname a name must be given (String)
     * @param reference a unique reference (String)
     * @param battleStrength a strength value (int)
     * @param cloakingDev whether the unit will have a cloaking device. If it does have cloaking device this should be set to true, otherwise false (boolean). 
     */
    public WarBird(String fullname, String reference, int battleStrength, boolean cloakingDev) {
        super(fullname, reference, 0, battleStrength);
        
        if(cloakingDev){
            this.setActivationFee(400);
        }
        else{
            this.setActivationFee(300);
        }
        
        
        this.cloakingDevice = cloakingDev;
        
    }

    @Override
    public String getDetails() {
        String result;
        
        result = "Cloaking Device: " + cloakingDevice;
        
        return result;
    }

    public boolean gameRule(Fight fight) {
        boolean result = false;
        switch(fight.getFightType()) {
            case AMBUSH:
                if(cloakingDevice) {
                    result = true;
                } else {
                    result = false;
                }
            break;
            case BATTLE:
                result =  true;
                break;
            case SKIRMISH:
                result = false;
                break;
                
        }
        
        return result;
    }
    
}

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
public class Starship extends ASF_Force {
    int laserCannons;
    int photontorpedo;
    
    
    
    public Starship(String fullname, String reference, ForceState status, int activationFee, int battleStrength, int no_laserCannons,int no_photontorpedo) {
        super(fullname, reference, status, activationFee, battleStrength);
        
        if(no_laserCannons > 0) {
           this.activationFee = no_laserCannons * 30;
        }
        
       this.photontorpedo = no_photontorpedo;
       this.laserCannons = no_laserCannons;
       
       this.battleStrength += no_photontorpedo * 5;
       this.battleStrength += no_laserCannons *10;
        
        
    }
    
    public String toString() {
        return "Number of Photon Torpedos " + this.photontorpedo + " \n Number of Laser Cannons: " + this.laserCannons;
    }
    
}
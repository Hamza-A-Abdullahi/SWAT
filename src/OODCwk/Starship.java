/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;
//

/**
 *
 * @author Wayne
 */
public class Starship extends ASF_Force {
    int laserCannons;
    int photonTorpedos;
    
    /**
     * To create a Starship:
     * @param fullname a name must be given (String)
     * @param reference a unique reference (String)
     * @param lasers the number of laser cannons the Starship will have (int)
     * @param photon the number of photon torpedos the Starship will have (init)
     * It currently costs 30 bitcoins per a laser cannon, and 5 bitcoins for a photon torpedo.
     * The battle strength is calculated by: [5 * number of photon torpedos + 10 * laser cannons]
     */
    public Starship(String fullname, String reference, int lasers, int photon) {
        super(fullname, reference, 0, 0);
        this.setActivationFee(30*lasers);
        this.setBattleStrength(5*photon + 10*lasers);
        this.laserCannons = lasers;
        this.photonTorpedos = photon;
    }

    @Override
    public String getDetails() {
        return "Laser Cannons: " + laserCannons + " Photon Torpedos: " + photonTorpedos;
    }

    @Override
    public boolean gameRule(Fight fight) {
        boolean result = false;
        

        switch(fight.getFightType()) {
            case SKIRMISH:
                result = true;
                break;
            case BATTLE:
                result = true;
                break;
            case AMBUSH:
                result = false;
                break;
                
        }
        
        return result;
    }
}

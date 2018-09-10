package OODCwk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

//
/**
 * This class implements the behaviour expected from a SWAT system as required
 * for 6COM1037 - Nov 2017
 *
 * @author
 * @version
 */
public class SpaceWars implements SWAT {

    // fields
    private String name = "";
    private int warchest = 1000;
    private boolean isDefeated = false;
    private final HashMap<String, ASF_Force> forces;
    private final HashMap<Integer, Fight> fights;

//**************** SWAT **************************  
    /**
     * Constructor requires the name of the admiral
     *
     * @param admiral the name of the admiral
     */
    public SpaceWars(String admiral) {
        this.name = admiral;
        this.forces = new HashMap();
        this.fights = new HashMap();
        setupForces();
        setupFights();

    }

    /**
     * Returns a String representation of the state of the game, including the
     * name of the admiral, state of the resources, whether defeated or not, and
     * the forces currently in the FightingFleet,(or, "No forces" if
     * FightingFleet is empty)
     *
     * @return a String representation of the state of the game, including the
     * name of the admiral, state of the resources, whether defeated or not, and
     * the forces currently in the FightingFleet,(or, "No forces" if
     * FightingFleet is empty)
     *
     */
    public String toString() {
        // Not properly done yet..
        String fightingFleet = this.getFightingFleet();
        return "SpaceWars{" + "name=" + name + ", warchest=" + warchest + ", isDefeated=" + isDefeated + '}' + "\n Fighting Fleet : " + fightingFleet;
    }

    /**
     * returns true if war chest <=0 and the admiral's FightingFleet has no
     * forces which can be recalled. @returns true if resources <=0 and the
     * admiral's FightingFleet has no
     *
     * forces which can be recalled.
     */
    @Override
    public boolean isDefeated() {
        boolean result = false;

        if (this.warchest <= 0 && this.getFightingFleet() == "") {
            result = true;
            this.isDefeated = result;
            System.out.println("The game has been lost.");
        }

        return result;
    }

    /**
     * returns the number of talents in the resources
     *
     * @returns the number of talents in the resources
     */
    @Override
    public int getWarchest() {
        return warchest;
    }

    /**
     * Returns a String representation of all forces in the Allied Space
     * Fleet(ASF)
     *
     * @return a String representation of all forces in the Allied Space
     * Fleet(ASF)
     *
     */
    public String getASFleet() {
        String result = "";
        if (!forces.isEmpty()) {
            for (ASF_Force force : forces.values()) {
                if (force.getStatus() != ForceState.ACTIVE) {
                    result = result + force.toString();
                }
            }
        }
        return result;
    }

    /**
     * Returns details of an ASF force with the given reference code
     *
     * @param ref this is the reference ID of the force member.
     * @return details of an ASF force that is docked with the given reference
     * code, if the force is not found or docked the string "no" will be
     * returned.
     *
     */
    @Override
    public String findForceInASF(String ref) {
        String result = "no";
        ASF_Force force = forces.get(ref);

        if (force != null) {

            if (force.getStatus() == ForceState.DOCKED) {
                result = force.toString();
            }
        }

        return result;
    }

    /**
     * Returns details of any force with the given reference code
     *
     * @param ref this is the reference ID of the force member.
     * @return details of any force with the given reference code, , if the
     * force is not found "No such force" will be returned.
     *
     */
    public String getForce(String ref) {
        ASF_Force force = forces.get(ref);

        if (force != null) {
            return force.toString();
        } else {
            return "No such force";
        }
    }

    // ***************** Fighting Fleet Forces ************************   
    /**
     * Allows a force to be activated into the admiral's FightingFleet, if there
     * are enough resources for the activation fee.The force's state is set to
     * "active"
     *
     * @param ref represents the reference code of the force
     * @return 0 if force is activated, 1 if force is not in the ASF 2 if not
     * enough money, 3 if no such force
     *
     */
    public int activateForce(String ref) {
        int result = 0;
        ASF_Force force = forces.get(ref);

        if (force != null) {
            switch (force.getStatus()) {
                case DOCKED:
                    if (warchest >= force.getActivationFee()) {
                        force.setStatus(ForceState.ACTIVE);
                        warchest = warchest - force.getActivationFee();
                        result = 0;
                    } else {
                        result = 2;
                    }
                    break;
                case ACTIVE:
                    result = 0;
                    break;
                case DESTROYED:
                    result = 1;
                    break;
            }
        } else {
            result = 3;
        }

        return result;
    }

    /**
     * Returns true if the force with the reference code is in the admiral's
     * FightingFleet, false otherwise.
     *
     * @param ref is the reference code of the force
     * @return returns true if the force with the reference code is in the
     * admiral's FightingFleet, false otherwise.
     *
     */
    @Override
    public boolean isInFightingFleet(String ref) {
        boolean result = false;
        ASF_Force force = forces.get(ref);

        if (force != null) {
            if (force.getStatus() == ForceState.ACTIVE) {
                result = true;
            }
        }

        return result;
    }

    /**
     * Removes a force from the FightingFleet back to the ASF dock, if they are
     * in the FightingFleet pre-condition: isInAdmiralsForce(ref)
     *
     * @param ref is the reference code of the force
     *
     */
    @Override
    public void recallForce(String ref) {
        ASF_Force force = forces.get(ref);

        if (force != null) {

            if (force.getStatus() == ForceState.ACTIVE) {
                warchest = warchest + (force.getActivationFee() / 2);
                force.setStatus(ForceState.DOCKED);
            }
        }

    }

    /**
     * Returns a String representation of the forces in the admiral's Fighting
     * Fleet or the message "No forces activated"
     *
     * @return a String representation of the forces in the admiral's
     * FightingFleet
     *
     */
    @Override
    public String getFightingFleet() {
        String result = "";

        for (ASF_Force member : forces.values()) {
            if (member.getStatus() == ForceState.ACTIVE) {
                result = result + member.toString();
            }
        }
        return result;
    }

//**********************Fights************************* 
    /**
     * returns true if the number represents a fight
     *
     * @param fightNo is the number of the fight
     * @return true if the number represents a fight
     *
     */
    public boolean isFight(int fightNo) {
        Fight result = fights.get(fightNo);

        return result != null;
    }

    /**
     * Retrieves the fight represented by the fight number.Finds a force from
     * the Fighting Fleet which can engage in the fight.The results of fighting
     * an fight will be one of the following: 0 - Fight won, add fight gains to
     * the warchest, 1 - Fight lost as no suitable force available, deduct the
     * fight losses from resources 2 - Fight lost on battle strength - deduct
     * fight losses warchest, and destroy the force 3 - If a fight is lost and
     * admiral completely defeated (no resources and no forces to recall) -1 -
     * no such fight
     *
     * @param fightNo is the number of the fight
     * @return a int showing the result of the fight
     */
    @Override
    public int fight(int fightNo) {
        int result = 0;
        Fight fight = fights.get(fightNo);
        if (fight != null) {

            switch (fight.beginFight(forces.values())) {
                case WON:
                    result = 0;
                    warchest = warchest + fight.getGains();
                    break;

                case FORCE_LOST:
                    result = 1;
                    break;

                case STRENGTH_LOST:
                    result = 2;
                    fight.DestroyForce();
                    break;
            }

            // common rule
            if (result > 0) {
                warchest = warchest - fight.getLosses();

                if (isDefeated()) {
                    result = 3;
                }
            }

        } else {
            result = -1;
        }

        return result;
    }

    /**
     * Provides a String representation of a fight given by the fight number
     *
     * @param fightNo the number of the fight
     * @return returns a String representation of a fight given by the fight
     * number
     *
     */
    @Override
    public String getFight(int fightNo) {
        Fight fight = fights.get(fightNo);

        if (fight != null) {
            return fight.toString();
        } else {
            return "Invalid fight number";
        }

    }

    /**
     * Provides a String representation of all fights
     *
     * @return returns a String representation of all fights
     *
     */
    public String getAllFights() {
        String result = "";

        for (Fight battle : fights.values()) {
            result = result + battle.toString() + "\n";
        }
        return result;
    }

    //****************** private methods for Task 4 functionality*******************
    //*******************************************************************************
    private void setupForces() {
        ASF_Force[] force_setUp = {new Wing("Dragons", "IW1", 10),
            new Starship("Enterprise", "SS2", 10, 20),
            new WarBird("Droop", "WB3", 100, false),
            new Wing("Wingers", "IW4", 20),
            new WarBird("Hang", "WB5", 300, true),
            new Starship("Voyager", "SS6", 15, 10),
            new Starship("Explorer", "SS7", 4, 5),
            new WarBird("Hover", "WB9", 400, false),
            new Wing("Flyers", "IW10", 5)
        };

        for (ASF_Force member : force_setUp) {
            forces.put(member.getReference(), member);
        }

    }

    private void setupFights() {
        Fight[] fight_setUp = {
            new Fight(FightType.BATTLE, new Enemy("Borg", 200), 300, 100),
            new Fight(FightType.SKIRMISH, new Enemy("Kardassians", 700), 200, 120),
            new Fight(FightType.AMBUSH, new Enemy("Ferengi", 100), 400, 150),
            new Fight(FightType.BATTLE, new Enemy("Ewoks", 600), 600, 200),
            new Fight(FightType.AMBUSH, new Enemy("Borg", 500), 400, 90),
            new Fight(FightType.SKIRMISH, new Enemy("Groaners", 150), 100, 100)
        };

        for (Fight battle : fight_setUp) {
            fights.put(battle.getFightNo(), battle);
        }

    }

    //*******************************************************************************
    //*******************************************************************************
    // These methods are not needed until Task 7.3
    // ***************   file write/read  *********************
    /**
     * Writes whole game to the specified file
     *
     * @param fname name of file storing requests
     */
    public void saveGame(String fname) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
            oos.writeObject(this);

            oos.flush();
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SpaceWars.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SpaceWars.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * reads all information about the game from the specified file and returns
     *
     * @param fname name of file storing the game
     * @return the game (as a Admiral object)
     */
    public SpaceWars restoreGame(String fname) {
        SpaceWars result = null;
        try {
            FileInputStream fis = new FileInputStream(fname);
            ObjectInputStream ois = new ObjectInputStream(fis);
            result = (SpaceWars) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SpaceWars.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(SpaceWars.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

}

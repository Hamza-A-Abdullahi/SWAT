/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jp14adn
 */
public class ForceActivationTest {
    SWAT game;
    
    public ForceActivationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new SpaceWars("Olenka");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void checkNotEnoughCreditInWarchest() {
        int expected = 200;
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        game.activateForce("WB5");
        assertEquals(expected, game.getWarchest());
    }
    
    @Test
    public void checkReturnValueForNotEnoughInWarchest() {
        int expected = 2;
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        int actual = game.activateForce("WB5");
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkReturnValueForNotEnoughInWarchestOnNonExistentForce() {
        int expected = 3;
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        game.activateForce("WB5");
        int actual = game.activateForce("XX3");
        assertEquals(expected, actual);
    }
    
    @Test
    public void reactivateExistingForceHasNoEffectOnWarchest() {
        int expected = 200;
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("WB3");
        game.activateForce("IW1");
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkActivatedForceNotOnASFleetList() {
        game.activateForce("IW10");
        game.activateForce("SS2");
        game.activateForce("WB3");
        boolean result = true;
        List<String> notOnList = new ArrayList<>(Arrays.asList("IW10","SS2","WB3"));
        String actual = game.getASFleet();
        for (String force : notOnList) {
            result &= !actual.contains(force);
        }
        assertTrue(result);
    }
    
    @Test
    public void checkForceRecallUpdatesWarchestForActivatedForce() {
        int expected = 800;
        game.activateForce("WB5");
        game.recallForce("WB5");
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkForceRecallDoesNotUpdateWarchestForNonActiveForce() {
        int expected = 800;
        game.activateForce("WB5");
        game.recallForce("WB5");
        game.recallForce("IW1");
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkForceRecallDoesNotUpdateWarchestForNonExistantForce() {
        int expected = 800;
        game.activateForce("WB5");
        game.recallForce("WB5");
        game.recallForce("XX3");
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
}

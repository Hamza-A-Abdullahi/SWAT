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
public class ForceGeneralTest {
    SWAT game;
    
    public ForceGeneralTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new SpaceWars("David");
    }
    
    @After
    public void tearDown() {
    }

    private boolean containsText(String text, List<String> str) {
        boolean result = true;
        for (String s : str) {
            result = result && text.toLowerCase().contains(s.toLowerCase());
        }
        return result;
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void checkDetailsOfWB3() {
        String str = game.getForce("WB3");
        boolean result = containsText(str, new ArrayList<>(Arrays.asList(
                "WB3","Droop","100","300","In dock","false")));
        assertTrue(result);
    }
    
    @Test
    public void checkDetailsOfSS2() {
        String str = game.getForce("SS2");
        boolean result = containsText(str, new ArrayList<>(Arrays.asList(
                "SS2","Enterprise","200","300","In dock","20","10")));
        assertTrue(result);
    }
    
    @Test
    public void checkDetailsOfIW1() {
        String str = game.getForce("IW1");
        boolean result = containsText(str, new ArrayList<>(Arrays.asList(
                "IW1","Dragons","200","200","In dock","10")));
        assertTrue(result);
    }
    
    @Test
    public void checkDetailsOfXX3() {
        String str = game.getForce("XX3");        
        boolean result = containsText(str, new ArrayList<>(Arrays.asList(
                "No such force")));
        assertTrue(result);
    }
    
    @Test
    public void checkFightingFleetEmptyAtTheBeginning() {
        boolean result = true;
        List<String> forces = new ArrayList<>(Arrays.asList("IW1","WB3","SS2",
                "IW4","WB5","SS6","SS7","WB9","IW10"));
        for (String force : forces) {
            result &= !game.isInFightingFleet(force);
        }
        assertTrue(result);
    }
    
    @Test
    public void checkFightForceActivationWorks() {
        String forceRef = "IW1";
        game.activateForce(forceRef);
        boolean actual = game.isInFightingFleet(forceRef);
        assertTrue(actual);
    }
    
    @Test
    public void checkWarchestWhenNoFight() {
        int expected = 1000;
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkWarchestAfterForceActivated() {
        int expected = 800;
        game.activateForce("IW1");
        int actual = game.getWarchest();
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkForceIsNotInAsfAfterActivated() {
        String forceRef = "IW1";
        game.activateForce(forceRef);
        String result = game.findForceInASF(forceRef);
        assertTrue(result.toLowerCase().contains("no"));
    }
    
    @Test
    public void showStatusActiveForActivatedForce() {
        String expected = "active";
        game.activateForce("IW1");
        String actual = game.getForce("IW1");
        boolean result = actual.toLowerCase().contains(expected);
        assertTrue(result);
    }
}

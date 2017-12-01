/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OODCwk;

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
public class DisplayFightsForcesTest {
    SWAT swat;
    
    public DisplayFightsForcesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        swat = new SpaceWars("Bob");
    }
    
    @After
    public void tearDown() {
    }

    private boolean containsText(String text, String s1, String s2, String s3) {
        boolean result = false;
        result = text.contains(s1) && text.contains(s2) && text.contains(s3);
        return result;
    }
    
    @Test
    public void fightNo1Displayed() {
        String result = swat.getAllFights();
        boolean actual = containsText(result, "1", "Battle", "Borg");
        assertTrue(actual);
    }
    
    @Test
    public void fightNo2Displayed() {
        String result = swat.getAllFights();
        boolean actual = containsText(result, "2", "Skirmish", "Kardassians");
        assertTrue(actual);
    }
    
    @Test
    public void fightNo3Displayed() {
        String result = swat.getAllFights();
        boolean actual = containsText(result, "3", "Ambush", "Ferengi");
        assertTrue(actual);
    }
    
    @Test
    public void fightNo4Displayed() {
        String result = swat.getAllFights();
        boolean actual = containsText(result, "4", "Battle", "Ewoks");
        assertTrue(actual);
    }
    
    @Test
    public void fightNo5Displayed() {
        String result = swat.getAllFights();
        boolean actual = containsText(result, "5", "Ambush", "Borg");
        assertTrue(actual);
    }
    
    @Test
    public void fightNo6Displayed() {
        String result = swat.getAllFights();
        boolean actual = containsText(result, "6", "Skirmish", "Groaners");
        assertTrue(actual);
    }
    
    @Test
    public void forceFleetIW1Displayed() {
        String result = swat.getASFleet();
        boolean actual = containsText(result, "IW1", "Dragons", "");
        assertTrue(actual);
    }
    
    @Test
    public void forceFleetSS2Displayed() {
        String result = swat.getASFleet();
        boolean actual = containsText(result, "SS2", "Enterprise", "");
        assertTrue(actual);
    }
    
    
    @Test
    public void forceFleetWB3Displayed() {
        String result = swat.getASFleet();
        boolean actual = containsText(result, "WB3", "Droop", "");
        assertTrue(actual);
    }
    
    
    @Test
    public void forceFleetIW4Displayed() {
        String result = swat.getASFleet();
        boolean actual = containsText(result, "IW4", "Wingers", "");
        assertTrue(actual);
    }
    
    @Test
    public void forceFleetWB5Displayed() {
        String result = swat.getASFleet();
        boolean actual = containsText(result, "WB5", "Hang", "");
        assertTrue(actual);
    }
    
    @Test
    public void forceFleetSS6Displayed() {
        String result = swat.getASFleet();
        boolean actual = containsText(result, "SS6", "Voyager", "");
        assertTrue(actual);
    }
    
    @Test
    public void forceFleetSS7Displayed() {
        String result = swat.getASFleet();
        boolean actual = containsText(result, "SS7", "Explorer", "");
        assertTrue(actual);
    }
    
    @Test
    public void forceFleetWB9Displayed() {
        String result = swat.getASFleet();
        boolean actual = containsText(result, "WB9", "Hover", "");
        assertTrue(actual);
    }
    
    @Test
    public void forceFleetIW10Displayed() {
        String result = swat.getASFleet();
        boolean actual = containsText(result, "IW10", "Flyers", "");
        assertTrue(actual);
    }
    
    @Test
    public void gameCorrectlyInitialised() {
        String result = swat.toString();
        boolean actual = containsText(result, "Bob", "1000", "");
        assertTrue(actual);
    }
}

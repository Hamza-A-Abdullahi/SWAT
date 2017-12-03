package OODCwk;
import java.io.*;
/**
 * Enumeration class FightType
 * This class has the purpose of determining the result of a fight.
 * 
 */

public enum FightResult implements Serializable
{

    /**
     * Fight won by the force – add fight gains to the resources
     */
    WON("Fight won by the force – add fight gains to the resources"), 

    /**
     * Fight lost as no suitable force available” – deduct the fight losses from resources
     */
    FORCE_LOST("Fight lost as no suitable force available” – deduct the fight losses from resources "),

    /**
     * Fight lost by force on battle strength ” - deduct fight losses from resources, decommission force
     */
    STRENGTH_LOST("Fight lost by force on battle strength ” - deduct fight losses from resources, decommission force"),

    /**
     * Fight not begun
     */
    NONE("Fight not begun");
    
    private String state;
    
    private FightResult(String st)
    {
        state = st;
    }
    
    public String toString()
    {
        return state;
    }
}

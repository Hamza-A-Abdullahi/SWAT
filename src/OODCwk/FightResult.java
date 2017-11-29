package OODCwk;
import java.io.*;
/**
 * Enumeration class FightType
 * 
 * 
 */
public enum FightResult implements Serializable
{
    WON("Fight won by the force – add fight gains to the resources"), 
    FORCE_LOST("Fight lost as no suitable force available” – deduct the fight losses from resources "),
    STRENGTH_LOST("Fight lost by force on battle strength ” - deduct fight losses from resources, decommission force"),
    NONE("Fight not begun.");
    
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

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
public class Wing extends ASF_Force {
    int strikers;
    
    public Wing(String fullname, String reference, int no_strikers) {
        super(fullname, reference, 200, no_strikers*20);

        this.strikers = no_strikers;
   
        


    }
   
    public String toString() {
        
        return super.toString() + " Number of Strikers: " + this.strikers + "\n";
    }
}

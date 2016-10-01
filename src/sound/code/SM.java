package sound.code;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.Thread.State;
import java.util.ArrayList;

/**
 *
 * @author Oliver
 */
public abstract class SM {
    
    private ArrayList<State> states;
    
    
    public SM(){
        states = new ArrayList<State>();
        initAllStates();
    }
    
    public abstract void initAllStates();

   
}
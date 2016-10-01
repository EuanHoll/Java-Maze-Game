package Core.code;

import java.awt.*;
import javax.swing.*;


public class PlayerClass2 {
    
	public int tileX;
	public int tileY;
	private Image player;
	
	public PlayerClass2(){
    	
		ImageIcon img = new ImageIcon(getClass().getResource("/Textures/heads/head2.png"));
		player = img.getImage();
		
		
	
    
    	tileX = 1;
    	tileY = 1;
    }
	
	public Image getPlayer(){
		return player;
		
	}
	
	public int gettileX(){
		return tileX;
	}
	public int gettileY(){
		return tileY;
	}
	
	public void Move( int tx, int ty){
		
		
		
		tileX += tx;
		tileY += ty;
		
	}
    
    
}

package Maps;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import Core.code.PlayerClass;


public class Map6 {

	private Scanner map;
	private String Tiles[] = new String[29];
    public Image  back,
                  finish,
                  cherry,
                  mud,
                  nails,
                  trap1,
                  trap2;
    
    
    
    public Map6(){
    	//images
    	
    ImageIcon img = new ImageIcon(getClass().getResource("/Textures/map1.png"));
    back = img.getImage();
    img = new ImageIcon(getClass().getResource("/Textures/mud.png"));
    mud = img.getImage();
    img = new ImageIcon(getClass().getResource("/Textures/flag.png"));
    finish = img.getImage();
    img = new ImageIcon(getClass().getResource("/Textures/cherry.png"));
    cherry = img.getImage();
    img = new ImageIcon(getClass().getResource("/Textures/nails.png"));
    nails = img.getImage();
    img = new ImageIcon(getClass().getResource("/Textures/trap1.png"));
    trap1 = img.getImage();
    img = new ImageIcon(getClass().getResource("/Textures/trap2.png"));
    trap2 = img.getImage();
    
    
         // files
		openFile();
		readFile();
		closeFile();

	}

    public Image getBack(){
    	return back;
    }
    
    public Image getMud(){
    	return mud;
    }
    
    public Image getFinish(){
    	return finish;
    }
    public Image getCherry(){
    	return cherry;
    }
    public Image getNails(){
    	return nails;
    }
    public Image getTrap1(){
    	return trap1;
    }
    public Image getTrap2(){
    	return trap2;
    }
    	
  
    
    	
    
    
    public String getMap(int x, int y){
	String index = Tiles[y].substring(x, x + 1);
	return index;
}

public void openFile() {
	try{
	map = new Scanner(getClass().getClassLoader().getResourceAsStream("Text/6.txt"));
	}catch(Exception e){
	   System.out.print("Error Loading Map");
	}
	}

public void readFile() {
	while(map.hasNext()){
		for(int i = 0; i < 29; i++){
			Tiles[i] = map.next();
		}
	}
}

public void closeFile() {
	map.close();
	
	
}

}
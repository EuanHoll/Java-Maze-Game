package Core.code;

import graphics.levelselect;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class saving {
	
	
	
	
	
	public saving(){
		
		
		
		
	}
	
	public void save(){
		String fileName = "save.dat";
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void Load(){
		
	}
	

}

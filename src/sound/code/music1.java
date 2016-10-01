package sound.code;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class music1 {
private static music1 staticSound = new music1();
	
	public String name;
	public AudioClip music;
	
	private music1(){}
	
	public music1(String name, URL url){
		
		this.name = name;
		try{
			music = Applet.newAudioClip(url);
		}catch(Exception e){
			System.out.print("No Music");
		}
		
	}
	
	
	public void play(){
		new Thread(new Runnable(){
			@Override
			public void run(){
				if(music != null)
				music.play();
				
			}
			
		}).start();
		
		
	}
	public void loop(){
		new Thread(new Runnable(){
			@Override
			public void run(){
				if(music != null)
				music.loop();
				
			}
			
		}).start();
		
		
	}
	
	public void stop(){
		if(music != null)
			music.stop();
			
		
	}
	
	public static URL getURL(String fileName){
		return staticSound.getClass().getResource("/music/" + fileName);
		
	}

	
	
	
}

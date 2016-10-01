package sound.code;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class sound {

	private static sound staticSound = new sound();
	
	public String name;
	public AudioClip cherry;
	
	private sound(){}
	
	public sound(String name, URL url){
		
		this.name = name;
		try{
			cherry = Applet.newAudioClip(url);
		}catch(Exception e){
			System.out.print("No Cherry Sound");
		}
		
	}
	
	
	public void play(){
		new Thread(new Runnable(){
			@Override
			public void run(){
				if(cherry != null)
				cherry.play();
				
			}
			
		}).start();
		
		
	}
	public void loop(){
		new Thread(new Runnable(){
			@Override
			public void run(){
				if(cherry != null)
				cherry.loop();
				
			}
			
		}).start();
		
		
	}
	
	public void stop(){
		if(cherry != null)
			cherry.stop();
			
		
	}
	
	public static URL getURL(String fileName){
		return staticSound.getClass().getResource("/sound/" + fileName);
		
	}
	
	
}

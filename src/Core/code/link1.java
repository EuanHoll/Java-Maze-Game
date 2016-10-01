package Core.code;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class link1 {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException{
		
		try{
			String url = "http://www.youtube.com/channel/UC9EzN5XNxhxqHZevM9kSuaw";
			String cmd = "cmd.exe /c start " + url;
			
			Runtime.getRuntime().exec(cmd);
			
		}catch (Exception ex){
			Desktop.getDesktop().browse(new URL("http://www.youtube.com/channel/UC9EzN5XNxhxqHZevM9kSuaw").toURI());
			
		}
		
	}
	
	
	
	
	
	
}

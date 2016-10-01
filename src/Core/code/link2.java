package Core.code;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class link2 {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException{
		
		try{
			String url = "https://www.facebook.com/euan.hollidgw";
			String cmd = "cmd.exe /c start " + url;
			
			Runtime.getRuntime().exec(cmd);
			
		}catch (Exception ex){
			Desktop.getDesktop().browse(new URL("https://www.facebook.com/euan.hollidgw").toURI());
			
		}
		
	}
	
	
	
	
	
	
}
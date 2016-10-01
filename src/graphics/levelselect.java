package graphics;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import javax.swing.*;

import sound.code.music1;
import sound.code.musicmanager;



	public class levelselect extends JFrame implements Runnable, Serializable{
		
		musicmanager h = new musicmanager() {
			@Override
			public void initMusic() {
				music.add(new music1("tomorrow", music1.getURL("Tomorrow.wav")));
			}
		};
		
		public boolean i = false;
		public boolean j = false;
		public boolean k = false;
		public boolean l = false;
		public boolean n = false;
		public boolean m = false;
		public boolean b = false;
		public boolean playing = true;
		
		public boolean cow = false;
		
		public boolean duck = false;
		
		//Double buffering
	    Image dbImage;
	    Graphics dbg;
	    
	    
	    //Menu Buttons
	    Rectangle Level1 = new Rectangle(95, 100, 100, 25);
	    Rectangle Level2 = new Rectangle(95, 150, 100, 25);
	    Rectangle Level3 = new Rectangle(95, 200, 100, 25);
	    Rectangle Level4 = new Rectangle(95, 250, 100, 25);
	    Rectangle Level5 = new Rectangle(95, 300, 100, 25);
	    Rectangle Level6 = new Rectangle(205, 100, 100, 25);
	    Rectangle Level7 = new Rectangle(205, 150, 100, 25);
	    Rectangle Level8 = new Rectangle(205, 200, 100, 25);
	    Rectangle Level9 = new Rectangle(205, 250, 100, 25);
	    Rectangle Level10 = new Rectangle(205, 300, 100, 25);
	    
	   // Rectangle save = new Rectangle(150, 250, 100, 25);
	    Rectangle quitButton = new Rectangle(150, 350, 100, 25);
	    //Variables for screen size
	    int
	    GWIDTH = 700,
	    GHEIGHT = 500;
	    //Dimension of GWIDTH*GHEIGHT
	    Dimension screenSize = new Dimension(GWIDTH, GHEIGHT);
	    
	    //Create constructor to spawn window
	    public levelselect(){
	    	
	    	this.setTitle("Maze Game Alpha");
	        this.setSize(screenSize);
	        this.setResizable(false);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setVisible(true);
	        this.setBackground(Color.DARK_GRAY);
            this.addMouseListener(new MouseHandler());
 	        this.addMouseMotionListener(new MouseHandler());
 	        h.loopSong("tomorrow");
 	        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Textures/heads/head1.png")));	
 	        
	    }	
	    
	    
		public static void main(String[] args){
	        levelselect m = new levelselect();
	        
			
			
	    }
	    
	    @Override
	    public void paint(Graphics g){
	        dbImage = createImage(getWidth(), getHeight());
	        dbg = dbImage.getGraphics();
	        draw(dbg);
	        g.drawImage(dbImage, 0, 0, this);
	        
	    }
	    public void draw(Graphics g){
	        //Menu
	        g.setFont(new Font("Arial", Font.BOLD, 26));
	        g.setColor(Color.WHITE);
	        g.drawString("Level Select", 125, 75);
	        g.setColor(Color.CYAN);
	        g.fillRect(Level1.x, Level1.y, Level1.width, Level1.height);
	        g.setFont(new Font("Arial", Font.BOLD, 12));
	        g.setColor(Color.GRAY);
	        g.drawString("Level 1", Level1.x+20, Level1.y+17);
	        
	        if(duck){
	        g.setColor(Color.CYAN);
	        g.fillRect(Level2.x, Level2.y, Level2.width, Level2.height);
	        g.setColor(Color.GRAY);
	        g.drawString("Level 2", Level2.x+20, Level2.y+17);
	        }
	        g.setColor(Color.CYAN);
	        g.fillRect(quitButton.x, quitButton.y, quitButton.width, quitButton.height);
	        g.setColor(Color.GRAY);
	        g.drawString("Quit Game", quitButton.x+20, quitButton.y+17);
	        

	        if(cow){
                duck = true;
	        	
		        g.setColor(Color.CYAN);
		        g.fillRect(Level3.x, Level3.y, Level3.width, Level3.height);
		        g.setColor(Color.GRAY);
		        g.drawString("Level 3", Level3.x+20, Level3.y+17);
	        	
	        }
	        
	        if(i){
                cow = true;
	        	
		        g.setColor(Color.CYAN);
		        g.fillRect(Level4.x, Level4.y, Level4.width, Level4.height);
		        g.setColor(Color.GRAY);
		        g.drawString("Level 4", Level4.x+20, Level4.y+17);
	        	
	        }
	        if(j){
                i = true;
	        	
		        g.setColor(Color.CYAN);
		        g.fillRect(Level5.x, Level5.y, Level5.width, Level5.height);
		        g.setColor(Color.GRAY);
		        g.drawString("Level 5", Level5.x+20, Level5.y+17);
	        	
	        }
	        if(k){
                j = true;
	        	
		        g.setColor(Color.CYAN);
		        g.fillRect(Level6.x, Level6.y, Level6.width, Level6.height);
		        g.setColor(Color.GRAY);
		        g.drawString("Level 6", Level6.x+20, Level6.y+17);
	        	
	        }
	        if(l){
                k = true;
	        	
		        g.setColor(Color.CYAN);
		        g.fillRect(Level7.x, Level7.y, Level7.width, Level7.height);
		        g.setColor(Color.GRAY);
		        g.drawString("Level 7", Level7.x+20, Level7.y+17);
	        	
	        }
	        if(n){
                l = true;
	        	
		        g.setColor(Color.CYAN);
		        g.fillRect(Level8.x, Level8.y, Level8.width, Level8.height);
		        g.setColor(Color.GRAY);
		        g.drawString("Level 8", Level8.x+20, Level8.y+17);
	        	
	        }
	        if(m){
                n = true;
	        	
		        g.setColor(Color.CYAN);
		        g.fillRect(Level9.x, Level9.y, Level9.width, Level9.height);
		        g.setColor(Color.GRAY);
		        g.drawString("Level 9", Level9.x+20, Level9.y+17);
	        	
	        }
	        if(b){
                m = true;
	        	
		        g.setColor(Color.CYAN);
		        g.fillRect(Level10.x, Level10.y, Level10.width, Level10.height);
		        g.setColor(Color.GRAY);
		        g.drawString("Level 10", Level10.x+20, Level10.y+17);
	        	
	        }
	        repaint();
	    }
		
		public class MouseHandler extends MouseAdapter {
		@Override
	    public void mouseMoved(MouseEvent e){
	        
	    }
	    @Override
	    public void mousePressed(MouseEvent e){
	        int mx = e.getX();
	        int my = e.getY();
	        if(mx > Level1.x && mx < Level1.x+Level1.width && mx > Level1.x && my < Level1.y+Level1.height && my > Level1.y){
	        	Frames f = new Frames();
				f.setVisible(false);
				setVisible(false);
	            h.stopallsongs();
	        }
	        if(duck){
	        if(mx > Level2.x && mx < Level2.x+Level2.width && mx > Level2.x && my < Level2.y+Level2.height && my > Level2.y){
	        	Frames2 f = new Frames2();
				f.setVisible(false);
				setVisible(false);
				h.stopallsongs();
	        }
	        }
	        if(cow){
		        if(mx > Level3.x && mx < Level3.x+Level3.width && mx > Level3.x && my < Level3.y+Level3.height && my > Level3.y){
		        	Frames3 f = new Frames3();
					f.setVisible(false);
					setVisible(false);
					h.stopallsongs();
		        }
		        }
	        if(i){
		        if(mx > Level4.x && mx < Level4.x+Level4.width && mx > Level4.x && my < Level4.y+Level4.height && my > Level4.y){
		        	Frames4 f = new Frames4();
					f.setVisible(false);
					setVisible(false);
					h.stopallsongs();
		        }
		        }if(j){
			        if(mx > Level5.x && mx < Level5.x+Level5.width && mx > Level5.x && my < Level5.y+Level5.height && my > Level5.y){
			        	Frames5 f = new Frames5();
						f.setVisible(false);
						setVisible(false);
						h.stopallsongs();
			        }
			        }if(k){
				        if(mx > Level6.x && mx < Level6.x+Level6.width && mx > Level6.x && my < Level6.y+Level6.height && my > Level6.y){
				        	Frames6 f = new Frames6();
							f.setVisible(false);
							setVisible(false);
							h.stopallsongs();
				        }
				        }if(l){
					        if(mx > Level7.x && mx < Level7.x+Level7.width && mx > Level7.x && my < Level7.y+Level7.height && my > Level7.y){
					        	Frames7 f = new Frames7();
								f.setVisible(false);
								setVisible(false);
								h.stopallsongs();
					        }
					        }if(n){
						        if(mx > Level8.x && mx < Level8.x+Level8.width && mx > Level8.x && my < Level8.y+Level8.height && my > Level8.y){
						        	Frames8 f = new Frames8();
									f.setVisible(false);
									setVisible(false);
									h.stopallsongs();
						        }
						        }if(m){
							        if(mx > Level9.x && mx < Level9.x+Level9.width && mx > Level9.x && my < Level9.y+Level9.height && my > Level9.y){
							        	Frames9 f = new Frames9();
										f.setVisible(false);
										setVisible(false);
										h.stopallsongs();
							        }
							        }if(b){
								        if(mx > Level10.x && mx < Level10.x+Level10.width && mx > Level10.x && my < Level10.y+Level10.height && my > Level10.y){
								        	Frames10 f = new Frames10();
											f.setVisible(false);
											setVisible(false);
											h.stopallsongs();
								        }
								        }

	       if(mx > quitButton.x && mx < quitButton.x+quitButton.width && mx > quitButton.x && my < quitButton.y+quitButton.height && my > quitButton.y){
	        	
	        	System.exit(0);
	        }
	    }
	  }

		
		
		
		
		@Override
		public void run() {
			
		}
		
		
	}
package graphics;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import sound.code.music1;
import sound.code.musicmanager;


	public class menubar extends JFrame implements Runnable{
		
		

		//booleans
		
		
		
	    //Double buffering
	    Image dbImage;
	    Graphics dbg;
	    
	    
	    //Menu Buttons
	    Rectangle startButton = new Rectangle(150, 100, 100, 25);
	    Rectangle quitButton = new Rectangle(150, 150, 100, 25);
	    //Variables for screen size
	    int
	    GWIDTH = 400,
	    GHEIGHT = 300;
	    //Dimension of GWIDTH*GHEIGHT
	    Dimension screenSize = new Dimension(GWIDTH, GHEIGHT);
	    
	    //Create constructor to spawn window
	    public menubar(){
	    	this.setTitle("Maze Game Alpha");
	        this.setSize(screenSize);
	        this.setResizable(false);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setVisible(true);
	        this.setBackground(Color.DARK_GRAY);
	        this.addKeyListener(new KeyHandler());
	        this.addMouseListener(new MouseHandler());
	        this.addMouseMotionListener(new MouseHandler());
	        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Textures/heads/head1.png")));
	    }
	    
	    
	    public static void main(String[] args){
	        menubar m = new menubar();
	    }
	    
	    @Override
	    public void paint(Graphics v){
	    	dbImage = createImage(getWidth(), getHeight());
	        dbg = dbImage.getGraphics();
	        draw(dbg);
	        v.drawImage(dbImage, 0, 0, this);
	    }
	    public void draw(Graphics v){
	        //Menu
	        v.setFont(new Font("Arial", Font.BOLD, 26));
	        v.setColor(Color.WHITE);
	        v.drawString("Maze Game Alpha", 125, 75);
	        v.setColor(Color.CYAN);
	        v.fillRect(startButton.x, startButton.y, startButton.width, startButton.height);
	        v.setFont(new Font("Arial", Font.BOLD, 12));
	        v.setColor(Color.GRAY);
	        v.drawString("Start Game", startButton.x+20, startButton.y+17);
	        v.setColor(Color.CYAN);
	        v.fillRect(quitButton.x, quitButton.y, quitButton.width, quitButton.height);
	        v.setColor(Color.GRAY);
	        v.drawString("Quit Game", quitButton.x+20, quitButton.y+17);
	        
	        
	        repaint();
	    }
	    
	    ////////EVENT LISTENER CLASSES/////////
	    public class KeyHandler extends KeyAdapter {
	        @Override
	        public void keyPressed(KeyEvent e){
	           
	        }
	        @Override
	        public void keyReleased(KeyEvent e){
	            
	        }
	    }
	    public class MouseHandler extends MouseAdapter {
	        @Override
	        public void mouseMoved(MouseEvent e){
	            
	        }
	        @Override
	        public void mousePressed(MouseEvent e){
	            int mx = e.getX();
	            int my = e.getY();
	            if(mx > startButton.x && mx < startButton.x+startButton.width && mx > startButton.x && my < startButton.y+startButton.height && my > startButton.y){
	            	levelselect f = new levelselect();
	                setVisible(false);
	            
	            }
	            if(mx > quitButton.x && mx < quitButton.x+quitButton.width && mx > quitButton.x && my < quitButton.y+quitButton.height && my > quitButton.y){
                             System.exit(0);
	            }
	            
	        }
	    }
	    ///////END EVENT LISTENER CLASSES/////
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	    
	}
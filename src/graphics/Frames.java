package graphics;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import sound.code.SoundManager;
import sound.code.music1;
import sound.code.musicmanager;
import sound.code.sound;
import Core.code.PlayerClass;
import Core.code.PlayerClass2;
import Maps.Map1;



public class Frames extends JFrame{
	
	musicmanager h = new musicmanager() {
		@Override
		public void initMusic() {
			music.add(new music1("cnb", music1.getURL("CnB.wav")));
		}
	};
	
	JPanel panel = new JPanel();

	JFrame v = new JFrame();

	public boolean friends = false;

	public Frames() {
		v.setTitle("Maze Game Alpha 1.0");
		v.add(new panel());
		v.setSize(940, 570);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Textures/heads/head1.png")));
		h.loopSong("cnb");
		
	}

	public class panel extends JPanel implements ActionListener {

		// Double buffering
		Image dbImage;
		Graphics dbg;

		public boolean pointl = false;
		
		public boolean pointp = false;
		
		public boolean music = true;
		
		public boolean nails = false;

		public boolean trapstop = false;
		
		public boolean trap = false;
		
		public boolean lose = false;

		public boolean NES = false;

		public boolean player = false;

		public boolean dog = true;

		Rectangle levelselect = new Rectangle(150, 100, 200, 25);

		boolean mainmenu = true;

		public boolean win = false;

		private String Message = "";

		private String fab2 = "Health: ";

		private PlayerClass2 p2;

		private PlayerClass p;

		private String fab = "Score: ";

		private Timer timer;

		private Map1 map;

		public int score = 0;

		private int health = 0;

		private int health2 = 2;

		private boolean cherry1 = false;

		public panel() {

			
			this.setBackground(Color.ORANGE);
			
			map = new Map1();
			p = new PlayerClass();
			p2 = new PlayerClass2();
			addKeyListener(new Al());
			setFocusable(true);
			timer = new Timer(25, this);
			timer.start();
			addMouseListener(new MouseHandler());
			addMouseMotionListener(new MouseHandler());
			
			
		}

		public void actionPerformed(ActionEvent e) {
			
			
			SoundManager s = new SoundManager() {
				@Override
				public void initSounds() {
					sounds.add(new sound("cherry", sound.getURL("cherry.wav")));
				}
			};
			if (health2 == 0) {

				Message = "You have failed to beat the maze!";
				lose = true;

			}
			if (health == 0) {

				player = true;

			}
			
			if (map.getMap(p.gettileX(), p.gettileY()).equals("f")) {
				if (score == 3) {
					Message = "Congrats You Have Beaten The Maze";
					win = true;
				} else {
					NES = true;
				}

			}
			if (map.getMap(p.gettileX(), p.gettileY()).equals("c")) {
				if (!cherry1) {
					score++;
					s.playSound("cherry");
					s.stopSound("cherry");
				}
				cherry1 = true;
				repaint();
			}
			if (map.getMap(p.gettileX(), p.gettileY()).equals("p")) {
				if (!pointp) {
					score++;
					s.playSound("cherry");
					s.stopSound("cherry");
				}
				pointp = true;
				repaint();
			}
			if (map.getMap(p.gettileX(), p.gettileY()).equals("l")) {
				if (!pointl) {
					score++;
					s.playSound("cherry");
					s.stopSound("cherry");
				}
				pointl = true;
				repaint();
			}
			if (map.getMap(p.gettileX(), p.gettileY()).equals("t")) {
				if(!trapstop){
					trap = true;
				if (!player) {
					if (trap) {
						health = 0;
					}
				}
				if (player) {
					if (trap) {
						health2 = 0;
					}
				}
				trapstop = true;
				}
				repaint();

			}
			if (map.getMap(p.gettileX(), p.gettileY()).equals("n")) {
				if (!player) {
					if (!nails) {
						health--;
					}
				}
				if (player) {
					if (!nails) {
						health2--;
					}
				}
				nails = true;
				repaint();

			}

			repaint();

		}

		public void paint(Graphics g) {
			super.paint(g);

			if (!win) {
				for (int y = 0; y <14; y++) {
					for (int x = 0; x < 29; x++) {
						if (map.getMap(x, y).equals("b")) {
							g.drawImage(map.getBack(), x * 32, y * 32, null);
						}
						if (map.getMap(x, y).equals("m")) {
							g.drawImage(map.getMud(), x * 32, y * 32, null);
						}
						if (map.getMap(x, y).equals("f")) {
							g.drawImage(map.getFinish(), x * 32, y * 32, null);
						}
						if(!trapstop){
						if(!trap){
						if (map.getMap(x, y).equals("t")) {
							g.drawImage(map.getTrap1(), x * 32, y * 32, null);
						}
						}
						if(trap){
							if (map.getMap(x, y).equals("t")) {
								g.drawImage(map.getTrap2(), x * 32, y * 32, null);
							}
						}
						}
						if(trapstop){
							if (map.getMap(x, y).equals("t")) {
								g.drawImage(map.getTrap2(), x * 32, y * 32, null);
							}
						}
						if (NES) {
							String NES = "You Do Not Have Enough Points To Complete This Map!";
							Font font = new Font("Serif", Font.BOLD, 20);
							g.setFont(font);
							g.setColor(Color.BLACK);
							g.drawString(NES, 300 + 1, 510 - 1);
							g.setColor(new Color(0, 255, 0));
							g.drawString(NES, 300, 510);


						}
						if (!cherry1) {

							if (map.getMap(x, y).equals("c")) {
								g.drawImage(map.getCherry(), x * 32, y * 32,
										null);
							}
						}

						if (cherry1) {

							if (map.getMap(x, y).equals("c")) {
								g.drawImage(map.getBack(), x * 32, y * 32, null);
							}
						}
						if (!pointp) {

							if (map.getMap(x, y).equals("p")) {
								g.drawImage(map.getCherry(), x * 32, y * 32,
										null);
							}
						}

						if (pointp) {

							if (map.getMap(x, y).equals("p")) {
								g.drawImage(map.getBack(), x * 32, y * 32, null);
							}
						}
						if (!pointl) {

							if (map.getMap(x, y).equals("l")) {
								g.drawImage(map.getCherry(), x * 32, y * 32,
										null);
							}
						}

						if (pointl) {

							if (map.getMap(x, y).equals("l")) {
								g.drawImage(map.getBack(), x * 32, y * 32, null);
							}
						}
						if (!nails) {

							if (map.getMap(x, y).equals("n")) {
								g.drawImage(map.getNails(), x * 32, y * 32,
										null);
							}
						}

						if (nails) {

							if (map.getMap(x, y).equals("n")) {
								g.drawImage(map.getBack(), x * 32, y * 32, null);
							}
						}
					}
				}
				if (!player) {
					g.drawImage(p.getPlayer(), p.gettileX() * 32,
							p.gettileY() * 32, null);
				}
				if (player) {

					g.drawImage(p2.getPlayer(), p2.gettileX() * 32,
							p2.gettileY() * 32, null);

				}

				String s = fab + Integer.toString(score);
				Font font = new Font("Serif", Font.BOLD, 32);
				g.setFont(font);
				g.setColor(Color.BLACK);
				g.drawString(s, 20 + 1, 20 - 1);
				g.setColor(new Color(0, 255, 0));
				g.drawString(s, 20, 20);

				String f = null;
				if (!player) {
					f = fab2 + Integer.toString(health);
				}
				if (player) {
					f = fab2 + Integer.toString(health2);
				}

				Font font1 = new Font("Serif", Font.BOLD, 32);
				g.setFont(font1);
				g.setColor(Color.BLACK);
				g.drawString(f, 180 + 1, 20 - 1);
				g.setColor(new Color(0, 255, 0));
				g.drawString(f, 180, 20);

			}
			Font cat = new Font("Serif", Font.BOLD, 32);
			g.setFont(cat);
			g.setColor(Color.BLACK);

			if (!lose) {

				if (win) {

					g.setColor(Color.BLUE);
					g.setFont(cat);
					g.drawString(Message, 32, 32);
					dbImage = createImage(getWidth(), getHeight());
					dbg = dbImage.getGraphics();
					draw(dbg);
					g.drawImage(dbImage, 0, 0, this);
					

				}
			}
			if (lose) {

				g.setColor(Color.BLUE);
				g.setFont(cat);
				g.drawString(Message, 32, 32);
				dbImage = createImage(getWidth(), getHeight());
				dbg = dbImage.getGraphics();
				draw(dbg);
				g.drawImage(dbImage, 0, 0, this);

			}

		}

		private void draw(Graphics g) {

			setBackground(Color.BLACK);
			g.drawString(Message, 32, 32);
			g.fillRect(levelselect.x, levelselect.y, levelselect.width,
					levelselect.height);
			g.setFont(new Font("Arial", Font.BOLD, 12));
			g.setColor(Color.GREEN);
			g.drawString("Back to Level Select", levelselect.x + 20,
					levelselect.y + 17);
			g.setColor(Color.CYAN);

		}

		public class Al extends KeyAdapter {

			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();

				if (keycode == KeyEvent.VK_W) {
					if (!map.getMap(p.gettileX(), p.gettileY() - 1).equals("m")) {
						p.Move(0, -1);
					}
				}
				if (keycode == KeyEvent.VK_A) {
					if (!map.getMap(p.gettileX() - 1, p.gettileY()).equals("m")) {
						p.Move(-1, 0);
					}
				}
				if (keycode == KeyEvent.VK_S) {
					if (!map.getMap(p.gettileX(), p.gettileY() + 1).equals("m")) {
						p.Move(0, 1);
					}
				}
				if (keycode == KeyEvent.VK_D) {
					if (!map.getMap(p.gettileX() + 1, p.gettileY()).equals("m")) {
						p.Move(1, 0);
					}
				}
				if (keycode == KeyEvent.VK_UP) {
					if (!map.getMap(p.gettileX(), p.gettileY() - 1).equals("m")) {
						p.Move(0, -1);
					}
				}
				if (keycode == KeyEvent.VK_LEFT) {
					if (!map.getMap(p.gettileX() - 1, p.gettileY()).equals("m")) {
						p.Move(-1, 0);
					}
				}
				if (keycode == KeyEvent.VK_DOWN) {
					if (!map.getMap(p.gettileX(), p.gettileY() + 1).equals("m")) {
						p.Move(0, 1);
					}
				}
				if (keycode == KeyEvent.VK_RIGHT) {
					if (!map.getMap(p.gettileX() + 1, p.gettileY()).equals("m")) {
						p.Move(1, 0);
					}
				}
				if (keycode == KeyEvent.VK_P) {
					player = true;
				}
				if (keycode == KeyEvent.VK_O) {
					player = false;
				}
				if (keycode == KeyEvent.VK_W) {
					if (!map.getMap(p2.gettileX(), p2.gettileY() - 1).equals(
							"m")) {
						p2.Move(0, -1);
					}
				}
				if (keycode == KeyEvent.VK_A) {
					if (!map.getMap(p.gettileX() - 1, p.gettileY()).equals("m")) {
						p2.Move(-1, 0);
					}
				}
				if (keycode == KeyEvent.VK_S) {
					if (!map.getMap(p2.gettileX(), p2.gettileY() + 1).equals(
							"m")) {
						p2.Move(0, 1);
					}
				}
				if (keycode == KeyEvent.VK_D) {
					if (!map.getMap(p2.gettileX() + 1, p2.gettileY()).equals(
							"m")) {
						p2.Move(1, 0);
					}
				}
				if (keycode == KeyEvent.VK_UP) {
					if (!map.getMap(p2.gettileX(), p2.gettileY() - 1).equals(
							"m")) {
						p2.Move(0, -1);
					}
				}
				if (keycode == KeyEvent.VK_LEFT) {
					if (!map.getMap(p2.gettileX() - 1, p2.gettileY()).equals(
							"m")) {
						p2.Move(-1, 0);
					}
				}
				if (keycode == KeyEvent.VK_DOWN) {
					if (!map.getMap(p2.gettileX(), p2.gettileY() + 1).equals(
							"m")) {
						p2.Move(0, 1);
					}
				}
				if (keycode == KeyEvent.VK_RIGHT) {
					if (!map.getMap(p2.gettileX() + 1, p2.gettileY()).equals(
							"m")) {
						p2.Move(1, 0);
					}
				}
			}

			public void keyRelased(KeyEvent e) {

			}

			public void keyTyped(KeyEvent e) {

			}

		}

		public class MouseHandler extends MouseAdapter {
			@Override
			public void mouseMoved(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				int mx = e.getX();
				int my = e.getY();
				if (mx > levelselect.x
						&& mx < levelselect.x + levelselect.width
						&& mx > levelselect.x
						&& my < levelselect.y + levelselect.height
						&& my > levelselect.y) {
					levelselect f = new levelselect();
					if (!lose) {
						f.duck = true;
                         
					}
					v.dispose();
					h.stopSong("cnb");
					// saving s = new saving();
					// s.savelv1();
				}
			}

		}
	}

}
      
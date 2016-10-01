package graphics;

import graphics.Frames.panel.MouseHandler;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sound.code.music1;
import sound.code.musicmanager;

public class credits extends JFrame {

	musicmanager h = new musicmanager() {
		@Override
		public void initMusic() {
			music.add(new music1("cnb", music1.getURL("02_305.wav")));
		}
	};

	JPanel panel = new JPanel();

	JFrame v = new JFrame();

	public boolean friends = false;

	public credits() {
		v.setTitle("Maze Game Alpha 1.0");
		v.setSize(940, 570);
		v.setResizable(false);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.add(new panel());
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/Textures/heads/head1.png")));
		h.loopSong("cnb");
	}

	public static void main(String[] args) {
		credits m = new credits();

	}

	public class panel extends JPanel implements ActionListener {

		Rectangle levelselect = new Rectangle(350, 290, 200, 25);

		Image dbImage;
		Graphics dbg;

		public boolean end = true;

		public String fab = "You Have Finished The Maze.";
		public String fab1 = "Now Lean back and listen to some nice music.";
		public String fab2 = "And remeber to read the credits to get the name of";
		public String fab3 = "the artist and musicians involed!";
		public String fab4 = "Coder : Euan Hollidge";
		public String fab5 = "Music : Approaching Nirvana";
		public String fab6 = "Artist : Liam Dunne";
		public String fab7 = "Map Creator : Euan Hollidge";
		public String fab8 = "Story Line : Conner O'Keeffe";

		public panel() {

			addMouseListener(new MouseHandler());
			addMouseMotionListener(new MouseHandler());

		}

		@Override
		public void actionPerformed(ActionEvent e) {

		}

		public void paint(Graphics g) {
			super.paint(g);

			if (end) {
				dbImage = createImage(getWidth(), getHeight());
				dbg = dbImage.getGraphics();
				draw(dbg);
				g.drawImage(dbImage, 0, 0, this);
				String s = fab;
				Font font = new Font("Serif", Font.BOLD, 32);
				g.setFont(font);
				g.setColor(Color.RED);
				g.drawString(s, 250, 100);
				String s1 = fab1;
				g.drawString(s1, 200, 150);
				String s2 = fab2;
				g.drawString(s2, 150, 200);
				String s3 = fab3;
				g.drawString(s3, 250, 250);

			}

		}

		private void draw(Graphics g) {

			if (end) {
				g.fillRect(levelselect.x, levelselect.y, levelselect.width,
						levelselect.height);
				g.setFont(new Font("Arial", Font.BOLD, 12));
				g.setColor(Color.RED);
				g.drawString("Next", levelselect.x + 20, levelselect.y + 17);
				g.setColor(Color.CYAN);
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
					credits1 g = new credits1();
					if (end) {
						g.end1 = true;
					}
					v.setVisible(false);
				}
			}

		}
	}
}

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

public class credits1 extends JFrame {

	musicmanager h = new musicmanager() {
		@Override
		public void initMusic() {
			music.add(new music1("cnb", music1.getURL("02_305.wav")));
		}
	};
	public boolean end = true;
	public boolean end1 = false;
	public boolean end2 = false;

	JPanel panel = new JPanel();

	JFrame f = new JFrame();

	public boolean friends = false;

	public credits1() {
		f.setTitle("Maze Game Alpha 1.0");
		f.setSize(940, 570);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.add(new panel());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/Textures/heads/head1.png")));
	}

	public static void main(String[] args) {
		credits m = new credits();

	}

	public class panel extends JPanel implements ActionListener {


		Image dbImage;
		Graphics dbg;

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

			
		}

		@Override
		public void actionPerformed(ActionEvent e) {

		}

		public void paint(Graphics g) {
			super.paint(g);

			if (end1) {
				dbImage = createImage(getWidth(), getHeight());
				dbg = dbImage.getGraphics();
				draw(dbg);
				g.drawImage(dbImage, 0, 0, this);
				String s = fab4;
				Font font = new Font("Serif", Font.BOLD, 32);
				g.setFont(font);
				g.setColor(Color.RED);
				g.drawString(s, 250, 100);
				String s1 = fab5;
				g.drawString(s1, 250, 150);
				String s2 = fab6;
				g.drawString(s2, 250, 200);
				String s3 = fab7;
				g.drawString(s3, 250, 250);
				String s4 = fab8;
				g.drawString(s4, 250, 300);

				Font Credit = new Font("Serif", Font.BOLD, 50);
				g.setFont(Credit);
				String s5 = "Credits";
				g.drawString(s5, 250, 50);
			}

		}

		private void draw(Graphics g) {

			
		}

		
		
	}

}

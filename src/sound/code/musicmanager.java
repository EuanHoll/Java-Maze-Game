package sound.code;

import java.util.ArrayList;

public abstract class musicmanager {

	public ArrayList<music1> music = new ArrayList<music1>();

	public musicmanager() {
		initMusic();

	}

	

	public abstract void initMusic();

	public void addSong(String m, music1 music1) {
		music.add(music1);
	}

	public void removeSong(music1 music1) {
		music.remove(music1);

	}

	public void playSong(String name) {
		for (music1  m : music) {
			if (m.name.equals(name)) {
				 m.play();

			}
		}
	}

	public void loopSong(String name) {
		for (music1 m : music) {
			if (m.name.equals(name)) {
				m.loop();
			}

		}

	}

	public void stopSong(String name) {
		for (music1 m : music) {
			if (m.name.equals(name)) {
				m.stop();
			}

		}

	}

	public void stopallsongs() {
		for (music1 m : music) {
			m.stop();
		}

	}

}

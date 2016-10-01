package sound.code;

import java.util.ArrayList;

public abstract class SoundManager {

	public ArrayList<sound> sounds = new ArrayList<sound>();

	public SoundManager() {
		initSounds();

	}

	public abstract void initSounds();

	public void addSound(String s, sound sound) {
		sounds.add(sound);
	}

	public void removeSound(sound sound) {
		sounds.remove(sound);

	}

	public void playSound(String name) {
		for (sound s : sounds) {
			if (s.name.equals(name)) {
				s.play();

			}
		}
	}

	public void loopSound(String name) {
		for (sound s : sounds) {
			if (s.name.equals(name)) {
				s.loop();
			}

		}

	}

	public void stopSound(String name) {
		for (sound s : sounds) {
			if (s.name.equals(name)) {
				s.stop();
			}

		}

	}

	public void stopallsounds() {
		for (sound s : sounds) {
			s.stop();
		}

	}

}

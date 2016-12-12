package logic;

import javafx.scene.media.AudioClip;

public class SoundManager {
	public static AudioClip bgm;
	static {
		bgm = new AudioClip(ClassLoader.getSystemResource("sound/bgm.wav").toString());
		bgm.setCycleCount(AudioClip.INDEFINITE);
	}

	public static void start() {
		bgm.play();
	}

	public static void stop() {
		bgm.stop();
	}

	public static void setVolume(double value) {
		bgm.setVolume(value / 100);
	}

	public static double getVolume() {
		return bgm.getVolume()*100;
	}
}
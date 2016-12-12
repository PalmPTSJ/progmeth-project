package logic;

import javafx.scene.media.AudioClip;

public class SoundManager {
	public static AudioClip bgm;
	public static AudioClip gunshot;
	static{
		bgm=new AudioClip(ClassLoader.getSystemResource("sound/bgm.wav").toString());
		bgm.setCycleCount(AudioClip.INDEFINITE);
		
		gunshot=new AudioClip(ClassLoader.getSystemResource("sound/gunshot.wav").toString());
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
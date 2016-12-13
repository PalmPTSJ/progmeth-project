package logic;

import javafx.scene.media.AudioClip;

public class SoundManager {
	private static AudioClip bgm;
	private static AudioClip gunshot;
	static{
		bgm=new AudioClip(ClassLoader.getSystemResource("sound/bgm.wav").toString());
		bgm.setCycleCount(AudioClip.INDEFINITE);
		
		gunshot=new AudioClip(ClassLoader.getSystemResource("sound/gunshot.wav").toString());
		
		setVolume(0.2);
	}

	public static void start() {
		bgm.play();
	}

	public static void stop() {
		bgm.stop();
	}

	public static void setVolume(double value) {
		bgm.setVolume(value);
		gunshot.setVolume(value);
	}

	public static double getVolume() {
		return bgm.getVolume();
	}

	public static AudioClip getBgm() {
		return bgm;
	}

	public static AudioClip getGunshot() {
		return gunshot;
	}
}
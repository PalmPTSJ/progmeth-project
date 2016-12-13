/*
 * Managing sounds
 */
package logic;

import javafx.scene.media.AudioClip;

public class SoundManager {
	private static AudioClip bgm;
	private static AudioClip gunshot;
	private static AudioClip getRes(String path){
		return new AudioClip(ClassLoader.getSystemResource(path).toString());
	}
	static{
		bgm=getRes("sound/bgm.wav");
		bgm.setCycleCount(AudioClip.INDEFINITE);
		
		gunshot=getRes("sound/gunshot.wav");
		
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
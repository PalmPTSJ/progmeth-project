package application;

import javafx.scene.media.AudioClip;

public class SoundManager {
	private static AudioClip bgm;
	static{
		// TODO Auto-generated constructor stub
		bgm=new AudioClip(ClassLoader.getSystemResource("sound/bgm.wav").toString());
		bgm.setCycleCount(AudioClip.INDEFINITE);
	}
	public static void start(){
		bgm.play();
	}
	public static void setVolume(double value){
//		bgm.stop();
//		bgm.setVolume(value);
//		bgm.play();
	}
}
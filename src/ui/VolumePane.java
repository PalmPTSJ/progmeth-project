package ui;

import javafx.geometry.Pos;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import logic.SoundManager;

public class VolumePane extends HBox {
	Slider sl;
	public VolumePane() {
		setAlignment(Pos.CENTER);
		
		ImageView iv=new ImageView(new Image(ClassLoader.getSystemResource("img/ui/volume.png").toString()));			
		sl=new Slider(0,100,50);
		SoundManager.setVolume(50);
		
		iv.setFitWidth(64);
		iv.setFitHeight(64);
		
		getChildren().addAll(iv,sl);
	}
	public double getVolume(){
		return sl.getValue();
	}
}

package ui;

import javafx.geometry.Pos;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import logic.SoundManager;

public class VolumePane extends HBox {
	public VolumePane() {
		setAlignment(Pos.CENTER);
		
		ImageView iv=new ImageView(new Image(ClassLoader.getSystemResource("img/volume.png").toString()));			
		Slider sl=new Slider(0,100,50);
		
		iv.setFitWidth(64);
		iv.setFitHeight(64);
		
		SoundManager.setVolume(50);
		sl.setOnMouseClicked(e->{
			SoundManager.setVolume(sl.getValue());
		});
		sl.setOnMouseDragReleased(e->{
			SoundManager.setVolume(sl.getValue());
		});
		
		getChildren().addAll(iv,sl);
	}
}

package ui;

import application.Main;
import application.SoundManager;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class MainMenu extends VBox {

	public MainMenu() {
		
		Button start=new Button("Start");
		Slider sl=new Slider(0,100,50);
		getChildren().addAll(start,sl,new Button("Exit"));
		start.setOnAction(e->{
			Main.changeSceneToGame();
		});
		sl.setOnMouseClicked(e->{
			SoundManager.setVolume(sl.getValue());
		});
	}
}

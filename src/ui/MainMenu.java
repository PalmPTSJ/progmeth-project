package ui;

import application.Main;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import logic.SoundManager;

public class MainMenu extends VBox {

	public MainMenu() {
		Label title=new Label("PROGMETH");
		Button start=new Button("Start");
		Button exit=new Button("Exit");
		Button highscore = new Button("High score");
		VolumePane volume=new VolumePane();
		getChildren().addAll(title,start,exit,highscore,volume);
		setAlignment(Pos.CENTER);
	
		title.getStyleClass().setAll("lbl-primary");
		title.setFont(Font.font(40));
		title.setPadding(new Insets(40));
		setMargin(title, new Insets(60));
		
		start.setOnAction(e->{
			start.setText("LOADING");
			SoundManager.setVolume(volume.getVolume());
			Main.changeSceneToGame();
		});
		start.getStyleClass().setAll("btn","btn-lg","btn-success");
		setMargin(start, new Insets(10));
		
		exit.setOnAction(e->{
			Platform.exit();
		});
		exit.getStyleClass().setAll("btn","btn-lg","btn-danger");
		setMargin(exit, new Insets(10));
		
		highscore.getStyleClass().setAll("btn","btn-lg","btn-info");
		setMargin(highscore, new Insets(10));

		volume.setPadding(new Insets(40));
	}
}

package ui;

import application.Main;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.SoundManager;

public class MainMenu extends VBox {

	public MainMenu() {
		HBox title=new HBox();
		Label titleName=new Label("Super Killing War");
		Label titleVersion=new Label("1.0.1");
		Button start=new Button("Start");
		Button exit=new Button("Exit");
		Button highscore = new Button("High score");
		VolumePane volume=new VolumePane();
		getChildren().addAll(title,start,exit,highscore,volume);
		setAlignment(Pos.CENTER);
	
		title.setAlignment(Pos.TOP_CENTER);
		titleName.getStyleClass().setAll("h1","text-primary");
		titleVersion.getStyleClass().setAll("lbl-success","lbl");
		title.getChildren().addAll(titleName,titleVersion);
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

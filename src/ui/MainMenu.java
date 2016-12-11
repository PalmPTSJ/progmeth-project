package ui;

import application.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainMenu extends VBox {

	public MainMenu() {
		Label title=new Label("PROGMETH");
		Button start=new Button("Start");
		Button exit=new Button("Exit");
		VolumePane volume=new VolumePane();
		getChildren().addAll(title,start,exit,volume);
		setAlignment(Pos.CENTER);
		
		title.getStyleClass().setAll("bg-primary");
		title.setPadding(new Insets(50));
		
		start.setOnAction(e->{
			start.setText("LOADING");
			Main.changeSceneToGame();
		});
		start.getStyleClass().setAll("btn","btn-lg","btn-primary");
		start.setPadding(new Insets(50));
		
		exit.getStyleClass().setAll("btn","btn-lg","btn-danger");
		exit.setPadding(new Insets(50));

		volume.setPadding(new Insets(50));
	}
}

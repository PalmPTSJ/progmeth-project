package ui;

import application.Main;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
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
		setPrefSize(Main.screenWidth+300, Main.screenHeight);
		setBackground(new Background(new BackgroundImage(new Image(ClassLoader.getSystemResource("img/ui/background.png").toString()), null, null, null,null)));
	
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
		start.setAlignment(Pos.CENTER);
		setMargin(start, new Insets(10));
		
		exit.setOnAction(e->{
			Platform.exit();
		});
		exit.getStyleClass().setAll("btn","btn-lg","btn-danger");
		exit.setAlignment(Pos.CENTER);
		setMargin(exit, new Insets(10));
		
		highscore.getStyleClass().setAll("btn","btn-lg","btn-info");
		highscore.setAlignment(Pos.CENTER);
		setMargin(highscore, new Insets(10));

	}
}

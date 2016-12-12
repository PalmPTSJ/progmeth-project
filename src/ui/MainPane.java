package ui;

import application.Main;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.VBox;
import logic.SoundManager;
import thread.showHighscoreThread;

public class MainPane extends VBox implements IStoppable {
	Thread joiner;
	public MainPane() {
		Button start=new Button("Start");
		Button exit=new Button("Exit");
		Button highscore = new Button("High score");
		VolumePane volume=new VolumePane();
		getChildren().addAll(start,exit,highscore,volume);
		
		setAlignment(Pos.BOTTOM_RIGHT);
		setPrefSize(Main.screenWidth+300, Main.screenHeight);
		
		setBackground(new Background(new BackgroundImage(new Image(ClassLoader.getSystemResource("img/ui/background.png").toString()), null, null, null,null)));
		
		start.setOnAction(e->{
			start.setText("LOADING");
			SoundManager.setVolume(volume.getVolume());
			Main.changeSceneToGame();
		});
		start.getStyleClass().setAll("btn","btn-lg","btn-success");
		start.setAlignment(Pos.CENTER);
		start.setPrefSize(200, 80);
		start.setStyle("-fx-cursor: hand;");
		setMargin(start, new Insets(20,100,20,0));
		
		exit.setOnAction(e->{
			Platform.exit();
		});
		exit.getStyleClass().setAll("btn","btn-lg","btn-danger");
		exit.setAlignment(Pos.CENTER);
		exit.setPrefSize(200, 80);
		exit.setStyle("-fx-cursor: hand;");
		setMargin(exit, new Insets(20,100,20,0));
		
		highscore.setOnAction(e->{
			highscore.setText("Loading");
			Thread t=new showHighscoreThread();
			t.start();
			joiner=new Thread(()->{
				try {
					t.join();
					Platform.runLater(()->{
						highscore.setText("High score");
					});
				} catch (InterruptedException e1) {

				}
			});
			joiner.start();
		});
		highscore.getStyleClass().setAll("btn","btn-lg","btn-info");
		highscore.setAlignment(Pos.CENTER);
		highscore.setPrefSize(200, 80);
		highscore.setStyle("-fx-cursor: hand;");
		setMargin(highscore, new Insets(20,100,20,0));
	}

	public void stop() {
		if(joiner!=null){
			joiner.interrupt();			
		}
	}
}

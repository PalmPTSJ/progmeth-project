package ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import application.Main;
import exception.HighscoreException;
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
import javafx.scene.text.Text;
import logic.HighscoreManager;
import logic.SoundManager;

public class MainPane extends VBox implements IStoppable {
	Thread highscoreThread;

	public MainPane() {
		HBox title=new HBox();
		Label titleName=new Label("Super Killing War");
		Label titleVersion=new Label("1.0.1");
		Button start=new Button("Start");
		Button exit=new Button("Exit");
		Button highscore = new Button("High score");
		Text highscoreText = new Text("Loading Highscore");
		VolumePane volume=new VolumePane();
		getChildren().addAll(title,start,exit,highscore,highscoreText,volume);
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
		
		highscoreThread=new Thread(()->{
			try {
				while(true){
					String rawscore;
					try{
						rawscore=HighscoreManager.getScore();
					}
					catch(HighscoreException e){
						continue;
					}
					ArrayList<String> scores=new ArrayList<>();
					for(String score:rawscore.split("\n")){
						scores.add(score);
					}
					Collections.sort(scores);
					Collections.reverse(scores);
					String scoreText="";
					for(int i=0;i<Math.min(10,scores.size());i++){
						scoreText+=scores.get(i).replaceAll("!"," : ");
						scoreText+="\n";
					}
					highscoreText.setText(scoreText);
					Thread.sleep(3000);
				}
				
			} catch (InterruptedException e) {
				
			}
			
		});
		highscoreThread.start();
	}

	public void stop() {
		highscoreThread.interrupt();
	}
}

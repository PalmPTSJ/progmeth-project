package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import logic.GameManager;
import logic.InputUtility;
import ui.GamePane;
import ui.MainMenu;

public class Main extends Application {
	
	public static final int screenWidth = 900;
	public static final int screenHeight = 600;
	public static Scene scene;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		scene = new Scene(new MainMenu(),screenWidth+200, screenHeight);
		InputUtility.instance.setEventHandler(scene);
		
		SoundManager.start();
		
		
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	@Override
	public void stop() {
		if(GameManager.enemyController!=null)GameManager.enemyController.stop();
	}
	public static void changeSceneToGame(){
		scene.setRoot(new GamePane(screenWidth, screenHeight));
	}
}

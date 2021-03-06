/*
 * JavaFx Main Class - The beginning of every thing
 */
package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.InputUtility;
import logic.SoundManager;
import ui.GamePane;
import ui.IStoppable;
import ui.MainPane;

public class Main extends Application {

	private static final int SCREEN_WIDTH = 1200;
	private static final int SCREEN_HEIGHT = 600;
	private static Scene scene;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainPane mainPane = new MainPane(SCREEN_WIDTH, SCREEN_HEIGHT);
		scene = new Scene(mainPane, SCREEN_WIDTH, SCREEN_HEIGHT);
		scene.getStylesheets().add("bootstrapfx.css");
		InputUtility.instance.setEventHandler(scene);

		primaryStage.setTitle("Super Killing Wars");
		primaryStage.setResizable(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void stop() {
		((IStoppable) scene.getRoot()).stop();
	}

	public static void changeSceneToGame() {
		((IStoppable) scene.getRoot()).stop();
		GamePane gamePane = new GamePane(SCREEN_WIDTH, SCREEN_HEIGHT);
		scene.setRoot(gamePane);
		SoundManager.start();
	}

	public static void changeSceneToMain() {
		((IStoppable) scene.getRoot()).stop();
		SoundManager.stop();
		MainPane mainPane = new MainPane(SCREEN_WIDTH, SCREEN_HEIGHT);
		scene.setRoot(mainPane);
	}
	
	public static Scene getScene() {
		return scene;
	}
}

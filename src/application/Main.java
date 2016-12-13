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

	public static final int screenWidth = 1200;
	public static final int screenHeight = 600;
	public static Scene scene;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainPane mainPane = new MainPane();
		scene = new Scene(mainPane, screenWidth, screenHeight);
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
		GamePane gamePane = new GamePane(screenWidth, screenHeight);
		scene.setRoot(gamePane);
		SoundManager.start();
	}

	public static void changeSceneToMain() {
		((IStoppable) scene.getRoot()).stop();
		SoundManager.stop();
		MainPane mainPane = new MainPane();
		scene.setRoot(mainPane);
	}
}

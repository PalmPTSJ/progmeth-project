/*
 * JavaFx Main Class - The beginning of every thing
 */
package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import logic.InputUtility;
import logic.SoundManager;
import ui.GamePane;
import ui.IStoppable;
import ui.MainPane;

public class Main extends Application {

	private static final int screenWidth = 1200;
	private static final int screenHeight = 600;
	private static Scene scene;
	private static Stage primaryStage;
	private static Scale scale=new Scale();
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Main.primaryStage=primaryStage;
		MainPane mainPane = new MainPane(screenWidth, screenHeight);
		scene = new Scene(mainPane, screenWidth, screenHeight);
		scene.getRoot().getTransforms().add(scale);
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
		scene.getRoot().getTransforms().add(scale);
		SoundManager.start();
	}

	public static void changeSceneToMain() {
		((IStoppable) scene.getRoot()).stop();
		SoundManager.stop();
		MainPane mainPane = new MainPane(screenWidth, screenHeight);
		scene.setRoot(mainPane);
		scene.getRoot().getTransforms().add(scale);
	}
	public static void setScale(double scaleValue){
		scale.setX(scaleValue);
		scale.setY(scaleValue);
		((Pane)scene.getRoot()).setPrefSize(screenWidth*scaleValue, screenHeight*scaleValue);
		System.out.println(((Pane)scene.getRoot()).getHeight());
		primaryStage.sizeToScene();
		System.out.println(primaryStage.getHeight());
	}
}

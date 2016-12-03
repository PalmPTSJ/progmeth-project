package application;
import graphics.GameScreen;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.GameManager;
import logic.InputUtility;
import ui.Menu;

public class Main extends Application {
	
	public final int screenWidth = 900;
	public final int screenHeight = 600;
	public final double screenScale = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox root = new HBox();
		Menu menu=new Menu();
		Scene s = new Scene(root,screenWidth+200, screenHeight);
		GameScreen gs = new GameScreen(screenWidth, screenHeight,screenScale);
		root.getChildren().add(gs);
		root.getChildren().add(menu);
		GameManager gm = new GameManager();
		InputUtility.instance.setEventHandler(s);
		
		new AnimationTimer() {
			Long start=0l;
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				if(start==0l)start=now;
				long diff = now-start;
				if(diff > 0) GameManager.fps = (int) (1000000000l/(diff));
				
				if(diff>=10000000l) { // Full speed (60fps)
					gm.update();
					gs.paintComponents();
					menu.update();
					start = now;
				}
				
			}
		}.start();
		primaryStage.setResizable(false);
		primaryStage.setScene(s);
		primaryStage.show();
		
	}

}

package application;
import graphics.GameScreen;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.GameManager;
import ui.Menu;

public class Main extends Application {
	
	public final int screenWidth = 900;
	public final int screenHeight = 600;
	public final double screenScale = 0.75;
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
		s.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {
				gm.receiveKey(ke.getCode());
			}
		});
		s.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {
				gm.dropKey(ke.getCode());
			}
		});
		
		new AnimationTimer() {
			Long start=0l;
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				if(start==0l)start=now;
				long diff = now-start;
				if(diff>=30000000l){ //30000000l = 30ms. = 30 fps
					//Fill in here
					gm.update();
					gs.paintComponents();
					start = now;
				}
				
			}
		}.start();
		
		primaryStage.setScene(s);
		primaryStage.show();
		
	}

}

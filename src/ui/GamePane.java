package ui;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.HBox;
import logic.GameManager;

public class GamePane extends HBox {
	AnimationTimer at;
	public GamePane(int width,int height) {
		// TODO Auto-generated constructor stub
		GameMenu menu=new GameMenu();
		GameScreen gs = new GameScreen(width, height);
		getChildren().add(gs);
		getChildren().add(menu);
		
		GameManager.instance = new GameManager();
		
		at=new AnimationTimer() {
			Long start=0l;
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				if(start==0l)start=now;
				long diff = now-start;
				if(diff > 0) GameManager.fps = (int) (1000000000l/(diff));
				
				if(diff>=10000000l) { // Full speed (60fps)
					GameManager.instance.update();
					gs.paintComponents();
					menu.update();
					start = now;
				}
				
			}
		};
		at.start();
	}
	public void stop(){
		at.stop();
		GameManager.enemyController.stop();
	}
}

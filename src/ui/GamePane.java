package ui;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.HBox;
import logic.GameManager;

public class GamePane extends HBox {
	AnimationTimer at;
	public GamePane(int width,int height) {
		GameMenu menu=new GameMenu();
		GameScreen gs = new GameScreen(width, height);
		getChildren().add(gs);
		getChildren().add(menu);
		
		GameManager.instance = new GameManager();
		
		at=new AnimationTimer() {
			Long start=0l;
			@Override
			public void handle(long now) {
				if(start==0l)start=now;
				long diff = now-start;
				if(diff > 0) GameManager.fps = (int) (1000000000l/(diff));
				
				if(diff>=10000000l) {
					GameManager.instance.update();
					//GameManager.instance.update();
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
	}
}

package ui;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import logic.GameManager;

public class StatsBox extends VBox {
	private Label score,fps;
	public StatsBox(){
		score=new Label();
		fps=new Label();
		getChildren().addAll(score,fps);
	}
	public void update(){
		score.setText("Score "+GameManager.score);
		fps.setText(GameManager.fps+"fps");
	}
}

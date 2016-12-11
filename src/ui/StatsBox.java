package ui;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import logic.GameManager;
import logic.TileManager;
import model.RenderableHolder;

public class StatsBox extends VBox {
	private Label score, fps, entityCount;

	public StatsBox() {
		score = new Label();
		fps = new Label();
		entityCount = new Label();
		getChildren().addAll(score, fps, entityCount);
	}

	public void update() {
		score.setText("Score " + GameManager.score);
		fps.setText(GameManager.fps + "fps");
		int tileCount = (TileManager.tileCountX+2)*(TileManager.tileCountY+2);
		entityCount.setText("Entity Count : " + (RenderableHolder.getInstance().getEntities().size() - tileCount));
	}
}

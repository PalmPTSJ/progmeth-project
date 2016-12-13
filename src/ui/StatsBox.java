package ui;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import logic.EnemyManager;
import logic.GameManager;
import logic.TileManager;
import model.RenderableHolder;
import model.projectile.ProjectilePlayerBullet;

public class StatsBox extends VBox {
	private Label score, fps, entityCount, playerDamage, wave;

	public StatsBox() {
		score = new Label();
		fps = new Label();
		entityCount = new Label();
		playerDamage = new Label();
		wave = new Label();
		getChildren().addAll(score, fps, wave);
	}

	public void update() {
		score.setText("Score " + GameManager.instance.getScore());
		fps.setText(GameManager.instance.getFps() + "fps");
		playerDamage.setText("Damage " + ProjectilePlayerBullet.getDamage());
		wave.setText("Wave " + EnemyManager.instance.getWaveNumber() + " , Next in "
				+ (EnemyManager.instance.getRemainingTime() / 60) + " sec " + "("
				+ EnemyManager.instance.getNextWaveName() + ")");
		int tileCount = (TileManager.tileCountX + 2) * (TileManager.tileCountY + 2);
		entityCount.setText("Entity Count : " + (RenderableHolder.getInstance().getEntities().size() - tileCount));
	}
}

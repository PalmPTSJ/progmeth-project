package model;

import javafx.scene.canvas.GraphicsContext;

public class EnemyBoss extends Enemy {

	public EnemyBoss(double x, double y,int level) {
		super(x, y, 3, 100 + 50*level, 4 + 3*level, 35*level);
	}
	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.enemy_boss_img);
	}
}

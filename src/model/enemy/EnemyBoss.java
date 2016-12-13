/*
 * Enemy boss
 */
package model.enemy;

import javafx.scene.canvas.GraphicsContext;
import model.RenderableHolder;

public class EnemyBoss extends Enemy {
	
	private static final double SPEED = 3;
	
	public EnemyBoss(double x, double y, int level) {
		super(x, y, SPEED, 50 + 40 * level, (int) (4 + 0.8 * level), 10 * level);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.enemy_boss_img);
	}
}

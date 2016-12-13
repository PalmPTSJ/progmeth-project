/*
 * Basic enemy (weak)
 */
package model.enemy;

import javafx.scene.canvas.GraphicsContext;
import model.RenderableHolder;

public class EnemyBasic extends Enemy {
	
	private static final double SPEED = 2;
	
	public EnemyBasic(double x, double y, int level) {
		super(x, y, SPEED, 20 + 20 * level, (int) (3 + 0.7 * level), 3 * level);
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.enemy_basic_img);
	}
}

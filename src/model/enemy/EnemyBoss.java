package model.enemy;

import javafx.scene.canvas.GraphicsContext;
import model.RenderableHolder;

public class EnemyBoss extends Enemy {

	public EnemyBoss(double x, double y,int level) {
		super(x, y, 3, 50 + 30*level, (int)(4 + 0.5*level), 10*level);
	}
	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.enemy_boss_img);
	}
}

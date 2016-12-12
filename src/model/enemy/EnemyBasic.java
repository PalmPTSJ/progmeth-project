package model.enemy;

import javafx.scene.canvas.GraphicsContext;
import model.RenderableHolder;

public class EnemyBasic extends Enemy {

	public EnemyBasic(double x, double y,int level) {
		super(x, y, 2, 20 + 20*level, (int)(3 + 0.8*level), 3*level);
	}
	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.enemy_basic_img);
	}
}

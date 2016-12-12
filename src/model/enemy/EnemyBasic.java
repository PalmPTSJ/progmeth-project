package model.enemy;

import javafx.scene.canvas.GraphicsContext;
import model.RenderableHolder;

public class EnemyBasic extends Enemy {

	public EnemyBasic(double x, double y,int level) {
		super(x, y, 2, 50 + 25*level, 3 + 2*level, 10*level);
	}
	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.enemy_basic_img);
	}
}

package model;

import javafx.scene.canvas.GraphicsContext;

public class EnemyBasic extends Enemy {

	public EnemyBasic(double x, double y,int level) {
		super(x, y, 2, 100, 3*level, 10*level);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.enemy_basic_img);
	}
}

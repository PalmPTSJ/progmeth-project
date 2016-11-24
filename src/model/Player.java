package model;

import javafx.scene.canvas.GraphicsContext;
import logic.IBlockable;

public class Player extends MovableEntity implements IBlockable {

	public static final double speed = 5;
	public static final double width = 20;
	public static final double height = 20;
	public Player(double x, double y) {
		super(x, y, width, height, speed);
	}
	
	@Override
	public void move() {
		super.move();
		velX = velY = 0;
	}
	
	@Override
	public void undoMove() {
		x = lastX;
		y = lastY;
	}

	@Override
	public int getZ() {
		return 100;
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.player_img);
	}

}
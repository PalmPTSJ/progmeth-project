package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import logic.InputUtility;

public class Player extends BlockingEntity {

	private static final double speed = 5;
	private static final double width = 20;
	private static final double height = 20;
	private static final int startHp = 400;

	public Player(double x, double y) {
		super(x, y, width, height, speed, startHp);
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
		return 0;
	}

	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.player_img);
	}

	@Override
	public void update(){
		if (InputUtility.instance.isKeyDown(KeyCode.A))
			setVelX(-1);
		if (InputUtility.instance.isKeyDown(KeyCode.D))
			setVelX(1);
		if (InputUtility.instance.isKeyDown(KeyCode.W))
			setVelY(-1);
		if (InputUtility.instance.isKeyDown(KeyCode.S))
			setVelY(1);
		super.update();
	}
}

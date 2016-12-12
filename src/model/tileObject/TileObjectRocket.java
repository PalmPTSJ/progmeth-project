package model.tileObject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameManager;
import logic.TileManager;
import model.RenderableHolder;
import model.Tile;

public class TileObjectRocket extends TileObject {
	
	private static final int startHP = 1500;
	public static final int sizeX = 3;
	public static final int sizeY = 3;
	
	private static final int launchDelay = 1800;
	private int launchTimer = 0;
	
	public TileObjectRocket(Tile tile) {
		super(tile, sizeX, sizeY, startHP);
	}
	
	public static boolean canPlace(Tile tile) {
		return TileManager.instance.canPlace(tile, sizeX, sizeY);
	}
	
	@Override
	public void update() {
		super.update();
		if(launchTimer < launchDelay) {
			launchTimer++;
		}
		else {
			GameManager.instance.setRocketLaunched(true);
			
		}
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		super.draw(gc, RenderableHolder.tileObject_rocket_img);
		gc.setFill(Color.GREEN);
		gc.setFont(Font.font(20));
		gc.fillText(""+(int)((launchDelay-launchTimer)/60), this.getCenterX()-10,this.getCenterY());
	}
	
	public static int[] getResourceNeeded() {
		return new int[]{0,0,0,0,0};
		//return new int[]{100,100,100,50,1000};
	}

}

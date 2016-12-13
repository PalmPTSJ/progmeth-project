/*
 * Canvas for drawing
 */
package ui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.BuyManager;
import logic.GameManager;
import logic.IRenderable;
import logic.TileManager;
import model.Entity;
import model.RenderableHolder;
import model.Tile;
import model.tileObject.tower.Tower;

public class GameScreen extends Canvas {
	private int screen_width, screen_height;

	public GameScreen(int width, int height) {
		super(width, height);
		screen_width = width;
		screen_height = height;
	}

	public void paintComponents() {
		synchronized (RenderableHolder.instance.getEntities()) {
			GraphicsContext gc = this.getGraphicsContext2D();
			drawBackground(gc);
			drawEntities(gc);
			if (BuyManager.instance.isBuyMode) {
				drawOverlay(gc);
				drawBuyingItem(gc);
			}
			if (GameManager.instance.isGamePause()) {
				drawPause(gc);
			}
		}
	}

	private void drawPause(GraphicsContext gc) {
		gc.setGlobalAlpha(0.5);
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, screen_width, screen_height);
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font(40));
		gc.fillText("PAUSE", screen_width / 2 - 50, screen_height / 2 - 15);
		gc.setGlobalAlpha(1);
	}

	public void drawBuyingItem(GraphicsContext gc) {
		int x = TileManager.getMouseTileX();
		int y = TileManager.getMouseTileY();
		int sizeX;
		int sizeY;
		try {
			sizeX = BuyManager.instance.currentObjectClass.getDeclaredField("sizeX").getInt(null);
			sizeY = BuyManager.instance.currentObjectClass.getDeclaredField("sizeY").getInt(null);
			// ie currentObjectClass Object is instance of Tower
			if (Tower.class.isAssignableFrom(BuyManager.instance.currentObjectClass)) {
				gc.setGlobalAlpha(0.3);
				gc.setFill(Color.BLACK);
				double r = BuyManager.instance.currentObjectClass.getDeclaredField("shootingRange").getDouble(null);
				gc.fillOval((x + (double) (sizeX) / 2) * TileManager.tileSize - r,
						(y + (double) (sizeY) / 2) * TileManager.tileSize - r, 2 * r, 2 * r);
				gc.setGlobalAlpha(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		boolean canPlace = BuyManager.instance.canBuy();
		if (!canPlace) {
			gc.setGlobalAlpha(0.2);
		}
		gc.drawImage(BuyManager.instance.currentObjectImage, x * TileManager.tileSize, y * TileManager.tileSize,
				sizeX * TileManager.tileSize, sizeY * TileManager.tileSize);
		gc.setGlobalAlpha(1.0);
	}

	public void drawOverlay(GraphicsContext gc) {
		gc.setGlobalAlpha(0.5);
		for (Tile tile : TileManager.instance.tileList) {
			if (tile.getTileObject() == null) {
				gc.setFill(Color.GREEN);
				gc.fillRect(tile.getX(), tile.getY(), TileManager.tileSize, TileManager.tileSize);
			} else {
				gc.setFill(Color.DARKRED);
				gc.fillRect(tile.getX(), tile.getY(), TileManager.tileSize, TileManager.tileSize);
			}
		}
		gc.setGlobalAlpha(1);
	}

	public void drawBackground(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, screen_width, screen_height);
	}

	public void drawEntities(GraphicsContext gc) {
		for (IRenderable o : RenderableHolder.instance.getEntities()) {
			o.draw(gc);
		}
		// draw healthbar
		for (IRenderable ir : RenderableHolder.instance.getEntities()) {
			if (ir instanceof Entity) {
				((Entity) ir).drawHealthBar(gc);
			}
		}

	}
}

package graphics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.BuyManager;
import logic.GameManager;
import logic.InputUtility;
import logic.TileManager;
import model.IRenderable;
import model.RenderableHolder;
import model.Tile;

public class GameScreen extends Canvas {
	public static int screen_width, screen_height;
	public static double scale;
	public GameScreen(int width,int height){
		super(width,height);
		screen_width = width;
		screen_height = height;
	}
	
	public void paintComponents(){
		GraphicsContext gc = this.getGraphicsContext2D();
		drawBackground(gc);
		drawEntities(gc);
		if(BuyManager.buyMode){
			drawOverlay(gc);
			drawBuyingItem(gc);
		}
	}
	public void drawBuyingItem(GraphicsContext gc){
		int x=(int) (InputUtility.instance.getMouseX()/TileManager.tileSize);
		int y=(int) (InputUtility.instance.getMouseY()/TileManager.tileSize);
		int sizeX=0,sizeY=0;
		try {
			sizeX=BuyManager.currentObjectClass.getDeclaredField("sizeX").getInt(null);
			sizeY=BuyManager.currentObjectClass.getDeclaredField("sizeY").getInt(null);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gc.drawImage(BuyManager.currentObjectImage,x*TileManager.tileSize,y*TileManager.tileSize,sizeX*TileManager.tileSize,sizeY*TileManager.tileSize);
	}
	public void drawOverlay(GraphicsContext gc){
		gc.setGlobalAlpha(0.5);
		for(Tile tile : TileManager.tileList) {
			if(tile.tileObject == null) {
				gc.setFill(Color.GREEN);
				gc.fillRect(tile.getX(), tile.getY(), TileManager.tileSize, TileManager.tileSize);
			}
			else {
				gc.setFill(Color.DARKRED);
				gc.fillRect(tile.getX(), tile.getY(), TileManager.tileSize, TileManager.tileSize);
			}
		}
		gc.setGlobalAlpha(1);
	}
	public void drawBackground(GraphicsContext gc){
		
		gc.setFill(Color.BLACK);
		gc.fillRect(0,0, screen_width,screen_height);
	}
	public void drawEntities(GraphicsContext gc){
		for(IRenderable o : RenderableHolder.getInstance().getEntities()) {
			o.draw(gc);
		}
	}
	public void drawScore(GraphicsContext gc){
		String score = ""+GameManager.fps;
		gc.setFont(Font.font("Times New Roman",FontWeight.BOLD,50));
		gc.setFill(Color.BLUE);
		gc.fillText(score, 350, 50);
		gc.setStroke(Color.WHITE);
		gc.strokeText(score, 350, 50);
	}
}

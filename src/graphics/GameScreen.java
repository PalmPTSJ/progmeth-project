package graphics;

import java.lang.reflect.InvocationTargetException;

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
import model.Tower;

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
		if(BuyManager.instance.buyMode){
			drawOverlay(gc);
			drawBuyingItem(gc);
		}
	}
	public void drawBuyingItem(GraphicsContext gc){
		int x=(int) (InputUtility.instance.getMouseX()/TileManager.tileSize);
		int y=(int) (InputUtility.instance.getMouseY()/TileManager.tileSize);
		if(x>=TileManager.tileCountX || x<0 || y>=TileManager.tileCountY || y<0)return;
		int sizeX=0,sizeY=0;
		try {
			sizeX=BuyManager.instance.currentObjectClass.getDeclaredField("sizeX").getInt(null);
			sizeY=BuyManager.instance.currentObjectClass.getDeclaredField("sizeY").getInt(null);
			
			if(Tower.class.isAssignableFrom(BuyManager.instance.currentObjectClass)) {
				gc.setGlobalAlpha(0.3);
				gc.setFill(Color.BLACK);
				double r = BuyManager.instance.currentObjectClass.getDeclaredField("shootingRange").getDouble(null);
				gc.fillOval((x+0.5)*TileManager.tileSize - r, (y+0.5)*TileManager.tileSize - r, 2*r, 2*r);
				gc.setGlobalAlpha(1);
			}
			
			boolean canPlace = (Boolean)BuyManager.instance.currentObjectClass.getMethod("canPlace", Tile.class).invoke(null, TileManager.instance.tileArray[x][y]);			
			if(!canPlace) {
				gc.setGlobalAlpha(0.2);
			}
			gc.drawImage(BuyManager.instance.currentObjectImage,x*TileManager.tileSize,y*TileManager.tileSize,sizeX*TileManager.tileSize,sizeY*TileManager.tileSize);
			gc.setGlobalAlpha(1.0);
			
			
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException | InvocationTargetException | NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void drawOverlay(GraphicsContext gc){
		gc.setGlobalAlpha(0.5);
		for(Tile tile : TileManager.instance.tileList) {
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

package graphics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.BuyManager;
import logic.GameManager;
import logic.TileManager;
import model.IRenderable;
import model.RenderableHolder;
import model.Tile;
import model.TileObjectStone;
import model.TileObjectTree;

public class GameScreen extends Canvas {
	public static int screen_width, screen_height;
	public static double scale;
	public GameScreen(int width,int height,double _scale){
		super(width,height);
		screen_width = width;
		screen_height = height;
		scale=_scale;
	}
	
	public void paintComponents(){
		GraphicsContext gc = this.getGraphicsContext2D();
		drawBackground(gc);
		drawEntities(gc);
//		drawScore(gc);
		if(BuyManager.buyMode){
			drawOverlay(gc);
		}
	}
	public void drawOverlay(GraphicsContext gc){
		gc.setGlobalAlpha(0.5);
		gc.setFill(Color.BLACK);
		gc.fillRect(0,0, screen_width,screen_height);
		gc.setFill(Color.GREEN);
		for(Tile t:TileManager.tileList){
			boolean ok=false;
			int w=0,h=0; // HELP!
			if(BuyManager.currentObjectName.equals("Tree")){
				ok=TileObjectTree.canPlace(t);
			}
			else if(BuyManager.currentObjectName.equals("Stone")){
				ok=TileObjectStone.canPlace(t);
			}
			if(ok){
				gc.fillRect(t.getX(), t.getY(), TileManager.tileSize, TileManager.tileSize);
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

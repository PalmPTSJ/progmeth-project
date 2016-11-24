package graphics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.IRenderable;
import model.RenderableHolder;

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
		drawScore(gc);
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
		/*String score = ""+GameManager.score;
		while(score.length() < 3) score = "0"+score;
		gc.setFont(Font.font("Times New Roman",FontWeight.BOLD,50));
		gc.setFill(Color.BLUE);
		gc.fillText(score, 350, 50);
		gc.setStroke(Color.WHITE);
		gc.strokeText(score, 350, 50);*/
	}
}

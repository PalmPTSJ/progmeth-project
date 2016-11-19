package graphics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.GameManager;
import model.IRenderable;
import model.RenderableHolder;

public class GameScreen extends Canvas {
	public static int screen_width, screen_height;
	
	public GameScreen(int width,int height){
		super(width,height);
		screen_width = width;
		screen_height = height;
	}
	
	public void paintComponents(){
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0,0, screen_width,screen_height);
		for(IRenderable o : RenderableHolder.getInstance().getEntities()) {
			o.draw(gc);
		}
		drawScore(gc);
	}
	
	public void drawScore(GraphicsContext gc){
		String score = ""+GameManager.score;
		while(score.length() < 3) score = "0"+score;
		gc.setFont(Font.font("Times New Roman",FontWeight.BOLD,50));
		gc.setFill(Color.BLUE);
		gc.fillText(score, 350, 50);
		gc.setStroke(Color.WHITE);
		gc.strokeText(score, 350, 50);
	}
}

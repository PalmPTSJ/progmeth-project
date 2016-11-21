package graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GraphicUtility {
	public static void drawScale(GraphicsContext gc,Image img,double x,double y,double scale){
		gc.drawImage(img, x, y,img.getWidth()*scale,img.getHeight()*scale);
	}
}

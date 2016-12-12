package logic;

import java.lang.reflect.InvocationTargetException;

import javafx.scene.image.Image;
import model.Tile;

public class BuyManager {
	public static BuyManager instance;
	public boolean buyMode=false;
	public Image currentObjectImage;
	@SuppressWarnings("rawtypes")
	public Class currentObjectClass;
	public BuyManager(){
		buyMode=false;
	}
	public boolean canBuy(){
		int x=(int) (InputUtility.instance.getMouseX()/TileManager.tileSize);
		int y=(int) (InputUtility.instance.getMouseY()/TileManager.tileSize);
		if(x>=TileManager.tileCountX || x<0 || y>=TileManager.tileCountY || y<0)return false;
		boolean ret=true;
		try {
			ret = (boolean)BuyManager.instance.currentObjectClass.getMethod("canPlace", Tile.class).invoke(null, TileManager.instance.tileArray[x][y]);
			int[] resourceNeeded = (int[]) BuyManager.instance.currentObjectClass.getMethod("getResourceNeeded")
					.invoke(null);
			for (int i = 0; i < 5; i++) {
				if (ResourceManager.instance.getResource(i) < resourceNeeded[i])
					ret = false;
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
			return false;
		}
		return ret;
	}
}

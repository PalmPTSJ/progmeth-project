package logic;

import java.lang.reflect.Method;

import javafx.scene.image.Image;
import model.Tile;

public class BuyManager {
	public static BuyManager instance;
	public boolean isBuyMode = false;
	public Image currentObjectImage;
	public Class currentObjectClass;

	public BuyManager() {
		isBuyMode = false;
	}

	public boolean canBuy() {
		int x = (int) (InputUtility.instance.getMouseX() / TileManager.tileSize);
		int y = (int) (InputUtility.instance.getMouseY() / TileManager.tileSize);
		if (x >= TileManager.tileCountX || x < 0 || y >= TileManager.tileCountY || y < 0)
			return false;
		boolean ret = true;
		try {
			// call methods on currentObjectClass class (static)
			Method canPlace = BuyManager.instance.currentObjectClass.getMethod("canPlace", Tile.class);
			ret = (boolean) canPlace.invoke(null, TileManager.instance.tileArray[x][y]);
			Method getResourceNeeded = BuyManager.instance.currentObjectClass.getMethod("getResourceNeeded");
			int[] resourceNeeded = (int[]) getResourceNeeded.invoke(null);
			for (int i = 0; i < 5; i++) {
				if (ResourceManager.instance.getResource(i) < resourceNeeded[i])
					ret = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return ret;
	}
}

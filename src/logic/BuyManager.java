package logic;

import java.lang.reflect.Method;

import javafx.scene.image.Image;
import model.Tile;

public class BuyManager {
	public static BuyManager instance;
	public boolean isBuyMode = false;
	public Image currentObjectImage = null;
	public Class currentObjectClass = null;

	public BuyManager() {
		isBuyMode = false;
	}

	public boolean canBuy() {
		int x = GameManager.getMouseTileX();
		int y = GameManager.getMouseTileY();
		if (GameManager.isOutOfBound(x, y))
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

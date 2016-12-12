package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.RenderableHolder;
import model.Tile;
import model.TileGround;
import model.TileStone;
import model.TileVoid;
import model.tileObject.TileObjectStone;
import model.tileObject.TileObjectTree;
import model.tileObject.TileObjectVoid;
import model.TileSpawner;

public class TileManager {
	public static TileManager instance;

	public static final int tileCountX = 30;
	public static final int tileCountY = 20;
	public static final double tileSize = 30;

	public List<Tile> tileList;
	public Tile[][] tileArray; // Use X,Y coordinate system

	public TileManager() {
		tileList = new ArrayList<Tile>();
		tileArray = new Tile[tileCountX][tileCountY];
	}

	public boolean canPlace(Tile tile, int sizeX, int sizeY) {
		for (int dx = 0; dx < sizeX; dx++) {
			for (int dy = 0; dy < sizeY; dy++) {
				int x = tile.getTileX() + dx;
				int y = tile.getTileY() + dy;
				if (x < 0 || y < 0 || x >= TileManager.tileCountX || y >= TileManager.tileCountY) {
					return false;
				}
				if (tileArray[x][y].tileObject != null) {
					return false; // already have object
				}
				
				if(tileArray[x][y] instanceof TileSpawner) return false; // can't place on spawner
			}
		}
		return true;
	}

	public void generateMap(int seed) {
		Random random = new Random(seed);
		for (int x = -1; x <= tileCountX; x++) {
			for (int y = -1; y <= tileCountY; y++) {
				if (x == -1 || y == -1 || x == tileCountX || y == tileCountY) {
					TileVoid vt = new TileVoid(x, y);
					new TileObjectVoid(vt);
					tileList.add(vt);
				} else {
					if(x == tileCountX-1) {
						tileArray[x][y] = new TileSpawner(x, y);
					}
					else {
						tileArray[x][y] = new TileGround(x, y);
					}

					tileList.add(tileArray[x][y]);
					RenderableHolder.getInstance().add(tileArray[x][y]);
				}
			}
		}
		// add some tree & stone
		for (Tile t : tileList) {
			if (random.nextInt(100) < 10 && TileObjectTree.canPlace(t)) {
				new TileObjectTree(t);
			} else if (random.nextInt(100) < 5 && TileObjectStone.canPlace(t)) {
				new TileObjectStone(t);
			}
		}
	}

}

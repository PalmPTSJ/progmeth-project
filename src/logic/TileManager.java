package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.RenderableHolder;
import model.Tile;
import model.TileGround;
import model.TileVoid;
import model.tileObject.TileObjectStone;
import model.tileObject.TileObjectTree;
import model.tileObject.TileObjectVoid;
import model.TileSpawner;

public class TileManager {
	public static TileManager instance;

	public static final int TILE_COUNT_X = 30;
	public static final int TILE_COUNT_Y = 20;
	public static final double TILE_SIZE = 30;

	public List<Tile> tileList;
	public Tile[][] tileArray; // Use X,Y coordinate system

	public TileManager() {
		tileList = new ArrayList<Tile>();
		tileArray = new Tile[TILE_COUNT_X][TILE_COUNT_Y];
	}

	private ICollidable createCollidableFromTile(Tile tile, int sizeX, int sizeY) {
		// create temporary ICollidable object to check collision with entities
		ICollidable ic = new ICollidable() {
			@Override
			public double getY() {
				return tile.getY();
			}

			@Override
			public double getX() {
				return tile.getX();
			}

			@Override
			public double getWidth() {
				return sizeX * TileManager.TILE_SIZE;
			}

			@Override
			public double getHeight() {
				return sizeY * TileManager.TILE_SIZE;
			}

			@Override
			public void onCollision(ICollidable entity) {
			}
		};

		return ic;
	}

	public boolean canPlace(Tile tile, int sizeX, int sizeY) {
		// can't place on tile that has Blocking entity
		ICollidable ic = createCollidableFromTile(tile, sizeX, sizeY);
		if (CollisionUtility.isBlocked(ic))
			return false;

		for (int dx = 0; dx < sizeX; dx++) {
			for (int dy = 0; dy < sizeY; dy++) {
				int x = tile.getTileX() + dx;
				int y = tile.getTileY() + dy;
				if (x < 0 || y < 0 || x >= TileManager.TILE_COUNT_X || y >= TileManager.TILE_COUNT_Y) {
					return false;
				}
				if (tileArray[x][y].getTileObject() != null) {
					return false; // already have object
				}
				if (tileArray[x][y] instanceof TileSpawner)
					return false; // can't place on spawner
			}
		}
		return true;
	}

	public void generateMap(int seed) {
		Random random = new Random(seed);
		for (int x = -1; x <= TILE_COUNT_X; x++) {
			for (int y = -1; y <= TILE_COUNT_Y; y++) {
				if (x == -1 || y == -1 || x == TILE_COUNT_X || y == TILE_COUNT_Y) {
					TileVoid vt = new TileVoid(x, y);
					new TileObjectVoid(vt);
					tileList.add(vt);
				} else {
					if (x >= TILE_COUNT_X - 2) {
						tileArray[x][y] = new TileSpawner(x, y);
					} else {
						tileArray[x][y] = new TileGround(x, y);
					}

					tileList.add(tileArray[x][y]);
					RenderableHolder.instance.add(tileArray[x][y]);
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

	public static int getMouseTileX() {
		return (int) (InputUtility.instance.getMouseX() / TILE_SIZE);
	}

	public static int getMouseTileY() {
		return (int) (InputUtility.instance.getMouseY() / TILE_SIZE);
	}

	public static boolean isOutOfBound(int x, int y) {
		return x >= TILE_COUNT_X || x < 0 || y >= TILE_COUNT_Y || y < 0;
	}

}

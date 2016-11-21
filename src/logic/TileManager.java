package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.RenderableHolder;
import model.Tile;
import model.TileGround;
import model.TileObject;
import model.TileObjectStone;
import model.TileObjectTree;
import model.TileStone;

public class TileManager {
	
	public static final int tileCountX = 30;
	public static final int tileCountY = 20;
	public static final int tileSize = 25;
	public static List<Tile> tileList;
	public static Tile[][] tileArray; // Use X,Y coordinate system
	public TileManager() {
		tileList = new ArrayList<Tile>();
		tileArray = new Tile[tileCountX][tileCountY];
		generateMap(555);
	}
	
	public static boolean canPlaceTileObjectOnTile(Tile tile,TileObject tileObject) { // tile is the upper left of the building
		for(int dx = 0; dx < tileObject.sizeX; dx++) {
			for(int dy = 0; dy < tileObject.sizeY; dy++) {
				int x = tile.getTileX() + dx;
				int y = tile.getTileY() + dy;
				if(x < 0 || y < 0 || x >= tileCountX || y >= tileCountY) {
					return false;
				}
				if(tileArray[x][y].tileObject != null) {
					return false; // already have object
				}
			}
		}
		return true;
		
	}
	public static boolean placeTileObjectOnTile(Tile tile,TileObject tileObject) {
		if(!canPlaceTileObjectOnTile(tile, tileObject)) return false;
		for(int dx = 0; dx < tileObject.sizeX; dx++) {
			for(int dy = 0; dy < tileObject.sizeY; dy++) {
				int x = tile.getTileX() + dx;
				int y = tile.getTileY() + dy;
				tileArray[x][y].setTileObject(tileObject);
			}
		}
		RenderableHolder.getInstance().add(tileObject);
		return true;
	}
	
	private void generateMap(int seed) {
		Random random = new Random(seed);
		for(int x = 0;x < tileCountX;x++) {
			for(int y = 0;y < tileCountY;y++) {
				if(random.nextInt(2) == 1)
					tileArray[x][y] = new TileGround(x,y);
				else 
					tileArray[x][y] = new TileStone(x,y);
				
				tileList.add(tileArray[x][y]);
			}
		}
		// push every tile to renderableHolder
		for(Tile t : tileList) {
			RenderableHolder.getInstance().add(t);
		}
		// add some tree & stone
		for(Tile t : tileList) {
			if(t instanceof TileGround) {
				if(random.nextInt(100) < 40) {
					TileObjectTree tree = new TileObjectTree(t);
					if(canPlaceTileObjectOnTile(t, tree)) {
						placeTileObjectOnTile(t, tree);
					}
				}
			}
			else if(t instanceof TileStone) {
				if(random.nextInt(100) < 20) {
					TileObjectStone stone = new TileObjectStone(t);
					if(canPlaceTileObjectOnTile(t, stone)) {
						placeTileObjectOnTile(t, stone);
					}
				}
			}
		}
	}

}

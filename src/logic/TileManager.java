package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import graphics.GameScreen;
import javafx.scene.canvas.GraphicsContext;
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
	public static final double tileSizeDefault = 30;
	public static double tileSize = 30;
	public static List<Tile> tileList;
	public static Tile[][] tileArray; // Use X,Y coordinate system
	public TileManager() {
		tileSize = tileSizeDefault*GameScreen.scale;
		tileList = new ArrayList<Tile>();
		tileArray = new Tile[tileCountX][tileCountY];
		generateMap(5555);
	}
	public static boolean canPlace(Tile tile,int sizeX,int sizeY) {
		for(int dx = 0; dx < sizeX; dx++) {
			for(int dy = 0; dy < sizeY; dy++) {
				int x = tile.getTileX() + dx;
				int y = tile.getTileY() + dy;
				if(x < 0 || y < 0 || x >= TileManager.tileCountX || y >= TileManager.tileCountY) {
					return false;
				}
				if(TileManager.tileArray[x][y].tileObject != null) {
					return false; // already have object
				}
			}
		}
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
				if(random.nextInt(100) < 30) {
					if(TileObjectTree.canPlace(t)) {
						TileObjectTree tree = new TileObjectTree(t);
					}
				}
			}
			else if(t instanceof TileStone) {
				if(random.nextInt(100) < 15) {
					if(TileObjectStone.canPlace(t)) {
						TileObjectStone stone = new TileObjectStone(t);
					}
				}
			}
		}
	}

}

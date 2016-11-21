package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import graphics.GameScreen;
import javafx.scene.canvas.GraphicsContext;
import model.RenderableHolder;
import model.Tile;
import model.TileGround;
import model.TileObjectStone;
import model.TileObjectTree;
import model.TileStone;
import sun.security.jca.GetInstance;

public class TileManager {
	
	public static final int tileCountX = 20;
	public static final int tileCountY = 15;
	public List<Tile> tileList;
	public TileManager() {
		tileList = new ArrayList<Tile>();
		generateMap(555);
	}
	
	private void generateMap(int seed) {
		Random random = new Random(seed);
		for(int i = 0;i < tileCountY;i++) {
			for(int j = 0;j < tileCountX;j++) {
				if(random.nextInt(2) == 1)
					tileList.add(new TileGround(j*50*GameScreen.scale,i*50*GameScreen.scale));
				else 
					tileList.add(new TileStone(j*50*GameScreen.scale,i*50*GameScreen.scale));
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
					RenderableHolder.getInstance().add(tree);
				}
			}
			else if(t instanceof TileStone) {
				if(random.nextInt(100) < 20) {
					TileObjectStone stone = new TileObjectStone(t);
					RenderableHolder.getInstance().add(stone);
				}
			}
		}
	}

}

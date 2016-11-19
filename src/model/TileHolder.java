package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;

public class TileHolder implements IRenderable {
	
	public static final int tileCountX = 10;
	public static final int tileCountY = 10;
	
	public List<Tile> tileHolder;
	
	public TileHolder() {
		tileHolder = new ArrayList<Tile>();
		generateMap(555);
	}
	
	private void generateMap(int seed) {
		Random random = new Random(seed);
		for(int i = 0;i < tileCountY;i++) {
			for(int j = 0;j < tileCountX;j++) {
				if(random.nextInt(2) == 1)
					tileHolder.add(new TileGround(j*50,i*50));
				else 
					tileHolder.add(new TileStone(j*50,i*50));
			}
		}
	}

	@Override
	public int getZ() {
		return -10;
	}

	@Override
	public void draw(GraphicsContext gc) {
		for(Tile tile : tileHolder) {
			tile.draw(gc);
		}
	}

	@Override
	public boolean isDestroy() {
		// TODO Auto-generated method stub
		return false;
	}

}

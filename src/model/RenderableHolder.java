package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;

public class RenderableHolder {
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image tile_ground_img;
	public static Image tile_stone_img;
	public static Image tileObject_tree_img;
	public static Image tileObject_stone_img;
	public final static RenderableHolder instance;
	
	public RenderableHolder(){
		entities = new ArrayList<>();
		comparator = new Comparator<IRenderable>() {
			public int compare(IRenderable a,IRenderable b) {
				return Integer.compare(a.getZ(),b.getZ());
			}
		};
		
	}
	static{
		instance = new RenderableHolder();
		loadResource();
	}
	
	public synchronized void add(IRenderable entity){
		instance.entities.add(entity);
		instance.entities.sort(comparator);
	}
	private static void loadResource() {
		tile_ground_img = new Image(ClassLoader.getSystemResource("img/tile/ground.png").toString());
		tile_stone_img = new Image(ClassLoader.getSystemResource("img/tile/mountain.png").toString());
		tileObject_tree_img = new Image(ClassLoader.getSystemResource("img/object/tree.png").toString());
		tileObject_stone_img = new Image(ClassLoader.getSystemResource("img/object/rock.png").toString());
	}
	public synchronized void remove(int index){
		instance.entities.remove(index);
	}

	public synchronized static RenderableHolder getInstance() {
		return instance;
	}

	public synchronized List<IRenderable> getEntities() {
		return entities;
	}
}

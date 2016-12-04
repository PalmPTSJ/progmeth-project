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
	public static Image projectile_arrow_img;
	public static Image player_img;
	public static Image enemy_img;
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
	private static Image getRes(String path) {
		return new Image(ClassLoader.getSystemResource(path).toString());
	}
	private static void loadResource() {
		tile_ground_img = getRes("img/tile/ground.png");
		tile_stone_img = getRes("img/tile/mountain.png");
		tileObject_tree_img = getRes("img/tileObject/tree.png");
		tileObject_stone_img = getRes("img/tileObject/stone.png");
		player_img = getRes("img/player.png");
		projectile_arrow_img = getRes("img/object/arrow.png");
		enemy_img = getRes("img/enemy.png");
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

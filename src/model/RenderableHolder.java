package model;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javafx.scene.image.Image;

public class RenderableHolder {
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image tile_ground_img;
	public static Image tile_stone_img;
	
	public static Image tileObject_tree_img;
	public static Image tileObject_stone_img;
	
	public static Image projectile_arrow_img;
	public static Image projectile_laser_img;
	public static Image projectile_rock_img;
	
	public static Image player_img;
	public static Image enemy_img;
	
	public static Image tower_arrow_img;
	public static Image tower_laser_img;
	
	public static Image tileObject_wall_wood_img;
	public static Image tileObject_wall_stone_img;
	public static Image tileObject_wall_iron_img;
	
	public static RenderableHolder instance;
	
	public RenderableHolder(){
		entities = new CopyOnWriteArrayList<>();
		comparator = new Comparator<IRenderable>() {
			public int compare(IRenderable a,IRenderable b) {
				return Integer.compare(a.getZ(),b.getZ());
			}
		};
	}
	static{
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
		enemy_img = getRes("img/enemy.png");
		
		tower_arrow_img = getRes("img/tileObject/towerArrow.png");
		tower_laser_img = getRes("img/tileObject/towerLaser.png");
		
		projectile_arrow_img = getRes("img/object/arrow.png");
		projectile_rock_img = getRes("img/object/laser.png");
		projectile_laser_img = getRes("img/object/laser.png");
		
		tileObject_wall_wood_img = getRes("img/object/woodwall.png");
		tileObject_wall_stone_img = getRes("img/object/stonewall.png");
		tileObject_wall_iron_img = getRes("img/object/ironwall.png");
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

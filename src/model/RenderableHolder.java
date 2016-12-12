package model;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javafx.scene.image.Image;
import logic.IRenderable;

public class RenderableHolder {
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image tile_ground_img;
	public static Image tile_stone_img;
	public static Image tile_spawner_img;

	public static Image tileObject_tree_img;
	public static Image tileObject_stone_img;

	public static Image[] resource_img;

	public static Image projectile_arrow_img;
	public static Image projectile_laser_img;
	public static Image projectile_rock_img;
	public static Image projectile_bullet_img;
	public static Image projectile_bomb_img;

	public static Image player_img;
	public static Image enemy_basic_img;
	public static Image enemy_boss_img;

	public static Image tower_arrow_img;
	public static Image tower_laser_img;
	public static Image tower_catapult_img;
	public static Image tower_turret_img;
	public static Image tower_sniper_img;
	public static Image tower_bomb_img;

	public static Image tileObject_wall_wood_img;
	public static Image tileObject_wall_stone_img;
	public static Image tileObject_wall_iron_img;

	public static Image generator_wood_img;
	public static Image generator_stone_img;
	public static Image generator_iron_img;
	public static Image generator_diamond_img;

	public static Image storage_wood_img;
	public static Image storage_stone_img;
	public static Image storage_iron_img;
	public static Image storage_diamond_img;
	
	public static Image research_building_img;
	public static Image research_iron_img;
	public static Image research_diamond_img;
	public static Image research_gun_img;
	public static Image research_supergun_img;
	public static Image research_regen_img;
	public static Image research_smallgun_img;
	
	public static Image tileObject_rocket_img;

	public static RenderableHolder instance;

	public RenderableHolder() {
		entities = new CopyOnWriteArrayList<>();
		comparator = new Comparator<IRenderable>() {
			public int compare(IRenderable a, IRenderable b) {
				return Integer.compare(a.getZ(), b.getZ());
			}
		};
	}

	static {
		loadResource();
	}

	public void add(IRenderable entity) {
		instance.entities.add(entity);
		instance.entities.sort(comparator);
	}

	private static Image getRes(String path) {
		return new Image(ClassLoader.getSystemResource(path).toString());
	}

	private static void loadResource() {
		tile_ground_img = getRes("img/tile/ground.png");
		tile_stone_img = getRes("img/tile/mountain.png");
		tile_spawner_img = getRes("img/tile/spawner.png");

		resource_img = new Image[5];
		resource_img[0] = getRes("img/ui/res_wood.png");
		resource_img[1] = getRes("img/ui/res_stone.png");
		resource_img[2] = getRes("img/ui/res_iron.png");
		resource_img[3] = getRes("img/ui/res_diamond.png");
		resource_img[4] = getRes("img/ui/res_alienArtifact.png");

		tileObject_tree_img = getRes("img/tileObject/tree.png");
		tileObject_stone_img = getRes("img/tileObject/stone.png");

		player_img = getRes("img/entity/player.png");
		enemy_basic_img = getRes("img/entity/enemy.png");
		enemy_boss_img = getRes("img/entity/enemy_boss.png");

		tower_arrow_img = getRes("img/tileObject/towerArrow.png");
		tower_laser_img = getRes("img/tileObject/towerLaser.png");
		tower_catapult_img = getRes("img/tileObject/towerCatapult.png");
		tower_turret_img = getRes("img/tileObject/towerTurret.png");
		tower_bomb_img = getRes("img/tileObject/towerBomb.png");
		tower_sniper_img = getRes("img/tileObject/towerSniper.png");

		projectile_arrow_img = getRes("img/projectile/arrow.png");
		projectile_rock_img = getRes("img/projectile/rock.png");
		projectile_bomb_img = getRes("img/projectile/bomb.png");
		projectile_laser_img = getRes("img/projectile/laser.png");
		projectile_bullet_img = getRes("img/projectile/bullet.png");

		tileObject_wall_wood_img = getRes("img/tileObject/wallWood.png");
		tileObject_wall_stone_img = getRes("img/tileObject/wallStone.png");
		tileObject_wall_iron_img = getRes("img/tileObject/wallIron.png");

		generator_wood_img = getRes("img/tileObject/generatorWood.png");
		generator_stone_img = getRes("img/tileObject/generatorStone.png");
		generator_iron_img = getRes("img/tileObject/generatorIron.png");
		generator_diamond_img = getRes("img/tileObject/generatorDiamond.png");

		storage_wood_img = getRes("img/tileObject/storageWood.png");
		storage_stone_img = getRes("img/tileObject/storageStone.png");
		storage_iron_img = getRes("img/tileObject/storageIron.png");
		storage_diamond_img = getRes("img/tileObject/storageDiamond.png");
		
		research_building_img = getRes("img/ui/research_building.png");
		research_iron_img = getRes("img/ui/research_iron.png");
		research_diamond_img = getRes("img/ui/research_diamond.png");
		research_gun_img = getRes("img/ui/research_gun.png");
		research_supergun_img = getRes("img/ui/research_supergun.png");
		research_regen_img = getRes("img/ui/research_regen.png");
		research_smallgun_img = getRes("img/ui/research_smallGun.png");
		
		tileObject_rocket_img = getRes("img/tileObject/rocketSilo.png");

	}

	public synchronized void remove(int index) {
		instance.entities.remove(index);
	}

	public synchronized static RenderableHolder getInstance() {
		return instance;
	}

	public synchronized List<IRenderable> getEntities() {
		return entities;
	}
}

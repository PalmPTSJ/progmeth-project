package model.storage;

import logic.ResourceManager;
import model.Tile;
import model.TileObject;

public abstract class Storage extends TileObject {
	
	private int resource;
	private int amount;
	
	public Storage(Tile tile, int sizeX, int sizeY, int hp, int resource, int amount) {
		super(tile, sizeX, sizeY, hp);
		this.resource = resource;
		this.amount = amount;
		ResourceManager.instance.addCapacity(resource, amount);
	}
	
	public void onDestroy() {
		super.onDestroy();
		ResourceManager.instance.addCapacity(resource,-amount);
	}

}

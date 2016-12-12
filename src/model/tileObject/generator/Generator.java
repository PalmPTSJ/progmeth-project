package model.tileObject.generator;

import model.Tile;
import model.tileObject.TileObject;

public abstract class Generator extends TileObject {

	private int resource = 0;
	private int amount = 0;
	private int resourceGenerateTimer = 0;
	private int resourceGenerateDelay = 0;

	public Generator(Tile tile, int sizeX, int sizeY, int hp, int resource, int delay, int amount) {
		super(tile, sizeX, sizeY, hp);
		this.resource = resource;
		this.resourceGenerateDelay = delay;
		this.amount = amount;
	}

	public void update() {
		super.update();
		if (resourceGenerateTimer < resourceGenerateDelay) {
			resourceGenerateTimer++;
		} else {
			logic.ResourceManager.instance.addResource(resource, amount);
			resourceGenerateTimer = 0;
		}
	}

}

/*
 * Unlock wood and stone storage
 */
package ui.research;

import logic.ResourceManager;
import model.RenderableHolder;

public class BuildingResearch extends ResearchItem {
	public BuildingResearch() {
		super(RenderableHolder.research_building_img, "Unlock wood & stone", new int[] { 0, 0, 0, 0, 25 });
	}

	@Override
	public void onResearchSuccess() {
		ResourceManager.instance.addCapacity(ResourceManager.WOOD, 5);
		ResourceManager.instance.addCapacity(ResourceManager.STONE, 5);
	}
}

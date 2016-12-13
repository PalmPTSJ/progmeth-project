/*
 * Unlock diamond storage
 */
package ui.research;

import logic.ResourceManager;
import model.RenderableHolder;

public class DiamondResearch extends ResearchItem {
	public DiamondResearch() {
		super(RenderableHolder.research_diamond_img, "Unlock diamond", new int[] { 50, 50, 30, 0, 2500 });
	}

	@Override
	public void onResearchSuccess() {
		ResourceManager.instance.addCapacity(ResourceManager.DIAMOND, 5);
	}
}

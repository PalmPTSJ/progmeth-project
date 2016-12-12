/*
 * Unlock iron storage
 */
package ui.research;

import logic.ResourceManager;
import model.RenderableHolder;

public class IronResearch extends ResearchItem {
	public IronResearch() {
		super(RenderableHolder.research_iron_img,"Unlock iron",new int[]{10,10,0,0,1000});
	}
	@Override
	public void onResearchSuccess() {
		ResourceManager.instance.addCapacity(ResourceManager.IRON, 5);
	}
}

package ui.research;

import logic.ResourceManager;
import model.RenderableHolder;

public class DiamondResearch extends ResearchItem {
	public DiamondResearch() {
		// TODO Auto-generated constructor stub
		super(RenderableHolder.research_diamond_img,"unlock diamond",new int[]{1,1,1,0,0});
	}
	@Override
	public void onResearchSuccess() {
		ResourceManager.instance.addCapacity(ResourceManager.DIAMOND, 10);
	}
}

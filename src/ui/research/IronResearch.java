package ui.research;

import logic.ResourceManager;
import model.RenderableHolder;

public class IronResearch extends ResearchItem {
	public IronResearch() {
		// TODO Auto-generated constructor stub
		super(RenderableHolder.enemy_img,"Unlock iron",new int[]{1,1,0,0,0});
	}
	@Override
	public void onResearchSuccess() {
		ResourceManager.instance.addCapacity(ResourceManager.IRON, 10);
	}
}

package ui.research;

import model.Player;
import model.RenderableHolder;

public class HealthRegenerationResearch extends ResearchItem {
	public HealthRegenerationResearch() {
		// TODO Auto-generated constructor stub
		super(RenderableHolder.research_regen,"Health Regeneration",new int[]{1,0,0,0,0});
	}
	@Override
	public void onResearchSuccess() {
		Player.setHealthRegenerationRate(10);
	}
}

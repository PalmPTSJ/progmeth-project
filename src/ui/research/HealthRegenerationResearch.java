package ui.research;

import model.Player;
import model.RenderableHolder;

public class HealthRegenerationResearch extends ResearchItem {
	public HealthRegenerationResearch() {
		super(RenderableHolder.research_regen,"Health Regeneration",new int[]{0,0,0,0,500});
	}
	@Override
	public void onResearchSuccess() {
		Player.setHealthRegenerationRate(10);
	}
}

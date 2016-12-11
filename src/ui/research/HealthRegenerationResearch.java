package ui.research;

import model.Player;
import model.ProjectilePlayerBullet;
import model.RenderableHolder;

public class HealthRegenerationResearch extends ResearchItem {
	public HealthRegenerationResearch() {
		// TODO Auto-generated constructor stub
		super(RenderableHolder.tower_sniper_img,"Health Regeneration",new int[]{1,0,0,0,0});
	}
	@Override
	public void onResearchSuccess() {
		Player.setHealthRegenerationRate(10);
	}
}

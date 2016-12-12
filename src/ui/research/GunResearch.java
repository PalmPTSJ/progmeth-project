package ui.research;

import model.RenderableHolder;
import model.projectile.ProjectilePlayerBullet;

public class GunResearch extends ResearchItem {
	public GunResearch() {
		super(RenderableHolder.research_gun,"Make your gun more powerful",new int[]{0,0,20,0,0});
	}
	@Override
	public void onResearchSuccess() {
		ProjectilePlayerBullet.addDamage(20);
	}
}

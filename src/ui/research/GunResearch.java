package ui.research;

import model.RenderableHolder;
import model.projectile.ProjectilePlayerBullet;

public class GunResearch extends ResearchItem {
	public GunResearch() {
		// TODO Auto-generated constructor stub
		super(RenderableHolder.research_gun,"Make your gun more powerful",new int[]{1,3,0,0,0});
	}
	@Override
	public void onResearchSuccess() {
		ProjectilePlayerBullet.addDamage(10);
	}
}

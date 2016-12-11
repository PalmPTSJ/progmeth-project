package ui.research;

import model.ProjectilePlayerBullet;
import model.RenderableHolder;

public class GunResearch extends ResearchItem {
	public GunResearch() {
		// TODO Auto-generated constructor stub
		super(RenderableHolder.projectile_bullet_img,"Make your gun more powerful",new int[]{1,3,0,0,0});
	}
	@Override
	public void onResearchSuccess() {
		ProjectilePlayerBullet.addDamage(10);
	}
}
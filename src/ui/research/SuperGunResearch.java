/*
 * Research SuperGun (Gun level 3)
 */
package ui.research;

import model.RenderableHolder;
import model.projectile.ProjectilePlayerBullet;

public class SuperGunResearch extends ResearchItem {
	public SuperGunResearch() {
		super(RenderableHolder.research_supergun_img, "Make your gun even a lot more powerful",
				new int[] { 0, 0, 0, 1, 0 });
	}

	@Override
	public void onResearchSuccess() {
		ProjectilePlayerBullet.addDamage(40);
	}
}

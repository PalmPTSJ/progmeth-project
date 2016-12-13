/*
 * Research SmallGun (Gun level 1)
 */
package ui.research;

import model.RenderableHolder;
import model.projectile.ProjectilePlayerBullet;

public class SmallGunResearch extends ResearchItem {
	public SmallGunResearch() {
		super(RenderableHolder.research_smallgun_img, "Make your gun more powerful", new int[] { 2, 2, 0, 0, 0 });
	}

	@Override
	public void onResearchSuccess() {
		ProjectilePlayerBullet.addDamage(10);
	}
}

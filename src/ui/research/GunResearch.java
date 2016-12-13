/*
 * Research Gun (Gun level 2)
 */
package ui.research;

import model.RenderableHolder;
import model.projectile.ProjectilePlayerBullet;

public class GunResearch extends ResearchItem {
	public GunResearch() {
		super(RenderableHolder.research_gun_img, "Make your gun even more powerful", new int[] { 0, 0, 1, 0, 0 });
	}

	@Override
	public void onResearchSuccess() {
		ProjectilePlayerBullet.addDamage(20);
	}
}

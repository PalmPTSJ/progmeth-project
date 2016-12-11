package model;

public class ProjectileBulletSniper extends ProjectileBullet {
	
	private static final double defaultWidth = 40;
	private static final double defaultHeight = 8;
	private static final double defaultSpeed = 20;
	private static final int defaultDamage = 120;
	
	public ProjectileBulletSniper(double x, double y, double targetX, double targetY) {
		super(x, y, targetX, targetY);
		this.width = defaultWidth;
		this.height = defaultHeight;
		this.speed = defaultSpeed;
		this.damage = defaultDamage;
	}

	public ProjectileBulletSniper(double x, double y, Entity target) {
		super(x, y, target);
		this.width = defaultWidth;
		this.height = defaultHeight;
		this.speed = defaultSpeed;
		this.damage = defaultDamage;
	}

}

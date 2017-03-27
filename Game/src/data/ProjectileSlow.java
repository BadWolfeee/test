package data;

public class ProjectileSlow extends Projectile {

	public ProjectileSlow(ProjectileType type, Enemy target, float x, float y, int width, int height) {
		super(type, target, x, y, width, height);
	}
	
	@Override
	public void damage(){
		super.getTarget().setSpeed(4f);
		super.damage();
	}

}

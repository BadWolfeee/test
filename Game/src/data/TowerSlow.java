package data;

import java.util.concurrent.CopyOnWriteArrayList;

public class TowerSlow extends Tower {

	public TowerSlow(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
	}
	@Override 
	public void shoot(Enemy target){
		super.projectiles.add(new ProjectileSlow(super.type.projectileType, super.target, super.getX(),super.getY(),32,32));
		super.target.reduceHiddenHelth(super.type.projectileType.damage);
	}
}
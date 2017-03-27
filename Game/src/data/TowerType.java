package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;

public enum TowerType {
	
	Cannon(new Texture[]{QuickLoad("TowerBase"), QuickLoad("Cannon")}, ProjectileType.CannonBall, 10, 1000, 3, 0),
	CannonBlack(new Texture[]{QuickLoad("TowerBaseBlack"), QuickLoad("CannonBlack")}, ProjectileType.CannonBall, 30, 1000, 3, 15),
	CannonSlow(new Texture[]{QuickLoad("TowerBaseSlow"), QuickLoad("CannonSlow")}, ProjectileType.TarBall, 30, 1000, 3, 20);
	
	Texture[] textures;
	ProjectileType projectileType;
	int damage, range, cost;
	float firingSpeed;
	
	TowerType(Texture[] textures, ProjectileType projectileType, int damage, int range, float firingSpeed, int cost){
		this.textures= textures;
		this.projectileType= projectileType;
		this.damage= damage;
		this.range= range;
		this.firingSpeed= firingSpeed;
		this.cost= cost;
	}
	
}

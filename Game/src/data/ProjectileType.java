package data;

import org.newdawn.slick.opengl.Texture;
import static helpers.Artist.*;

public enum ProjectileType {
		
		CannonBall(QuickLoad("Bullet"), 10, 500),
		TarBall(QuickLoad("BulletSlow"), 6, 450);
		
		Texture texture;
		int damage;
		float speed;
		
		ProjectileType(Texture texture, int damage, float speed){
			this.texture= texture;
			this.damage= damage;
			this.speed= speed;
		}
		
}

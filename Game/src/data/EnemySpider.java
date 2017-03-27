package data;

public class EnemySpider extends Enemy {

	public EnemySpider(int tileX, int tileY, TileGrid grid) {
		super(tileX, tileY, grid);
		this.setTexture("Enemy");
		this.setSpeed(100);
		this.setHealth(20);
	}

}

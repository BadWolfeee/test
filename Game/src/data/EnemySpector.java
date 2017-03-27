package data;

public class EnemySpector extends Enemy{

	public EnemySpector(int tileX, int tileY, TileGrid grid) {
		super(tileX, tileY, grid);
		super.setTexture("Enemy");
	}

}

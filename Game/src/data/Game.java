package data;

import static helpers.Artist.QuickLoad;
import static helpers.Artist.TILE_SIZE;
import static helpers.Artist.DrawQuadTex;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import UI.UI;
import UI.UI.Menu;
import helpers.StateManager;

public class Game {
	
	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	private UI gameUI;
	private Menu towerPickerMenu;
	private Texture menuBackground;
	private Enemy[] enemyTypes;
	
	public Game(TileGrid grid){
		this.grid= grid;
		enemyTypes = new Enemy[3];
		enemyTypes[0]= new EnemyGhost(10, 11, grid);
		enemyTypes[1]= new EnemySpider(10, 11, grid);
		enemyTypes[2]= new EnemySpector(10, 11, grid);
		waveManager = new WaveManager(enemyTypes, 3, 3);
		player= new Player(grid, waveManager);
		player.setup();
		setupUI();
		this.menuBackground=QuickLoad("MenuBack");
	}
	
	private void setupUI(){
		gameUI = new UI();
		gameUI.createMenu("TowerPicker", 1214, 0, 152, 768, 2, 0 );
		towerPickerMenu = gameUI.getMenu("TowerPicker");
		towerPickerMenu.quickAdd("CannonBlack", "TowerBlackFull");
		towerPickerMenu.quickAdd("CannonSlow", "TowerSlowFull");
	}
	
	private void updateUI(){
		gameUI.draw();
		gameUI.drawString(1234, 600, "Lives: " + Player.Lives);
		gameUI.drawString(1234, 650, "Gold: " + Player.Gold);
		gameUI.drawString(0, 0, "fps " + StateManager.framesInLastSecond);
		gameUI.drawString(1234, 700, "Wave: " + waveManager.getWaveNumber());
		
		if(Mouse.next()){
			boolean mouseClicked = Mouse.isButtonDown(0);
			if(mouseClicked){
		if(towerPickerMenu.isButtonClicked("CannonBlack"))
			player.pickTower(new TowerCannonBlack(TowerType.CannonBlack, grid.getTile( 0, 0), waveManager.getCurrentWave().getEnemyList()));
		if(towerPickerMenu.isButtonClicked("CannonSlow"))
			player.pickTower(new TowerSlow(TowerType.CannonSlow, grid.getTile( 0, 0), waveManager.getCurrentWave().getEnemyList()));		
			}
		}
	}
	
	public void update(){
		DrawQuadTex(menuBackground, 1174, 0, 192, 960);
		grid.draw();
		waveManager.update();
		player.update();
		updateUI();
	}

}

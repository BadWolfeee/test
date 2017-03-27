package data;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import helpers.Clock;

import static helpers.Artist.*;

import java.util.ArrayList;

public class Player {
	private TileGrid grid;
	private TileType[] types;
	private WaveManager waveManager;
	private ArrayList<Tower> towerList;
	private boolean leftMouseButtonDown, rightMouseButtonDown, holdingTower;
	private Tower tempTower;
	public static int Gold, Lives;
	
	public Player(TileGrid grid, WaveManager waveManager) {
		this.grid = grid;
		this.types = new TileType[3];
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Dirt;
		this.types[2] = TileType.Water;
		this.waveManager = waveManager;
		this.towerList = new ArrayList<Tower>();
		this.leftMouseButtonDown = false;
		this.rightMouseButtonDown = false;
		this.holdingTower= false;
		this.tempTower= null;
		Gold = 0;
		Lives = 0;
		
	}
	// init gold and live
	public void setup(){
		Gold = 250;
		Lives = 10;
	}
	
	public static boolean modifyGold(int amount){
		if(Gold + amount >= 0){
			System.out.println(Gold);
			Gold += amount;
			return true;
		}
		System.out.println(Gold);
		return false;
	}
	
	public static void modifyLives( int amount){
		Lives += amount;
	}

	public void update() {
		//update holding tower
		if (holdingTower){
			tempTower.setX(getMouseTile().getX());
			tempTower.setY(getMouseTile().getY());
			tempTower.draw();
		}
		//update all towers in game
		for (Tower t : towerList) {
			t.update();
			t.draw();
			t.updateEnemyList(waveManager.getCurrentWave().getEnemyList());
		}
		// handle mouse
		if (Mouse.isButtonDown(0) && !leftMouseButtonDown) {
			placeTower();
		}
		
		if (Mouse.isButtonDown(1) && !rightMouseButtonDown) {
		}
		leftMouseButtonDown = Mouse.isButtonDown(0);
		rightMouseButtonDown = Mouse.isButtonDown(1);
		
		// handle keyboard
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				Clock.ChangeMultiplier(0.2f);
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()) {
				Clock.ChangeMultiplier(-0.2f);
			}
		}
	}
	
	private void placeTower(){
		Tile currentTile = getMouseTile();
		if(holdingTower)
			if(!currentTile.getOccupied() && modifyGold(-tempTower.getCost())){
				towerList.add(tempTower);
				currentTile.setOccupied(true);
				holdingTower= false;
				tempTower= null;
		}
	}
	
	public void pickTower(Tower t){
		tempTower = t;
		holdingTower= true;
	}
	
	private Tile getMouseTile(){
		return grid.getTile(Mouse.getX() / TILE_SIZE, (HEIGHT - Mouse.getY() - 1) / TILE_SIZE);
	}
}

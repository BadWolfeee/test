package data;

import static helpers.Artist.DrawQuadTex;
import static helpers.Artist.HEIGHT;
import static helpers.Artist.QuickLoad;
import static helpers.Artist.TILE_SIZE;
import static helpers.Leveler.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import UI.UI;
import UI.UI.Menu;

public class Editor {

	private TileGrid grid;
	private int index;
	private TileType[] types;
	private UI editorUI;
	private Menu tilePickerMenu;
	private Texture menuBackground;

	public Editor() {
		this.grid = LoadMap("NewMap1");
		this.index = 0;
		this.types = new TileType[3];
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Dirt;
		this.types[2] = TileType.Water;
		this.menuBackground =QuickLoad("MenuBack");
		setupUI();
	}

	private void setupUI() {
		editorUI = new UI();
		editorUI.createMenu("TilePicker", 1214, 0, 152, 768, 2, 0);
		tilePickerMenu = editorUI.getMenu("TilePicker");
		tilePickerMenu.quickAdd("Grass", "Grass");
		tilePickerMenu.quickAdd("Dirt", "Dirt");
		tilePickerMenu.quickAdd("Water", "Water");
	}

	public void update() {
		draw();

		if (Mouse.next()) {
			boolean mouseClicked = Mouse.isButtonDown(0);
			if (mouseClicked) {
				if (tilePickerMenu.isButtonClicked("Grass")) {
					index = 0;
				} else if (tilePickerMenu.isButtonClicked("Dirt")) {
					index = 1;
				}else if (tilePickerMenu.isButtonClicked("Water")) {
					index = 2;
				}  else {
					setTile();
				}
			}
		}
		// handle keyboard
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				moveIndex();
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_S && Keyboard.getEventKeyState()) {
				SaveMap("NewMap1", grid);
			}
		}
	}

	private void draw() {
		DrawQuadTex(menuBackground , 1174, 0, 192, 960);
		grid.draw();
		editorUI.draw();
	}

	private void setTile() {
		grid.setTile((int) Math.floor(Mouse.getX() / TILE_SIZE),
				(int) Math.floor((HEIGHT - Mouse.getY() - 1) / TILE_SIZE), types[index]);
	}

	// Allows editor to change which TileType is selected
	private void moveIndex() {
		index++;
		if (index > types.length - 1) {
			index = 0;
		}
	}
}

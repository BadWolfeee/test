package data;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import UI.UI;
import helpers.StateManager;
import helpers.StateManager.GameState;

import static helpers.Artist.*;

public class MainMenu {
	
	private Texture background;
	private UI menuUI;
	
	public MainMenu(){
		background = QuickLoad("Minemenu");
		menuUI= new UI();
		menuUI.addButton("Play", "Play", WIDTH  / 2 - 210,(int) (HEIGHT * 0.55f));
		menuUI.addButton("Editor", "Editor", WIDTH / 2 - 210,(int) (HEIGHT * 0.65f));
		menuUI.addButton("Quit", "Quit", WIDTH / 2 - 210,(int) (HEIGHT * 0.75f));
	}
	//check if button is clicked, do action
	private void updateButtons(){
		if(Mouse.isButtonDown(0)){
			if(menuUI.isButtonClicked("Play"))
				StateManager.setState(GameState.GAME);
			if(menuUI.isButtonClicked("Editor"))
				StateManager.setState(GameState.EDITOR);
			if(menuUI.isButtonClicked("Quit"))
				System.exit(0);
		}
	}
	
	public void update(){
		DrawQuadTex(background, 0, 0, 2048, 1024);
		menuUI.draw();
		updateButtons();
	}
}

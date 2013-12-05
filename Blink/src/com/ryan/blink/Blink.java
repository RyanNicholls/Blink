package com.ryan.blink;

import com.badlogic.gdx.Game;
import com.ryan.blink.Screens.GameScreen;

public class Blink extends Game {

	public GameScreen gameScreen;

	@Override
	public void create() {
		
		gameScreen=new GameScreen(this);
		
		setScreen(gameScreen);
		
		
	}
	
	@Override
	public void render()
	{
		super.render();
	}

}

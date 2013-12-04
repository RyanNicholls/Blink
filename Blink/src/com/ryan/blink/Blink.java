package com.ryan.blink;

import com.badlogic.gdx.Game;

public class Blink extends Game {

	public GameScreen gameScreen;
	
	@Override
	public void create() {
		gameScreen=new GameScreen(this);
		
		setScreen(gameScreen);
		
	}

}

package com.ryan.blink;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {
	public Blink game;
	OrthographicCamera camera;
	SpriteBatch batch;
	
	
	Texture textureScreen;
	Sprite spriteScreen;
	
	public GameScreen(Blink game)
	{
		this.game= game;
		
		camera= new OrthographicCamera();
		camera.setToOrtho(true,1920,1080);
		
		batch=new SpriteBatch();
	}
	
	@Override
	public void render(float delta) {
		camera.update();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}

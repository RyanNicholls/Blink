package com.ryan.blink.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.ryan.blink.Assets;
import com.ryan.blink.Blink;

public class GameScreen implements Screen {
	
	Blink game;
	IsometricTiledMapRenderer renderer;
	OrthographicCamera camera;
	SpriteBatch batch;
	
	

	
	public GameScreen(Blink game)
	{
		this.game= game;
		
		camera= new OrthographicCamera();
		camera.setToOrtho(true,1920,1080);
		
		batch=new SpriteBatch();
		Assets.load();
		
	}
	
	@Override
	public void render(float delta) {
		
		//clears screen to white-ish gray
		Gdx.gl.glClearColor(0.95F, 0.95F, 0.95F, 0.95F);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		renderer=new IsometricTiledMapRenderer(Assets.caveMap);
		renderer.render();
		batch.setProjectionMatrix(camera.combined);
	
		batch.begin();
			//batch.draw(Assets.spriteScreen, 0, 0);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		
		
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

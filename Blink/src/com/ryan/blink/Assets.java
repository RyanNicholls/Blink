package com.ryan.blink;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Assets {

	public static Texture textureScreen;
	public static Sprite spriteScreen;
	public static TiledMap caveMap;
	
	public static void load()
	{
		
		textureScreen=new Texture(Gdx.files.internal("assets/back.png"));
		textureScreen.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		spriteScreen=new Sprite(textureScreen);
		spriteScreen.flip(false, true);
		TmxMapLoader loader=new TmxMapLoader();
		Assets.caveMap= loader.load("assets/cavemap2.tmx");
		
	}
	
}

package com.ryan.blink;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.ryan.blink.Entities.Player;

public class Assets {

	public static Texture textureScreen;
	public static Sprite spriteScreen;
	public static TiledMap caveMap;
	public static Sprite player;
	
	public static void load()
	{
		
		textureScreen=new Texture(Gdx.files.internal("assets/back.png"));
		textureScreen.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		spriteScreen=new Sprite(textureScreen);
		spriteScreen.flip(false, true);
		
		
		TmxMapLoader loader=new TmxMapLoader();
		Assets.caveMap= loader.load("assets/cavemap2.tmx");
		
		
		player=new Player(new Sprite(new Texture("assets/simpleSprite.png")), (TiledMapTileLayer)caveMap.getLayers().get(0));
		player.setPosition(7 * ((Player) player).getCollisionLayer().getTileWidth(), (((Player) player).getCollisionLayer().getHeight() - 38) *  ((Player) player).getCollisionLayer().getTileWidth());
		
	}
	
}

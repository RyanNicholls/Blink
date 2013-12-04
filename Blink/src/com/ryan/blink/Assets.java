package com.ryan.blink;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Assets {

	public static Texture textureScreen;
	public static Sprite spriteScreen;
	
	public static void load()
	{
		
		textureScreen=new Texture(Gdx.files.internal("menu/back.png"));
		textureScreen.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		spriteScreen=new Sprite(textureScreen);
		spriteScreen.flip(false, true);
		
	}
	
}

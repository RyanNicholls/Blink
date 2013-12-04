package com.ryan.blink;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Assets {

	public static void load()
	{
		
		Texture textureScreen;
		Sprite spriteScreen;
		
		
		textureScreen=new Texture(Gdx.files.internal("menu/background.png"));
		textureScreen.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		spriteScreen=new Sprite(textureScreen);
		spriteScreen.flip(false, true);
	}
	
}

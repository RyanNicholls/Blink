package com.ryan.blink.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite{

	private Vector2 velocity=new Vector2();
	private float speed = 60 * 2;
	private float gravity = 60 * 1.0F;
	
	private TiledMapTileLayer collisionLayer;
	
	public Player (Sprite sprite, TiledMapTileLayer collisionLayer)
	{
		super(sprite);
		this.collisionLayer = collisionLayer;
	}
	
	@Override
	public void draw(SpriteBatch batch)
	{
		
		update(Gdx.graphics.getDeltaTime());
		super.draw(batch);
		
	}
	
	public void update(float delta)
	{
		//gravity
		velocity.y-=gravity*delta;
		
		//clamp velocity
		if(velocity.y > speed)
		{
			velocity.y=speed;
		}else if(velocity.y < -speed)
		{
			velocity.y = -speed;
		}
		
		
		//save old poition
		float oldX=getX();
		float oldY=getY();
		float tileWidth = collisionLayer.getTileWidth();
		float tileHeight = collisionLayer.getTileHeight();
		
		boolean collidedX = false;
		boolean collidedY = false;
		
		//move on x
		setX(getX() + velocity.x * delta);
		
		if(velocity.x < 0)//if moving left
		{
			// check top left
			collidedX = collisionLayer.getCell((int)(getX() / tileWidth),
											   (int) ((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
			//check mid left
			if(!collidedX){
			collidedX = collisionLayer.getCell((int)(getX() / tileWidth),
					   (int) ((getY() + getHeight() /2)/ tileHeight)).getTile().getProperties().containsKey("blocked");}
			//check bottom left
			if(!collidedX){
			collidedX = collisionLayer.getCell((int)(getX() / tileWidth),
					   (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");}
		}else if(velocity.x > 0)//if moving right
		{
			//check top right
			collidedX = collisionLayer.getCell((int)((getX() + getWidth())+tileWidth),
					   (int) ((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
			//check mid right
			if(!collidedX){
				collidedX = collisionLayer.getCell((int)((getX() + getWidth()) / tileWidth),
						   (int) ((getY() + getWidth() / 2) / tileHeight)).getTile().getProperties().containsKey("blocked");}
			//check bottom right
			if(!collidedX){
				collidedX = collisionLayer.getCell((int)((getX() + getWidth()) / tileWidth),
						   (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");}
		}
		
		//move on y
		setY(getY() + velocity.y * delta);
		
		if(velocity.y < 0)//down
		{
			//bottom left
			//bottom mid/
			//bottom right
		}else if(velocity.y > 0)//up
		{
			
		}
		//
	}
	
}

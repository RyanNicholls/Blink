package com.ryan.blink.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
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
	public void draw(SpriteBatch spriteBatch) {
		update(Gdx.graphics.getDeltaTime());
		super.draw(spriteBatch);
	}

	public void update(float delta) {
		// apply gravity
		velocity.y -= gravity * delta;

		// clamp velocity
		if(velocity.y > speed)
			velocity.y = speed;
		else if(velocity.y < -speed)
			velocity.y = -speed;

		// save old position
		float oldX = getX(), oldY = getY();
		boolean collisionX = false, collisionY = false;

		// move on x
		setX(getX() + velocity.x * delta);

		if(velocity.x < 0) // going left
			collisionX = collidesLeft();
		else if(velocity.x > 0) // going right
			collisionX = collidesRight();

		// react to x collision
		if(collisionX) {
			setX(oldX);
			velocity.x = 0;
		}

		// move on y
		setY(getY() + velocity.y * delta * 5f);

		if(velocity.y < 0) // going down
			collisionY = collidesBottom();
		else if(velocity.y > 0) // going up
			collisionY = collidesTop();

		// react to y collision
		if(collisionY) {
			setY(oldY);
			velocity.y = 0;
		}

		
	}

	private boolean isCellBlocked(float x, float y) {
		Cell cell = collisionLayer.getCell((int) (x / collisionLayer.getTileWidth()), (int) (y / collisionLayer.getTileHeight()));
		return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey("blocked");
	}

	public boolean collidesRight() {
		for(float step = 0; step < getHeight(); step += collisionLayer.getTileHeight() / 2)
			if(isCellBlocked(getX() + getWidth(), getY() + step))
				return true;
		return false;
	}

	public boolean collidesLeft() {
		for(float step = 0; step < getHeight(); step += collisionLayer.getTileHeight() / 2)
			if(isCellBlocked(getX(), getY() + step))
				return true;
		return false;
	}

	public boolean collidesTop() {
		for(float step = 0; step < getWidth(); step += collisionLayer.getTileWidth() / 2)
			if(isCellBlocked(getX() + step, getY() + getHeight()))
				return true;
		return false;

	}

	public boolean collidesBottom() {
		for(float step = 0; step < getWidth(); step += collisionLayer.getTileWidth() / 2)
			if(isCellBlocked(getX() + step, getY()))
				return true;
		return false;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getGravity() {
		return gravity;
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

	public TiledMapTileLayer getCollisionLayer() {
		return collisionLayer;
	}

	public void setCollisionLayer(TiledMapTileLayer collisionLayer) {
		this.collisionLayer = collisionLayer;
	}
	
}

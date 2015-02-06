package com.me.Tutorial;


import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class banana {

    Vector2 position;
	Texture texture;
	Rectangle bounds;
	private Random random;

	
	public banana()
	{
		random = new Random();
		this.position = new Vector2(random.nextInt(Gdx.graphics.getWidth()), random.nextInt(Gdx.graphics.getHeight() - Gdx.graphics.getHeight()/2 - Gdx.graphics.getHeight() /4) + (Gdx.graphics.getHeight()/3)*2);
		bounds = new Rectangle(position.x, position.y, 20, 20);
		Texture.setEnforcePotImages(false); //set picture don't have to be power of 2
		texture = new Texture(Gdx.files.internal("banana.png"));
	}
	
	public void update()
	{
		bounds.set(position.x,position.y, 20, 20);
		if(position.y > 50)
			position.y -= 2f;
	}

	public void random() {
		
	}
    
	public Rectangle getBounds() {
		return bounds;
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	
}

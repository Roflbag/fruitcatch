package com.me.Tutorial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Kirby_menu {
	
	Vector2 position;
	Texture texture;
	
	private static final int col = 8;
	private static final int row = 4;
	
	Animation animation;
	
	Texture kirbyTexture;
	TextureRegion [] frames;
	TextureRegion currentFrame;
	float stateTime;
	
	public Kirby_menu(Vector2 position, String textureLoc){
		this.position = position;
		//this.texture = new Texture(Gdx.files.internal(textureLoc));
		Texture.setEnforcePotImages(false);
		kirbyTexture = new Texture(Gdx.files.internal(textureLoc));
		TextureRegion[][] tmp = TextureRegion.split(kirbyTexture, kirbyTexture.getWidth()/col, kirbyTexture.getHeight()/row);
		frames = new TextureRegion[col*row];
		
		int index = 0;
		for(int i = 0; i<row;i++){
			for(int j = 0 ; j < col; j++){
				frames[index++] = tmp[i][j];
			}
		}
		
		animation = new Animation(1f,frames);
		stateTime = 0f;
		currentFrame = animation.getKeyFrame(0);
		
	}


	public void update()
	{
		if (stateTime >= 32)
			stateTime = 0;
		stateTime += Gdx.graphics.getDeltaTime()*2;
		currentFrame = animation.getKeyFrame(0 + stateTime);
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


	public Animation getAnimation() {
		return animation;
	}


	public void setAnimation(Animation animation) {
		this.animation = animation;
	}


	public TextureRegion[] getFrames() {
		return frames;
	}


	public void setFrames(TextureRegion[] frames) {
		this.frames = frames;
	}


	public TextureRegion getCurrentFrame() {
		return currentFrame;
	}


	public void setCurrentFrame(TextureRegion currentFrame) {
		this.currentFrame = currentFrame;
	}


	public float getStateTime() {
		return stateTime;
	}


	public void setStateTime(float stateTime) {
		this.stateTime = stateTime;
	}	
	
}



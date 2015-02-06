package com.me.Tutorial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Mage {

    Vector2 position;
	Texture texture;
	
	private static final int col = 5;
	private static final int row = 2;
	
	Animation animation;
	
	Texture playerTexture;
	TextureRegion[] frames;
	TextureRegion currentFrame;
	float stateTime;
	int side;
	
	public Mage(Vector2 position, String textureLoc){
		this.position = position;
		//this.texture = new Texture(Gdx.files.internal(textureLoc));
		Texture.setEnforcePotImages(false);
		playerTexture = new Texture(Gdx.files.internal(textureLoc));
		TextureRegion[][] tmp = TextureRegion.split(playerTexture,playerTexture.getWidth()/col,playerTexture.getHeight()/row);
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
	
	public void update(){
		
	
		stateTime += Gdx.graphics.getDeltaTime()*5;
	
		

		if (Global.xlowbound <= position.x && position.x <= Global.xupbound)
		{

			//Not moving, facing left or right determined by "side". 1 for right, 0 for left
			if 	(Gdx.input.getAccelerometerY()<1 && Gdx.input.getAccelerometerY()>-1 && side == 1)
				currentFrame = animation.getKeyFrame(5);
			
			if 	(Gdx.input.getAccelerometerY()<1 && Gdx.input.getAccelerometerY()>-1 && side == 0)
				currentFrame = animation.getKeyFrame(0);
			
			
			if (Gdx.input.getAccelerometerY() > 1)
				{
					position.x += 5f;
					currentFrame = animation.getKeyFrame(6+stateTime%4);	
					side = 1;  //Last time facing right
				}
			
			if (Gdx.input.getAccelerometerY() < -1)
				{
					position.x -= 5f;
					currentFrame = animation.getKeyFrame(1+stateTime%4);
					side = 0;  //Last time facing left
				}

			//Boundaries
			if (position.x <= Global.xlowbound)
			{
				position.x = Global.xlowbound;
				currentFrame = animation.getKeyFrame(0);
			}
			if (position.x >= Global.xupbound)
			{
				position.x = Global.xupbound;
				currentFrame = animation.getKeyFrame(5);
			}

		}	
		
			
			
			
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

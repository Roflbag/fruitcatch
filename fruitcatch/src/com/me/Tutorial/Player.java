package com.me.Tutorial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player {

    Vector2 position;
	Texture texture;
	//String textureLoc;
	
	private static final int col = 5;
	private static final int row = 2;
	
	int side = 0;
	
	Animation right;
	
	Texture playerTexture_right;

	TextureRegion []  frames;
	
	float stateTime;
	
	TextureRegion currentFrame;
	
	
	
	public Player(Vector2 position, String textureLoc)
	{
		this.position = position;
		Texture.setEnforcePotImages(false); //set picture don't have to be power of 2
		//this.texture = new Texture(Gdx.files.internal(textureLoc));
		
		playerTexture_right = new Texture(Gdx.files.internal("megaman_run.png"));
		TextureRegion[][] temp = TextureRegion.split(playerTexture_right, playerTexture_right.getWidth()/col, playerTexture_right.getHeight()/row);
		frames = new TextureRegion[col*row];
		
		int index = 0;
		for(int i=0; i<row; i++)
		{
			for (int j=0; j<col; j++)
			{
				frames[index++] = temp[i][j];
			}
		}
		
		
		right = new Animation(1f, frames); //DONT CHANGE THE TIME IT WILL FK UP THE ANIMATION
		
		stateTime = 0f;
		
		currentFrame = right.getKeyFrame(0);

	}
	
	public void update()
	{

			
		stateTime += Gdx.graphics.getDeltaTime()*4;
	
		if (Global.xlowbound <= position.x && position.x <= Global.xupbound)
		{

			//Not moving, facing left or right determined by "side". 1 for right, 0 for left
			if 	(Gdx.input.getAccelerometerY()<1 && Gdx.input.getAccelerometerY()>-1 && side == 1)
				currentFrame = right.getKeyFrame(0);
			
			if 	(Gdx.input.getAccelerometerY()<1 && Gdx.input.getAccelerometerY()>-1 && side == 0)
				currentFrame = right.getKeyFrame(5);
			
			
			if (Gdx.input.getAccelerometerY() > 1)
				{
					position.x += 5f;
					currentFrame = right.getKeyFrame(1+stateTime%4);	
					side = 1;  //Last time facing right
				}
			
			if (Gdx.input.getAccelerometerY() < -1)
				{
					position.x -= 5f;
					currentFrame = right.getKeyFrame(6+stateTime%4);
					side = 0;  //Last time facing left
				}

			//Boundaries
			if (position.x <= Global.xlowbound)
			{
				position.x = Global.xlowbound;
				currentFrame = right.getKeyFrame(5);
			}
			if (position.x >= Global.xupbound)
			{
				position.x = Global.xupbound;
				currentFrame = right.getKeyFrame(0);
			}

		}	
	}





	public Animation getRight() {
		return right;
	}

	public void setRight(Animation right) {
		this.right = right;
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

	public TextureRegion[] getFrames() {
		return frames;
	}

	public void setFrames(TextureRegion[] frames) {
		this.frames = frames;
	}


	public float getStateTime() {
		return stateTime;
	}

	public void setStateTime(float stateTime) {
		this.stateTime = stateTime;
	}


	public TextureRegion getCurrentFrame() {
		return currentFrame;
	}

	public void setCurrentFrame(TextureRegion currentFrame) {
		this.currentFrame = currentFrame;
	}

	
}

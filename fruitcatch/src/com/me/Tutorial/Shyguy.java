package com.me.Tutorial;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Shyguy {

    Vector2 position;
	Texture texture;
	
	private static final int col = 5;
	private static final int row = 2;
	
	Animation animation;
	
	Texture playerTexture;
	TextureRegion[] frames;
	TextureRegion currentFrame;
	float stateTime;
	Rectangle bounds;
	
	String movement;
	boolean swapping;
	int isSwapped;
	int side;
	
	public Shyguy(Vector2 position, String textureLoc){
		this.position = position;
		movement = "";
		isSwapped = 0;
		swapping = false;
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
		bounds = new Rectangle(position.x,position.y,currentFrame.getRegionWidth(),currentFrame.getRegionHeight());
	}
	
	public void update(){
		
		bounds.set(position.x,position.y,currentFrame.getRegionWidth(),currentFrame.getRegionHeight());
		stateTime += Gdx.graphics.getDeltaTime()*5;
		
		if (position.x <= 0)
		{
			position.x = 0;
			currentFrame = animation.getKeyFrame(1);
		}
		if (position.x >= Gdx.graphics.getWidth()-currentFrame.getRegionWidth())
		{
			position.x = Gdx.graphics.getWidth()-currentFrame.getRegionWidth();
			currentFrame = animation.getKeyFrame(1);
		}
		
		if(!swapping){
			if(Gdx.input.getAccelerometerY()<1 && Gdx.input.getAccelerometerY()>-1)
			{
				currentFrame = animation.getKeyFrame(1);
				movement = "still";
			}

			if(Gdx.input.getAccelerometerY() < -1)
		{
				position.x = position.x - 5f;	
				movement = "left";
				currentFrame = animation.getKeyFrame(2+stateTime%2);
			}

			if(Gdx.input.getAccelerometerY() > 1)
			 {
				position.x = position.x + 5f;
				movement = "right";
				currentFrame = animation.getKeyFrame(7+stateTime%2);
			}
		}else if (swapping){
			currentFrame = animation.getKeyFrame(0);
			if(isSwapped == 0){
				position.x +=3f;
			}else{
				position.x -=3f;
			}

		}
		
		
		if (PlayScreen.finish_position == 1)
		{
			currentFrame = animation.getKeyFrame(6);
		}

//		if(Gdx.input.isTouched()){
//			System.out.println("Application Clicked");
//		}
			/*
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
		*/
		
	}
	


	public void reAdjust(){
		if(movement =="left"){
			position.x += 8f;
			//currentFrame = animation.getKeyFrame(0);
		}
		if(movement =="right"){
			position.x -= 8f;
			//currentFrame = animation.getKeyFrame(5);
		}
		if(movement == "still" && isSwapped == 0){
			position.x +=5f;
		}
		if(movement == "still" && isSwapped != 0){
			position.x -=5f;
		}
	}
	
	
	
	
	
	public boolean isSwapping() {
		return swapping;
	}

	public void setSwapping(boolean swapping) {
		this.swapping = swapping;
	}
	
	public int getIsSwapped() {
		return isSwapped;
	}

	public void setIsSwapped(int isSwapped) {
		this.isSwapped = isSwapped;
	}


	public void set_shyX(float x ) {
		this.position.x= x;
	}
	
	public String getMovement() {
		return movement;
	}

	public void setMovement(String movement) {
		this.movement = movement;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
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
package com.me.Tutorial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Title {
	
	public static Texture titleTexture;
	public static Texture titleBackground;
	
	public static Texture finishTexture;
	public static Texture finishBackground;
	
	public static Texture selectTexture;
	public static Texture selectBackground;
	

public Title(Vector2 position, String textureLoc)
{
	Texture.setEnforcePotImages(false);
	titleTexture = new Texture(Gdx.files.internal("title.png"));
	titleBackground = new Texture(Gdx.files.internal("titlescreen.png"));
	
	finishTexture = new Texture(Gdx.files.internal("finish_text.png"));
	finishBackground = new Texture(Gdx.files.internal("finish_background.png"));
	
	selectTexture = new Texture(Gdx.files.internal("title.png"));
	selectBackground = new Texture(Gdx.files.internal("player_select.png"));
	
}


}
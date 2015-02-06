package com.me.Tutorial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Background {
	
	public static Texture backgroundTexture;

	

public Background(Vector2 position, String textureLoc)
{
	Texture.setEnforcePotImages(false);
	backgroundTexture = new Texture(Gdx.files.internal("8bitwhispy.png"));

}


}


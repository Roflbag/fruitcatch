package com.me.Tutorial;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class Button {
	TextureAtlas buttonAtlas;
	TextButtonStyle buttonStyle;
	TextButton button;
	Skin skin;
	BitmapFont font;
	
	/* Text= text being show on the button, Button_loc = button's pack loaction, pos_x, pos_y = position, size_x, size_y = button size
	  */
	
	public Button( String notpress, String pressed, String Text,String font_loc, String button_loc, int pos_x, int pos_y, int size_x, int size_y)
	{ 
	
		font = new BitmapFont(Gdx.files.internal(font_loc),false);
		skin = new Skin();
		buttonAtlas= new TextureAtlas(button_loc);
		skin.addRegions(buttonAtlas);

		buttonStyle = new TextButtonStyle();
		buttonStyle.up = skin.getDrawable(notpress);
		buttonStyle.down = skin.getDrawable(pressed);
		buttonStyle.font= font;
		button = new TextButton(Text, buttonStyle);
		button.setPosition(pos_x, pos_y);
		if( !(size_x == 0|| size_y ==0))
			button.setSize(size_x, size_y);
	 	
	}

	public void addListener(InputListener inputListener) {
		// TODO Auto-generated method stub
		
	}
	

}

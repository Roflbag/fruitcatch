package com.me.Tutorial;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class Player_Select implements Screen{

	Game game;
	
	SpriteBatch batch;
	
	Title selectText;
	Title selectBackground;
	
	Button shyguy_button;
	Button kirby_button;
	Button mega_button;
	Button mage_button;
	
	public static int select_number = 0;
	
	Shyguy shyguy;
	Kirby kirby;
	
	BitmapFont font_kirby;
	BitmapFont font_shyguy;
	
	Stage stage;
	
	
	public Player_Select(Game game){
		this.game = game;
		}
	
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		selectText = new Title(new Vector2(0,0), "title.png");
		selectBackground = new Title(new Vector2(0,0), "player_select.png");
	
		stage = new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), false);
		
		mega_button = new Button("button", "buttonpressed", " ", "font.fnt", "buttons/button.pack",Gdx.graphics.getWidth()/3  + Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/11, 150, 50);
		kirby_button = new Button("button", "buttonpressed", " ", "font.fnt", "buttons/button.pack",Gdx.graphics.getWidth()/3 + Gdx.graphics.getWidth()/12 + Gdx.graphics.getWidth()/5,Gdx.graphics.getHeight()/11, 150, 50);
		shyguy_button = new Button("button", "buttonpressed", " ", "font.fnt", "buttons/button.pack",Gdx.graphics.getWidth()/3 + + Gdx.graphics.getWidth()/20 ,Gdx.graphics.getHeight()/11, 150, 50);
		mage_button = new Button("button", "buttonpressed", " ", "font.fnt", "buttons/button.pack",Gdx.graphics.getWidth()/6 ,Gdx.graphics.getHeight()/11, 150, 50);
		
		select_number = 0;
		
		stage.addActor(shyguy_button.button);
		stage.addActor(kirby_button.button);
		stage.addActor(mega_button.button);
		stage.addActor(mage_button.button);
		
		Gdx.input.setInputProcessor(stage);
	}
	
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		batch.begin();

		batch.draw(Title.selectBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); 
		//batch.draw(Title.selectTexture, Gdx.graphics.getWidth()/4 , Gdx.graphics.getHeight()/2 + Title.finishTexture.getHeight()/3);
	
		if (shyguy_button.button.isChecked())
		{ 
			select_number = 1;
			MainMenu.menu_theme.stop();
			MainMenu.menu_theme.dispose();
			MainMenu.letsgo.play(5f);
			game.setScreen(new PlayScreen(game));
		}

		else if (kirby_button.button.isChecked())
		{ 
			select_number = 2;
			MainMenu.menu_theme.stop();
			MainMenu.menu_theme.dispose();
			MainMenu.letsgo.play(5f);
			game.setScreen(new PlayScreen(game));
		}
		
		else if (mega_button.button.isChecked())
		{ 
			select_number = 3;
			MainMenu.menu_theme.stop();
			MainMenu.menu_theme.dispose();
			MainMenu.letsgo.play(5f);
			game.setScreen(new PlayScreen(game));
		}
		
		else if (mage_button.button.isChecked())
		{ 
			select_number = 4;
			MainMenu.menu_theme.stop();
			MainMenu.menu_theme.dispose();
			MainMenu.letsgo.play(5f);
			game.setScreen(new PlayScreen(game));
		}
		
		
		batch.end();
		stage.draw();
	}


	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
}
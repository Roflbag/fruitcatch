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


public class Finish_screen implements Screen{

	Game game;
	
	SpriteBatch batch;
	
	Title finishText;
	Title finishBackground;
	
	Button back;
	Shyguy shyguy;
	Kirby kirby;
	
	BitmapFont font_kirby;
	BitmapFont font_shyguy;
	
	Stage stage;
	
	
	public Finish_screen(Game game){
		this.game = game;
		}
	
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		finishText = new Title(new Vector2(0,0), "title.png");
		finishBackground = new Title(new Vector2(0,0), "finish_background.png");
		
		shyguy = new Shyguy(new Vector2(Gdx.graphics.getWidth()/2+300 ,90), "shyguy.png");
		kirby = new Kirby(new Vector2(Gdx.graphics.getWidth()/2+300 ,90), "kirby.png");	

		
		font_kirby = new BitmapFont(Gdx.files.internal("font.fnt"),false);
		font_kirby.setColor(Color.LIGHT_GRAY);
		font_kirby.setScale(3);
		
		
		font_shyguy = new BitmapFont(Gdx.files.internal("font.fnt"),false);
		font_shyguy.setColor(Color.CYAN);
		font_shyguy.setScale(3);
		
		stage = new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), false);
		back = new Button("button", "buttonpressed", " ", "font.fnt", "buttons/button.pack",Gdx.graphics.getWidth()/3 - Gdx.graphics.getWidth()/20 + Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/2 - Gdx.graphics.getHeight()/2, 250, 100);
		stage.addActor(back.button);
		Gdx.input.setInputProcessor(stage);
	}
	
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		batch.begin();

		batch.draw(Title.finishBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); 
		batch.draw(Title.finishTexture, Gdx.graphics.getWidth()/4 , Gdx.graphics.getHeight()/2 + Title.finishTexture.getHeight()/3);
	
		shyguy.update();
		kirby.update();
		
		batch.draw(shyguy.getCurrentFrame(),Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/2 + Gdx.graphics.getHeight()/7);
		batch.draw(kirby.getCurrentFrame(),Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/2);

		font_kirby.draw(batch, Integer.toString(PlayScreen.score_kirby), Gdx.graphics.getWidth()/3 + Gdx.graphics.getWidth()/5,Gdx.graphics.getHeight()/2 + Gdx.graphics.getHeight()/10);
		font_shyguy.draw(batch, Integer.toString(PlayScreen.score_shyguy), Gdx.graphics.getWidth()/3 +  Gdx.graphics.getWidth()/5 ,Gdx.graphics.getHeight()/2 + Gdx.graphics.getHeight()/4);
		
		
		if (back.button.isChecked())
		{ 
			game.setScreen(new MainMenu(game));
			if (PlayScreen.music.isPlaying())
				PlayScreen.music.stop();
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

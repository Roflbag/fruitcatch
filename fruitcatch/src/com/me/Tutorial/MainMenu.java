package com.me.Tutorial;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;



public class MainMenu implements Screen{

	Game game;

	Title titleText;
	Title titleBackground;
	Button start;

	public static Sound letsgo;
	public static Sound choose_char;


	Stage stage;

	SpriteBatch batch;
	public static Music menu_theme;

	Kirby_menu kirby;

	public MainMenu(Game game){
		this.game = game;
	}

	
	@Override
	public void show() {

		batch = new SpriteBatch();
		titleText = new Title(new Vector2(0,0), "title.png");
		titleBackground = new Title(new Vector2(0,0), "titlescreen.png");

		kirby = new Kirby_menu (new Vector2(Gdx.graphics.getWidth()/4 ,70), "kirbyMenu.png");

		menu_theme = Gdx.audio.newMusic(Gdx.files.internal("menu_legit.mp3"));
		menu_theme.play();
		menu_theme.setLooping(true);

		letsgo = Gdx.audio.newSound(Gdx.files.internal("herewego.wav"));
		choose_char = Gdx.audio.newSound(Gdx.files.internal("choose_your_character.wav"));

		stage = new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),false);
		start = new Button("button", "buttonpressed", " ", "font.fnt", "buttons/button.pack",Gdx.graphics.getWidth()/3 - Gdx.graphics.getWidth()/20 + Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/2, 250, 100);
		stage.addActor(start.button);
		Gdx.input.setInputProcessor(stage);

		PlayScreen.score_kirby = 0;
		PlayScreen.score_shyguy = 0;
		PlayScreen.finish_position = 0;
		
		
	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);


		kirby.update();

		batch.begin();

		batch.draw(Title.titleBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); 
		batch.draw(Title.titleTexture, Gdx.graphics.getWidth()/3 - Gdx.graphics.getWidth()/20, Gdx.graphics.getHeight()/2 + Title.titleTexture.getHeight()*2 );
		batch.draw(kirby.getCurrentFrame(), Gdx.graphics.getWidth()/5, 50);
		
		
		if (start.button.isChecked())
		{ 
			Gdx.input.vibrate(100);
			choose_char.play();
			game.setScreen(new Player_Select(game));

		}

		batch.end();

		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		//stage.setViewport(1920, 1080, true);k
		//stage.getCamera().position.set(1920/2, 1080/2, 0);

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
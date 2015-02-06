package com.me.Tutorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net.Protocol;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import com.badlogic.gdx.scenes.scene2d.Stage;



public class PlayScreen implements Screen{
	Socket client;
	String S_pos,k_acc,char_id="0",char_swp="1",response="0000",response_first="000";
	int S_length,check_s=0,check_swp=0,check_loop=0;
	float char_acc;
	
	
	Stage stage;
	SpriteBatch batch;
	Vector2 position;
	
	public static Music music;
	Sound sound;
	
	Game game;
	Mage mage;
	
	Sound win;
	
	Vector2 position2;
	Background background;

	Player player;
	Shyguy shyguy;
	Kirby kirby;
	ShapeRenderer sr;
	
	ArrayList<banana> fruits;
	Iterator<banana> fruitIterator;
	banana fruit;
	Random random;
	int count;
	
	BitmapFont font_kirby;
	BitmapFont font_shyguy;
	
	public static int score_kirby= 0;
	public static int score_shyguy= 0;
	
	public static int finish_position = 0;
	
	public PlayScreen(Game game){
		this.game = game;
	}

	@Override
	public void show() {
		
		batch = new SpriteBatch();
		
		
		kirby = new Kirby(new Vector2(Gdx.graphics.getWidth()/2 ,90), "kirby.png");
		shyguy = new Shyguy(new Vector2(Gdx.graphics.getWidth()/2+300 ,90), "shyguy.png");		
		
		sr = new ShapeRenderer();
		/*fruits = new ArrayList<banana>();
		random = new Random();
		*/
		
		player = new Player (new Vector2(Gdx.graphics.getWidth()/2 - 40, 90), "megaman_run.png");
		background = new Background(new Vector2(0,0), "8bitwhispy.png");
		
		music = Gdx.audio.newMusic(Gdx.files.internal("In_game.mp3"));
		sound = Gdx.audio.newSound(Gdx.files.internal("eat.wav"));
		win = Gdx.audio.newSound(Gdx.files.internal("didiwin.wav"));
		
		mage = new Mage (new Vector2(Gdx.graphics.getWidth()/2 - 300, 90), "mage.png");
		
		//setScreen(new MainMenu(game));
		font_kirby = new BitmapFont(Gdx.files.internal("font.fnt"),false);
		font_kirby.setColor(Color.MAGENTA);
		font_kirby.setScale(2);
		
		
		font_shyguy = new BitmapFont(Gdx.files.internal("font.fnt"),false);
		font_shyguy.setColor(Color.RED);
		font_shyguy.setScale(2);
		//Loops Background music

		music.play();
		music.setLooping(true);
		
		SocketHints hints = new SocketHints();
		hints.connectTimeout -=4000;
		client = Gdx.net.newClientSocket(Protocol.TCP, "192.168.1.143", 50002, hints);

		if (Player_Select.select_number == 1)
			char_id="1";
		
		else if (Player_Select.select_number == 2)
			char_id="2";

		else if (Player_Select.select_number == 3)
			char_id="3";
		
		else if (Player_Select.select_number == 4)
			char_id="4";
		//MainMenu.menu_theme.dispose();
		
	}

	@Override
	public void render(float delta) {	
		
			char_swp="1";
		   if(Gdx.input.isTouched()){
			   char_swp="0";
			   check_swp=0;
		   }

		   
		   if(check_loop>2)
			   check_loop=0;
		   
		if(client.isConnected()){
			try {// send/receiving from server
			
			if(Gdx.input.getAccelerometerY()>1 || Gdx.input.getAccelerometerY()<-1 ){
			k_acc = char_id+char_swp+Float.toString(Gdx.input.getAccelerometerY());
			if(check_loop==0)
			{client.getOutputStream().write(k_acc.getBytes());}
			check_loop++;
			
			check_s=0;
			}else{
			if(check_s<=10){// send position 0 to screen
			k_acc=char_id+char_swp+"00000";
			client.getOutputStream().write(k_acc.getBytes());
			check_s++;
			}
			}
			//System.out.println(k_acc);//just for debugging
			
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			if(in.ready()){ 

			response = in.readLine();
			response_first= response.substring(0,1);// first element is the id			
			System.out.println(response);

			}
			
			
			} catch (IOException e) {
			System.out.println("COULDNT WRITE TO SERVER!");//just for debugging
			}
			}
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		/*if (count == 100) {
			count = 0;	
			for(int i=0; i<random.nextInt(20); i++) {
				fruit = new banana();
				fruits.add(fruit);
			}
		}
		count++;*/

		
		player.update();
		shyguy.update();
		kirby.update();
		mage.update();
		
		/*
		
		if(kirby.getBounds().overlaps(shyguy.getBounds())){

				kirby.reAdjust();
				shyguy.reAdjust();	



			
			if(Gdx.input.isTouched()){
				
				position = shyguy.getPosition();

				
				if(shyguy.getIsSwapped() == 0){

					shyguy.setIsSwapped(1);
				}else{
					shyguy.setIsSwapped(0);
				}
				if(kirby.getIsSwapped() == 0){
					kirby.setIsSwapped(1);
				}else{
					kirby.setIsSwapped(0);
				}

				
				
				shyguy.setPosition(kirby.getPosition());
				kirby.setPosition(position);
			}
			
			
		}
		
		
		sr.begin(ShapeType.Rectangle);
		*/
		
		batch.begin();

		batch.draw(Background.backgroundTexture, 0, 0,  Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		if (Player_Select.select_number == 1)
		batch.draw(shyguy.getCurrentFrame(),shyguy.getPosition().x,shyguy.getPosition().y);
		
		else if (Player_Select.select_number == 2)
		batch.draw(kirby.getCurrentFrame(),kirby.getPosition().x,kirby.getPosition().y);
	
		else if (Player_Select.select_number == 3)
		batch.draw(player.getCurrentFrame(),player.getPosition().x,player.getPosition().y);
		
		else if (Player_Select.select_number == 4)
		batch.draw(mage.getCurrentFrame(),mage.getPosition().x,mage.getPosition().y);
		
			
		//font_kirby.draw(batch, Integer.toString(score_kirby), kirby.getPosition().x+30,kirby.getPosition().y-15);
		//font_shyguy.draw(batch, Integer.toString(score_shyguy), shyguy.getPosition().x+30, shyguy.getPosition().y-15);

		
	    if (response_first.equals("G")){
	    	score_kirby=Integer.parseInt(response.substring(1,3));
	    	score_shyguy=Integer.parseInt(response.substring(3,5));
	    	client.dispose();
	    	finish_position = 1;
	    	win.play();
	    	game.setScreen(new Finish_screen(game));
	    	
	    }
	
	    if (Gdx.input.justTouched()){
	    	Gdx.input.vibrate(50);
	    	//score_kirby++;
	    }
	    
	    
		/*fruitIterator = fruits.iterator();
		while (fruitIterator.hasNext()) {
		banana current = fruitIterator.next();
		batch.draw(current.getTexture(), current.getPosition().x, current.getPosition().y);
		current.update();
		sr.setColor(Color.GREEN);
		sr.rect(current.getPosition().x,current.getPosition().y,40,40);
		if ((current.getPosition().y <= 50))
		fruitIterator.remove();
		boolean b1 = (current.getBounds().overlaps(shyguy.getBounds()));
		boolean b2= (current.getBounds().overlaps(kirby.getBounds()));
		
		if (b2)
		{
			Gdx.input.vibrate(200);
			sound.play(1.0f);
			score_kirby++;
		}	
		if (b1)
		{
			Gdx.input.vibrate(200);
			sound.play(1.0f);
			score_shyguy++;
		}
		
			
		if ( b1 || b2 )
		fruitIterator.remove();
		}

		
		*/
		
		
		
		batch.end();

/*
		sr.setColor(Color.BLUE);
		sr.rect(kirby.getPosition().x,kirby.getPosition().y,kirby.getCurrentFrame().getRegionWidth(),kirby.getCurrentFrame().getRegionHeight());
		sr.setColor(Color.RED);
		sr.rect(shyguy.getPosition().x,shyguy.getPosition().y,shyguy.getCurrentFrame().getRegionWidth(),shyguy.getCurrentFrame().getRegionHeight());
		sr.end();
		*/
//		player.update(); // Update character's movement
//		mage.update();
//		
//		batch.begin();
//		batch.draw(Background.backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		batch.draw(mage.getCurrentFrame(), mage.position.x, mage.position.y);
//		batch.draw(player.getCurrentFrame(), player.position.x, player.position.y);
//		//batch.draw(player.getCurrentFrame(), 0, 0, 50, 50, 150,250, 500/1280, 500/800, 0);
//		batch.end();
//		
	}

	
	
	
	
	public static Music getMusic() {
		return music;
	}

	public static void setMusic(Music music) {
		PlayScreen.music = music;
	}

	@Override
	public void resize(int width, int height) {
		//stage.setViewport(1920, 1080, true);
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

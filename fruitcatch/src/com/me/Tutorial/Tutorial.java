package com.me.Tutorial;

import com.badlogic.gdx.Game;

public class Tutorial extends Game{
	
	Game game;

	@Override
	public void create() {	
		game = this;
		setScreen(new MainMenu(game));
	}

	
	@Override
	public void dispose() {
		
	}

	@Override
	public void render() {		

		super.render();
	}


	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}

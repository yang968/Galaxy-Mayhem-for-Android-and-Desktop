package com.shy.spacehavoc;

import screens.Splash;
import com.badlogic.gdx.Game;

/**
 * This is the main class where the game is set up and launched. Extends Game class from com.badlogic.gdx package
 * Previous version implemented ActionResolver Interface to apply Google Play Game Services in Android version.
 */
public class MyGdxGame extends Game {
	
	public MyGdxGame(){
	}

	/**
	 * Sets Assets version based on scale method and loads background, player, enenmies, and etc resources to display on screen.
	 */
	@Override
	public void create() {
		Assets.scale();
		Assets.load();
		setScreen(new Splash(this));
	}

	/**
	 * Disposes Assets and user's current screen
	 */
	@Override
	public void dispose() {
		super.dispose();
		Assets.dispose();
		getScreen().dispose();
	}
}

/*
public class MyGdxGame extends Game {

	public ActionResolver actionResolver;

	public MyGdxGame(ActionResolver actionResolver){
		this.actionResolver = actionResolver;
	}

	@Override
	public void create() {
		Assets.scale();
		Assets.load();
		setScreen(new Splash(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		Assets.dispose();
		getScreen().dispose();
	}
}

 */
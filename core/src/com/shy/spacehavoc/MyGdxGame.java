package com.shy.spacehavoc;

import screens.Splash;
import com.badlogic.gdx.Game;

public class MyGdxGame extends Game {
	
	public MyGdxGame(){
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
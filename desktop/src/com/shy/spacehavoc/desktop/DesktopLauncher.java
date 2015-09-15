package com.shy.spacehavoc.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.shy.spacehavoc.MyGdxGame;

public class DesktopLauncher{
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "SpaceHavoc";
		config.resizable = true;
		config.width = 1280;
		config.height = 720;
		
		new LwjglApplication(new MyGdxGame(), config);
	}
}

/*
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.google.example.games.basegameutils.GameHelper.GameHelperListener;
import com.shy.spacehavoc.ActionResolver;
import com.shy.spacehavoc.MyGdxGame;

public class DesktopLauncher implements GameHelperListener, ActionResolver{
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "SpaceHavoc";
		config.resizable = true;
		config.width = 1280;
		config.height = 720;

		new LwjglApplication(new MyGdxGame(this), config);
	}

	@Override
	public boolean getSignedInGPGS() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void loginGPGS() {
		// TODO Auto-generated method stub

	}

	@Override
	public void submitScoreGPGS(float f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unlockAchievementGPGS(String achievementId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getLeaderboardGPGS() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAchievementsGPGS() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSignInFailed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSignInSucceeded() {
		// TODO Auto-generated method stub

	}
}
 */
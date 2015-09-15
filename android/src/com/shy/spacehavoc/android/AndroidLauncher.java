package com.shy.spacehavoc.android;

import android.content.Intent;
import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.shy.spacehavoc.MyGdxGame;

public class AndroidLauncher extends AndroidApplication{

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration 
        cfg = new AndroidApplicationConfiguration();
        cfg.useAccelerometer = true;
        initialize(new MyGdxGame(), cfg);
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

	@Override
	public void onBackPressed(){

	}
}
/**
 * Code below was previous implementation using GameHelperListener, ActionResolver libraries to implement Google Play Game Services Integration.
 */
/*
import android.content.Intent;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.example.games.basegameutils.GameHelper;
import com.google.example.games.basegameutils.GameHelper.GameHelperListener;
import com.shy.spacehavoc.ActionResolver;
import com.shy.spacehavoc.Assets;
import com.shy.spacehavoc.MyGdxGame;

public class AndroidLauncher extends AndroidApplication implements GameHelperListener, ActionResolver{

	private GameHelper gh;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration
        cfg = new AndroidApplicationConfiguration();
        cfg.useAccelerometer = true;
        gh = new GameHelper(this);
		gh.enableDebugLog(true, "GooglePlayGS");
        initialize(new MyGdxGame(this), cfg);
        gh.setup(this);
    }

    @Override
    protected void onResume() {
    	super.onResume();
    	gh.onStart(this);
    }

    @Override
    protected void onPause() {
    	super.onPause();
    	gh.onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        gh.onActivityResult(requestCode, resultCode, data);
    }

	@Override
	public boolean getSignedInGPGS() {
		return gh.isSignedIn();
	}

	@Override
	public void loginGPGS() {
		try{
			runOnUiThread(new Runnable() {
				@Override
				public void run() {
					gh.beginUserInitiatedSignIn();
				}
			});
		}catch(final Exception ex){
		}
	}

	@Override
	public void submitScoreGPGS(float score) {
		if(Assets.N){
			gh.getGamesClient().submitScore("CgkI8v6htZIIEAIQAQ", (long) score);
		}
		else if (Assets.H){
			gh.getGamesClient().submitScore("CgkI8v6htZIIEAIQAg", (long) score);
		}
	}

	@Override
	public void unlockAchievementGPGS(String achievementId) {
		gh.getGamesClient().unlockAchievement(achievementId);
	}

	@Override
	public void getLeaderboardGPGS() {
		if(Assets.N){
			startActivityForResult(gh.getGamesClient().getLeaderboardIntent("CgkI8v6htZIIEAIQAQ"), 100);
		}
		else if (Assets.H){
			startActivityForResult(gh.getGamesClient().getLeaderboardIntent("CgkI8v6htZIIEAIQAg"), 100);
		}
	}

	@Override
	public void getAchievementsGPGS() {
		startActivityForResult(gh.getGamesClient().getAchievementsIntent(), 101);
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
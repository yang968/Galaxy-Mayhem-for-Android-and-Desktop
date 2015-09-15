package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.shy.spacehavoc.Assets;
import com.shy.spacehavoc.MyGdxGame;
import com.shy.spacehavoc.Time;

public class Replay implements Screen{
	MyGdxGame game;
	Stage gameOver;
	private Table table;
	private Skin skin;
	SpriteBatch batch;
	float yourtime, gap, gap2;
	
	//ImageButton playButton, rankButton, back, medal;
	ImageButton playButton, back;
	float W = Gdx.graphics.getWidth();
	float H = Gdx.graphics.getHeight();
	float augH = Gdx.graphics.getHeight() / 8f;
	
	Time best;
	Time your;
	Texture[] bestTexture;
	Texture[] currTexture;
	
	public Replay(MyGdxGame game){
		this.game = game;
		batch = new SpriteBatch();
		gameOver = new Stage();
		if(Assets.N && !Assets.H){
			best = new Time(Assets.prefs.getFloat("bestTimeN"));
		}
		else if (Assets.H && !Assets.N){
			best = new Time(Assets.prefs.getFloat("bestTimeH"));
		}
		your = new Time(Assets.prefs.getFloat("yourTime"));
		yourtime = Assets.prefs.getFloat("yourTime");
		bestTexture = best.getTexture();
		currTexture = your.getTexture();
		if(Assets.v3){
			gap = 70;
			gap2 = 46;
		}
		else if(Assets.v2){
			gap = 50;
			gap2 = 34;
		}else{
			gap = 35;
			gap2 = 23;
		}
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1F, 1F, 1F, 1F);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.input.setInputProcessor(gameOver);
		gameOver.act();
		batch.begin();
		batch.draw(Assets.background, 0, 0, W, H);
		batch.draw(Assets.gameover, (W / 2f) - (Assets.gameover.getWidth() / 2), H - (augH + (Assets.gameover.getHeight() / 2)));
		batch.draw(Assets.bestTime, (W / 4f) - 10, (H * 0.4f) - (Assets.bestTime.getHeight() / 2));
		batch.draw(Assets.yourTime, (W / 4f) - 10, (H * 0.6f) - (Assets.yourTime.getHeight() / 2));
		for (int i = 0; i < bestTexture.length; i++) {
			batch.draw(bestTexture[i], (W / 2f) + (i * gap),
					(float) (H * 0.4) - gap2);
		}
		for (int i = 0; i < currTexture.length; i++) {
			batch.draw(currTexture[i], (W / 2f) + (i * gap),
					(float) (H * 0.6) - gap2);
		}
		if(yourtime > 75f){
			batch.draw(Assets.platGold, (W * 0.18f), (H * 0.6f) - (Assets.platGold.getHeight() / 2));
		}
		else if(yourtime > 60f){
			batch.draw(Assets.plat, (W * 0.18f), (H * 0.6f) - (Assets.plat.getHeight() / 2));
		}
		else if(yourtime > 45f){
			batch.draw(Assets.gold, (W * 0.18f), (H * 0.6f) - (Assets.gold.getHeight() / 2));
		}
		else if(yourtime > 30f){
			batch.draw(Assets.silver, (W * 0.18f), (H * 0.6f) - (Assets.silver.getHeight() / 2));
		}
		else if(yourtime > 15f){
			batch.draw(Assets.bronze, (W * 0.18f), (H * 0.6f) - (Assets.bronze.getHeight() / 2));
		}
		batch.end();
		gameOver.draw();
		//updateGameOver();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		skin = new Skin();
		table = new Table(skin);
		
		playButton = new ImageButton(Assets.playButtonStyle);
		back = new ImageButton(Assets.backButtonStyle);
		//rankButton = new ImageButton(Assets.rankButtonStyle);
		//medal = new ImageButton(Assets.medButtonStyle);
		
		playButton.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button) {
				game.setScreen(new GameScreen(game));
				gameOver.clear();
				return true;
				}
		});
		back.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
									 int pointer, int button) {
				game.setScreen(new MainMenu(game));
				return true;
			}
		});
		/*
		rankButton.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Assets.bgm.stop();
				if(game.actionResolver.getSignedInGPGS()) game.actionResolver.getLeaderboardGPGS();
				else game.actionResolver.loginGPGS();
				return true;
			}
		});
		medal.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Assets.bgm.stop();
				if(game.actionResolver.getSignedInGPGS()) game.actionResolver.getAchievementsGPGS();
				else game.actionResolver.loginGPGS();
				return true;
			}
		});
		*/
		table.setPosition((W * 0.5f), (augH + 50f));
		table.add(playButton).pad(20);
		table.add(back).pad(20);
		//table.add(rankButton).pad(20);
		//table.add(medal).pad(20);
		
		gameOver.addActor(table);
	}
	/*
	private void updateGameOver(){
		if(game.actionResolver.getSignedInGPGS()){
			game.actionResolver.submitScoreGPGS(Assets.prefs.getFloat("bestTimeH"));
			if(Assets.prefs.getFloat("bestTimeH") >= 15) game.actionResolver.unlockAchievementGPGS("CgkI8v6htZIIEAIQAw");
			if(Assets.prefs.getFloat("bestTimeH") >= 30) game.actionResolver.unlockAchievementGPGS("CgkI8v6htZIIEAIQBA");
			if(Assets.prefs.getFloat("bestTimeH") >= 45) game.actionResolver.unlockAchievementGPGS("CgkI8v6htZIIEAIQBQ");
			if(Assets.prefs.getFloat("bestTimeH") >= 60) game.actionResolver.unlockAchievementGPGS("CgkI8v6htZIIEAIQBg");
			if(Assets.prefs.getFloat("bestTimeH") >= 75) game.actionResolver.unlockAchievementGPGS("CgkI8v6htZIIEAIQBw");
		}
	}
	*/
	@Override
	public void hide() {
		this.dispose();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		skin.dispose();
		best.dispose();
		your.dispose();
	}
}

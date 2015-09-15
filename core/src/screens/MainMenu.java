package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.shy.spacehavoc.Assets;
import com.shy.spacehavoc.MyGdxGame;

public class MainMenu implements Screen{
	private Stage menuStage;
	private Table table;
	private SpriteBatch batch;
	private Skin skin;
	MyGdxGame game;

	ImageButton play, rank, rate, set, how, medal;

	float W = Gdx.graphics.getWidth();
	float H = Gdx.graphics.getHeight();
	float augH = Gdx.graphics.getHeight() / 8;

	public MainMenu(MyGdxGame game) {
		this.game = game;
		batch = new SpriteBatch();
		menuStage = new Stage();
		Assets.bgm.play();
		Assets.bgm.setLooping(true);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1F, 1F, 1F, 1F);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		Gdx.input.setInputProcessor(menuStage);
		menuStage.act();
		batch.begin();
		batch.draw(Assets.background, 0, 0, W, H);
		batch.draw(Assets.player, (W / 2) - (Assets.player.getWidth() / 2f), (H * 0.6f) - (Assets.player.getHeight() / 2));
		batch.draw(Assets.title, (W / 2) - (Assets.title.getWidth() / 2f), H - (augH + 94));
		batch.draw(Assets.copy, (W / 2) - (Assets.copy.getWidth() / 2), augH);
		batch.end();
		menuStage.draw();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		skin = new Skin();
		table = new Table(skin);
		play = new ImageButton(Assets.playButtonStyle);
		rank = new ImageButton(Assets.rankButtonStyle);
		rate = new ImageButton(Assets.rateButtonStyle);
		set = new ImageButton(Assets.diffButtonStyle);
		how = new ImageButton(Assets.howButtonStyle);
		medal = new ImageButton(Assets.medButtonStyle);

		play.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Assets.bgm.stop();
				game.setScreen(new GameScreen(game));
				menuStage.clear();
				return true;
			}
		});
		rate.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Assets.bgm.stop();
				Gdx.net.openURI("https://play.google.com/");
				return true;
			}
		});
		/*
		rank.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Assets.bgm.stop();
				if(game.actionResolver.getSignedInGPGS()) game.actionResolver.getLeaderboardGPGS();
				else game.actionResolver.loginGPGS();
				return true;
			}
		});
		*/
		how.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				game.setScreen(new Tutorial(game));
				menuStage.clear();
				return true;
			}
		});
		set.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Assets.bgm.stop();
				game.setScreen(new Settings(game));
				menuStage.clear();
				return true;
			}
		});
		/*
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
		//table.setBounds((float) ((W * 0.26)),(augH + 100), (float) ((W * 0.75)), augH);
		table.setPosition((W * 0.5f), (H * 0.35f));
		table.add(rank).pad(30);
		table.add(play).pad(30);
		table.add(rate).pad(30);
		table.row();
		//table.add(tut);
		table.add(set).pad(30);
		table.add(medal).pad(30);
		table.add(how).pad(30);
		menuStage.addActor(table);
	}

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
		skin.dispose();
		menuStage.dispose();
		batch.dispose();
	}
}

package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.shy.spacehavoc.Assets;
import com.shy.spacehavoc.MyGdxGame;

public class Settings implements Screen{
	
	MyGdxGame game;
	private Stage stage;
	private Table table;
	private SpriteBatch batch;
	private Skin skin;
	
	ImageButton normal;
	ImageButton hard;
	
	float W = Gdx.graphics.getWidth();
	float H = Gdx.graphics.getHeight();
	float augH = H / 8;
	
	public Settings(MyGdxGame game){
		this.game = game;
		batch = new SpriteBatch();
		stage = new Stage();
		skin = new Skin();
		table = new Table(skin);
	}

	@Override
	public void render(float delta) {
		Gdx.input.setInputProcessor(stage);
		stage.act();
		batch.begin();
		batch.draw(Assets.background, 0, 0, W, H);
		batch.draw(Assets.choose, (W / 2) - (Assets.choose.getWidth() / 2), H - (augH + 94));
		batch.draw(Assets.player, (W / 2) - (Assets.player.getWidth() / 2), (H / 2) - (Assets.player.getHeight() / 2)); 
		batch.end();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		normal = new ImageButton(Assets.nButtonStyle);
		hard = new ImageButton(Assets.hButtonStyle);
		
		normal.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Assets.boom.play();
				Timer.schedule(new Task() {
					@Override
					public void run() {
						Assets.N = true;
						Assets.H = false;
						game.setScreen(new MainMenu(game));
					}
				}, 1);
				return true;
			}
		});
		
		hard.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Assets.boom.play();
				Timer.schedule(new Task() {
					@Override
					public void run() {
						Assets.N =false;
						Assets.H = true;
						game.setScreen(new MainMenu(game));
					}
				}, 1);
				return true;
			}
		});
		
		table.setPosition((W * 0.5f), (augH + 100f));
		table.add(normal).pad(40);
		table.add(hard).pad(40);
		stage.addActor(table);
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
		batch.dispose();
		stage.dispose();
		skin.dispose();
	}
}

package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.shy.spacehavoc.Assets;
import com.shy.spacehavoc.MyGdxGame;
import entities.Player;

public class Tutorial implements Screen{
	
	MyGdxGame game;
	SpriteBatch batch;
	Player player;
	float W;
	float H;
	float augH;
	Stage stage;
	ImageButton back;
	int move;
	
	public Tutorial(MyGdxGame game){
		this.game = game;
		batch = new SpriteBatch();
		player = new Player();
		W = Gdx.graphics.getWidth();
		H = Gdx.graphics.getHeight();
		augH = H / 8f;
		stage = new Stage();
		if(Assets.v2 || Assets.v3){
			move = 200;
		}else{
			move = 120;
		}
	}

	@Override
	public void render(float delta) {
		player.update();
		player.movement();
		Gdx.input.setInputProcessor(stage);
		batch.begin();
		batch.draw(Assets.background, 0, 0, W, H);
		batch.draw(Assets.player, player.getPosition().x, H - move);
		batch.draw(Assets.h1, (W / 2) - (Assets.h1.getWidth() / 2), (H * 0.8f) - (Assets.h1.getHeight()));
		batch.draw(Assets.h2, (W / 2) - (Assets.h2.getWidth() / 2), (H * 0.6f) - (Assets.h2.getHeight()));
		batch.draw(Assets.h3, (W / 2) - (Assets.h3.getWidth() / 2), (H * 0.6f) - (Assets.h2.getHeight() + Assets.h3.getHeight() / 1.5f));
		batch.draw(Assets.h4, (W / 2) - (Assets.h4.getWidth() / 2), (H * 0.4f) - (Assets.h4.getHeight()));
		batch.draw(Assets.h5, (W / 2) - (Assets.h5.getWidth() / 2), (H * 0.2f) - (Assets.h5.getHeight()));
		batch.end();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		back = new ImageButton(Assets.backButtonStyle);
		back.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Assets.bgm.stop();
				game.setScreen(new MainMenu(game));
				return true;
			}
		});
		stage.addActor(back);
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
	}
	
	public void touch(){
		if(Gdx.input.isTouched()){
			game.setScreen(new MainMenu(game));
		}
	}
}

package screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.shy.spacehavoc.Assets;
import com.shy.spacehavoc.MyGdxGame;

public class Splash implements Screen{
	private MyGdxGame game;
	private SpriteBatch batch;
	private Sprite sprite;
	private TweenManager tweenManager;
	public Splash(MyGdxGame game){
		this.game = game;
	}

	@Override
	public void render(float delta) {
		//Black Screen
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		sprite.draw(batch);
		batch.end();
		
		tweenManager.update(delta);
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		sprite = new Sprite(Assets.logo);
		sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2, Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
		tweenManager = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SplashAccessor());
		Tween.set(sprite, SplashAccessor.ALPHA).target(0).start(tweenManager);
		Tween.to(sprite, SplashAccessor.ALPHA, 1).target(1).repeatYoyo(1, 1).setCallback(new TweenCallback() {
			
			@Override
			public void onEvent(int type, BaseTween<?> source) {
					game.setScreen(new MainMenu(game));
			}
		}).start(tweenManager);
		tweenManager.update(Float.MIN_VALUE);
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
	}

}

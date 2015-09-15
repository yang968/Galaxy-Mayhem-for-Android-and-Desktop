package screens;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.shy.spacehavoc.Assets;
import com.shy.spacehavoc.MyGdxGame;

import entities.Enemy;
import entities.Enemy2;
import entities.Explosion;
import entities.Meteor;
import entities.Player;

public class GameScreen implements Screen{
	
	MyGdxGame game;
	SpriteBatch batch;
	private State state;
	float time, scX, scY;
	float W = Gdx.graphics.getWidth();
	float H = Gdx.graphics.getHeight();
	float augH = H / 8;
	
	private Player player;
	boolean playing;
	boolean gameover;
	
	ArrayList<Meteor> meteor;
	Iterator<Meteor> meteorIterator;
	ArrayList<Enemy> enemy;
	Iterator<Enemy> enemyIterator;
	Enemy2 e2;
	Enemy2 e4;
	
	Explosion exp;

	public GameScreen(MyGdxGame game){
		this.game = game;
		batch = new SpriteBatch();
		time = 0f;
		player = new Player();
		state = State.PAUSE;
		
		playing = true;
		gameover = false;
		
		e2 = new Enemy2(true, player);
		e4 = new Enemy2(false, player);
		
		exp = new Explosion();
		if(Assets.v3){
			scX = 166;
			scY = 162;
		}
		else if(Assets.v2){
			scX = 124;
			scY = 121;
		}
		else if(Assets.v1){
			scX = 80;
			scY = 78;
		}
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1F, 1F, 1F, 1F);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(Assets.background, 0, 0, W, H);
		batch.end();
		
		switch(state){
		case PAUSE:
			batch.begin();
			batch.draw(Assets.avoid, (W / 2) - (Assets.avoid.getWidth() / 2), H - (augH + Assets.avoid.getHeight()));
			batch.draw(Assets.touch, (W / 2) - (Assets.touch.getWidth() / 2), augH);
			batch.draw(Assets.player, player.getPosition().x, player.getPosition().y);
			batch.end();
			Timer.schedule(new Task() {
				@Override
				public void run() {
					touch();
				}
			}, 0.3f);

			break;
		case RUN:
			if(playing){
				if(gameover == false){
					time += Gdx.graphics.getDeltaTime();
					meteorIterator = meteor.iterator();
					while (meteorIterator.hasNext()) {
						Meteor cur = meteorIterator.next();
						cur.update();
						batch.begin();
						batch.draw(Assets.meteor, cur.getPosition().x, cur.getPosition().y,
								Assets.meteor.getWidth() / 2f, Assets.meteor.getHeight() / 2f, 
								Assets.meteor.getWidth(), Assets.meteor.getHeight(), 1, 1, cur.getMetSp().getRotation(), 
								0, 0, Assets.meteor.getWidth(), Assets.meteor.getHeight(), false, false);
						batch.end();
						cur.getMetSp().rotate(8f);
						if(Intersector.overlaps(cur.getmBounds(), player.getpBounds())){
							gameover = true;
						}
					}
					enemyIterator = enemy.iterator();
					enemyIterator = enemy.iterator();
					while (enemyIterator.hasNext()) {
						Enemy cur = enemyIterator.next();
						cur.update();
						batch.begin();
						batch.draw(Assets.enemy1, cur.getPosition().x, cur.getPosition().y, 
								scX / 2f, scY / 2f, scX, scY, 1, 1, cur.getRotate().getRotation());
						batch.end();
						cur.getRotate().rotate(-5f);
						if(Intersector.overlaps(cur.getBounds(), player.getpBounds())){
							gameover = true;
						}
					}
					batch.begin();
					if(time > 40){
						e2.update();
						batch.draw(Assets.enemy2, e2.getPosition().x, e2.getPosition().y);
						if(Intersector.overlaps(player.getpBounds(), e2.getBounds())){
							gameover = true;
						}
					}
					if(Assets.H && !Assets.N){
						if (time > 80){
							e4.update();
							batch.draw(Assets.enemy2, e4.getPosition().x, e4.getPosition().y);
							if(Intersector.overlaps(player.getpBounds(), e2.getBounds())){
								gameover = true;
							}
						}
					}
					batch.draw(Assets.player, player.getPosition().x, player.getPosition().y);
					batch.end();
				}
				else{
					if(Assets.N){
						Assets.setBestTime(time, true);
					}
					else{
						Assets.setBestTime(time, false);
					}
					Assets.setCurrentTime(time);
					exp.currentFrame = exp.anime.getKeyFrame(delta, false);
					batch.begin();
					batch.draw(exp.currentFrame, player.getPosition().x, player.getPosition().y);
					batch.end();
					if (!Assets.boom.isPlaying()) {
						Assets.boom.play();
					}
					Timer.schedule(new Task() {
						@Override
						public void run() {
							playing = false;
						}
					}, 0.7f);
				}
			}
			else{
				game.setScreen(new Replay(game));
			}
			
			if (gameover == false) {
				player.movement();
				player.update();
			} else if (gameover) {
				Assets.bgm.stop();
			}
			break;
		}
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		if(Assets.N && !Assets.H){
			meteor = new ArrayList<Meteor>();
			for (int i = 0; i < 5; i++) {
				meteor.add(new Meteor(this));
			}
		}
		else if(Assets.H && !Assets.N){
			meteor = new ArrayList<Meteor>();
			for (int i = 0; i < 6; i++) {
				meteor.add(new Meteor(this));
			}
		}
		enemy = new ArrayList<Enemy>();
		for (int i = 0; i < 2; i++) {
			enemy.add(new Enemy(this));
		}
	}

	@Override
	public void hide() {
		this.dispose();
	}

	@Override
	public void pause() {
		Assets.bgm.pause();
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
	
	public enum State {
		PAUSE, RUN
	}
	
	public void touch(){
		if(Gdx.input.isTouched()){
			state = State.RUN;
			Assets.bgm.setLooping(true);
			Assets.bgm.play();
		}
	}
	public float time(){
		return time;
	}
}

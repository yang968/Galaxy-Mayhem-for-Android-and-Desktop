package entities;

import screens.GameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.shy.spacehavoc.Assets;

public class Meteor {
	
	Vector2 position;
	Circle mBounds;
	float metVelX = 0;
	float metVelY = 0;
	float W = Gdx.graphics.getWidth();
	float H = Gdx.graphics.getHeight();
	Sprite metSp;
	GameScreen gs;
	
	public Meteor(GameScreen gameScreen){
		this.gs = gameScreen;
		position = new Vector2(MathUtils.random(-100, 0), MathUtils.random(H));
		metSp = new Sprite();
		mBounds = new Circle();
		if(Assets.N && !Assets.H){
			metVelX = MathUtils.random(-2, 2) * 2 + 1;
			metVelY = MathUtils.random(-2, 2) * 2 - 1;
		}
		else if (Assets.H && !Assets.N){
			metVelX = MathUtils.random(-4, 4) * 2 + 1;
			metVelY = MathUtils.random(-4, 4) * 2 - 1;
		}
		if(Assets.v3){
			mBounds.set(position.x + 98, position.y + 96, 96);
		}
		else if(Assets.v2){
			mBounds.set(position.x + 73, position.y + 72, 72);
		}
		else if(Assets.v1){
			mBounds.set(position.x + 40, position.y + 39, 39);
		}
	}
	
	public void update(){
		position.x = position.x + metVelX;
		position.y = position.y + metVelY;
		if(position.x > W){
			position.x = ((position.x + metVelX) % W) - 98;
		}
		if(position.y > H){
			position.y = ((position.y + metVelY) - H) - 96;
		}
		if(position.x < (-98)){
			position.x = W;
		}
		if(position.y < (-96)){
			position.y = H;
		}
		if(Assets.v3){
			mBounds.set(position.x + 98, position.y + 96, 96);
		}
		else if(Assets.v2){
			mBounds.set(position.x + 73, position.y + 72, 72);
		}
		else if(Assets.v1){
			mBounds.set(position.x + 40, position.y + 39, 39);
		}
		if(gs.time() > 20f && gs.time() < 20.6f){
			if(metVelX > 0){
				metVelX += 0.05;
			}
			else{
				metVelX -= 0.05;
			}
			if(metVelY > 0){
				metVelY += 0.05;
			}
			else{
				metVelY -= 0.05;
			}
		}
		if(gs.time() > 50f && gs.time() < 50.6f){
			if(metVelX > 0){
				metVelX += 0.05;
			}
			else{
				metVelX -= 0.05;
			}
			if(metVelY > 0){
				metVelY += 0.05;
			}
			else{
				metVelY -= 0.05;
			}
		}
	}

	public Vector2 getPosition() {
		return position;
	}
	public Sprite getMetSp() {
		return metSp;
	}

	public Circle getmBounds() {
		return mBounds;
	}
}

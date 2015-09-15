package entities;

/**
 * Enemy Class sets up Green UFOs with random position and x&y velocity.
 */

import screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.shy.spacehavoc.Assets;

public class Enemy {
	Vector2 position;
	Circle bounds;
	private float W = Gdx.graphics.getWidth();
	private float H = Gdx.graphics.getHeight();
	float eVelX = 0;
	float eVelY = 0;
	TextureRegion ship;
	Sprite rotate;
	GameScreen gs;
	
	public Enemy(GameScreen gs){
		this.gs = gs;
		position = new Vector2(MathUtils.random(-100, 0), MathUtils.random(H));
		if(Assets.N && !Assets.H){
			eVelX = MathUtils.random(-2, 2) * 2 + 1;
			eVelY = MathUtils.random(-2, 2) * 2 - 1;
		}
		else if (Assets.H && !Assets.N){
			eVelX = MathUtils.random(-4, 4) * 2 + 1;
			eVelY = MathUtils.random(-4, 4) * 2 - 1;
		}
		eVelX = MathUtils.random(-2, 2) * 2 + 1;
		eVelY = MathUtils.random(-2, 2) * 2 - 1;
		bounds = new Circle();
		if(Assets.v3){
			bounds.set(position.x + 83, position.y + 81, 82);
		}
		else if(Assets.v2){
			bounds.set(position.x + 62, position.y + 60, 60);
		}
		else if(Assets.v1){
			bounds.set(position.x + 40, position.y + 39, 36);
		}
		
		ship = new TextureRegion();
		ship = Assets.enemy1;
		rotate = new Sprite();
	}
	
	public void update(){
		position.x = position.x + eVelX;
		position.y = position.y + eVelY;
		if(position.x > W){
			position.x = ((position.x + eVelX) % W) - 72;
		}
		if(position.y > H){
			position.y = ((position.y + eVelY) - H) - 72;
		}
		if(position.x < (-72)){
			position.x = W;
		}
		if(position.y < (-72)){
			position.y = H;
		}
		if(Assets.v3){
			bounds.set(position.x + 83, position.y + 81, 82);
		}
		else if(Assets.v2){
			bounds.set(position.x + 62, position.y + 60, 60);
		}
		else if(Assets.v1){
			bounds.set(position.x + 40, position.y + 39, 36);
		}
		if(gs.time() > 30f && gs.time() < 30.5f){
			if(eVelX > 0){
				eVelX += 0.05;
			}
			else{
				eVelX -= 0.05;
			}
			if(eVelY > 0){
				eVelY += 0.05;
			}
			else{
				eVelY -= 0.05;
			}
		}
		if(gs.time() > 60f && gs.time() < 60.5f){
			if(eVelX > 0){
				eVelX += 0.05;
			}
			else{
				eVelX -= 0.05;
			}
			if(eVelY > 0){
				eVelY += 0.05;
			}
			else{
				eVelY -= 0.05;
			}
		}
	}

	public Vector2 getPosition() {
		return position;
	}

	public Circle getBounds() {
		return bounds;
	}

	public TextureRegion getShip() {
		return ship;
	}

	public Sprite getRotate() {
		return rotate;
	}	
}

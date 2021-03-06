package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.shy.spacehavoc.Assets;

/**
 * Class for setting up the player
 */
public class Player {
	Vector2 position;
	Circle pBounds; // Player Hitbox
	float velX = 0;
	float velY = 0;
	float W = Gdx.graphics.getWidth();
	float H = Gdx.graphics.getHeight();
	
	public Player(){
		if(Assets.v3){
			position = new Vector2((W / 2) - 91, (H / 2) - 91);
		}
		else if(Assets.v2){
			position = new Vector2((W / 2) - 68, (H / 2) - 68);
		}
		else if(Assets.v1){
			position = new Vector2((W / 2) - 45, (H / 2) - 45);
		}
		
		pBounds = new Circle();
		if(Assets.v3){
			pBounds.set(position.x + 91, position.y + 91, 91);
		}
		else if(Assets.v2){
			pBounds.set(position.x + 68, position.y + 68, 68);
		}
		else if(Assets.v1){
			pBounds.set(position.x + 45, position.y + 45, 45);
		}
	}

	/**
	 * Player's velocity gets updated on xy plane based on current device : Desktop, Android, iOS.
	 * Desktop uses WASD keys for user input while Android/iOS uses Accelerometer.
	 */
	public void update(){
		switch (Gdx.app.getType()) {
		case Desktop:
			if (Gdx.input.isKeyPressed(Keys.A)) {
				velX -= 1;
			}
			if (Gdx.input.isKeyPressed(Keys.D)) {
				velX += 1;
			}
			if (Gdx.input.isKeyPressed(Keys.W)) {
				velY += 1;
			}
			if (Gdx.input.isKeyPressed(Keys.S)) {
				velY -= 1;
			}
			if (Gdx.input.isKeyPressed(Keys.W)
					&& Gdx.input.isKeyPressed(Keys.A)) {
				velX -= 1;
				velY += 1;
			}
			if (Gdx.input.isKeyPressed(Keys.W)
					&& Gdx.input.isKeyPressed(Keys.D)) {
				velX += 1;
				velY += 1;
			}
			if (Gdx.input.isKeyPressed(Keys.S)
					&& Gdx.input.isKeyPressed(Keys.A)) {
				velX -= 1;
				velY -= 1;
			}
			if (Gdx.input.isKeyPressed(Keys.S)
					&& Gdx.input.isKeyPressed(Keys.D)) {
				velX += 1;
				velY -= 1;
			}
			break;
		case Android:
			if(Assets.N && !Assets.H){
				velX = (float) (7 * Gdx.input.getAccelerometerY());
				velY = (float) -(7 * Gdx.input.getAccelerometerX());
			}
			else if (Assets.H && !Assets.N){
				velX = (float) (10 * Gdx.input.getAccelerometerY());
				velY = (float) -(10 * Gdx.input.getAccelerometerX());
			}
			break;
		case iOS:
			if(Assets.N && !Assets.H){
				velX = (float) (7 * Gdx.input.getAccelerometerY());
				velY = (float) -(7 * Gdx.input.getAccelerometerX());
			}
			else if (Assets.H && !Assets.N){
				velX = (float) (10 * Gdx.input.getAccelerometerY());
				velY = (float) -(10 * Gdx.input.getAccelerometerX());
			}
			break;
		default:
			break;
		}
	}

	/**
	 * Player's position on the x&y plane gets updated. If player leaves the screen on one side, it will appear
	 * on the opposite location. Player's hitbox gets updated based on resolution.
	 */
	public void movement(){
		position.x = position.x + velX;
		position.y = position.y + velY;
		if (position.x > W) {
			position.x = ((position.x + velX) % W) - 91;
		}
		if (position.y > H) {
			position.y = ((position.y + velY) % H) - 91;
		}
		if (position.x < -91) {
			position.x = W;
		}
		if (position.y < -91) {
			position.y = H;
		}
		if(Assets.v3){
			pBounds.set(position.x + 91, position.y + 91, 91);
		}
		else if(Assets.v2){
			pBounds.set(position.x + 68, position.y + 68, 68);
		}
		else if(Assets.v1){
			pBounds.set(position.x + 45, position.y + 45, 45);
		}
	}

	/**
	 * Returns Player's position
	 * @return Player's position
	 */
	public Vector2 getPosition() {
		return position;
	}

	/**
	 * Returns Player's hitbox area
	 * @return Player's hitbox area
	 */
	public Circle getpBounds() {
		return pBounds;
	}

}

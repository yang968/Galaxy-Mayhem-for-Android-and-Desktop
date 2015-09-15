package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.shy.spacehavoc.Assets;

public class Enemy2 {
	Vector2 position;
	Circle bounds;
	TextureRegion ship;
	Sprite en;
	Player player;
	float W = Gdx.graphics.getWidth();
	float H = Gdx.graphics.getHeight();
	
	public Enemy2(boolean tf, Player player){
		this.player = player;
		if(tf){
			position = new Vector2(MathUtils.random(W, W + 100), MathUtils.random(H));
		}else{
			position = new Vector2(MathUtils.random(-100, 0), MathUtils.random(H));
		}
		ship = new TextureRegion();
		if(tf){
			ship = Assets.enemy2;
		}else{
			ship = Assets.enemy3;
		}
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
	}
	
	public void update(){
		if(player.getPosition().x > position.x){
			position.x += 1.5;
		}else{
			position.x -= 1.5;
		}
		if(player.getPosition().y > position.y){
			position.y += 1.5;
		}else{
			position.y -= 1.5;
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
	}

	public Vector2 getPosition() {
		return position;
	}
	public Circle getBounds() {
		return bounds;
	}
	public Sprite getEn() {
		return en;
	}
}

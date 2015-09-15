package entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.shy.spacehavoc.Assets;

public class Explosion {
	private TextureRegion[] sheetFrame;
	public TextureRegion currentFrame;
	public Animation anime;
	private TextureRegion[][] temp;
	
	public Explosion(){
		if(Assets.v3){
			temp = TextureRegion.split(Assets.explosionSheet, 200, 200);
		}
		else if(Assets.v2){
			temp = TextureRegion.split(Assets.explosionSheet, 150, 150);
		}
		else if(Assets.v1){
			temp = TextureRegion.split(Assets.explosionSheet, 100, 100);
		}
		sheetFrame = new TextureRegion[36];
		int index = 0;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				sheetFrame[index++] = temp[i][j];
			}
		}
		anime = new Animation(0.02f, sheetFrame);
	}
	
}

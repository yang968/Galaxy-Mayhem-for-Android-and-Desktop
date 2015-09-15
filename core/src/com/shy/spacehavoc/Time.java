package com.shy.spacehavoc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Time {
	private float timestamp;
	private Texture[] currTime;
	
	public Time(float timestamp) {
		this.timestamp = timestamp;
		this.currTime = null;
	}
	
	/**
	 * Returns the second digit of the minute time.
	 * 
	 * @return [Int] - The second digit of the minute time.
	 */
	public int getMins() {
		return isUnderOneMinute() ? 0 : ((int) timestamp) / 60;
	}

	public int getTenMins() {
		return isUnderOneMinute() ? 0 : getMins() / 10;
	}
	
	public int getSecs() {
		return (((int)timestamp) - (((int)timestamp / 60) * 60)) % 10;
	}
	
	public int getTenSecs() {
		return (((int) timestamp) - (((int) timestamp / 60) * 60)) / 10;
	}
	
	public int getMillisecs() {
		return ((int)(timestamp * 100) % 100) % 10;
	}
	
	public int getTenMillisecs() {
		return ((int)(timestamp * 100) % 100) / 10;
	}
	
	public int compareTo(Time other) {
		return 0;
	}
	
	public boolean equals(Time other) {
		return false;
	}
	
	public int hashCode() {
		return 0;
	}
	
	public Texture[] getTexture() {

		if(currTime == null) {
			int tenSecs = getTenSecs();
			int secs = getSecs();
	
			int tenMillisecs = getTenMillisecs();
			int milliSecs = getMillisecs();
	
			int tenMins = getTenMins();
			int mins = getMins();
	
			currTime = new Texture[8];
			currTime[0] = getNumberTexture(tenMins);
			currTime[1] = getNumberTexture(mins);
			currTime[2] = getColonTexture();
			currTime[3] = getNumberTexture(tenSecs);
			currTime[4] = getNumberTexture(secs);
			currTime[5] = getDotTexture();
			currTime[6] = getNumberTexture(tenMillisecs);
			currTime[7] = getNumberTexture(milliSecs);
		}

		return currTime;
	}
	
	public void dispose() {
		for(int i = 0; i < currTime.length; i++) {
			currTime[i].dispose();
		}
	}

	private boolean isUnderOneMinute() {
		return ((int) timestamp) < 60;
	}

	private Texture getNumberTexture(int number) {
		if(Assets.v3){
			return new Texture(Gdx.files.internal("ui/v3/" + number + ".png"));
		}else if (Assets.v2){
			return new Texture(Gdx.files.internal("ui/v2/" + number + ".png"));
		}else{
			return new Texture(Gdx.files.internal("ui/v1/" + number + ".png"));
		}
	}

	private Texture getColonTexture() {
		if(Assets.v3){
			return new Texture(Gdx.files.internal("ui/v3/colon.png"));
		}else if (Assets.v2){
			return new Texture(Gdx.files.internal("ui/v2/colon.png"));
		}else{
			return new Texture(Gdx.files.internal("ui/v1/colon.png"));
		}
	}

	private Texture getDotTexture(){
		if(Assets.v3){
			return new Texture(Gdx.files.internal("ui/v3/dot.png"));
		}else if (Assets.v2){
			return new Texture(Gdx.files.internal("ui/v2/dot.png"));
		}else{
			return new Texture(Gdx.files.internal("ui/v1/dot.png"));
		}
	}
}

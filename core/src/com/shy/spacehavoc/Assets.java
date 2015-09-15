package com.shy.spacehavoc;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
	public static Texture background, title, enemySprite, explosionSheet,
			meteor, player, tilt, tilt2, touch, bestTime, yourTime, logo,
			gameover, avoid, choose, copy, bronze, silver, gold, plat,
			platGold, h1, h2, h3, h4, h5;
	public static TextureRegion enemy1, enemy2, enemy3; // explo_frame;

	public static TextureAtlas playButton, rankButton, rateButton, hButton,
			nButton, backB, diffB, howB, medalB;
	public static ImageButtonStyle playButtonStyle, rankButtonStyle,
			rateButtonStyle, hButtonStyle, nButtonStyle, backButtonStyle,
			diffButtonStyle, howButtonStyle, medButtonStyle;
	public static Skin play, rank, rate, hard, normal, back, diff, how, medal;

	public static Music bgm;
	public static Music boom;
	public static Preferences prefs;
	public static Time time;
	
	private static float W;

	public static boolean N, H, v1, v2, v3;
	public static String v;
	
	public static void scale(){
		W = Gdx.graphics.getWidth();
		if (W > 1920){
			v3 = true;
			v = "v3";
		}
		else if (W > 1280){
			v2 = true;
			v = "v2";
		}
		else {
			v1 = true;
			v = "v1";
		}
	}

	public static void load() {
		N = true;
		H = false;
		
		Random rand = new Random();
		for (int i = 0; i < 2; i++) {
			switch (rand.nextInt(2)) {
			case 0:
				background = new Texture(
						Gdx.files.internal("game/background_1.png"));
				break;
			case 1:
				background = new Texture(
						Gdx.files.internal("game/background_3.png"));
				break;
			}
		}
		logo = new Texture(Gdx.files.internal("ui/" + v + "/logo.png"));
		avoid = new Texture(Gdx.files.internal("ui/" + v + "/avoid.png"));
		choose = new Texture(Gdx.files.internal("set/" + v + "/choose.png"));
		copy = new Texture(Gdx.files.internal("ui/" + v + "/copyright.png"));
		
		h1 = new Texture(Gdx.files.internal("how/" + v + "/h1.png"));
		h2 = new Texture(Gdx.files.internal("how/" + v + "/h2.png"));
		h3 = new Texture(Gdx.files.internal("how/" + v + "/h3.png"));
		h4 = new Texture(Gdx.files.internal("how/" + v + "/h4.png"));
		h5 = new Texture(Gdx.files.internal("how/" + v + "/h5.png"));
		
		gameover = new Texture(Gdx.files.internal("game/" + v + "/gameover.png"));
		title = new Texture(Gdx.files.internal("game/" + v + "/title.png"));
		enemySprite = new Texture(Gdx.files.internal("game/" + v + "/ships_saucer_0.png"));
		explosionSheet = new Texture(Gdx.files.internal("game/" + v + "/spritesheet3.png"));
		touch = new Texture(Gdx.files.internal("ui/" + v + "/touch_to_begin.png"));
		bestTime = new Texture(Gdx.files.internal("ui/" + v + "/best_time.png"));
		yourTime = new Texture(Gdx.files.internal("ui/" + v + "/your_time.png"));
		
		for (int i = 0; i < 2; i++) {
		switch (rand.nextInt(2)) {
		case 0:
			meteor = new Texture(Gdx.files.internal("game/" + v + "/meteorGrey_big4.png"));
			break;
		case 1:
			meteor = new Texture(Gdx.files.internal("game/" + v + "/meteorBrown_big4.png"));
			break;
			}
		}
		
		Random rand2 = new Random();
		for (int j = 0; j < 4; j++) {
			switch (rand2.nextInt(4)) {
			case 0:
				player = new Texture(Gdx.files.internal("game/" + v + "/ufo_red.png"));
				break;
			case 1:
				player = new Texture(Gdx.files.internal("game/" + v + "/ufo_blue.png"));
				break;
			case 2:
				player = new Texture(Gdx.files.internal("game/" + v + "/ufo_green.png"));
				break;
			case 3:
				player = new Texture(Gdx.files.internal("game/" + v + "/ufo_yellow.png"));
				break;
			}
		}
		
		if(v3){
			enemy2 = new TextureRegion(enemySprite, 21, 18, 166, 162);
			enemy1 = new TextureRegion(enemySprite, 21, 466, 166, 162);
			playButton = new TextureAtlas("button/v2/play.pack");
			rankButton = new TextureAtlas("button/v2/rank.pack");
			rateButton = new TextureAtlas("button/v2/rate.pack");
			hButton = new TextureAtlas("button/v2/hard.pack");
			nButton = new TextureAtlas("button/v2/normal.pack");
			backB = new TextureAtlas("button/v2/back.pack");
			howB = new TextureAtlas("button/v2/how.pack");
			diffB = new TextureAtlas("button/v2/diff.pack");
			medalB = new TextureAtlas("button/v2/medal.pack");
		}
		else if(v2){
			enemy2 = new TextureRegion(enemySprite, 13, 10, 124, 121);
			enemy1 = new TextureRegion(enemySprite, 13, 346, 124, 121);
			playButton = new TextureAtlas("button/v2/play.pack");
			rankButton = new TextureAtlas("button/v2/rank.pack");
			rateButton = new TextureAtlas("button/v2/rate.pack");
			hButton = new TextureAtlas("button/v2/hard.pack");
			nButton = new TextureAtlas("button/v2/normal.pack");
			backB = new TextureAtlas("button/v2/back.pack");
			howB = new TextureAtlas("button/v2/how.pack");
			diffB = new TextureAtlas("button/v2/diff.pack");
			medalB = new TextureAtlas("button/v2/medal.pack");
		}
		else{
			enemy2 = new TextureRegion(enemySprite, 10, 13, 80, 78);
			enemy1 = new TextureRegion(enemySprite, 10, 237, 80, 78);
			playButton = new TextureAtlas("button/play.pack");
			rankButton = new TextureAtlas("button/rank.pack");
			rateButton = new TextureAtlas("button/rate.pack");
			hButton = new TextureAtlas("button/hard.pack");
			nButton = new TextureAtlas("button/normal.pack");
			backB = new TextureAtlas("button/back.pack");
			howB = new TextureAtlas("button/how.pack");
			diffB = new TextureAtlas("button/diff.pack");
			medalB = new TextureAtlas("button/medal.pack");
		}
		if(v1 || v2){
			bronze = new Texture(Gdx.files.internal("medals/v2/bronze.png"));
			silver = new Texture(Gdx.files.internal("medals/v2/silver.png"));
			gold = new Texture(Gdx.files.internal("medals/v2/gold.png"));
			plat = new Texture(Gdx.files.internal("medals/v2/platinum.png"));
			platGold = new Texture(Gdx.files.internal("medals/v2/platinumgold.png"));
		}
		else if (v3){
			bronze = new Texture(Gdx.files.internal("medals/v3/bronze.png"));
			silver = new Texture(Gdx.files.internal("medals/v3/silver.png"));
			gold = new Texture(Gdx.files.internal("medals/v3/gold.png"));
			plat = new Texture(Gdx.files.internal("medals/v3/platinum.png"));
			platGold = new Texture(Gdx.files.internal("medals/v3/platinumgold.png"));
		}
		
		play = new Skin(playButton);
		rank = new Skin(rankButton);
		rate = new Skin(rateButton);
		hard = new Skin(hButton);
		normal = new Skin(nButton);
		back = new Skin(backB);
		how = new Skin(howB);
		diff = new Skin(diffB);
		medal = new Skin(medalB);
		playButtonStyle = new ImageButtonStyle();
		playButtonStyle.up = play.getDrawable("play");
		rankButtonStyle = new ImageButtonStyle();
		rankButtonStyle.up = rank.getDrawable("rank");
		rateButtonStyle = new ImageButtonStyle();
		rateButtonStyle.up = rate.getDrawable("rate");
		hButtonStyle = new ImageButtonStyle();
		hButtonStyle.up = hard.getDrawable("hard");
		nButtonStyle = new ImageButtonStyle();
		nButtonStyle.up = normal.getDrawable("normal");
		backButtonStyle = new ImageButtonStyle();
		backButtonStyle.up = back.getDrawable("back");
		howButtonStyle = new ImageButtonStyle();
		howButtonStyle.up = how.getDrawable("how");
		diffButtonStyle = new ImageButtonStyle();
		diffButtonStyle.up = diff.getDrawable("diff");
		medButtonStyle = new ImageButtonStyle();
		medButtonStyle.up = medal.getDrawable("cooltext1601713815");
		bgm = Gdx.audio.newMusic(Gdx.files.internal("ouroboros.mp3"));
		boom = Gdx.audio.newMusic(Gdx.files.internal("nff_cannon.wav"));

		// Create (or retrieve existing) preferences file
		prefs = Gdx.app.getPreferences("TimeRecord");
		if (!prefs.contains("bestTimeN")) {
			prefs.putFloat("bestTimeN", 0);
		}
		if (!prefs.contains("bestTimeH")) {
			prefs.putFloat("bestTimeH", 0);
		}
	}

	public static void setBestTime(float val, boolean DiffN) {
		if (DiffN) {
			if (val > prefs.getFloat("bestTimeN")) {
				prefs.putFloat("bestTimeN", val);
			}
		} else {
			if (val > prefs.getFloat("bestTimeH")) {
				prefs.putFloat("bestTimeH", val);
			}
		}
		prefs.flush();
	}

	public static void getBestTime(boolean NorH) {
		if (NorH) {
			float val = prefs.getFloat("bestTimeN");
			time = new Time(val);
		} else {
			float val = prefs.getFloat("bestTimeH");
			time = new Time(val);
		}
	}

	public static void setCurrentTime(float val) {
		prefs.putFloat("yourTime", val);
		prefs.flush();
	}

	public static void dispose() {
		background.dispose();
		title.dispose();
		enemySprite.dispose();
		explosionSheet.dispose();
		meteor.dispose();
		player.dispose();
		tilt.dispose();
		tilt2.dispose();
		touch.dispose();
		bestTime.dispose();
		yourTime.dispose();
		logo.dispose();
		gameover.dispose();
		avoid.dispose();
		choose.dispose();
		copy.dispose();
		bronze.dispose();
		silver.dispose();
		gold.dispose();
		plat.dispose();
		platGold.dispose();
		h1.dispose();
		h2.dispose();
		h3.dispose();
		h4.dispose();
		h5.dispose();

		playButton.dispose();
		rankButton.dispose();
		rateButton.dispose();
		hButton.dispose();
		nButton.dispose();
		backB.dispose();
		diffB.dispose();
		howB.dispose();
		medalB.dispose();

		play.dispose();
		rank.dispose();
		rate.dispose();
		hard.dispose();
		normal.dispose();
		back.dispose();
		diff.dispose();
		hard.dispose();
		medal.dispose();

		bgm.dispose();
		boom.dispose();
	}
}

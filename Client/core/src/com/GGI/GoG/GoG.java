package com.GGI.GoG;

import com.GGI.GoG.Screens.GameScreen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GoG extends Game {

	
	@Override
	public void create () {
	setScreen(new GameScreen(this));
	}

	
}

package org.dandy.base;

import android.app.Activity;

public abstract class GameActivity extends Activity {

	private int[][] checkboard;
	private GameResolver gameResolver;
	
	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		findView();
		createGameResolver();
		checkboard = gameResolver.start();
		setView(checkboard);
	}

	public abstract void findView();
	public abstract void setView(int[][] checkboard);
	public abstract void createGameResolver();
}

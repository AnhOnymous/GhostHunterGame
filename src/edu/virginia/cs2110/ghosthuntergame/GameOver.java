package edu.virginia.cs2110.ghosthuntergame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class GameOver extends Activity {

	private final int SPLASH_DISPLAY_LENGHT = 1000;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.gameover);
	}
}
package com.rts.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.rts.game.RTSGame;

//Огромное спасибо Александру за классный курс по Java
//за интересную подачу материала и креативность

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720;
//		config.foregroundFPS = 1;
		new LwjglApplication(new RTSGame(), config);
	}
}

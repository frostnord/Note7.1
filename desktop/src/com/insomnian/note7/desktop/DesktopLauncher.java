package com.insomnian.note7.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.insomnian.note.Note;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.samples =2;
		config.vSyncEnabled= true;
//		config.width = 720;
		config.width = 800;
//		config.width = 1920;
//		config.width = 1280;
//        config.width = 320;
		config.height = 480;
//		config.height = 1080;
//		config.height = 720;
//        config.height = 240;
		config.vSyncEnabled = true;
		new LwjglApplication(new Note(), config);
	}
}

package org.mt4j.android;

import org.mt4j.MTAndroidApplication;
import org.mt4j.android.scenes.Scene1;

public class StartMT4jApp extends MTAndroidApplication {
	
	

	@Override
	public void startUp() {
//		this.addScene(new MT4jAndroidTestScene(this, "MT4j Android TestScene"));
		this.addScene(new Scene1(this, "MT4j Android TestScene"));
	}
	
	
	/*
	//Print the frames per second regularly
	
	private long timeLastFrame;
	private long time; 
	  
	@Override
	public void draw() {
		
		long nanos = System.nanoTime();
		long timeDelta = (nanos - timeLastFrame) / 1000000L;
		timeLastFrame = nanos;
		
		time += timeDelta;
		if (time > 5000){
			time = 0;
			Log.i("FPS", "FPS: " + frameRate);
		}
		super.draw();
	}
	 */



}

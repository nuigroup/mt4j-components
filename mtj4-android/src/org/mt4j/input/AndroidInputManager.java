package org.mt4j.input;

import org.mt4j.MTAndroidApplication;
import org.mt4j.input.inputSources.AndroidMTInputSource;

public class AndroidInputManager extends InputManager {
	
	public AndroidInputManager(MTAndroidApplication pa) {
		this(pa, true);
	}
	
	public AndroidInputManager(MTAndroidApplication pa, boolean registerDefaultSources) {
		super(pa, registerDefaultSources);
	}
	
	@Override
	protected void registerDefaultInputSources() {
		super.registerDefaultInputSources();
		
		if (app instanceof MTAndroidApplication){
			this.registerInputSource(new AndroidMTInputSource((MTAndroidApplication)app));	
		}
	}



}

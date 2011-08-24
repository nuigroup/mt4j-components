package org.mt4j.android;

import org.mt4j.MTAndroidApplication;
import org.mt4j.android.scenes.TestScene1;

public class StartTest extends MTAndroidApplication {
	
    @Override
    public void startUp() {
    	this.addScene(new TestScene1(this, "TestScene1"));
    	
    }
    
    
}
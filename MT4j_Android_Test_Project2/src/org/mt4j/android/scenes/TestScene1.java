package org.mt4j.android.scenes;

import org.mt4j.MTApplication;
import org.mt4j.components.visibleComponents.shapes.*;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.util.MT4jSettings;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.ToolsMath;
import org.mt4j.util.math.Vector3D;
import org.mt4j.util.logging.ILogger;
import org.mt4j.util.logging.MTLoggerFactory;

import processing.core.PGraphics;

public class TestScene1 extends AbstractScene{
	private ILogger logger = MTLoggerFactory.getLogger("TestScene1");

	public TestScene1(MTApplication mtApplication, String name) {
		super(mtApplication, name);
		
//		MT4jSettings.getInstance().renderer = MT4jSettings.OPENGL_MODE;
		
		registerGlobalInputProcessor(new CursorTracer(mtApplication, this));
		
		MTRectangle r1 = new MTRectangle(mtApplication, 0,0, 200, 100);
		r1.setFillColor(MTColor.RED);
		getCanvas().addChild(r1);
		
		for (int i = 0; i < 5; i++) {
//			MTRectangle r = new MTRectangle(mtApplication, 0,0, 200, 100);
			MTEllipse r = new MTEllipse(mtApplication, new Vector3D(100,100), 100, 80);
//			MTRoundRectangle r = new MTRoundRectangle(mtApplication, 0,0,0, 100, 80, 30, 30);
			r.setFillColor(MTColor.randomColor());
			getCanvas().addChild(r);
			
			r.setPositionGlobal(new Vector3D(ToolsMath.getRandom(0, MT4jSettings.getInstance().getWindowWidth()), ToolsMath.getRandom(0, MT4jSettings.getInstance().getWindowHeight())));
			
//			r.setUseVBOs(true);
		}
		
		/*
		 P android:
		 cameraFOV = 60 * DEG_TO_RAD; // at least for now
    cameraX = width / 2.0f;
    cameraY = height / 2.0f;
    cameraZ = cameraY / ((float) Math.tan(cameraFOV / 2.0f));
    cameraNear = cameraZ / 10.0f;
    cameraFar = cameraZ * 10.0f;
    cameraAspect = (float) width / (float) height;
    
    P desktop:
    cameraFOV = 60 * DEG_TO_RAD; // at least for now
    cameraX = width / 2.0f;
    cameraY = height / 2.0f;
    cameraZ = cameraY / ((float) Math.tan(cameraFOV / 2.0f));
    cameraNear = cameraZ / 10.0f;
    cameraFar = cameraZ * 10.0f;
    cameraAspect = (float)width / (float)height;
		 */
		
	}
	
	float time = 0;
	
	//TODO at setvertices if count doesent change just update vertex buffer sinstead of recreate
	
	@Override
	public void drawAndUpdate(PGraphics graphics, long timeDelta) {
		super.drawAndUpdate(graphics, timeDelta);
		
		time+= timeDelta;
		if (time > 5000){
			time = 0;
			logger.info("FrameRate: " + getMTApplication().frameRate);
		}
	}

}

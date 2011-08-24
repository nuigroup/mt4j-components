package org.mt4j.android.scenes;

import org.mt4j.AbstractMTApplication;
import org.mt4j.components.TransformSpace;
import org.mt4j.components.visibleComponents.shapes.MTEllipse;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.shapes.MTRoundRectangle;
import org.mt4j.components.visibleComponents.shapes.mesh.MTCube;
import org.mt4j.components.visibleComponents.shapes.mesh.MTSphere;
import org.mt4j.components.visibleComponents.widgets.MTTextArea;
import org.mt4j.components.visibleComponents.widgets.buttons.MTImageButton;
import org.mt4j.input.gestureAction.DefaultLassoAction;
import org.mt4j.input.gestureAction.DefaultPanAction;
import org.mt4j.input.gestureAction.DefaultZoomAction;
import org.mt4j.input.gestureAction.InertiaDragAction;
import org.mt4j.input.gestureAction.Rotate3DAction;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.dragProcessor.DragProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.flickProcessor.FlickEvent;
import org.mt4j.input.inputProcessors.componentProcessors.flickProcessor.FlickProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.lassoProcessor.LassoProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.panProcessor.PanProcessorTwoFingers;
import org.mt4j.input.inputProcessors.componentProcessors.rotate3DProcessor.Rotate3DProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapProcessor;
import org.mt4j.input.inputProcessors.componentProcessors.zoomProcessor.ZoomProcessor;
import org.mt4j.input.inputProcessors.globalProcessors.CursorTracer;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.sceneManagement.Iscene;
import org.mt4j.sceneManagement.transition.FadeTransition;
import org.mt4j.util.MT4jSettings;
import org.mt4j.util.MTColor;
import org.mt4j.util.camera.MTCamera;
import org.mt4j.util.font.FontManager;
import org.mt4j.util.math.ToolsMath;
import org.mt4j.util.math.Vector3D;

import processing.core.PImage;

public class Scene1 extends AbstractScene {
	private AbstractMTApplication mtApp;
	private Iscene scene2;
	
	private String imagePath =  "";
	
	public Scene1(AbstractMTApplication mtApplication, String name) {
		super(mtApplication, name);
		this.mtApp = mtApplication;
		
		//Set the background color
		this.setClearColor(new MTColor(146, 150, 188, 255));
		
		this.registerGlobalInputProcessor(new CursorTracer(mtApp, this));
		
		//Create a textfield
		MTTextArea textField = new MTTextArea(mtApplication, FontManager.getInstance().createFont(mtApp, "arial20.fnt", 20, MTColor.WHITE)); 
		textField.setNoFill(true);
		textField.setNoStroke(true);
		textField.setText("Hello MT4j-Android!");
		this.getCanvas().addChild(textField);
		textField.setPositionGlobal(new Vector3D(ToolsMath.getRandom(0, MT4jSettings.getInstance().getWindowWidth()),ToolsMath.getRandom(0, MT4jSettings.getInstance().getWindowHeight())));
		
		//Button to get to the next scene
		PImage arrow = mtApplication.loadImage(imagePath +	"arrowRight.png");
		MTImageButton nextSceneButton = new MTImageButton(mtApplication, arrow);
		nextSceneButton.setNoStroke(true);
		if (MT4jSettings.getInstance().isOpenGlMode())
			nextSceneButton.setUseDirectGL(true);
		nextSceneButton.addGestureListener(TapProcessor.class, new IGestureEventListener() {
			public boolean processGestureEvent(MTGestureEvent ge) {
				TapEvent te = (TapEvent)ge;
				if (te.isTapped()){
					//Save the current scene on the scene stack before changing
					mtApp.pushScene();
					if (scene2 == null){
						scene2 = new Scene2(mtApp, "Scene 2");
						//Add the scene to the mt application
						mtApp.addScene(scene2);
					}
					//Do the scene change
					mtApp.changeScene(scene2);
				}
				return true;
			}
		});
		getCanvas().addChild(nextSceneButton);
		nextSceneButton.setPositionGlobal(new Vector3D(MT4jSettings.getInstance().getWindowWidth() - nextSceneButton.getWidthXY(TransformSpace.GLOBAL) - 5, MT4jSettings.getInstance().getWindowHeight() - nextSceneButton.getHeightXY(TransformSpace.GLOBAL) - 5, 0));
		nextSceneButton.attachCamera(new MTCamera(mtApplication));
		
		//Set a scene transition - Flip transition only available using opengl supporting the FBO extenstion
		this.setTransition(new FadeTransition(mtApplication, 1700));
		
		//Register flick gesture with the canvas to change the scene
		getCanvas().registerInputProcessor(new FlickProcessor(220, 7));
		getCanvas().addGestureListener(FlickProcessor.class, new IGestureEventListener() {
			public boolean processGestureEvent(MTGestureEvent ge) {
				FlickEvent e = (FlickEvent)ge;
				if (e.getId() == MTGestureEvent.GESTURE_ENDED && e.isFlick()){
					switch (e.getDirection()) {
					case WEST:
					case NORTH_WEST:
					case SOUTH_WEST:
						//Save the current scene on the scene stack before changing
						mtApp.pushScene();
						if (scene2 == null){
							scene2 = new Scene2(mtApp, "Scene 2");
							//Add the scene to the mt application
							mtApp.addScene(scene2);
						}
						//Do the scene change
						mtApp.changeScene(scene2);
						break;
					default:
						break;
					}
				}
				return false;
			}
		});
		
		
		LassoProcessor lp = new LassoProcessor(mtApplication, getCanvas(), getSceneCam());
		getCanvas().registerInputProcessor(lp);
		getCanvas().addGestureListener(LassoProcessor.class, new DefaultLassoAction(mtApplication, getCanvas().getClusterManager(), getCanvas()));
		
		ZoomProcessor zp = new ZoomProcessor(mtApplication, 800);
		getCanvas().registerInputProcessor(zp);
		getCanvas().addGestureListener(ZoomProcessor.class, new DefaultZoomAction());
		
		PanProcessorTwoFingers pp = new PanProcessorTwoFingers(mtApplication, 800);
		getCanvas().registerInputProcessor(pp);
		getCanvas().addGestureListener(PanProcessorTwoFingers.class, new DefaultPanAction());
		
		
		
		lp.addLassoable(textField);
		
//		PImage mt4jTexture = getMTApplication().loadImage("MT4j.gif");
		PImage mt4jTexture = getMTApplication().loadImage("MT4jAndroid_256px_black.png");
		
		MTRectangle rect = new MTRectangle(getMTApplication(), mt4jTexture);
		rect.setStrokeColor(MTColor.BLACK);
		rect.addGestureListener(DragProcessor.class, new InertiaDragAction());
		getCanvas().addChild(rect);
		rect.setPositionGlobal(new Vector3D(ToolsMath.getRandom(0, MT4jSettings.getInstance().getWindowWidth()),ToolsMath.getRandom(0, MT4jSettings.getInstance().getWindowHeight())));
		rect.rotateZ(rect.getCenterPointRelativeToParent(), ToolsMath.getRandom(-45, 45), TransformSpace.RELATIVE_TO_PARENT);
		lp.addLassoable(rect);
		
		MTRoundRectangle roundRect = new MTRoundRectangle(getMTApplication(), 0,0,0, 150, 120, 30,30);
		roundRect.setStrokeColor(MTColor.BLACK);
		roundRect.setTexture(mt4jTexture);
		roundRect.addGestureListener(DragProcessor.class, new InertiaDragAction());
		getCanvas().addChild(roundRect);
		roundRect.setPositionGlobal(new Vector3D(ToolsMath.getRandom(0, MT4jSettings.getInstance().getWindowWidth()),ToolsMath.getRandom(0, MT4jSettings.getInstance().getWindowHeight())));
		roundRect.rotateZ(rect.getCenterPointRelativeToParent(), ToolsMath.getRandom(-45, 145), TransformSpace.RELATIVE_TO_PARENT);
		lp.addLassoable(roundRect);
		
		MTEllipse ell = new MTEllipse(getMTApplication(), new Vector3D(), 150, 100);
		ell.setTexture(mt4jTexture);
		ell.addGestureListener(DragProcessor.class, new InertiaDragAction());
		getCanvas().addChild(ell);
		ell.setPositionGlobal(new Vector3D(ToolsMath.getRandom(0, MT4jSettings.getInstance().getWindowWidth()),ToolsMath.getRandom(0, MT4jSettings.getInstance().getWindowHeight())));
		ell.rotateZ(rect.getCenterPointRelativeToParent(), ToolsMath.getRandom(-145, 45), TransformSpace.RELATIVE_TO_PARENT);
		lp.addLassoable(ell);
		
		MTCube c = new MTCube(getMTApplication(), 190);
		c.registerInputProcessor(new Rotate3DProcessor(getMTApplication(), c));
		c.addGestureListener(Rotate3DProcessor.class, new Rotate3DAction(getMTApplication(), c));
		c.addGestureListener(DragProcessor.class, new InertiaDragAction());
		getCanvas().addChild(c);
		c.setPositionGlobal(new Vector3D(ToolsMath.getRandom(0, MT4jSettings.getInstance().getWindowWidth()),ToolsMath.getRandom(0, MT4jSettings.getInstance().getWindowHeight())));
		c.rotateX(c.getCenterPointRelativeToParent(), ToolsMath.getRandom(0, 90), TransformSpace.RELATIVE_TO_PARENT);
		c.rotateY(c.getCenterPointRelativeToParent(), ToolsMath.getRandom(0, 90), TransformSpace.RELATIVE_TO_PARENT);
		c.setTexture(mt4jTexture);
		lp.addLassoable(c);
		
		MTSphere sphere = new MTSphere(mtApplication, "", 20, 20, 125);
		sphere.registerInputProcessor(new Rotate3DProcessor(getMTApplication(), sphere));
		sphere.addGestureListener(Rotate3DProcessor.class, new Rotate3DAction(getMTApplication(), sphere));
		sphere.setTexture(mt4jTexture);
		sphere.rotateX(c.getCenterPointRelativeToParent(), ToolsMath.getRandom(0, 90), TransformSpace.RELATIVE_TO_PARENT);
		sphere.rotateY(c.getCenterPointRelativeToParent(), ToolsMath.getRandom(0, 90), TransformSpace.RELATIVE_TO_PARENT);
		sphere.addGestureListener(DragProcessor.class, new InertiaDragAction());
		getCanvas().addChild(sphere);
		sphere.setPositionGlobal(new Vector3D(ToolsMath.getRandom(0, MT4jSettings.getInstance().getWindowWidth()),ToolsMath.getRandom(0, MT4jSettings.getInstance().getWindowHeight())));
		sphere.setUseVBOs(true);
		
		
		
	}
	

	public void onEnter() {
		System.out.println("Entered scene: " +  this.getName());
	}
	
	public void onLeave() {	
		System.out.println("Left scene: " +  this.getName());
	}

}

package org.mt4j;

import org.mt4j.input.AndroidInputManager;
import org.mt4j.input.ISurfaceTouchListener;
import org.mt4j.util.AndroidPlatformUtil;
import org.mt4j.util.PlatformUtil;
import org.mt4j.util.MT4jSettings;
import org.mt4j.util.MTColor;
import org.mt4j.util.animation.ani.AniAnimation;
import org.mt4j.util.font.FontManager;
import org.mt4j.util.font.fontFactories.AngelCodeFontFactory;
import org.mt4j.util.logging.AndroidDefaultLogger;
import org.mt4j.util.logging.ILogger;
import org.mt4j.util.logging.MTLoggerFactory;
import org.mt4j.util.opengl.AndroidGL10;
import org.mt4j.util.opengl.AndroidGL11;

import processing.core.PGraphicsAndroid3D;
import android.view.MotionEvent;

/*
 Android notes:
  * at the moment OpenGL ES Version 1.1 is supported/used
  * put all resources in the asset folder -> asset subfolders are not supported for the most part
  * fonts dont support dynamic sizes -> at createFont, use the font size which is specified in the .fnt font file's name
    - to create new fonts, use the BMFont tool (Set the output to .png - tga seems to have problem, also only use 1 page and to avoid artifacts at scaling add a little padding)
  
  
  
 */

public abstract class MTAndroidApplication extends AbstractMTApplication{
	
	public MTAndroidApplication(){
		super();
	}
	
	
	@Override
	public void setup() {
//		Log.i(this.getClass().getSimpleName(), "SETUP CALLED");
		
//		 orientation(LANDSCAPE); //TODO make configurable
//		 orientation(PORTRAIT); //TODO make configurable
		
		// Initialize Loggin facilities  - IMPORTANT TO DO THIS ASAP! \\
		MTLoggerFactory.setLoggerProvider(new AndroidDefaultLogger()); 
//		MTLoggerFactory.setLoggerProvider(new AndroidDummyLogger());
		logger = MTLoggerFactory.getLogger(MTAndroidApplication.class.getName());
		logger.setLevel(ILogger.INFO);
		
		// Default font settings and factories \\
		FontManager.DEFAULT_FONT = "arial20.fnt";
		FontManager.DEFAULT_FONT_SIZE = 16;
		FontManager.DEFAULT_FONT_FILL_COLOR = MTColor.BLACK;
		FontManager.DEFAULT_FONT_STROKE_COLOR = MTColor.BLACK;
		FontManager.DEFAULT_FONT_ANTIALIASING = true;
		//FontManager.getInstance().registerFontFactory(".ttf", new TTFontFactory());
		FontManager.getInstance().registerFontFactory(".fnt", new AngelCodeFontFactory());
		//////////////////////
		
		/////////////////////// 
		PlatformUtil.setGraphicsUtilProvider(new AndroidPlatformUtil(this));
		///////////////////////
		
		//Set to use our own OpenGL rendering by default
		MT4jSettings.getInstance().renderer = MT4jSettings.OPENGL_MODE;
		
		//Set all default paths to the "" (asset folder) path because we cant use the assetmanager 
		//if we use subfolders (no path separators allowed) but have to load the files/set permissions ourselves :( 
		//TODO -> is there another way to handle this?
		MT4jSettings.DEFAULT_3D_MODEL_PATH = "";
		MT4jSettings.DEFAULT_DATA_FOLDER_PATH = "";
		MT4jSettings.DEFAULT_FONT_PATH = "";
		MT4jSettings.DEFAULT_IMAGES_PATH = "";
		MT4jSettings.DEFAULT_SETTINGS_PATH = "";
		MT4jSettings.DEFAULT_SVG_PATH = "";
		MT4jSettings.DEFAULT_VIDEOS_PATH = "";
		
		MT4jSettings.getInstance().windowHeight = this.sketchHeight();
		MT4jSettings.getInstance().windowWidth = this.sketchWidth();
		logger.info("MT4j window dimensions: \"" + MT4jSettings.getInstance().getWindowWidth() + " x " +  MT4jSettings.getInstance().getWindowHeight() + "\"");
		
		// Save this applets rendering thread for reference
		this.renderThread = Thread.currentThread();
		
		//Set background color
		background(150);
		
		//Set the framerate
	    frameRate(MT4jSettings.getInstance().getMaxFrameRate());
	    logger.info("Maximum framerate: \"" + MT4jSettings.getInstance().getMaxFrameRate() + "\"");
	    
//	    hint(MTApplication.DISABLE_OPENGL_ERROR_REPORT);
		
		MT4jSettings.getInstance().programStartTime = System.currentTimeMillis();
		
		this.loadGL();
		
		AniAnimation.init(this); //Initialize Ani animation library
		
		//Create a new inputsourcePool
		if (getInputManager() == null){ //only set the default inputManager if none is set yet
			this.setInputManager(new AndroidInputManager(this, true));
		}
		
		//Call startup at the end of setup(). Should be overridden in extending classes
		this.startUp();
	}

	
	protected void loadGL(){
		/*
		String version = ((PGraphicsAndroid3D)g).gl.glGetString(GL10.GL_VERSION);
		logger.info("OpenGL Version: " + version);
        int major = Integer.parseInt("" + version.charAt(0));
        int minor = Integer.parseInt("" + version.charAt(2));
        */
		
        this.gl11Supported = false;
        this.gl20Supported = false;
        
        PGraphicsAndroid3D pg3D = (PGraphicsAndroid3D)this.g;

        if (pg3D.gl11xp != null || pg3D.gl11x != null || pg3D.gl11 != null){
        	iGL11 = new AndroidGL11(pg3D.gl);
        	iGL10 = iGL11;
        	glCommon = iGL11;
        	gl11PlusSupported = true;
        	logger.info("OpenGL profile 1.1 supported");
        }else{
        	iGL10 = new AndroidGL10(((PGraphicsAndroid3D)g).gl);
        	glCommon = iGL10;
        	logger.info("OpenGL profile 1.0 supported");
        }
        
//        if (major >= 2) {
//        		AndroidGL20 agl20 = new AndroidGL20(((PGraphicsAndroid3D)g).gl);
//                iGL20 = agl20;
//                //FIXME ADDED
////                iGL10  = jogl20;
////                iGL11 = jogl20;
////                iGL11Plus = jogl20;
//                glCommon = agl20;
//                this.gl20Supported = true;
////                this.gl11Supported = true;
////                this.gl11PlusSupported = true;
//        } else {
//                if (major == 1 && minor < 5) {
//                        iGL10 = new AndroidGL10(((PGraphicsAndroid3D)g).gl);
//                } else {
//                        iGL11 = new AndroidGL11(((PGraphicsAndroid3D)g).gl);
//                        iGL10 = iGL11;
//                        this.gl11Supported = true;
//                }
//                glCommon = iGL10;
//        }
	}
	


	private ISurfaceTouchListener touchListener;
	
	public void setTouchListener(ISurfaceTouchListener listener){
		this.touchListener = listener;
	}
	
	public ISurfaceTouchListener getTouchListener(){
		return this.touchListener;
	}
	
	///////////////////////////////////////////////////////
	
	/** Process incoming touch events */
	@Override
	public boolean surfaceTouchEvent(MotionEvent event) {
		super.surfaceTouchEvent(event);
		
		final MotionEvent mEvent = event;
		if (touchListener != null){
			touchListener.onTouchEvent(mEvent);
		}
		return true;
	}

	
	//Dont override, because loadImage(img) which already creates a GLTexture (MTApplication) will call loadImage(img, null) and again try to create
	//a GLTexture..we just shouldnt use loadImage(img, params) directly..
//	@Override
//	public PImage loadImage(String filename, Object params) {
//		if (MT4jSettings.getInstance().isOpenGlMode()){
//			return new GLTexture(this, super.loadImage(filename, params));
//		}else{
//			return super.loadImage(filename, params);
//		}
//	}

	
//	protected int sketchWidth = 200;
//	protected int sketchHeight = 300;
	
	
	@Override
	public int sketchWidth() {
//		return screenWidth;
		return screenWidth;
//		return 600;
	}

	@Override
	public int sketchHeight() {
//		return sketchHeight;
		return screenHeight;
//		return 1024;
	}

	@Override
	public String sketchRenderer() {
		return A3D; 
	}
	
	
	@Override
	public String sketchColordepth() { 
//		return super.sketchColordepth(); //To get default color, depth and stencil bit depths
//		return HIGH_COLOR_DEPTH;
		return "8:8:8:8:24:8"; //To get a stencil buffer
	}
	
	
	@Override
	protected void onStop() {
		//at least on android even if stopping the mt4j app, the fontmanager seems to be kept with fonts cached, but textures destroyed already?
		FontManager.getInstance().clearCache(); 
		super.onStop();
	}
	
}

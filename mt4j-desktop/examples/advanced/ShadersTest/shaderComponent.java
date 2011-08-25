package advanced.ShadersTest;

import org.mt4j.AbstractMTApplication;
import org.mt4j.MTApplication;
import org.mt4j.components.TransformSpace;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.util.MT4jSettings;
import org.mt4j.util.math.Vector3D;
import org.mt4j.util.math.Vertex;
import org.mt4j.util.opengl.GLFBO;
import org.mt4j.util.opengl.GLTexture;
import org.mt4j.util.opengl.shaders.GLShader;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

public class shaderComponent extends MTRectangle {

	MTApplication pa;
	    
    private String shaderPath = System.getProperty("user.dir")+AbstractMTApplication.separator+"bin"+AbstractMTApplication.separator+"advanced" + AbstractMTApplication.separator + "ShadersTest" + AbstractMTApplication.separator + "data"+ AbstractMTApplication.separator + "shaders" + AbstractMTApplication.separator;
    
    private String dataPath = System.getProperty("user.dir")+AbstractMTApplication.separator+"bin"+AbstractMTApplication.separator+"advanced" + AbstractMTApplication.separator + "ShadersTest" + AbstractMTApplication.separator + "data"+ AbstractMTApplication.separator + "images" + AbstractMTApplication.separator;
    private GLShader myShader;
    
    private GLFBO fbo;
    
    MTRectangle rec;
	
	public shaderComponent(PApplet pApplet) {
		 super(pApplet,500,500);
		 this.pa = (MTApplication)pApplet;
		                
     myShader = new GLShader(pa);
     myShader.loadVertexShader(shaderPath+"zoom.vert");
     myShader.loadFragmentShader(shaderPath+"zoom.frag");
     myShader.useShaders();
        
     // setNoFill(true);
        
     PImage img = pa.loadImage(dataPath+"background.jpg");

     //   fbo = new GLFBO(pApplet,img.width,img.height);
		//Attach texture to FBO to draw into
	  //GLTexture tex = fbo.addNewTexture();
		
		//Apply the texture to this component
	  this.setTexture(img);
		
    //  rec = new MTRectangle(pa,500,500);
	}

	@Override
	public void drawComponent(PGraphics g) {
        if (MT4jSettings.getInstance().isOpenGlMode()){
            myShader.startShader();
            super.drawComponent(g);
            myShader.stopShader();
        //fbo.clear(true, 0, 255, 0, 0, true);
        //fbo.startRenderToTexture();
         //rec.drawComponent(g);
        // fbo.stopRenderToTexture();
        }
	}
	
}

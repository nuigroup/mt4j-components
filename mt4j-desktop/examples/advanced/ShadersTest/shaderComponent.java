package advanced.ShadersTest;

import javax.media.opengl.GL;

import org.mt4j.AbstractMTApplication;
import org.mt4j.MTApplication;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.util.MT4jSettings;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Tools3D;
import org.mt4j.util.math.Vector3D;
import org.mt4j.util.math.Vertex;
import org.mt4j.util.opengl.GL10;
import org.mt4j.util.opengl.GL11;
import org.mt4j.util.opengl.GL11Plus;
import org.mt4j.util.opengl.GL20;
import org.mt4j.util.opengl.GLFBO;
import org.mt4j.util.opengl.GLTexture;
import org.mt4j.util.opengl.shaders.GLShader;

import processing.core.PApplet;
import processing.core.PGraphics;

public class shaderComponent extends MTRectangle {

	MTApplication pa;
	    
    private String shaderPath = System.getProperty("user.dir")+AbstractMTApplication.separator+"bin"+AbstractMTApplication.separator+"advanced" + AbstractMTApplication.separator + "ShadersTest" + AbstractMTApplication.separator + "data"+ AbstractMTApplication.separator + "shaders" + AbstractMTApplication.separator;
    
    private GLShader myShader;
    
    private GLFBO fbo;
    
    MTRectangle rec;
	
	public shaderComponent(PApplet pApplet) {
		super(pApplet,300,300);
		this.pa = (MTApplication)pApplet;
		                
        myShader = new GLShader(pa);
        myShader.loadVertexShader(shaderPath+"zoom.vert");
        myShader.loadFragmentShader(shaderPath+"zoom.frag");
        myShader.useShaders();
        
        fbo = new GLFBO(pApplet, 300,300);
        
		//Attach texture to FBO to draw into
		GLTexture tex = fbo.addNewTexture();
		
		//Apply the texture to this component
		this.setTexture(tex);
		
      //  rec = new MTRectangle(pa,MT4jSettings.getInstance().getWindowWidth(),MT4jSettings.getInstance().getWindowHeight());
      //rec.setFillColor(new MTColor(255f,0f,0f,0f));
      //rec.setAnchor(PositionAnchor.UPPER_LEFT);
      //rec.setPositionGlobal(new Vector3D(0f,0f,0f));
      //addChild(rec);
	}

	@Override
	public void drawComponent(PGraphics g) {
        if (MT4jSettings.getInstance().isOpenGlMode()){
//            GL11Plus gl = (GL11Plus)Tools3D.beginGL(getRenderer());
//          gl.glPushMatrix();
        	
    		fbo.clear(true, 0, 255, 0, 0, true);
        	fbo.startRenderToTexture();
            super.drawComponent(g);
//          myShader.startShader();
        	//rec.drawComponent(g);
//        	myShader.stopShader();
        	fbo.stopRenderToTexture();
        	
//          gl.glBegin(GL.GL_POLYGON);
//          gl.glColor3f(0.0f, 0.0f, 1.0f);
//          gl.glVertex2f(100.0f, 100.0f);
//          gl.glColor3f(0.0f, 1.0f, 0.0f);
//          gl.glVertex2f(700.0f, 100.0f);
//          gl.glColor3f(1.0f, 0.0f, 0.0f);
//          gl.glVertex2f(100.0f, 700.0f);
//          gl.glEnd();
//  		gl.glPopMatrix();
//          Tools3D.endGL(getRenderer());
        }
	}
	
}

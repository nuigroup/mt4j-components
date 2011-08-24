package org.mt4j.util;

import org.mt4j.IMTApplication;
import org.mt4j.util.opengl.AndroidGLU;
import org.mt4j.util.opengl.GL10;
import org.mt4j.util.opengl.GL11;
import org.mt4j.util.opengl.GL11Plus;
import org.mt4j.util.opengl.GL20;
import org.mt4j.util.opengl.IGLU;

import processing.core.P5ProtectedAccessProxy;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PGraphicsAndroid3D;
import processing.core.PMatrix3D;

public class AndroidPlatformUtil implements IPlatformUtil {
	private final IMTApplication app;
	private AndroidGLU androidGLU;
	private P5ProtectedAccessProxy p5ProtectedAccessProxy;

	public AndroidPlatformUtil(IMTApplication app){
		this.app = app;
		this.androidGLU = new AndroidGLU();
		
		this.p5ProtectedAccessProxy = new P5ProtectedAccessProxy((PApplet) app); //FIXME use PApplet instead of IMTApplication everywhere!?
	}

	public PGraphics getPGraphics(){
		return app.getPGraphics();
	}
	
	public PMatrix3D getModelView() {
//		return ((PGraphicsAndroid3D)app.getPGraphics()).modelview;
		return this.p5ProtectedAccessProxy.getModelView();
	}
	
	public PMatrix3D getModelViewInv() {
		return ((PGraphicsAndroid3D)app.getPGraphics()).modelviewInv;
	}
	
	public float getCameraFOV() {
		return ((PGraphicsAndroid3D)app.getPGraphics()).cameraFOV;
	}

	public float getCameraAspect() {
		return ((PGraphicsAndroid3D)app.getPGraphics()).cameraAspect;
	}

	public float getCameraNear() {
		return ((PGraphicsAndroid3D)app.getPGraphics()).cameraNear;
	}

	public float getCameraFar() {
		return ((PGraphicsAndroid3D)app.getPGraphics()).cameraFar;
	}

	public GL10 getGL() {
		return app.getGL10(); 
	}
	
	public GL11 getGL11() {
		return app.getGL11(); 
	}

	public GL20 getGL20() {
		return app.getGL20(); 
	}

	public GL10 beginGL() {
		((PGraphicsAndroid3D)app.getPGraphics()).beginGL();
//		app.beginGL();
		return app.getGL10();
	}
    
    public void endGL(){
    	((PGraphicsAndroid3D)app.getPGraphics()).endGL();
//    	app.endGL();
    }

	public int getPlatform() {
		return IPlatformUtil.ANDROID;
	}

	public PMatrix3D getCamera() {
		return ((PGraphicsAndroid3D)app.getPGraphics()).camera;
	}

	public GL11Plus getGL11Plus() {
		return app.getGL11Plus();
	}

	@Override
	public IGLU getGLU() {
		return androidGLU;
	}

	@Override
	public PMatrix3D getProjection() {
//		return ((PGraphicsAndroid3D)app.getPGraphics()).projection;
		return p5ProtectedAccessProxy.getProjection();
	}

	@Override
	public boolean isBigEndian() {
		return PGraphicsAndroid3D.BIG_ENDIAN;
	}

	@Override
	public boolean isNPOTTextureSupported() {
		return false;
	}
	
	
	
	public void setModelView(
			float m00, float m01, float m02, float m03,
            float m10, float m11, float m12, float m13,
            float m20, float m21, float m22, float m23,
            float m30, float m31, float m32, float m33
    ){
		this.p5ProtectedAccessProxy.setModelView(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33);
	}
	
	public void setModelViewInv(float m00, float m01, float m02, float m03,
            float m10, float m11, float m12, float m13,
            float m20, float m21, float m22, float m23,
            float m30, float m31, float m32, float m33
    ){
		this.p5ProtectedAccessProxy.setModelViewInv(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33);
	}
			
	
	public void setCamera(
			float m00, float m01, float m02, float m03,
            float m10, float m11, float m12, float m13,
            float m20, float m21, float m22, float m23,
            float m30, float m31, float m32, float m33
    ){
		this.p5ProtectedAccessProxy.setCamera(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33);
	}
	
	public void setCameraInv(
			float m00, float m01, float m02, float m03,
            float m10, float m11, float m12, float m13,
            float m20, float m21, float m22, float m23,
            float m30, float m31, float m32, float m33
    ){
		this.p5ProtectedAccessProxy.setCameraInv(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33);
	}

	
}

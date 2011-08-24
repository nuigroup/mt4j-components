package org.mt4j.util.opengl;

import java.nio.Buffer;

import android.opengl.GLU;

public class AndroidGLU implements IGLU{

	public AndroidGLU(){
	}
	
	@Override
	public int gluBuild2DMipmaps(int target, int internalFormat, int width,
			int height, int format, int type, Buffer data) {
//		GLU.gluUnProject(winX, winY, winZ, model, modelOffset, project, projectOffset, view, viewOffset, obj, objOffset)
		throw new UnsupportedOperationException(); 
	}
	
	public void gluUnproject(){
//		GLU.gluUnProject(winX, winY, winZ, model, modelOffset, project, projectOffset, view, viewOffset, obj, objOffset)
	}

}

package processing.core;

public class P5ProtectedAccessProxy {
	
	private PApplet app;
	
	private PMatrix3D modelView;
	
	private PGraphicsAndroid3D a3d;
	
	public P5ProtectedAccessProxy(PApplet app){
		this.app = app;
		
		modelView = new PMatrix3D();
		
		a3d = (PGraphicsAndroid3D)app.g;
	}
	
	//TODO use in graphicsutil -> else we dont get the current matrix (whis is in glModelview)
	public PMatrix3D getModelView(){
		if (!a3d.modelviewUpdated) {
		      a3d.getModelviewMatrix();
		    }
//		a3d.copyGLArrayToPMatrix(a3d.glmodelview, modelView);
		return a3d.modelview;
	}
	
	public void setModelView(
			float m00, float m01, float m02, float m03,
            float m10, float m11, float m12, float m13,
            float m20, float m21, float m22, float m23,
            float m30, float m31, float m32, float m33
    ){
		
		a3d.modelview.set(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33);
		
//		a3d.glmodelview 
		
		a3d.copyPMatrixToGLArray(a3d.modelview, a3d.glmodelview);
		
		//FIXME DO SOMEWHER ELSE?! but neccessary !
		a3d.gl.glLoadMatrixf(a3d.glmodelview, 0);
		    if (a3d.usingGLMatrixStack) {
		    	a3d.modelviewStack.set(a3d.glmodelview);
		    }
		a3d.modelviewUpdated = true; //do?
		
//		a3d.camera; //wann wird die benutzt?
	}
	
	public void setModelViewInv(
			float m00, float m01, float m02, float m03,
            float m10, float m11, float m12, float m13,
            float m20, float m21, float m22, float m23,
            float m30, float m31, float m32, float m33
    ){
		a3d.modelviewInv.set(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33);
		a3d.copyPMatrixToGLArray(a3d.modelviewInv, a3d.glmodelviewInv);
	}
			
	
	//modelviewUpdated indicates whether the PMatrix3D modelview is coherent with the glModelView which is used internally

	//TODO modelViewInf, cameraInv
	
	public void setCamera(
			float m00, float m01, float m02, float m03,
            float m10, float m11, float m12, float m13,
            float m20, float m21, float m22, float m23,
            float m30, float m31, float m32, float m33
    ){
		
		a3d.camera.set(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33);
		
		//set camera to modelview and cameraInv to modelviewinv
		a3d.copyPMatrixToGLArray(a3d.camera, a3d.pcamera);
	}
	
	public void setCameraInv(
			float m00, float m01, float m02, float m03,
            float m10, float m11, float m12, float m13,
            float m20, float m21, float m22, float m23,
            float m30, float m31, float m32, float m33
    ){
		
		a3d.cameraInv.set(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30, m31, m32, m33);
		
		//set camera to modelview and cameraInv to modelviewinv
		
		a3d.copyPMatrixToGLArray(a3d.cameraInv, a3d.pcameraInv);
	}
	
	
	public PMatrix3D getProjection(){
		if (!a3d.projectionUpdated) {
		      a3d.getProjectionMatrix();
		    }
//		a3d.copyGLArrayToPMatrix(a3d.glmodelview, modelView);
		return a3d.projection;
	}
			
}

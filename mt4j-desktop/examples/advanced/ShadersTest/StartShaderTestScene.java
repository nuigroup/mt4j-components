package advanced.ShadersTest;

import org.mt4j.MTApplication;

public class StartShaderTestScene extends MTApplication{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]){
		initialize();
	}
	
	@Override
	public void startUp(){
		this.addScene(new ShaderTestScene(this, "Shader Scene"));
	}
}
